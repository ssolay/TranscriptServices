import { AbstractControl } from '@angular/forms';
import { isEmpty as _isEmpty } from 'lodash';


export function ValidateDateEnrolled (fromControlName, toControlName) {
  return (abstractControl: AbstractControl) => {
    const fromControl = abstractControl.get(fromControlName);
    const fromValue = fromControl.value;
    const toControl = abstractControl.get(toControlName);
    const toValue = toControl.value;
    const errors = toControl.errors || {};

    // if the from year isn't less than (or equal) to the to year, set a dateEnrolled error;
    // there may be other errors, dont overwrite them;
    // if the years are valid, remove the dateEnrolled error;
    if (fromValue && toValue && fromValue > toValue) {
      errors.dateEnrolled = true;
    } else {
      delete errors.dateEnrolled;
    }

    // if there are no errors present, return null;
    // angular will present an error even with an empty error object;
    toControl.setErrors(_isEmpty(errors) ? null : errors);
  };
}
