import { Component, ElementRef, Input, OnInit, QueryList, ViewChildren } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { SizeLvl1, SizeLvl2, SizeLvl3, SizeLvl3_large, SizeLvlFull } from '@const/styles';
import { StepBaseComponent } from '../step-base/step-base.component';

@Component({
  selector: 'app-step-hormigones',
  templateUrl: './step-hormigones.component.html',
  styleUrls: ['./step-hormigones.component.scss']
})
export class StepHormigonesComponent extends StepBaseComponent implements OnInit {

  @Input() formGroup: FormGroup;
  @ViewChildren('hormigonesContainer') public hormigonesContainer: QueryList<ElementRef>;

  constructor(private _formBuilder: FormBuilder) {
    super();
    this.container = this.hormigonesContainer;
  }

  ngOnInit(): void {
    this.sizeParentElement = window.innerWidth;
  }

}
