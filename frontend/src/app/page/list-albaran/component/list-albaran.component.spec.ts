import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListAlbaranComponent } from './list-albaran.component';

describe('ListAlbaranComponent', () => {
  let component: ListAlbaranComponent;
  let fixture: ComponentFixture<ListAlbaranComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListAlbaranComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListAlbaranComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
