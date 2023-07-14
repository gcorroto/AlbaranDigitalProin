import { Component, Input, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-step-form',
  templateUrl: './step-form.component.html',
  styleUrls: ['./step-form.component.scss']
})
export class StepFormComponent implements OnInit {

  @Input() formGroup: FormGroup;
  @Input() direction?: string;
  @Input() title?: string;

  constructor() { }

  ngOnInit(): void {
  }

}
