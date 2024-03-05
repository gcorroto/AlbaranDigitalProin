import { Injectable } from '@angular/core';
import { Formats } from '@app/core/const/Enums';
import { EntityApi } from '@const/types';
import { Observable } from 'rxjs';
import { GenericService } from '../generic.service';
import { HttpClientOptions } from '../impl/http.service';

@Injectable({providedIn:'root'})
export class GenericCacheService<T,I>  implements GenericService<T,I> {
  constructor(
    private readonly service: GenericService<T,I>
  ) {
  }

  getById(id: I, ent: EntityApi, format?: Formats, options?: HttpClientOptions): Observable<T> {
    return this.service.getById(id, ent, format, options);
  }

  getAll(ent: EntityApi, format?: Formats, options?: HttpClientOptions): Observable<T[]> {
    return this.service.getAll(ent, format, options);
  }
  postSave(id: I, t: T, ent: EntityApi, format?: Formats, options?: HttpClientOptions): Observable<T> {
    return this.service.postSave(id, t, ent, format, options);
  }
  putUpdate(id: I, t: T, ent: EntityApi, format?: Formats, options?: HttpClientOptions): Observable<T> {
    return this.service.putUpdate(id, t, ent, format, options);
  }
  patchUpdate(p: Partial<T>, ent: EntityApi, format?: Formats, options?: HttpClientOptions): Observable<T> {
    return this.service.patchUpdate(p, ent, format, options);
  }

}
