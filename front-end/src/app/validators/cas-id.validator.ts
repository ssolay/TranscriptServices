import { AbstractControl } from '@angular/forms';


export function ValidateCasId (abstractControl: AbstractControl) {
  if (abstractControl.value) {
    let errors = false;

    // there must be two dashes in the value;
    if ((abstractControl.value.match(/-/g) || []).length !== 2) {
      errors = true;
    }

    // but the dashes must be non-consecutive;
    if (abstractControl.value.indexOf('--') !== -1) {
      errors = true;
    }

    if (errors) {
      return {
        casId: true
      };
    }
  }
}
