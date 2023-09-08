import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StepMeteorologiaComponent } from './step-meteorologia.component';

describe('StepMeteorologiaComponent', () => {
  let component: StepMeteorologiaComponent;
  let fixture: ComponentFixture<StepMeteorologiaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StepMeteorologiaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StepMeteorologiaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
