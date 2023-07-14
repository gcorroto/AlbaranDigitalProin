import { MatDividerModule } from '@angular/material/divider';
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
import { AlbaranRoutingModule } from '@app/page/albaran/router/albaran.routing.module';
import { StepFormComponent } from '@component/step-form/step-form.component';
import { ToolbarComponent } from '@component/toolbar/toolbar.component';
import { StepClienteComponent } from './component/step-cliente/step-cliente.component';
import { PrimeraCargaAlbaranResolver } from '@app/core/resolvers/albaran.resolver';
import { StepTransporteComponent } from './component/step-transporte/step-transporte.component';


const components = [
	AlbaranComponent,
  ToolbarComponent,
  StepFormComponent,
  StepClienteComponent,
  StepTransporteComponent
];

const pipes = [
];
const directives = [
	// MetricResizableDirective
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
    MatDividerModule
	],
	declarations: [components, pipes, directives],
	entryComponents: [AlbaranComponent],
	providers: [
		resolvers
	]
})
export class AlbaranModule {

}
