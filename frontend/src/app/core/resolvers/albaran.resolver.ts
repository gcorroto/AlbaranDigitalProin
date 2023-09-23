import { ILog } from './../dto/log.model';
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve } from '@angular/router';
import { EntityApiEnum } from '@const/Enums';
import { Albaran } from '@dto/albaran.model';
import { GenericCacheService } from '@services/cache/generic.service';
import { Observable } from 'rxjs';
import { Log } from '@dto/log.model';

@Injectable()
export class PrimeraCargaAlbaranResolver implements Resolve<Albaran[]> {


    constructor(
        private readonly serviceAlbaran: GenericCacheService<Albaran,string>
    ) { }

    resolve(route: ActivatedRouteSnapshot): Observable<Albaran[]> {
      // request param ???
      // const clientId: string = route.paramMap.get('clientId');

        return new Observable<Albaran[]>((observ) => {
          console.debug(`realizamos primera carga albaran`);
          this.serviceAlbaran.getAll(EntityApiEnum.Albaran)
          .subscribe((data: Albaran[]) => {
              observ.next(data);
            },
            (err) => {
              observ.error(err);
            },
            ()=> {
              observ.complete();
            }
          );
        });
    }
}
