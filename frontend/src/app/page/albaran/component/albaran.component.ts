import { Component, OnInit, Output, ViewContainerRef, Input } from '@angular/core';
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
  // selector: 'app-albaran',
  templateUrl: './albaran.component.html',
  styleUrls: ['./albaran.component.scss']
})
export class AlbaranComponent implements OnInit {
  isLinear = true;
  // @Output() isReader = true;
  clienteFormGroup: FormGroup = new FormGroup({});
  transporteFormGroup: FormGroup = new FormGroup({});
  hormigonFormGroup: FormGroup = new FormGroup({});
  meteorologiaFormGroup: FormGroup = new FormGroup({});
  horarioFormGroup: FormGroup = new FormGroup({});
  recepcionFormGroup: FormGroup = new FormGroup({});
  firmaFormGroup: FormGroup = new FormGroup({});
  albaran?: Albaran;
  // @Input() simple: boolean = true;
  widthSize: number = 0;

  constructor(
    private readonly _formBuilder: FormBuilder,
    protected readonly ngxService: NgxUiLoaderService,
    private readonly route: ActivatedRoute,
    protected readonly router: Router,
    protected readonly breakpointObserver: BreakpointObserver,
    private readonly log: GenericCacheService<Log,string>,
    public viewContainerRef: ViewContainerRef
    ) {
    }

  ngOnInit(): void {
    console.debug(`detallesalbaran firma`);
    this.responsiveStepper();

    // this.route.paramMap.subscribe(params => {
      const state = window.history.state;
      this.albaran = state?.['albaran'];

      if (this.albaran) {
        this.logInitialData(this.albaran);
      }

      this.buildFormCliente();
      this.buildFormTransporte();
      this.buildFormHormigon();
      this.buildFormMeteorologia();
      this.buildFormHorarios();
      this.buildFormRecepcion();
      this.buildFormFirma();

      this.ngxService.stop();
    // });
  }

  private logInitialData(data: Albaran) {
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
      numAlbaran: [{value: this.albaran?.numAlbaran || '', disabled: true}],
      fechaEntrega: [{value: this.albaran?.fechaEntrega || '', disabled: true}],
      radial: [{value: this.albaran?.radial || '', disabled: true}],
      m3: [{value: this.albaran?.m3 || '', disabled: true}],
      progresoDia: [{value: this.albaran?.progresoDia || '', disabled: true}],
      planta: [{value: this.albaran?.planta || '', disabled: true}],
      viaCarga: [{value: this.albaran?.viaCarga || '', disabled: true}],
      'cliente.nombre': [{value: this.albaran?.cliente?.nombre || '', disabled: true}],
      'cliente.id': [{value: this.albaran?.cliente?.id || '', disabled: true}],
      'cliente.cif': [{value: this.albaran?.cliente?.cif || '', disabled: true}],
      obra: [{value: this.albaran?.obra || '', disabled: true}],
      direccion: [{value: this.albaran?.direccion || '', disabled: true}],
      cp: [{value: this.albaran?.cp || '', disabled: true}],
      municipio: [{value: this.albaran?.municipio || '', disabled: true}]
    });
  }

  private buildFormTransporte() {
    this.transporteFormGroup = this._formBuilder.group({
      'transporte.empresa': [{value: this.albaran?.transporte?.empresa || '', disabled: true}],
      'transporte.cif': [{value: this.albaran?.transporte?.cif || '', disabled: true}],
      'transporte.camion.matricula': [{value: this.albaran?.transporte?.camion?.matricula || '', disabled: true}],
      'transporte.remolque.matricula': [{value: this.albaran?.transporte?.remolque?.matricula || '', disabled: true}],
      'transporte.cargadorContractual': [{value: this.albaran?.transporte?.cargadorContractual || '', disabled: true}]
    });
  }

  private buildFormHormigon() {
    this.hormigonFormGroup = this._formBuilder.group({
      'hormigon.tipo': [{value: this.albaran?.hormigon?.tipo || '', disabled: true}],
      'hormigon.referencia': [{value: this.albaran?.hormigon?.referencia || '', disabled: true}],
      'hormigon.relacion': [{value: this.albaran?.hormigon?.relacion || '', disabled: true}],
      'hormigon.contenido.cementos': [{value: this.albaran?.hormigon?.contenido?.cementos || '', disabled: true}],
      'hormigon.contenido.aditivos': [{value: this.albaran?.hormigon?.contenido?.aditivos || '', disabled: true}],
      'hormigon.contenido.adiciones': [{value: this.albaran?.hormigon?.contenido?.adiciones || '', disabled: true}],
      // 'hormigon.adiciones.tipo': ['', Validators.required],
      // 'hormigon.adiciones.cantidad': ['', Validators.required],
    });
  }

  private buildFormMeteorologia() {
    this.meteorologiaFormGroup = this._formBuilder.group({
      // 'meteorologia.temperatura': [{value: this.albaran.meteorologia.temperatura, disabled: true}],
      // 'meteorologia.humedad': [{value: this.albaran.meteorologia.humedad, disabled: true}],
      // 'meteorologia.velocidad': [{value: this.albaran.meteorologia.velocidad, disabled: true}],
      'meteorologia.temperatura': [{value: '100', disabled: true}],
      'meteorologia.humedad': [{value: '40', disabled: true}],
      'meteorologia.velocidad': [{value: '60', disabled: true}],
    });
  }

  private buildFormHorarios() {
    this.horarioFormGroup = this._formBuilder.group({
      'horario.cargaPlanta': [{value: '11:30', disabled: true}],
      'horario.llegadaObra': ['', Validators.required],
      'horario.inicioDescarga': ['', Validators.required],
      'horario.finalDescarga': ['', Validators.required],
      'horario.llegadaPlanta': ['', Validators.required],
      'horario.limiteUso': [{value: '13:00', disabled: true}],
      'horario.hormigonBombeado': ['', Validators.required],
      'horario.aguaCliente': ['', Validators.required],
    });
  }

  private buildFormRecepcion() {
    this.recepcionFormGroup = this._formBuilder.group({
      'recepcion.laboratorio': ['', Validators.required],
      'recepcion.elementoHormigon': ['', Validators.required],
      'recepcion.horaToma': ['', Validators.required],
      'recepcion.cono': ['', Validators.required],
      'recepcion.numProbetas': ['', Validators.required],
    });
  }

  private buildFormFirma() {
    this.firmaFormGroup = this._formBuilder.group({
      'firma': [{value: this.albaran?.firma}, Validators.required],
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
