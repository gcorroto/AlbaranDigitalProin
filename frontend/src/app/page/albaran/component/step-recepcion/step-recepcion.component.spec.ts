import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StepRecepcionComponent } from './step-recepcion.component';

describe('StepRecepcionComponent', () => {
  let component: StepRecepcionComponent;
  let fixture: ComponentFixture<StepRecepcionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StepRecepcionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StepRecepcionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
