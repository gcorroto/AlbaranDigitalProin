import { ILog } from './../dto/log.model';
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve } from '@angular/router';
import { EntityApiEnum } from '@const/Enums';
import { Albaran } from '@dto/albaran.model';
import { GenericCacheService } from '@services/cache/generic.service';
import { Observable, of } from 'rxjs';
import { Log } from '@dto/log.model';

@Injectable()
export class PrimeraCargaAlbaranResolver implements Resolve<Albaran[]> {


  private cacheConsulta:Albaran[] = [];

    constructor(
        private readonly serviceAlbaran: GenericCacheService<Albaran,string>
    ) { }

    resolve(route: ActivatedRouteSnapshot): Observable<Albaran[]> {
      // request param ???
        return new Observable<Albaran[]>((observ) => {
          console.debug(`realizamos primera carga albaran`);
          const observer:Observable<Albaran[]>= this.cacheConsulta && this.cacheConsulta.length>0 ?  of(this.cacheConsulta) : this.serviceAlbaran.getAll(EntityApiEnum.Albaran);
          observer
          .subscribe({
            next:(data: Albaran[]) => {
              this.cacheConsulta = data;
              observ.next(data);
            },
            error:(err) => {
              this.cacheConsulta = [];
              observ.error(err);
            },
            complete:()=> {
              observ.complete();
            },
        });
        });
    }
}
