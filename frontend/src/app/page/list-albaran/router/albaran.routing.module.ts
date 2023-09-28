import { ListAlbaranComponent } from '@app/page/list-albaran/component/list-albaran.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AlbaranComponent } from '@albaran/component/albaran.component';
import { PrimeraCargaAlbaranResolver } from '@app/core/resolvers/albaran.resolver';

const routes: Routes = [
  {
    path: '',
    component: ListAlbaranComponent,
    // canActivate: [],
    data: { roles: [] },
    resolve: {
      albaranesUsuario: PrimeraCargaAlbaranResolver
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AlbaranRoutingModule { }
