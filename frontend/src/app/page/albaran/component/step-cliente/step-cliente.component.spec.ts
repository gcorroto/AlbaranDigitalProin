import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StepClienteComponent } from './step-cliente.component';

describe('StepClienteComponent', () => {
  let component: StepClienteComponent;
  let fixture: ComponentFixture<StepClienteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StepClienteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StepClienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
