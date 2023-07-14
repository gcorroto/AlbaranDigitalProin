import {
  BreakpointObserver,
  BreakpointState
} from '@angular/cdk/layout';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UntilDestroy } from '@ngneat/until-destroy';
import { NgxUiLoaderService } from 'ngx-ui-loader';

@UntilDestroy({ checkProperties: true })
@Component({
    template: ''
})


export class BaseComponentPage  {

    levelSize: number;
    state: BreakpointState;

    protected router: Router;
    protected ngxService: NgxUiLoaderService;
    protected breakpointObserver: BreakpointObserver;

    // protected translateService: TranslateService;
    // protected notificationService: NotificationService;


    constructor(ngxService: NgxUiLoaderService, router: Router, breakpointObserver: BreakpointObserver) {
            this.router = router;
            this.ngxService = ngxService;
            this.breakpointObserver = breakpointObserver;
    }

    ngOnInit() {
      this.levelSize = 1;
      this.breakpointObserver
        .observe(['(min-width: 500px)'])
        .subscribe((state: BreakpointState) => {
          if (state.matches) {
            this.levelSize = 1;
            console.log('Viewport width is 500px or greater!');
          } else {
            this.levelSize = 0;
            console.log('Viewport width is less than 500px!');
          }
        });
    }
}

