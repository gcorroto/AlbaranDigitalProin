import { Component, ElementRef, Input, OnInit, QueryList, ViewChildren } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { StepBaseComponent } from '../step-base/step-base.component';

@Component({
  selector: 'app-step-recepcion',
  templateUrl: './step-recepcion.component.html',
  styleUrls: ['./step-recepcion.component.scss']
})
export class StepRecepcionComponent extends StepBaseComponent implements OnInit {

  @Input() formGroup: FormGroup;
  @ViewChildren('recepcionContainer') public recepcionContainer: QueryList<ElementRef>;

  constructor(private _formBuilder: FormBuilder) {
    super();
    this.container = this.recepcionContainer;
  }

  ngOnInit(): void {
    this.sizeParentElement = window.innerWidth;
  }

}
