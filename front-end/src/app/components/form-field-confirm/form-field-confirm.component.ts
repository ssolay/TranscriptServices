import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';


@Component({
  selector: 'nsc-form-field-confirm',
  templateUrl: './form-field-confirm.component.html',
  styleUrls: ['./form-field-confirm.component.scss'],
})
export class FormFieldConfirmComponent implements OnInit {
  @Input() autocomplete = 'off';
  @Input() controlNamePrimary: string;
  @Input() controlNameConfirm: string;
  @Input() group: FormGroup;
  @Input() hint: string;
  @Input() mask: (string | RegExp)[] | boolean = false;
  @Input() maxlength: number;
  @Input() placeholder: string;
  @Input() requiredPrimary = true;
  @Input() requiredConfirm = true;
  @Input() type = 'text';

  content = {
    hintPrimary: null,
    hintConfirm: null
  };

  values = {
    // used to prevent the confirm field from being autopopulated;
    autocompleteConfirm: null
  };

  constructor () {}

  ngOnInit () {
    // cf. https://developer.mozilla.org/en-US/docs/Web/Security/Securing_your_site/Turning_off_form_autocompletion
    // if the type is a password, browsers can override the random autocomplete value, so use 'new-password';

    this.values.autocompleteConfirm = this.type === 'password'
      ? 'new-password'
      : Math.random().toString(36).substring(7);

    // update validity of confirm field as the primary is changed;
    // so if the user enters in a valid value in confirm, and fixes the value in the primary;
    // the user will see the validator automatgically fix itself;
    this.group.controls[this.controlNamePrimary].valueChanges.subscribe((value: string) => {
      if (value && value.length) {
        this.group.controls[this.controlNameConfirm].updateValueAndValidity();
      }
    });

    // set the hints even if they're optional;
    this.content.hintPrimary = this.hint || '';
    this.content.hintConfirm = this.hint || '';

    // if the field is optional, show that (with the optional hint);
    if (this.requiredPrimary === false) {
      this.content.hintPrimary = `${ this.content.hintPrimary } (Optional)`;
    }

    if (this.requiredConfirm === false) {
      this.content.hintConfirm = `${ this.content.hintConfirm } (Optional)`;
    }
  }
}
