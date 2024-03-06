import {Component, Inject} from '@angular/core';
import {
  MAT_DIALOG_DATA,
  MatDialogContent,
  MatDialogRef,
  MatDialogActions,
} from '@angular/material/dialog';

export interface DialogData {
  message: string;
  btnText: string;
}

@Component({
  selector: 'app-generic-dialog',
  templateUrl: './generic-dialog.component.html',
  styleUrls: ['./generic-dialog.component.scss'],
})
export class GenericDialogComponent {

  public dialogData!: DialogData;

  constructor(
    public dialogRef: MatDialogRef<GenericDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData) {

  }

  onClick(): void {
    this.dialogRef.close();
  }
}
