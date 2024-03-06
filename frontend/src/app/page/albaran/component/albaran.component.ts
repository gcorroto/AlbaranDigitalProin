import { Component, OnInit, Output, ViewContainerRef, Input, ElementRef, QueryList, ViewChildren } from '@angular/core';
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
import { StepBaseComponent } from './step-base/step-base.component';
import { MatDialog } from '@angular/material/dialog';
import { DialogData, GenericDialogComponent } from '@app/generic-dialog/generic-dialog.component';

@UntilDestroy({ checkProperties: true })
@Component({
  // selector: 'app-albaran',
  templateUrl: './albaran.component.html',
  styleUrls: ['./albaran.component.scss']
})
export class AlbaranComponent extends StepBaseComponent  implements OnInit {
  isLinear = true;
  // @Output() isReader = true;
  clienteFormGroup: FormGroup = new FormGroup({});
  transporteFormGroup: FormGroup = new FormGroup({});
  hormigonFormGroup: FormGroup = new FormGroup({});
  meteorologiaFormGroup: FormGroup = new FormGroup({});
  horarioFormGroup: FormGroup = new FormGroup({});
  recepcionFormGroup: FormGroup = new FormGroup({});
  firmaFormGroup: FormGroup = new FormGroup({});
  public albaran!: Albaran;
  // @Input() simple: boolean = true;
  widthSize: number = 0;
  isLoadComplete: boolean = false;

  @ViewChildren('clienteContainer') public clienteContainer!: QueryList<ElementRef>;

  constructor(
    private readonly _formBuilder: FormBuilder,
    protected readonly ngxService: NgxUiLoaderService,
    private readonly route: ActivatedRoute,
    protected readonly router: Router,
    protected readonly breakpointObserver: BreakpointObserver,
    private readonly log: GenericCacheService<Log,string>,
    public viewContainerRef: ViewContainerRef,
    private readonly serviceAlbaran: GenericCacheService<Albaran,string>,
    public dialog: MatDialog
    ) {
      super();
      this.container = this.clienteContainer;
      this.isLoadComplete = false;

    }

  ngOnInit(): void {

    console.debug(`detalle albaran firma`);
    this.responsiveStepper();

    // this.route.paramMap.subscribe(params => {
      const state = window.history.state;
      this.albaran = state?.['albaran'];

      if (this.albaran) {
        this.logInitialData(this.albaran);
      }
      this.buildFormCliente();
      this.buildFormTransporte();
      this.buildFormMeteorologia();
      this.buildFormHorarios();
      this.buildFormFirma();

      this.clienteFormGroup.valueChanges.subscribe(() => this.executeIfAllFormsAreValid());
      this.transporteFormGroup.valueChanges.subscribe(() => this.executeIfAllFormsAreValid());
      this.hormigonFormGroup.valueChanges.subscribe(() => this.executeIfAllFormsAreValid());
      this.meteorologiaFormGroup.valueChanges.subscribe(() => this.executeIfAllFormsAreValid());
      this.horarioFormGroup.valueChanges.subscribe(() => this.executeIfAllFormsAreValid());
      this.recepcionFormGroup.valueChanges.subscribe(() => this.executeIfAllFormsAreValid());
      this.firmaFormGroup.valueChanges.subscribe(() => this.executeIfAllFormsAreValid());

      this.ngxService.stop();
      this.isLoadComplete = true;
    // });
  }

  private logInitialData(data: Albaran) {
    const logCurrent:ILog  = {level: 'debug', message: `recibimos primera carga albaran [${JSON.stringify(data)}]`};
    this.log.postSave('send',logCurrent , EntityApiEnum.Log)
    .pipe(untilDestroyed(this))
    .subscribe({
      next: (logResp) => {
        console.debug(logResp.message);
      },
      error: (err) => {
        console.error(err);
      }
    });
  }

  private buildFormCliente() {
    this.clienteFormGroup = this._formBuilder.group({
      numeroAlbaran: [{value: this.albaran?.numeroAlbaran || '', disabled: true}],
      fechaAlbaran: [{value: this.albaran?.fechaAlbaran || '', disabled: true}],
      distanciaADestino: [{value: this.albaran?.distanciaADestino || '', disabled: true}],
      //m3: [{value: this.albaran?.m3 || '', disabled: true}],
      //progresoDia: [{value: this.albaran?.progresoDia || '', disabled: true}], //TODO: llevar a lineas
      codigoPlanta: [{value: this.albaran?.codigoPlanta || '', disabled: true}],
      centro: [{value: this.albaran?.centro || '', disabled: true}],
      nombreCliente: [{value: this.albaran?.nombreCliente || '', disabled: true}],
      cliente: [{value: this.albaran?.cliente || '', disabled: true}],
      //'cliente.cif': [{value: this.albaran?.cliente?.cif || '', disabled: true}],
      nombreObra: [{value: this.albaran?.nombreObra || '', disabled: true}],
      obra: [{value: this.albaran?.obra || '', disabled: true}],
      //direccion: [{value: this.albaran?.direccion || '', disabled: true}], // TODO: llevalo a la cabecera?
      // cp: [{value: this.albaran?.cp || '', disabled: true}],
      // municipio: [{value: this.albaran?.municipio || '', disabled: true}]
    });
  }

