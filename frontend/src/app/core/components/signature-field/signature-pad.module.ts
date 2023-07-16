import { NgModule } from '@angular/core';
import { SignatureFieldComponent } from './signature-field.component';
import { AngularSignaturePadModule } from '../signature-pad/signature-pad.module';

@NgModule({
  declarations: [SignatureFieldComponent],
  imports: [AngularSignaturePadModule],
  exports: [SignatureFieldComponent],
})
export class AngularSignatureFieldModule {
}
