

import { HTTP_INTERCEPTORS, HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError, filter, map } from 'rxjs/operators';
import { CookieService } from '../services/impl/cookie-service.service';

// const TOKEN_HEADER_KEY = 'Authorization';  // for Spring Boot back-end
const TOKEN_HEADER_KEY = 'x-access-token';    // for Node.js Express back-end

@Injectable()
export class CsrfInterceptor implements HttpInterceptor {

  constructor(private readonly cookieService: CookieService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<Object>> {
    let csrfReq = req;
    if(req.url.includes("/api/v1")) {
    const  token = this.cookieService.get('CSRF-TOKEN');
      csrfReq = req.clone({
        headers: req.headers.set('CSRF-TOKEN', token)
      });
    }

    return next.handle(csrfReq).pipe(
      filter(event => event instanceof HttpResponse),
      map((event: HttpResponse<any>) => {
        if (event.status === 302) {
          window.location.href = csrfReq.url;
          throw new Error('Redirect to login');
        }
        return event;
      }),
      catchError(error => {
      if (error instanceof HttpErrorResponse){
        if(error.status === 401 || error.status === 403){
          return this.handle401Error(req, next);
        } else if(error.status === 200  && error.url.includes('/login')) {
          window.location.href = error.url;
        }
      }

      return throwError(error);
    }));
  }

  private handle401Error(request: HttpRequest<any>, next: HttpHandler) {
    window.location.href = '/login';
    return next.handle(request);
  }


}

export const CSRF_TOKEN_PROVIDERS = [
  { provide: HTTP_INTERCEPTORS, useClass: CsrfInterceptor, multi: true }
];
