import { HttpClient, HttpContext, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Formats } from '@const/Enums';
import { EntityApi } from '@const/types';
import { environment } from '@environment';
import { GenericService } from '@services/generic.service';
import { UtilService } from '@util/util.service.';
import { Observable } from 'rxjs';

export interface HttpClientOptions {
  headers?: HttpHeaders | {
      [header: string]: string | string[];
  };
  params?: HttpParams | {
      [param: string]: string | number | boolean | ReadonlyArray<string | number | boolean>;
  };
}


@Injectable()
export class HttpServiceImpl<T,ID> implements GenericService<T,ID> {

  private readonly url: string;

  constructor(
    private readonly http: HttpClient) {
    this.url = environment.API_SERVER.BASE_URL;
  }

  getById(id: ID, ent: EntityApi, format?: Formats, options?: HttpClientOptions): Observable<T> {
    console.log("options", options);
    return this.http.get<T>(`${this.url}/${ent}/${id}${UtilService.formatQueryParam(format)}`, options);
  }

  getAll(ent: EntityApi, format?: Formats, options?: HttpClientOptions): Observable<T[]> {
    return this.http.get<T[]>(`${this.url}/${ent}${UtilService.formatQueryParam(format)}`, options);
  }

  postSave(id: ID, t: T, ent: EntityApi, format?: Formats, options?: HttpClientOptions): Observable<T> {
    return this.http.post<T>(`${this.url}/${ent}${id ?`/${id}`:''}${UtilService.formatQueryParam(format)}`, t, options);
  }

  putUpdate(id: ID, t: T, ent: EntityApi, format?: Formats, options?: HttpClientOptions): Observable<T> {
    return this.http.put<T>(`${this.url}/${ent}${id ?`/${id}`:''}${UtilService.formatQueryParam(format)}`, t, options);
  }

  patchUpdate(p: Partial<T>, ent: EntityApi, format?: Formats, options?: HttpClientOptions): Observable<T> {
    return this.http.patch<T>(`${this.url}/${ent}${UtilService.formatQueryParam(format)}`, p, options);
  }

}

