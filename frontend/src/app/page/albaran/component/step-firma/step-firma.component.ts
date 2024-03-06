import { outputAst } from '@angular/compiler';
import { AfterViewInit, Component, ElementRef, EventEmitter, Input, Output, QueryList, ViewChildren } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { SignatureFieldComponent } from '@app/core/components/signature-field/signature-field.component';

@Component({
  selector: 'app-step-firma',
  templateUrl: './step-firma.component.html',
  styleUrls: ['./step-firma.component.scss']
})
export class StepFirmaComponent implements  AfterViewInit {

  @Input() formGroup!: FormGroup;
  @Output() formSubmit = new EventEmitter<string>();

  public title = 'Firma';


  @ViewChildren(SignatureFieldComponent) public sigs!: QueryList<SignatureFieldComponent>;
  @ViewChildren('firmaContainer') public firmaContainer!: QueryList<ElementRef>;

  constructor(fb: FormBuilder) {

  }

  public ngAfterViewInit() {
    this.beResponsive();
    this.setOptions();
  }

  // set the dimensions of the signature pad canvas
  public beResponsive() {
    console.log('Resizing firmaContainer pad canvas to suit container size');
    this.size(this.firmaContainer.first, this.sigs.first);
  }

  public size(container: ElementRef, sig: SignatureFieldComponent) {
    sig.signaturePad.set('canvasWidth', container.nativeElement.clientWidth);
    sig.signaturePad.set('canvasHeight', container.nativeElement.clientHeight);
  }

  public setOptions() {
    this.sigs.first.signaturePad.set('penColor', 'rgb(0,0,0)');
  }

  public submit() {

    // console.log(this.sigs.first.signaturePad);

    const firmaUrl = this.sigs.first.signaturePad.toDataURL();
    console.log('CAPTURED firmaContainer:' + firmaUrl);
    this.formGroup.controls['firma'].setValue(firmaUrl);
    this.formSubmit.emit(firmaUrl);
  }

  public clear() {
    this.sigs.first.clear.bind(this);
    this.sigs.first.clear();
    this.formGroup.controls['firma'].setValue(undefined);
  }
}
