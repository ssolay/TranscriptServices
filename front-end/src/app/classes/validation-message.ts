import { FormControl } from '@angular/forms';
import { isEmpty as _isEmpty } from 'lodash';


export class ValidationMessage {
  get (formField: FormControl, label: string): string {
    // if no errors, do nothing;
    // if errors, check properties to determine which message to show;
    // only a single message is displayed at a time, so the order of the IF statements is important;
    if (_isEmpty(formField.errors) === false) {
      const errors = formField.errors;
      let message = `${ label } is required`; // default error message;

      if (errors.casId ||
        errors.creditCardNumber ||
        errors.dateCreditCard ||
        errors.dateEnrolled ||
        errors.dateOfBirth ||
        errors.email ||
        errors.invalid ||
        errors.max ||
        errors.min ||
        errors.minlength ||
        errors.pattern) {
        message = `Invalid ${ label }`;
      }

      if (errors.schoolAutocomplete) {
        message = 'There is no match for the school entered';
      }

      // will always win out due to being run after all previous form validation;
      if (errors.match) {
        message = `This does not match ${ label.replace('Confirm', '') }`;
      }

      return message;
    }
  }
}
