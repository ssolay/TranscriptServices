import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

import { ValidationMessage } from '../../classes/validation-message';


@Component({
  selector: 'nsc-form-field-input',
  templateUrl: './form-field-input.component.html',
  styleUrls: ['./form-field-input.component.scss'],
})
export class FormFieldInputComponent implements OnChanges, OnInit {
  @Input() autocomplete = 'off';
  @Input() controlName: string;
  @Input() group: FormGroup;
  @Input() hint: string;
  @Input() mask: (string | RegExp)[] | boolean = false;
  @Input() maxlength: number;
  @Input() placeholder: string;
  @Input() required = true;
  @Input() suffix: string;
  @Input() type = 'text';

  content = {
    hint: ''
  };

  constructor (private validationMessage: ValidationMessage) {}

  ngOnInit () {
    this.setHint(this.hint, this.required);
  }

  ngOnChanges (changes: SimpleChanges) {
    const newHint = changes.hint ? changes.hint.currentValue : this.hint;
    const newRequired = changes.required ? changes.required.currentValue : this.required;

    this.setHint(newHint, newRequired);
  }

  setHint (hint: string, required: boolean): void {
    // if a field isn't required and it's optional, we need to combine the `hint` values;
    this.content.hint = `${ hint || '' } ${ required ? '' : '(Optional)' }`;
  }
}
