import { Component, ElementRef, Input, OnInit, QueryList, ViewChildren } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { StepBaseComponent } from '../step-base/step-base.component';

@Component({
  selector: 'app-step-meteorologia',
  templateUrl: './step-meteorologia.component.html',
  styleUrls: ['./step-meteorologia.component.scss']
})
export class StepMeteorologiaComponent extends StepBaseComponent implements OnInit {

  @Input() formGroup: FormGroup;
  @ViewChildren('meteorologiaContainer') public meteorologiaContainer: QueryList<ElementRef>;

  constructor(private _formBuilder: FormBuilder) {
    super();
    this.container = this.meteorologiaContainer;
  }

  ngOnInit(): void {
    this.sizeParentElement = window.innerWidth;
  }

}
