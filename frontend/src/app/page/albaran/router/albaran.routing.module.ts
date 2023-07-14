import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AlbaranComponent } from '@albaran/component/albaran.component';
import { PrimeraCargaAlbaranResolver } from '@app/core/resolvers/albaran.resolver';

const routes: Routes = [
  {
    path: '',
    component: AlbaranComponent,
    // canActivate: [],
    data: { roles: [] },
    resolve: {
      albaran: PrimeraCargaAlbaranResolver
    }
  },
  {
    path: ':albaranId',
    component: AlbaranComponent,
    // canActivate: [guard],
    data: { roles: [] },
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AlbaranRoutingModule { }
