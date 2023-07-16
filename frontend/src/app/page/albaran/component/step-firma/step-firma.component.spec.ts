import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StepFirmaComponent } from './step-firma.component';

describe('StepFirmaComponent', () => {
  let component: StepFirmaComponent;
  let fixture: ComponentFixture<StepFirmaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StepFirmaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StepFirmaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
