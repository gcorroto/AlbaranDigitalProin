import { Component, EventEmitter, Input, OnChanges, Output, SimpleChanges } from '@angular/core';
import { DataTableType, PageChangeEventType, RowActionWithData } from '../table.component';

@Component({
  selector: 'app-data-table-wrapper',
  templateUrl: './data-table-wrapper.component.html',
  styleUrls: ['./data-table-wrapper.component.scss']
})
export class DataTableWrapperComponent<A> implements OnChanges {

  @Input()
  public tableConfig: DataTableType;

  @Input()
  public tableContent: A[];

  @Output()
  public getDataForPage = new EventEmitter<PageChangeEventType>();

  @Output()
  public startRowAction = new EventEmitter<{}>();

  public pageList: number[];

  ngOnChanges(changes: SimpleChanges) {
    // only run when property "data" changed
    if (changes['tableConfig']) {
        this.tableConfig = this.tableConfig;
    } else if (changes['tableContent']) {
      this.tableContent = this.tableContent;
  }
}

  public onRowActionClicked(actionType: string, rowData: A): void {
    const userAction: RowActionWithData<A> = {
      actionToPerform: actionType,
      rowData: rowData
    };

    this.startRowAction.emit(userAction);
  }
}
