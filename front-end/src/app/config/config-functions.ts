import { isEmpty as _isEmpty, isEqual as _isEqual } from 'lodash';
import { FormControl } from '@angular/forms';

import { configValues } from './config-values';
import { SelectOption } from '../interfaces/select-option.interface';


export const configFunctions = {
  convertDeliveryMethod: convertDeliveryMethod,
  noErrorFound: noErrorFound,
  validationMessage: validationMessage
};

// certain delivery methods (defined in values) need to be converted before displayed to the user;
// e.g. Electronic PDF > Electronic;
export function convertDeliveryMethod (value: string): string {
  let returnValue = value;

  configValues.deliveryMethod.electronicDisplaySource.forEach(source => {
    returnValue = returnValue.replace(source, configValues.deliveryMethod.electronicDisplayTarget);
  });

  return returnValue;
}

// display the validation message per form field;
export function validationMessage (formField: FormControl, label: string) {
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

export function noErrorFound (json): boolean {
  return json && json.status !== 'fail';
}
