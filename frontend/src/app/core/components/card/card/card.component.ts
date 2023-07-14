import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { DataTableType } from '../../table/table.component';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.scss']
})
export class CardComponent<A> implements OnInit,OnChanges {

  constructor() { }

  @Input()
  public content: A;
  @Input()
  public tableConfig: DataTableType;

  ngOnInit(): void {
  }

  ngOnChanges(changes: SimpleChanges) {
    if (changes['tableConfig']) {
        this.tableConfig = this.tableConfig;
    }else if (changes['content']) {
        this.content = this.content;
    }
  }
}
