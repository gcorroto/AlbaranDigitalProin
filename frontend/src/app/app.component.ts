import { Component, OnInit } from '@angular/core';
import { NavigationStart, Router } from '@angular/router';
import { UntilDestroy, untilDestroyed } from '@ngneat/until-destroy';
import { NgxUiLoaderService } from 'ngx-ui-loader';
@UntilDestroy({ checkProperties: true })
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent implements OnInit  {
  title = 'frontend';
  constructor(
    private readonly router: Router,
    private readonly ngxService: NgxUiLoaderService
  ) {}
  ngOnInit(): void {
    this.router.events
      .pipe(untilDestroyed(this))
      .subscribe((event) => {
        if (event instanceof NavigationStart) {
          this.ngxService.start();
        }
      });
  }

}
