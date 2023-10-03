import { HttpClientModule } from '@angular/common/http';
import { APP_INITIALIZER, NgModule } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatTreeModule } from '@angular/material/tree';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AlbaranMaterialModule } from '@component/material.module';
// import { CacheConfigService, NgxCachemanagerModule } from '@grec0/ngx-cachemanager';
import { HttpCacheModule } from '@services/generic-service.module';
import { CookieService } from '@services/impl/cookie-service.service';
import { NgxUiLoaderConfig, NgxUiLoaderModule, SPINNER as spinner } from 'ngx-ui-loader';
import { RoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';


const defaultLoaderConfig: NgxUiLoaderConfig = {
	fgsType: spinner.circle,
	overlayColor: 'rgba(256, 256, 256, 0.8)',
	logoSize: 50,
	fgsSize: 60,
	pbColor: '#fff',
	fgsColor: '#1c4466',
  bgsColor: '#1c4466',
  bgsOpacity: 0.9,
  bgsPosition: 'bottom-right',
  bgsSize: 30,
  bgsType: 'square-jelly-box',
};

// export function initializer(cacheConfig: CacheConfigService): () => Promise<any> {
// 	return (): Promise<any> => cacheConfig.loadGlobalConfig({logger:true});
// }

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    RoutingModule,
    HttpClientModule,
    // NgxCachemanagerModule,
    // SwapiHttpModule.forRoot(),
    AlbaranMaterialModule.forRoot(),
    HttpCacheModule.forRoot(),
    NgxUiLoaderModule.forRoot(defaultLoaderConfig),
    MatTreeModule,
    MatIconModule,
    MatButtonModule
  ],
  bootstrap: [AppComponent],
  exports: [HttpClientModule, NgxUiLoaderModule],
  providers: [
    // {
		// 	provide: APP_INITIALIZER,
		// 	useFactory: initializer,
		// 	deps: [CacheConfigService],
		// 	multi: true
    // },
    CookieService
  ]
})
export class AppModule { }
