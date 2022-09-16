import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material';

import { config } from '../../config/config';
import { DialogHelpComponent } from '../dialog-help/dialog-help.component';


@Component({
  selector: 'nsc-form-field-toggle',
  templateUrl: './form-field-toggle.component.html',
  styleUrls: ['./form-field-toggle.component.scss'],
})
export class FormFieldToggleComponent implements OnInit {
  @Input() controlName: string;
  @Input() disabled = false;
  @Input() group: FormGroup;
  @Input() help: string;
  @Input() label: string;
  @Input() note: string;
  @Input() valueNo = config.values.no;
  @Input() valueYes = config.values.yes;

  values = {
    yes: this.valueYes,
    no: this.valueNo
  };

  constructor (public dialog: MatDialog) {}

  ngOnInit () {
    // reset if the properties were defined (odd that it wasn't picked up during initialization);
    this.values = {
      yes: this.valueYes,
      no: this.valueNo
    };
  }

  // button toggle to change the selected value;
  // this will trigger a listener to update the form requirements;
  changeValue (value: string): void {
    const newValue = {};

    newValue[this.controlName] = value;

    this.group.patchValue(newValue);
  }

  openDialog (): void {
    const dialogRef = this.dialog.open(DialogHelpComponent, {
      width: this.help.length > 300 ? '480px' : '310px',
      data: {
        body: this.help
      }
    });
  }
}
