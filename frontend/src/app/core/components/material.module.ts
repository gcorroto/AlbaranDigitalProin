import { MatInputModule } from '@angular/material/input';
import { ModuleWithProviders, NgModule } from '@angular/core';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatSliderModule } from '@angular/material/slider';
import { MatStepperModule } from '@angular/material/stepper';
import { MatToolbarModule } from '@angular/material/toolbar';


@NgModule({
    imports: [
      MatStepperModule,
      MatToolbarModule,
      MatInputModule,
      MatButtonModule,
      MatFormFieldModule,
      MatAutocompleteModule,
      MatIconModule,
      MatCardModule,
      MatSliderModule,
  ],
    exports: [],
    declarations: [
  ]
})
export class AlbaranMaterialModule {
    static forRoot(): ModuleWithProviders<AlbaranMaterialModule> {
        return {
            ngModule: AlbaranMaterialModule
        };
    }
}
