import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StepHormigonesComponent } from './step-hormigones.component';

describe('StepHormigonesComponent', () => {
  let component: StepHormigonesComponent;
  let fixture: ComponentFixture<StepHormigonesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StepHormigonesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StepHormigonesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
