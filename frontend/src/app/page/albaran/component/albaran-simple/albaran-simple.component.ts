import { Component, ElementRef, Input, OnInit, QueryList, ViewChildren } from '@angular/core';
import { Albaran } from '@app/core/dto/albaran.model';
import { UntilDestroy } from '@ngneat/until-destroy';
import { StepBaseComponent } from '../step-base/step-base.component';

@UntilDestroy({ checkProperties: true })
@Component({
  templateUrl: './albaran-simple.component.html',
  styleUrls: ['./albaran-simple.component.scss']
})
export class AlbaranSimpleComponent  extends StepBaseComponent implements OnInit {
  @Input() albaran: Albaran;
  @ViewChildren('albaranSimpleContainer') public albaranSimpleContainer: QueryList<ElementRef>;
  constructor() {
    super();
    this.container = this.albaranSimpleContainer;
  }

  ngOnInit(): void {
    this.sizeParentElement = window.innerWidth;
  }

}
