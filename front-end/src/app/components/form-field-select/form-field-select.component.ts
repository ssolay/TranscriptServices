import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

import { SelectOption } from '../../interfaces/select-option.interface';
import { ValidationMessage } from '../../classes/validation-message';


@Component({
  selector: 'nsc-form-field-select',
  templateUrl: './form-field-select.component.html',
  styleUrls: ['./form-field-select.component.scss'],
})
export class FormFieldSelectComponent implements OnInit {
  @Input() controlName: string;
  @Input() group: FormGroup;
  @Input() hint: string;
  @Input() placeholder: string;
  @Input() selectObjects: SelectOption[];

  constructor (private validationMessage: ValidationMessage) {}

  ngOnInit () {}
}
