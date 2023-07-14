import { Component, OnInit } from '@angular/core';
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

@UntilDestroy({ checkProperties: true })
@Component({
  selector: 'app-albaran',
  templateUrl: './albaran.component.html',
  styleUrls: ['./albaran.component.scss']
})
export class AlbaranComponent implements OnInit {
  isLinear = true;
  clienteFormGroup: FormGroup;
  transporteFormGroup: FormGroup;
  albaran: Albaran;
  widthSize: number;

  constructor(
    private readonly _formBuilder: FormBuilder,
    protected readonly ngxService: NgxUiLoaderService,
    private readonly route: ActivatedRoute,
    protected readonly router: Router,
    protected readonly breakpointObserver: BreakpointObserver,
    private readonly log: GenericCacheService<Log,string>
    ) {
    }

  ngOnInit(): void {

    this.responsiveStepper();

    const resolvedData: Albaran = this.route.snapshot.data['albaran'];
    this.albaran = resolvedData;
    this.logInitialData(resolvedData);
    this.buildFormCliente();
    this.buildFormTransporte();

  }

  private logInitialData(data) {
    const logCurrent:ILog  = {level: 'debug', message: `recibimos primera carga albaran [${JSON.stringify(data)}]`};
          this.log.postSave('send',logCurrent , EntityApiEnum.Log)
          .pipe(untilDestroyed(this))
          .subscribe(
            (logResp) => {
              console.debug(logResp.message);
            },
            (err)=>{
              console.error(err);
            }
          );
  }

  private buildFormCliente() {
    this.clienteFormGroup = this._formBuilder.group({
      numAlbaran: ['', Validators.required],
      fechaEntrega: [{value: this.albaran.fechaEntrega, disabled: true}],
      radial: [{value: this.albaran.radial, disabled: true}],
      m3: [{value: this.albaran.m3, disabled: true}],
      progresoDia: [{value: this.albaran.progresoDia, disabled: true}],
      planta: [{value: this.albaran.planta, disabled: true}],
      viaCarga: [{value: this.albaran.viaCarga, disabled: true}],
      'cliente.nombre': [{value: this.albaran.cliente.nombre, disabled: true}],
      'cliente.id': [{value: this.albaran.cliente.id, disabled: true}],
      'cliente.cif': [{value: this.albaran.cliente.cif, disabled: true}],
      obra: [{value: this.albaran.obra, disabled: true}],
      direccion: [{value: this.albaran.direccion, disabled: true}],
      cp: [{value: this.albaran.cp, disabled: true}],
      municipio: [{value: this.albaran.municipio, disabled: true}]
    });
  }

  private buildFormTransporte() {
    this.transporteFormGroup = this._formBuilder.group({
      'transporte.empresa': [{value: this.albaran.transporte.empresa, disabled: true}],
      'transporte.cif': [{value: this.albaran.transporte.cif, disabled: true}],
      'transporte.camion.matricula': [{value: this.albaran.transporte.camion.matricula, disabled: true}],
      'transporte.remolque.matricula': [{value: this.albaran.transporte.remolque.matricula, disabled: true}],
      'transporte.cargadorContractual': [{value: this.albaran.transporte.cargadorContractual, disabled: true}]
    });
  }

  private responsiveStepper(): void {
    this.widthSize = 0;


        this.breakpointObserver
        .observe(['(min-width: 1280px)'])
        .pipe(untilDestroyed(this))
        .subscribe((state: BreakpointState) => {
          if (state.matches) {
            this.widthSize = 2;
            this.callLogger('log', 'Viewport width is 1280px or greater!');
          } else {
            this.callLogger('log', 'Viewport width is less than 1280px!');
            this.breakpointObserver
            .observe(['(min-width: 600px)'])
            .pipe(untilDestroyed(this))
            .subscribe((state: BreakpointState) => {
              if (state.matches) {
                this.widthSize = 1;
                  this.callLogger('log', 'Viewport width is 600px or greater!');
              } else {
                this.widthSize = 0;
                this.callLogger('log', 'Viewport width is less than 600px!');
              }
            });
          }
        })
  }

  private callLogger(level: string, message: string) {
    const logCurrent:ILog  = {level, message};
    this.log.postSave('send',logCurrent , EntityApiEnum.Log)
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
