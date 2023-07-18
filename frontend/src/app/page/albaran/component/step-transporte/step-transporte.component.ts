import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { SizeLvl1, SizeLvl2, SizeLvl3, SizeLvl3_large, SizeLvlFull } from '@const/styles';

@Component({
  selector: 'app-step-transporte',
  templateUrl: './step-transporte.component.html',
  styleUrls: ['./step-transporte.component.scss']
})
export class StepTransporteComponent implements OnInit {

  @Input() formGroup: FormGroup;
  @Input() widthSize: number;

  sizeLvl1: number = SizeLvl1;
  sizeLvl1_3: number = 180;
  sizeLvl2: number = SizeLvl2;
  sizeLvl3: number = SizeLvl3;
  sizeLvl3_large: number = SizeLvl3_large;
  sizeLvlFull: number = SizeLvlFull;

  constructor(private _formBuilder: FormBuilder) { }

  ngOnInit(): void {
  }

}
