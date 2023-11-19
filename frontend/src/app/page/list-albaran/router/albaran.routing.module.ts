import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PrimeraCargaAlbaranResolver } from '@app/core/resolvers/albaran.resolver';
import { ListAlbaranComponent } from '@app/page/list-albaran/component/list-albaran.component';

const routes: Routes = [
  {
    path: '',
    component: ListAlbaranComponent,
    data: { roles: [] },
    resolve: {
      albaranesUsuario: PrimeraCargaAlbaranResolver
    }
  },
  {
    path: 'sign/:id',
    loadChildren: () => import('@app/page/albaran/component/albaran.module').then(m => m.AlbaranDetailModule)
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AlbaranRoutingModule { }
