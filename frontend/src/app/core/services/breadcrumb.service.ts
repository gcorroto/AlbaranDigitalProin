import { Injectable } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { Subject } from 'rxjs';
import { filter } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class BreadcrumbService {
  private routeChangeSubject = new Subject<string>();

  constructor(private router: Router) {
    this.router.events.pipe(
      filter(event => event instanceof NavigationEnd)
    ).subscribe(() => {
      const id = this.router.routerState.snapshot.url;
      this.routeChangeSubject.next(id.replace('/sign/','')); // Emit the id parameter
    });
  }

  getRouteChangeObservable() {
    return this.routeChangeSubject.asObservable();
  }
}
