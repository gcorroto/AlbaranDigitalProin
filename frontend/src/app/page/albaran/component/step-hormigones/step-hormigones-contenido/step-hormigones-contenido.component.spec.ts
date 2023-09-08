import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StepTransporteComponent } from './step-hormigones-contenido.component';

describe('StepTransporteComponent', () => {
  let component: StepTransporteComponent;
  let fixture: ComponentFixture<StepTransporteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StepTransporteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StepTransporteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
