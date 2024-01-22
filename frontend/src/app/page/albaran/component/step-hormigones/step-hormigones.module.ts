import { CdkAccordionModule } from '@angular/cdk/accordion';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatDividerModule } from '@angular/material/divider';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatSliderModule } from '@angular/material/slider';
import { MatStepperModule } from '@angular/material/stepper';
import { MatToolbarModule } from '@angular/material/toolbar';
import { AlbaranRoutingModule } from '@app/page/list-albaran/router/albaran.routing.module';
// import { StepFormComponent } from '@component/step-form/step-form.component';
import { AngularSignatureFieldModule } from '@app/core/components/signature-field/signature-pad.module';
// import { NgxMaterialTimepickerModule } from 'ngx-material-timepicker';
import { CdkStepperModule } from '@angular/cdk/stepper';
import { MatChipsModule } from '@angular/material/chips';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatProgressBarModule } from '@angular/material/progress-bar';
import { NgxMaterialTimepickerModule } from 'ngx-material-timepicker';
import { StepHormigonesComponent } from './step-hormigones.component';
import { StepHormigonesContenidoComponent } from './step-hormigones-contenido/step-hormigones-contenido.component';

@NgModule({
  declarations: [
    StepHormigonesComponent,
    StepHormigonesContenidoComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    CommonModule,
		AlbaranRoutingModule,
		ReactiveFormsModule,
    FormsModule,
    AngularSignatureFieldModule,
    MatPaginatorModule,
    MatStepperModule,
    MatToolbarModule,
    MatInputModule,
    MatButtonModule,
    MatFormFieldModule,
    MatAutocompleteModule,
    MatIconModule,
    MatCardModule,
    MatSliderModule,
    MatGridListModule,
    MatDividerModule,
    MatSlideToggleModule,
    CdkAccordionModule,
    CdkStepperModule,
    MatProgressBarModule,
    MatExpansionModule,
    MatChipsModule,
    NgxMaterialTimepickerModule,
  ],
  exports: [
    StepHormigonesComponent
  ]
})
export class StepHormigonesModule { }
