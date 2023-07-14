import {HostBinding, Component, ElementRef, Input, OnChanges, ViewChild} from '@angular/core';

import {
  animate, style, transition, trigger
} from "@angular/animations";

@Component({
  selector: 'app-label-sw',
  template: `
    <ng-content [ngStyle]="LabelTransform()"></ng-content>
  `,
  styles: [`
    :host {
      display: block;
      overflow: hidden;
      font-family: Starjout;
      color: rgb(172, 162, 22);
    },


  `]
})
export class LabelSwComponent  {
  @Input()
  trigger: string;

  @Input()
  sizeText: number = 44;

  constructor(private element: ElementRef) {}

  LabelTransform() {
    return this.transformStyle();
  }
  private transformStyle() {
    return { 'font-size': `${this.sizeText}px` };
  }

}
