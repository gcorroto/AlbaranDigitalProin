import {HostBinding, Component, ElementRef, Input, OnChanges, ViewChild} from '@angular/core';

import {
  animate, style, transition, trigger
} from "@angular/animations";

@Component({
  selector: 'app-smooth-height',
  template: `
    <ng-content></ng-content>
  `,
  styles: [`
    :host {
      display: block;
      overflow: hidden;
      font-family: Starjout;
      color: rgb(172, 162, 22);
      /* font-size: 44px; */
    },


  `],
  animations: [
    trigger('grow', [
      transition('void <=> *', [style({'font-size': '{{sizeText}}px'}),]),
      transition('* <=> *', [
        style({height: '{{startHeight}}px', opacity: 0, 'font-size': '{{sizeText}}px'}),
        animate('.5s ease'),
      ], {params: {startHeight: 0}})
    ])
  ]
})
export class SmoothHeightComponent implements OnChanges {
  @Input()
  trigger: string;

  startHeight: number;

  @Input()
  sizeText: number = 44;

  constructor(private element: ElementRef) {}

  @HostBinding('@grow') get grow() {
    return {value: this.trigger, params: {startHeight: this.startHeight}};
  }

  setStartHeight(){
    this.startHeight = this.element.nativeElement.clientHeight;
  }

  ngOnChanges(){
    this.setStartHeight();
  }
}
