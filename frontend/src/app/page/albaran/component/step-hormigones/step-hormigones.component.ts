import { Component, ElementRef, Input, OnInit, QueryList, ViewChildren } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Albaran, LineaAlbaranDto } from '@app/core/dto/albaran.model';
import { SizeLvl1, SizeLvl2, SizeLvl3, SizeLvl3_large, SizeLvlFull } from '@const/styles';
import { StepBaseComponent } from '../step-base/step-base.component';

@Component({
  selector: 'app-step-hormigones',
  templateUrl: './step-hormigones.component.html',
  styleUrls: ['./step-hormigones.component.scss']
})
export class StepHormigonesComponent extends StepBaseComponent implements OnInit {

  @Input() albaran!: Albaran | undefined;
  @ViewChildren('hormigonesContainer') public hormigonesContainer!: QueryList<ElementRef>;

  constructor() {
    super();
    this.container = this.hormigonesContainer;
    console.log("constructor albaran", this.albaran);
  }

  ngOnInit(): void {
    this.sizeParentElement = window.innerWidth;
    console.log("ngOnInit albaran", this.albaran);
  }

}
