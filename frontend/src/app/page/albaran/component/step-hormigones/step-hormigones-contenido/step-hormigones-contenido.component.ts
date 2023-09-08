import { Component, ElementRef, Input, OnInit, QueryList, ViewChildren } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { StepBaseComponent } from '../../step-base/step-base.component';
import { DesgloseContenido } from '@app/core/dto/desglose-contenido.model';

export type tiposCemento = 'Cementos'|'Aditivos'|'Adiciones';

@Component({
  selector: 'app-step-hormigones-contenido',
  templateUrl: './step-hormigones-contenido.component.html',
  styleUrls: ['./step-hormigones-contenido.component.scss']
})
export class StepHormigonesContenidoComponent extends StepBaseComponent implements OnInit {

  @Input() formGroup: FormGroup;
  @ViewChildren('hormigonesContainer') public hormigonesContenidoContainer: QueryList<ElementRef>;
  cementos: DesgloseContenido[];
  aditivos: DesgloseContenido[];
  adiciones: DesgloseContenido[];

  elementos: tiposCemento[] = ['Cementos','Aditivos','Adiciones'];

  constructor(private _formBuilder: FormBuilder) {
    super();
    this.container = this.hormigonesContenidoContainer;
  }

  ngOnInit(): void {
    this.sizeParentElement = window.innerWidth;
    this.cementos = this.formGroup.controls['hormigon.contenido.cementos'].value
    this.aditivos = this.formGroup.controls['hormigon.contenido.aditivos'].value
    this.adiciones = this.formGroup.controls['hormigon.contenido.adiciones'].value
  }

}
