import { Component, ComponentFactoryResolver, OnInit, Output, ViewChild, ViewContainerRef } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, ActivatedRouteSnapshot, Router } from '@angular/router';
import { Albaran } from '@app/core/dto/albaran.model';
import { NgxUiLoaderService } from 'ngx-ui-loader';
import {
  BreakpointObserver,
  BreakpointState
} from '@angular/cdk/layout';
import { untilDestroyed, UntilDestroy } from '@ngneat/until-destroy';
import { EntityApiEnum } from '@app/core/const/Enums';
import { ILog, Log } from '@app/core/dto/log.model';
import { GenericCacheService } from '@app/core/services/cache/generic.service';
import { AlbaranSimpleComponent } from '@albaran/component/albaran-simple/albaran-simple.component';
import { Subject } from 'rxjs';

@UntilDestroy({ checkProperties: true })
@Component({
  selector: 'app-list-albaran',
  templateUrl: './list-albaran.component.html',
  styleUrls: ['./list-albaran.component.scss']
})
export class ListAlbaranComponent implements OnInit {

  //list albaranes
  private _albaranes: Albaran[];
  private totalAlbaranes: Albaran[];
  albaranesLength: number;
  get albaranes(): Albaran[] {
    return this._albaranes;
  }
  set albaranes(data: Albaran[]) {
    this._albaranes = data;
  }

  //idDetail Control
  private _idDetail: string;
  get idDetail(): string {
    return this._idDetail;
  }
  set idDetail(data: string) {
    this._idDetail = data;
  }

  //loading Control
  private _loading: boolean = false;
  get loading(): boolean {
    return this._loading;
  }
  set loading(data: boolean) {
    this._loading = data;
  }


  changesPagination: Subject<void>;
  pageSizeAlbaranes: number = 25;
  currentPageAlbaranes: number = 0;
  @ViewChild('albaranTemplate', { read: ViewContainerRef }) albaranTemplate: ViewContainerRef;


  widthSize: number;

  constructor(
    private readonly _formBuilder: FormBuilder,
    protected readonly ngxService: NgxUiLoaderService,
    private readonly route: ActivatedRoute,
    protected readonly router: Router,
    protected readonly breakpointObserver: BreakpointObserver,
    private readonly log: GenericCacheService<Log,string>,
    private readonly serviceAlbaran: GenericCacheService<Albaran,string>,
    private componentFactoryResolver: ComponentFactoryResolver
    ) {
    }

  pageChange(event) {
    event ??= {pageIndex:0, pageSize: this.pageSizeAlbaranes};
    let calcSize = (event.pageIndex*event.pageSize);
    let currentCalcSize = calcSize + event.pageSize;
    if (currentCalcSize > this.totalAlbaranes.length) currentCalcSize =  this.totalAlbaranes.length - calcSize;
    this.albaranes = this.totalAlbaranes.slice(calcSize, currentCalcSize);

  }

  expand(id){//method to load component when panel is expanded
    const componentFactory =
    this.componentFactoryResolver.resolveComponentFactory(AlbaranSimpleComponent);
    this.idDetail = id;
    this.loading = true;

    this.serviceAlbaran.getById(id, EntityApiEnum.Albaran)
      .pipe(untilDestroyed(this))
      .subscribe(
        (data: Albaran) => {
            this.albaranTemplate.clear();
            const componentRef = this.albaranTemplate.createComponent(componentFactory);
            // here you can send data to dynamically loaded component
          (<AlbaranSimpleComponent>componentRef.instance).albaran = data;
          // you can detach without destroying
          this.albaranTemplate.detach(0);
          // also reattach it with preserved elements.
          this.albaranTemplate.insert(componentRef.hostView, 0);
          this.loading = false;
        },
        (err) => {
          console.error(err);
          this.loading = false;
        }
      );

 }



  ngOnInit(): void {

    const resolvedData: Albaran[] = this.route.snapshot.data['albaranesUsuario'];
    this.totalAlbaranes = resolvedData;
    this.albaranesLength = resolvedData.length;
    this.logInitialData(resolvedData);
    this.pageChange(undefined);
    this.ngxService.stop();
  }

  private logInitialData(data) {
      this.callLogger('debug',`recibimos primera carga albaranes [${JSON.stringify(data)}]`);
  }

  private callLogger(level: string, message: string) {
    const logCurrent:ILog  = {level, message};
    this.log.postSave('send',logCurrent , EntityApiEnum.Log)
    .pipe(untilDestroyed(this))
    .subscribe((logResp) => {
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
    },(err)=>{
      console.error(err);
    });
  }

}
