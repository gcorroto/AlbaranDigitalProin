// import { Component, EventEmitter, Input } from "@angular/core";

// @Component({
//   selector: 'data-table-pagination',
//   templateUrl: './pagination.component.html'
// })
// export class PaginationComponent {

//   @Input()
//   public listOfAvailablePages: number[];

//   @Output()
//   public pageChangeRequested = new EventEmitter<number>();

//   constructor(public paginationService: PaginationService) {
//     this.paginationService.currentPage = 1;
//   }

//   public onPageSelection(pageNumber: number): void {
//     this.paginationService.currentPage = pageNumber;
//     this.pageChangeRequested.emit(pageNumber);
//   }

//   public onAdjacentPageSelection(dir: number): void {
//     if (dir < 0 && this.paginationService.currentPage > 1) {
//       this.onPageSelection(this.paginationService.currentPage - 1);
//     } else if (dir > 0 && this.paginationService.currentPage < this.listOfAvailablePages.length) {
//       this.onPageSelection(this.paginationService.currentPage + 1);
//     }
//   }
// }
