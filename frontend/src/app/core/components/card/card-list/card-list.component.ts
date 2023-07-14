import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { DataTableType } from '../../table/table.component';

@Component({
  selector: 'app-card-list',
  templateUrl: './card-list.component.html',
  styleUrls: ['./card-list.component.scss']
})
export class CardListComponent<A> implements OnInit,OnChanges {

  constructor() { }

  @Input()
  public tableContent: A[];
  @Input()
  public tableConfig: DataTableType;

  ngOnInit(): void {
  }

  ngOnChanges(changes: SimpleChanges) {
    if (changes['tableConfig']) {
      this.tableConfig = this.tableConfig;
    }else if (changes['tableContent']) {
        this.tableContent = this.tableContent;
    }
  }
}
