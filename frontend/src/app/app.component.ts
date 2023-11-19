import { Component, OnInit } from '@angular/core';
import { NavigationStart, Router } from '@angular/router';
import { UntilDestroy, untilDestroyed } from '@ngneat/until-destroy';
import { NgxUiLoaderService } from 'ngx-ui-loader';
import { BreadcrumbService } from './core/services/breadcrumb.service';
@UntilDestroy({ checkProperties: true })
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent implements OnInit  {
  title = 'frontend';
  level1: string = 'Listado Albaranes';
  level2: string = '';

  constructor(
    private readonly router: Router,
    private readonly ngxService: NgxUiLoaderService,
    private breadcrumbService: BreadcrumbService
  ) {}





  breadCrumbMain() {
    this.router.navigate(['/']);
  }


  ngOnInit(): void {
    this.router.events
      .pipe(untilDestroyed(this))
      .subscribe((event) => {
        if (event instanceof NavigationStart) {
          this.ngxService.start();
        }
      });
      console.log('subscribe to breadcrumb detail id');

      this.breadcrumbService.getRouteChangeObservable().subscribe((id: string )=> {
        console.log('breadcrumb detail id', id);
        this.level2 = id;
      });
  }

}
