import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { Routes, RouterModule, NoPreloading } from '@angular/router';
import { APP_ROUTES } from './routes';
import { AlbaranMaterialModule } from './core/components/material.module';

const routes: Routes = [];

// @NgModule({
//   imports: [RouterModule.forRoot(routes, { relativeLinkResolution: 'legacy' })],
//   exports: [RouterModule]
// })
// export class AppRoutingModule { }

@NgModule({
	imports: [
		BrowserAnimationsModule,
    AlbaranMaterialModule.forRoot(),
		RouterModule.forRoot(APP_ROUTES, {
			useHash: false,
			enableTracing: false,
			// preloadingStrategy: NoPreloading,
      // scrollPositionRestoration: 'enabled',
      // anchorScrolling: 'enabled',
      // scrollOffset: [0, 168],
		 }
		)
	],
	providers: [
		// KeycloakAuthorizationGuard,
    // HomeGuard,
    // InitializeGuard
	],
	exports: [RouterModule]
})
export class RoutingModule {

}