  private buildFormTransporte() {
    this.transporteFormGroup = this._formBuilder.group({
      nombreOperadorTransporte: [{value: this.albaran?.nombreOperadorTransporte || '', disabled: true}],
      cifOperadorTransporte: [{value: this.albaran?.cifOperadorTransporte || '', disabled: true}],
      matriculaCamion: [{value: this.albaran?.matriculaCamion || '', disabled: true}],
      matricularemolque: [{value: this.albaran?.matricularemolque || '', disabled: true}],
      clienteEsCargadorContractual: [{value: this.albaran?.clienteEsCargadorContractual || '', disabled: true}], //TODO: convertir en SI / NO
      cifTransportista: [{value: this.albaran?.cifTransportista || '', disabled: true}],
      nombreTransportista: [{value: this.albaran?.nombreTransportista || '', disabled: true}],
    });
  }

  private buildFormMeteorologia() {
    this.meteorologiaFormGroup = this._formBuilder.group({
      direccionViento: [{value: this.albaran.direccionViento, disabled: true}],
      humedad: [{value: this.albaran.humedad, disabled: true}],
      intensidadPrecipitacion: [{value: this.albaran.intensidadPrecipitacion, disabled: true}],
      presion: [{value: this.albaran.presion, disabled: true}],
      prevision: [{value: this.albaran.prevision, disabled: true}],
      razonesClima: [{value: this.albaran.razonesClima, disabled: true}],
      temperatura: [{value: this.albaran.temperatura, disabled: true}],
      velocidadViento: [{value: this.albaran.velocidadViento, disabled: true}]
      // 'meteorologia.temperatura': [{value: '100', disabled: true}],
      // 'meteorologia.humedad': [{value: '40', disabled: true}],
      // 'meteorologia.velocidad': [{value: '60', disabled: true}],
    });
  }

  private buildFormHorarios() {
    this.horarioFormGroup = this._formBuilder.group({
      fechaAlbaran : [{value: this.albaran.fechaAlbaran, disabled: true}],
      llegadaobra: [{value: this.albaran.llegadaobra}, Validators.required],
      iniciodescarga: [{value: this.albaran.iniciodescarga}, Validators.required],
      salidaobra: [{value: this.albaran.salidaobra}, Validators.required],
      llegadaplanta: [{value: this.albaran.llegadaplanta}, Validators.required],
    });
  }

  private buildFormFirma() {
    this.firmaFormGroup = this._formBuilder.group({
      'firma': [ undefined, Validators.required],
    });
  }

  public onFormSubmit(firmaB64: string) {
    let numeroAlbaran = this.albaran.numeroAlbaran?this.albaran.numeroAlbaran:'';

    this.albaran.llegadaobra = this.horarioFormGroup.get("llegadaobra")?.value();
    this.albaran.iniciodescarga = this.horarioFormGroup.get("iniciodescarga")?.value();
    this.albaran.salidaobra = this.horarioFormGroup.get("salidaobra")?.value();
    this.albaran.llegadaplanta = this.horarioFormGroup.get("llegadaplanta")?.value();
    this.albaran.firmaCliente = firmaB64;

    this.serviceAlbaran.postSave(numeroAlbaran, this.albaran, EntityApiEnum.Albaran)
      .pipe(untilDestroyed(this))
      .subscribe({
        next:(data: Albaran) => {
          const dialogRef = this.dialog.open(GenericDialogComponent, {
            data: {
              message: 'El albarán se ha guardado correctamente',
              btnText: 'Aceptar'
            } as DialogData,
          });
      
          dialogRef.afterClosed().subscribe(result => {
            this.router.navigate(['/list']);
          });
        },
        error:(err: any) => {
          console.error(err);
          this.dialog.open(GenericDialogComponent, {
            data: {
              message: `Se ha producido un error al guardar el albarán. ${err}`,
              btnText: 'Aceptar'
            } as DialogData,
          });
        }
      }
    );

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
    switch (level) {
      case 'log':
        console.log(message);
        break;
      case 'debug':
        console.debug(message);
          break;
      case 'info':
        console.info(message);
          break;
      case 'warn':
        console.warn(message);
          break;
      case 'error':
        console.error(message);
          break;
      default:
          break;
    }
  }

  private areAllFormsValid(): boolean {

      // this.clienteFormGroup.valid &&
      // this.transporteFormGroup.valid &&
      // this.hormigonFormGroup.valid &&
      // this.meteorologiaFormGroup.valid &&
      // this.horarioFormGroup.valid &&
      return  this.recepcionFormGroup.valid &&
      this.firmaFormGroup.valid;
  }

  private getInvalidForm(): string | null {
    // if (!this.clienteFormGroup.valid) {
    //   return 'clienteFormGroup';
    // }
    // if (!this.transporteFormGroup.valid) {
    //   return 'transporteFormGroup';
    // }
    // if (!this.hormigonFormGroup.valid) {
    //   return 'hormigonFormGroup';
    // }
    // if (!this.meteorologiaFormGroup.valid) {
    //   return 'meteorologiaFormGroup';
    // }
    // if (!this.horarioFormGroup.valid) {
    //   return 'horarioFormGroup';
    // }
    // if (!this.recepcionFormGroup.valid) {
    //   return 'recepcionFormGroup';
    // }
    if (!this.firmaFormGroup.valid) {
      return 'firmaFormGroup';
    }
    return null;
  }

  private executeIfAllFormsAreValid() {
    const firma = this.firmaFormGroup.get('firma')?.value;
    if (this.areAllFormsValid() && firma) {
      console.log (` firma ${firma}`);
      console.log('all forms are valid');
    } else {
      console.log(`${this.getInvalidForm()} are invalid`);
    }
  }

}
