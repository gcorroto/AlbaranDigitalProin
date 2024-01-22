import { Component, ElementRef, Input, OnInit, QueryList, ViewChildren } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { StepBaseComponent } from '../step-base/step-base.component';

@Component({
  selector: 'app-step-transporte',
  templateUrl: './step-transporte.component.html',
  styleUrls: ['./step-transporte.component.scss']
})
export class StepTransporteComponent extends StepBaseComponent implements OnInit {

  @Input() formGroup: FormGroup;
  @ViewChildren('transporteContainer') public transporteContainer: QueryList<ElementRef>;

  constructor(private _formBuilder: FormBuilder) {
    super();
    this.container = this.transporteContainer;
  }

  ngOnInit(): void {
    this.sizeParentElement = window.innerWidth;
  }

}
