import { HttpClientModule } from '@angular/common/http';
import { APP_INITIALIZER, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CardListComponent } from '@component/card/card-list/card-list.component';
import { CardComponent } from '@component/card/card/card.component';
import { LightCardComponent } from '@component/card/light-card/light-card.component';
import { LabelSwComponent } from '@component/label-sw/label-sw.component';
import { SmoothHeightComponent } from '@component/smooth-height/smooth-height.component';
import { DataTableWrapperComponent } from '@component/table/data-table-wrapper/data-table-wrapper.component';
import { CacheConfigService, NgxCachemanagerModule } from '@grec0/ngx-cachemanager';
import { HttpCacheModule } from '@services/generic-service.module';
import { NgxUiLoaderConfig, NgxUiLoaderModule, SPINNER as spinner } from 'ngx-ui-loader';
import { RoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AlbaranMaterialModule } from '@component/material.module';
import { CookieService } from '@services/impl/cookie-service.service';


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

export function initializer(cacheConfig: CacheConfigService): () => Promise<any> {
	return (): Promise<any> => cacheConfig.loadGlobalConfig({logger:true});
}

@NgModule({
  declarations: [
    DataTableWrapperComponent,
    CardComponent,
    CardListComponent,
    LightCardComponent,
    SmoothHeightComponent,
    LabelSwComponent,
    AppComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    RoutingModule,
    HttpClientModule,
    NgxCachemanagerModule,
    // SwapiHttpModule.forRoot(),
    AlbaranMaterialModule.forRoot(),
    HttpCacheModule.forRoot(),
    NgxUiLoaderModule.forRoot(defaultLoaderConfig)
  ],
  bootstrap: [AppComponent],
  exports: [HttpClientModule, NgxUiLoaderModule],
  providers: [
    {
			provide: APP_INITIALIZER,
			useFactory: initializer,
			deps: [CacheConfigService],
			multi: true
    },
    CookieService
  ]
})
export class AppModule { }
