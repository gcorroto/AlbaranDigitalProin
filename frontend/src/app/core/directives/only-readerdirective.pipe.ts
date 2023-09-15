import { Directive, ElementRef, Input, OnChanges, OnInit, SimpleChanges } from "@angular/core";

@Directive({
  selector: '[onlyReader]'
})
export class OnlyReaderdirectivesPipe implements OnInit, OnChanges  {

  @Input() read: boolean;

  constructor(private elementRef: ElementRef) {
  }

  ngOnInit(): void {
    if (!this.reader()) {
      this.elementRef.nativeElement.display = 'none';
    } else  {
      this.elementRef.nativeElement.display = 'block';
    }
  }

  ngOnChanges(changes: SimpleChanges){
    if(changes.read){
      console.log('read changed');
      if (!this.reader()) {
        this.elementRef.nativeElement.display = 'none';
      } else  {
        this.elementRef.nativeElement.display = 'block';
      }
    }
  }

  private reader() {
    return this.read;
  }
}
