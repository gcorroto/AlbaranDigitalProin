import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve } from '@angular/router';
import { EntityApiEnum } from '@const/Enums';
import { Albaran } from '@dto/albaran.model';
import { GenericCacheService } from '@services/cache/generic.service';
import { Observable } from 'rxjs';

@Injectable()
export class PrimeraCargaAlbaranResolver implements Resolve<Albaran> {


    constructor(
        private readonly service: GenericCacheService<Albaran,string>,
    ) { }

    resolve(route: ActivatedRouteSnapshot): Observable<Albaran> {
      // request param ???
      // const clientId: string = route.paramMap.get('clientId');

        return new Observable<Albaran>((observ) => {
          console.info("realizamos primera carga albaran");
          const subscribtion = this.service.getAll(EntityApiEnum.Albaran)
          .subscribe((data: Albaran) => {
              observ.next(data);
              observ.complete();
            },
            (err) => observ.error(err),
            ()=> {
              // if(subscribtion && !subscribtion.closed) {
              //   subscribtion.unsubscribe();
              // }
              observ.complete();
            }
          );
        });
    }
}
