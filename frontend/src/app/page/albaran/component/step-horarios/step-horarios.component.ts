import { Component, ElementRef, Input, OnInit, QueryList, ViewChildren } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { StepBaseComponent } from '../step-base/step-base.component';

@Component({
  selector: 'app-step-horarios',
  templateUrl: './step-horarios.component.html',
  styleUrls: ['./step-horarios.component.scss']
})
export class StepHorariosComponent extends StepBaseComponent implements OnInit {

  @Input() formGroup!: FormGroup;
  @ViewChildren('horariosContainer') public horariosContainer!: QueryList<ElementRef>;

  constructor(private _formBuilder: FormBuilder) {
    super();
    this.container = this.horariosContainer;
  }

  ngOnInit(): void {
    this.sizeParentElement = window.innerWidth;
  }

}
