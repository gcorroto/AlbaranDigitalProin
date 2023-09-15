import { Meteorologia } from '@dto/meteorologia.model';
import { MatDividerModule } from '@angular/material/divider';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatGridListModule } from '@angular/material/grid-list';
import { AlbaranComponent } from '@albaran/component/albaran.component';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatSliderModule } from '@angular/material/slider';
import { MatStepperModule } from '@angular/material/stepper';
import { MatToolbarModule } from '@angular/material/toolbar';
import {CdkAccordionModule} from '@angular/cdk/accordion';
import { AlbaranRoutingModule } from '@albaran/router/albaran.routing.module';
import { StepFormComponent } from '@component/step-form/step-form.component';
import { ToolbarComponent } from '@component/toolbar/toolbar.component';
import { StepClienteComponent } from '@albaran/component/step-cliente/step-cliente.component';
import { StepHormigonesComponent } from '@albaran/component/step-hormigones/step-hormigones.component';
import { PrimeraCargaAlbaranResolver } from '@core/resolvers/albaran.resolver';
import { StepTransporteComponent } from '@app/page/albaran/component/step-transporte/step-transporte.component';
import { StepMeteorologiaComponent } from '@app/page/albaran/component/step-meteorologia/step-meteorologia.component';
import { StepHorariosComponent } from '@app/page/albaran/component/step-horarios/step-horarios.component';
import { StepRecepcionComponent } from '@app/page/albaran/component/step-recepcion/step-recepcion.component';
import { StepHormigonesContenidoComponent } from '@app/page/albaran/component/step-hormigones/step-hormigones-contenido/step-hormigones-contenido.component';
import { AngularSignaturePadModule } from '@component/signature-pad/signature-pad.module';
import { StepFirmaComponent } from '@albaran/component/step-firma/step-firma.component';
import { AngularSignatureFieldModule } from '@app/core/components/signature-field/signature-pad.module';
import { NgxMaterialTimepickerModule } from 'ngx-material-timepicker';
import { OnlyReaderdirectivesPipe } from '@core/directives/only-readerdirective.pipe';

const components = [
	AlbaranComponent,

  ToolbarComponent,
  StepFormComponent,

  StepClienteComponent,
  StepHormigonesComponent,
  StepHormigonesContenidoComponent,
  StepTransporteComponent,
  StepMeteorologiaComponent,
  StepHorariosComponent,
  StepRecepcionComponent,
  StepFirmaComponent,
];

const pipes = [
];
const directives = [
	OnlyReaderdirectivesPipe
];

const resolvers = [
	PrimeraCargaAlbaranResolver
];
@NgModule({
	imports: [
		CommonModule,
		AlbaranRoutingModule,
		ReactiveFormsModule,
    FormsModule,
    AngularSignatureFieldModule,

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

    NgxMaterialTimepickerModule
	],
	declarations: [components, pipes, directives],
	entryComponents: [AlbaranComponent],
	providers: [
		resolvers
	]
})
export class AlbaranModule {

}
