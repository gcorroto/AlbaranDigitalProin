import { Injectable } from '@angular/core';
import { Cache, Cacheable, CacheableService } from '@grec0/ngx-cachemanager';
import { Async, EntityApi } from '@const/types';
import { GenericService } from '../generic.service';
import { ResultSearch } from '@dto/result.search.model';
import { Observable } from 'rxjs';
import { Formats } from '@app/core/const/Enums';

@Cacheable({defaultStrategy:'localStorage', logger: true})
@Injectable({providedIn:'root'})
export class GenericCacheService<T,I> extends CacheableService implements GenericService<T,I> {
  constructor(
    private readonly service: GenericService<T,I>
  ) {
    super();
  }

  @Cache({timeout: 10000})
  getById(id: I, ent: EntityApi): Observable<T> {
    return this.service.getById(id, ent);
  }

  @Cache({timeout: 30000})
  getAll(ent: EntityApi): Observable<T> {
    return this.service.getAll(ent);
  }
  @Cache({timeout: 1000})
  postSave(id: I, t: T, ent: EntityApi, format?: Formats): Observable<T> {
    return this.service.postSave(id, t, ent, format);
  }
  putUpdate(id: I, t: T, ent: EntityApi, format?: Formats): Observable<T> {
    return this.service.putUpdate(id, t, ent, format);
  }
  patchUpdate(p: Partial<T>, ent: EntityApi, format?: Formats): Observable<T> {
    return this.service.patchUpdate(p, ent, format);
  }

}
