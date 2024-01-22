import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PrimeraCargaAlbaranResolver } from '@app/core/resolvers/albaran.resolver';
import { AlbaranComponent } from '@app/page/albaran/component/albaran.component';
import { ListAlbaranComponent } from '@app/page/list-albaran/component/list-albaran.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'list',
    pathMatch: 'full'
  },
  {
    path: 'list',
    component: ListAlbaranComponent,
    data: { roles: [] },
    resolve: {
      albaranesUsuario: PrimeraCargaAlbaranResolver
    }
  },
  // {
  //   path: 'sign/:id',
  //   loadChildren: () => import('@app/page/albaran/component/albaran.module').then(m => m.AlbaranDetailModule)
  // }
  {
    path: 'sign/:id',
    component: AlbaranComponent,
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AlbaranRoutingModule { }
