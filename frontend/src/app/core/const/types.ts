import { Albaran } from '@dto/albaran.model';
import { Observable } from 'rxjs';

export type Async<T> = Promise<T> | Observable<T>;
export type EntityApi = 'albaran' | 'cliente' | 'transporte' | 'meteorologia' | 'hormigon'| 'log';
export type Dto = Albaran | unknown;
