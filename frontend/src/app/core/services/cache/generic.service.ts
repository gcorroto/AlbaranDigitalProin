import { Injectable } from '@angular/core';
import { Formats } from '@app/core/const/Enums';
import { EntityApi } from '@const/types';
import { Observable } from 'rxjs';
import { GenericService } from '../generic.service';

@Injectable({providedIn:'root'})
export class GenericCacheService<T,I>  implements GenericService<T,I> {
  constructor(
    private readonly service: GenericService<T,I>
  ) {
  }

  getById(id: I, ent: EntityApi): Observable<T> {
    return this.service.getById(id, ent);
  }

  getAll(ent: EntityApi): Observable<T[]> {
    return this.service.getAll(ent);
  }
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
