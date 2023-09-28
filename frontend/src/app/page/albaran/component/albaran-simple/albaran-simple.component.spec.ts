import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AlbaranSimpleComponent } from './albaran-simple.component';

describe('AlbaranSimpleComponent', () => {
  let component: AlbaranSimpleComponent;
  let fixture: ComponentFixture<AlbaranSimpleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AlbaranSimpleComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AlbaranSimpleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
