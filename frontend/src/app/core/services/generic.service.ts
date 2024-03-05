import { Injectable } from '@angular/core';
import { Formats } from '@const/Enums';
import { EntityApi } from '@const/types';
import { Observable } from 'rxjs';
import { HttpClientOptions } from './impl/http.service';

/***
 * Servicio Singleton HTTP
 * @template {T,I}
 * @path '/api/v1/films'
 */
@Injectable({
  providedIn: 'root'
})
export abstract class GenericService<T,I> {

  /**
   * @template GET by id
   * @param {I}
   * @return {Async<T>}
   * **/
  abstract getById(id: I,ent: EntityApi, format?: Formats, options?: HttpClientOptions): Observable<T>;

  /**
   * @template GET all
   * @param
   * @return {Async<T>}
   * **/
  abstract getAll(ent: EntityApi, format?: Formats, options?: HttpClientOptions): Observable<T[]>;


  /**
   * @template {T} POST
   * @param
   * @return {Async<T>}
   * **/
  abstract postSave(id: I, t: T, ent: EntityApi, format?: Formats, options?: HttpClientOptions): Observable<T>;

  /**
   * @template {T} PUT
   * @param
   * @return {Async<T>}
   * **/
  abstract putUpdate(id: I, t: T, ent: EntityApi, format?: Formats, options?: HttpClientOptions): Observable<T>;

  /**
   * @template {T} PATCH
   * @param
   * @return {Async<T>}
   * **/
  abstract patchUpdate(p: Partial<T>, ent: EntityApi, format?: Formats, options?: HttpClientOptions): Observable<T>;

}
