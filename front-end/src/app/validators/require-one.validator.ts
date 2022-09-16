import { AbstractControl } from '@angular/forms';


export function ValidateRequireOne (controls: AbstractControl[]) {
  return (abstractControl: AbstractControl) => {
    let atLeastOneValue = false;

    controls.forEach(control => {
      // expecting a boolean value;
      // so one of the values needs to be true;
      if (control.value) {
        atLeastOneValue = true;
      }
    });

    // dont need to show a specific field validation error;
    // but return an error so the form is invalid;
    // the error isn't assigned to a form field because we don't know which one to put it on since multiple componets share the requirement;
    if (!atLeastOneValue) {
      return {
        atLeastOne: true
      };
    }
  };
}
