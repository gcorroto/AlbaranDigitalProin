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

@UntilDestroy({ checkProperties: true })
@Component({
  templateUrl: './albaran.component.html',
  styleUrls: ['./albaran.component.scss']
})
export class AlbaranComponent implements OnInit {
  isLinear = true;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  albaran: Albaran;
  widthSize: number;

  constructor(
    private readonly _formBuilder: FormBuilder,
    protected readonly ngxService: NgxUiLoaderService,
    private readonly route: ActivatedRoute,
    protected readonly router: Router,
    protected readonly breakpointObserver: BreakpointObserver
    ) {
    }

  ngOnInit(): void {

    this.responsiveStepper();

    const resolvedData: Albaran = this.route.snapshot.data['albaran'];
    this.albaran = resolvedData;
    this.buildFormCliente();

    this.secondFormGroup = this._formBuilder.group({
      secondCtrl: ['', Validators.required]
    });
  }

  private buildFormCliente() {
    this.firstFormGroup = this._formBuilder.group({
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

  private responsiveStepper(): void {
    this.widthSize = 0;
      this.breakpointObserver
        .observe(['(min-width: 600px)'])
        .pipe(untilDestroyed(this))
        .subscribe((state: BreakpointState) => {
          if (state.matches) {
            this.widthSize = 1;
            console.log('Viewport width is 500px or greater!');
          } else {
            this.widthSize = 0;
            console.log('Viewport width is less than 500px!');
          }
        });

        this.breakpointObserver
        .observe(['(min-width: 1280px)'])
        .pipe(untilDestroyed(this))
        .subscribe((state: BreakpointState) => {
          if (state.matches) {
            this.widthSize = 2;
            console.log('Viewport width is 1280px or greater!');
          } else {
            this.widthSize = 1;
            console.log('Viewport width is less than 500px!');
          }
        })
  }

}
