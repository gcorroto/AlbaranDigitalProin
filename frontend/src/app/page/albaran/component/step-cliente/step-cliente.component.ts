import { Component, ElementRef, Input, OnInit, QueryList, ViewChildren } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { SizeLvl1, SizeLvl2, SizeLvl3, SizeLvl3_large, SizeLvlFull } from '@const/styles';
import { StepBaseComponent } from '../step-base/step-base.component';

@Component({
  selector: 'app-step-cliente',
  templateUrl: './step-cliente.component.html',
  styleUrls: ['./step-cliente.component.scss']
})
export class StepClienteComponent extends StepBaseComponent implements OnInit {

  @Input() formGroup: FormGroup;
  @ViewChildren('clienteContainer') public clienteContainer: QueryList<ElementRef>;

  constructor(private _formBuilder: FormBuilder) {
    super();
    this.container = this.clienteContainer;
  }

  ngOnInit(): void {
    this.sizeParentElement = window.innerWidth;
  }

}
