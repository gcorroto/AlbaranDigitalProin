import { Component, ElementRef, Input, OnInit, QueryList, ViewChildren, WritableSignal } from '@angular/core';
import { Albaran } from '@app/core/dto/albaran.model';
import { UntilDestroy } from '@ngneat/until-destroy';
import { StepBaseComponent } from '../step-base/step-base.component';
import { MatCardModule } from '@angular/material/card';
import { MatGridListModule } from '@angular/material/grid-list';

@UntilDestroy({ checkProperties: true })
@Component({
  templateUrl: './albaran-simple.component.html',
  standalone: true,
  styleUrls: ['./albaran-simple.component.scss'],
  imports: [
    MatCardModule,
    MatGridListModule
  ]
})
export class AlbaranSimpleComponent  extends StepBaseComponent implements OnInit {
  @Input() albaran!: WritableSignal<Albaran>;
  @ViewChildren('albaranSimpleContainer') public albaranSimpleContainer!: QueryList<ElementRef>;
  constructor() {
    super();
    this.container = this.albaranSimpleContainer;
  }

  ngOnInit(): void {
    this.sizeParentElement = window.innerWidth;
  }

}
