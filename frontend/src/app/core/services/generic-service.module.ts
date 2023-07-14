// others
import { ModuleWithProviders, NgModule } from '@angular/core';
import { GenericService } from '@services/generic.service';
import { HttpServiceImpl } from '@services/impl/http.service';
import { UtilService } from '@util/util.service.';
import { UtilTableService } from '@util/util.table.service';
import { GenericCacheService } from '@services/cache/generic.service';
import { CSRF_TOKEN_PROVIDERS } from '../interceptors/csrfinterceptor.service';


const httpServices: any = [
  { provide: GenericService,  useClass: HttpServiceImpl },

];

const asyncServices: any = [
  GenericCacheService
];

const utilServices: any = [
  UtilService,
  UtilTableService
];

@NgModule({
})
export class HttpCacheModule {

	static forRoot(): ModuleWithProviders<HttpCacheModule> {
		return {
			ngModule: HttpCacheModule,
			providers: [
        CSRF_TOKEN_PROVIDERS,
        httpServices,
        asyncServices,
        utilServices
			]
		};
	}
}
