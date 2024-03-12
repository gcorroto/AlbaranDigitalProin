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
import { HttpClientOptions } from '@app/core/services/impl/http.service';
import { HttpParams } from '@angular/common/http';

@UntilDestroy({ checkProperties: true })
@Component({
  selector: 'app-list-albaran',
  templateUrl: './list-albaran.component.html',
  styleUrls: ['./list-albaran.component.scss']
})
export class ListAlbaranComponent implements OnInit {

  //list albaranes
  private _albaranes: Albaran[] = [];
  private totalAlbaranes: Albaran[] = [];
  albaranesLength: number = 0;
  get albaranes(): Albaran[] {
    return this._albaranes;
  }
  set albaranes(data: Albaran[]) {
    this._albaranes = data;
  }

  //idDetail Control
  private _idDetail: string = '';
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


  changesPagination!: Subject<void>;
  pageSizeAlbaranes: number = 25;
  currentPageAlbaranes: number = 0;
  @ViewChild('albaranTemplate', { read: ViewContainerRef }) albaranTemplate!: ViewContainerRef;


  widthSize?: number;

  constructor(
    private readonly _formBuilder: FormBuilder,
    protected readonly ngxService: NgxUiLoaderService,
    private readonly route: ActivatedRoute,
    protected readonly router: Router,
    protected readonly breakpointObserver: BreakpointObserver,
    private readonly serviceAlbaran: GenericCacheService<Albaran,string>
    ) {
    }

  pageChange(event: { pageIndex: any; pageSize: any; } | undefined) {
    event ??= {pageIndex:0, pageSize: this.pageSizeAlbaranes};
    let calcSize = (event.pageIndex * event.pageSize);
    let currentCalcSize = calcSize + event.pageSize;
    if (currentCalcSize > this.totalAlbaranes.length) {
      currentCalcSize = this.totalAlbaranes.length;
    }
    this.albaranes = this.totalAlbaranes.slice(calcSize, currentCalcSize);
  }

  expand(albaran: Albaran){//method to load component when panel is expanded
    this.idDetail = albaran.numeroAlbaran?albaran.numeroAlbaran:'';
    this.loading = true;

    const params = new HttpParams()
    .set('centro', albaran.centro ? albaran.centro : '')
    .set('codigoPlanta', albaran.codigoPlanta ? albaran.codigoPlanta : '')
    .set('serie', albaran.serie ? albaran.serie : '');

    const options = {
      params: params
    };

    this.serviceAlbaran.getById(this.idDetail, EntityApiEnum.Albaran, undefined, options)
      .pipe(untilDestroyed(this))
      .subscribe({
        next:(data: Albaran) => {
            this.albaranTemplate.clear();
            const componentRef = this.albaranTemplate.createComponent(AlbaranSimpleComponent);
            // here you can send data to dynamically loaded component
          (<AlbaranSimpleComponent>componentRef.instance).albaran = data;
          // you can detach without destroying
          this.albaranTemplate.detach(0);
          // also reattach it with preserved elements.
          this.albaranTemplate.insert(componentRef.hostView, 0);
          this.loading = false;
        },
        error:(err: any) => {
          console.error(err);
          this.loading = false;
        },
        complete:() => {
          this.loading = false;
        }
      }
      );

  }

  ngOnInit(): void {
    const resolvedData: Albaran[] = this.route.snapshot.data['albaranesUsuario'];
    this.totalAlbaranes = resolvedData;
    this.albaranesLength = resolvedData.length;
    this.pageChange(undefined);
    this.ngxService.stop();
  }

}
