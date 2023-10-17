import { AlbaranSimpleComponent } from '@albaran/component/albaran-simple/albaran-simple.component';
import {
  BreakpointObserver
} from '@angular/cdk/layout';
import { ChangeDetectionStrategy, Component, OnInit, ViewChild, ViewChildren, ViewContainerRef, WritableSignal, signal } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { EntityApiEnum } from '@app/core/const/Enums';
import { Albaran } from '@app/core/dto/albaran.model';
import { ILog, Log } from '@app/core/dto/log.model';
import { GenericCacheService } from '@app/core/services/cache/generic.service';
import { UntilDestroy, untilDestroyed } from '@ngneat/until-destroy';
import { NgxUiLoaderService } from 'ngx-ui-loader';
import { EMPTY, Subject, catchError, map, switchMap, tap } from 'rxjs';

@UntilDestroy({ checkProperties: true })
@Component({
  selector: 'app-list-albaran',
  templateUrl: './list-albaran.component.html',
  styleUrls: ['./list-albaran.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class ListAlbaranComponent implements OnInit {

  //list albaranes
  private totalAlbaranes: WritableSignal<Albaran[]> = signal<Albaran[]>([]);
  albaranesLength = signal(0);
  albaranes= signal<Albaran[]>([]);

  //idDetail Control
  idDetail = signal<string>('');
  loading = signal<boolean>(false);


  changesPagination!: Subject<void>;
  pageSizeAlbaranes= signal(25);
  @ViewChildren('albaranTemplate', { read: ViewContainerRef }) albaranTemplate!: ViewContainerRef;


  widthSize?: number;

  constructor(
    private readonly _formBuilder: FormBuilder,
    protected readonly ngxService: NgxUiLoaderService,
    private readonly route: ActivatedRoute,
    protected readonly router: Router,
    protected readonly breakpointObserver: BreakpointObserver,
    private readonly log: GenericCacheService<Log,string>,
    private readonly serviceAlbaran: GenericCacheService<Albaran,string>
    ) {
  }

  ngOnInit(): void {
    const resolvedData: Albaran[] = this.route.snapshot.data['albaranesUsuario'];
    this.totalAlbaranes.set(resolvedData);
    this.albaranesLength.set(resolvedData.length);
    this.logInitialData(resolvedData);
    this.pageChange(undefined);
    this.ngxService.stop();
  }

  pageChange(event: { pageIndex: any; pageSize: any; } | undefined) {
    event ??= {pageIndex:0, pageSize: this.pageSizeAlbaranes()};
    let calcSize = (event.pageIndex*event.pageSize);
    let currentCalcSize = calcSize + event.pageSize;
    if (currentCalcSize > this.totalAlbaranes().length) currentCalcSize =  this.totalAlbaranes().length - calcSize;
    console.log(`calcSize: ${calcSize} currentCalcSize: ${currentCalcSize}`);
    this.albaranes.set(this.totalAlbaranes().slice(calcSize, currentCalcSize));

  }

  expand(id: string){//method to load component when panel is expanded
    this.idDetail.set(id);
    this.loading.set(true);

    this.serviceAlbaran.getById(id, EntityApiEnum.Albaran)
      .pipe(
        untilDestroyed(this),
        tap(() => this.albaranTemplate.clear()),
        map((data: Albaran) => {
          const componentRef = this.albaranTemplate.createComponent(AlbaranSimpleComponent);
          // here you can send data to dynamically loaded component
          (<AlbaranSimpleComponent>componentRef.instance).albaran.set(data);
          // you can detach without destroying
          this.albaranTemplate.detach(0);
          // also reattach it with preserved elements.
          this.albaranTemplate.insert(componentRef.hostView, 0);
          // return of(data);
        }),
        catchError((err) => {
          console.error(err);
          return EMPTY;
        })
      )
      .subscribe({
        complete: () => this.loading.set(false)
      });
  }

  private logInitialData(data: Albaran[]) {
      this.callLogger('debug',`recibimos primera carga albaranes [${JSON.stringify(data)}]`);
  }

  private callLogger(level: string, message: string) {
    const logCurrent:ILog  = {level, message};
    this.log.postSave('send',logCurrent , EntityApiEnum.Log)
    .pipe(untilDestroyed(this))
    .subscribe({
        next: (logResp) => {
            switch (level) {
              case 'log':
                console.log(logResp.message);
                break;
              case 'debug':
                console.debug(logResp.message);
                  break;
              case 'info':
                console.info(logResp.message);
                  break;
              case 'warn':
                console.warn(logResp.message);
                  break;
              case 'error':
                console.error(logResp.message);
                  break;
              default:
                  break;
            }
        },
        error: (err)=>{
          console.error(err);
        }
    });
  }

}
