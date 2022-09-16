import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

import { SelectOptgroup } from '../../interfaces/select-optgroup.interface';
import { ValidationMessage } from '../../classes/validation-message';


@Component({
  selector: 'nsc-form-field-select-optgroup',
  templateUrl: './form-field-select-optgroup.component.html',
  styleUrls: ['./form-field-select-optgroup.component.scss'],
})
export class FormFieldSelectOptgroupComponent implements OnInit {
  @Input() controlName: string;
  @Input() group: FormGroup;
  @Input() hint: string;
  @Input() placeholder: string;
  @Input() selectObjects: SelectOptgroup[];

  constructor (private validationMessage: ValidationMessage) {}

  ngOnInit () {}
}
