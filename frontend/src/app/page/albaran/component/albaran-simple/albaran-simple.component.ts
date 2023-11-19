import { Component, ElementRef, Input, OnInit, QueryList, ViewChildren } from '@angular/core';
import { Albaran } from '@app/core/dto/albaran.model';
import { UntilDestroy } from '@ngneat/until-destroy';
import { StepBaseComponent } from '../step-base/step-base.component';
import { MatCardModule } from '@angular/material/card';
import { MatGridListModule } from '@angular/material/grid-list';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { NgxUiLoaderService } from 'ngx-ui-loader';

@UntilDestroy({ checkProperties: true })
@Component({
  templateUrl: './albaran-simple.component.html',
  standalone: true,
  styleUrls: ['./albaran-simple.component.scss'],
  imports: [
    MatCardModule,
    MatGridListModule,
    CommonModule
  ]
})
export class AlbaranSimpleComponent  extends StepBaseComponent implements OnInit {
  @Input() albaran!: Albaran;
  @ViewChildren('albaranSimpleContainer') public albaranSimpleContainer!: QueryList<ElementRef>;
  constructor(
    protected readonly router: Router,
    protected readonly ngxService: NgxUiLoaderService,
    ) {
    super();
    this.container = this.albaranSimpleContainer;
  }

  ngOnInit(): void {
    this.sizeParentElement = window.innerWidth;
  }


 navigateToSignAlbaran(albaran: Albaran) {
  this.ngxService.start();
  this.router.navigate(['/sign', albaran.numAlbaran], {
    state: {
      albaran: albaran
    }
  });
}

}
