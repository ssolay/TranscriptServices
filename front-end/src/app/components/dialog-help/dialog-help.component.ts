import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';

import { TimeoutService } from '../../services/timeout/timeout.service';


@Component({
  selector: 'nsc-dialog-help',
  templateUrl: './dialog-help.component.html',
  styleUrls: ['./dialog-help.component.scss']
})
export class DialogHelpComponent implements OnInit {
  constructor (
    @Inject(MAT_DIALOG_DATA) public data: { title?: string; body: string; },
    public dialogRef: MatDialogRef<DialogHelpComponent>,
    private timeoutService: TimeoutService
  ) {}

  ngOnInit () {}

  // initiate a close action by clicking on the close button within the dialog;
  close (): void {
    this.timeoutService.startWarningCountdown();
    this.dialogRef.close();
  }
}
