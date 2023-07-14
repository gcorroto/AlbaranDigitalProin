import { Routes } from '@angular/router';


export const APP_ROUTES: Routes = [

  {
    path: '',
    canActivate: [],
    data: { roles: [], menu: false, headers: false, footer: false, breadcrumbs: false  },
    loadChildren: () => import('@albaran/albaran.module').then(m => m.AlbaranModule)
  },

];
