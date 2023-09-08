import { Component, ElementRef, QueryList } from '@angular/core';
import { UntilDestroy } from '@ngneat/until-destroy';

@UntilDestroy({ checkProperties: true })
@Component({
    template: ''
})
export class StepBaseComponent {

    sizeParentElement: number;
    numColumns: number = 3*2;
    container: QueryList<ElementRef>;

    constructor() {
    }

    size(container: QueryList<ElementRef>) {
      if(container) {
        this.sizeParentElement = container.first['_element'].nativeElement.clientWidth;
        console.log('Resizing container with value ' + this.sizeParentElement );
      }
    }

    public getColSpan(fraccion : number): number {
        return this.sizeParentElement<=700 ? this.numColumns : (this.numColumns)/fraccion;
    }

    // set the dimensions of the container
    public beResponsive() {
      this.size(this.container);
    }


    public getWidth(fraccion : number): number {
      if(fraccion>1){
        return this.sizeParentElement<=700 ? this.sizeParentElement : this.sizeParentElement/fraccion;
      } else{
        return this.sizeParentElement;
      }
    }

}

