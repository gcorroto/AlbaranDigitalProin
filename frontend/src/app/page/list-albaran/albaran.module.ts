import { AlbaranComponent } from '@albaran/component/albaran.component';
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
// import { StepHorariosComponent } from '@app/page/albaran/component/step-horarios/step-horarios.component';
import { ToolbarComponent } from '@component/toolbar/toolbar.component';
import { PrimeraCargaAlbaranResolver } from '@core/resolvers/albaran.resolver';
// import { NgxMaterialTimepickerModule } from 'ngx-material-timepicker';
import { CdkStepperModule } from '@angular/cdk/stepper';
import { MatChipsModule } from '@angular/material/chips';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatProgressBarModule } from '@angular/material/progress-bar';
import { ListAlbaranComponent } from '@app/page/list-albaran/component/list-albaran.component';
import { NgxMaterialTimepickerModule } from 'ngx-material-timepicker';
import { StepClienteModule } from '../albaran/component/step-cliente/step-cliente.module';
import { StepFirmaModule } from '../albaran/component/step-firma/step-firma.module';
import { StepHorariosModule } from '../albaran/component/step-horarios/step-horarios.module';
import { StepHormigonesModule } from '../albaran/component/step-hormigones/step-hormigones.module';
import { StepMeteorologiaModule } from '../albaran/component/step-meteorologia/step-meteorologia.module';
import { StepRecepcionModule } from '../albaran/component/step-recepcion/step-recepcion.module';
import { StepTransporteModule } from '../albaran/component/step-transporte/step-transporte.module';


const components = [
  // AlbaranSimpleComponent,
  ListAlbaranComponent,
  ToolbarComponent,
  AlbaranComponent
];


// const directives = [
// 	OnlyReaderdirectivesPipe
// ];

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
    StepClienteModule,
    StepTransporteModule,
    StepHormigonesModule,
    // StepHormigonesContenidoComponent,
    StepMeteorologiaModule,
    StepHorariosModule,
    StepRecepcionModule,
    StepFirmaModule,
	],
	declarations: [components],
	bootstrap: [ListAlbaranComponent],
	providers: [
		resolvers
	]
})
export class AlbaranModule {

}
