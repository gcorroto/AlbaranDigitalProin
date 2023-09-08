import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StepHorariosComponent } from './step-horarios.component';

describe('StepHorariosComponent', () => {
  let component: StepHorariosComponent;
  let fixture: ComponentFixture<StepHorariosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StepHorariosComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StepHorariosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
