import { AbstractControl } from '@angular/forms';


export class ManageFields {
  disable (controls: AbstractControl[]): void {
    controls.forEach(control => {
      // disable the field, and then clear out any value;
      // clear out the value so if the field is shown again, it won't be shown with a selected value;
      control.setValue(null);
      control.disable();
    });
  }

  enable (controls: AbstractControl[]): void {
    controls.forEach(control => {
      // set the field as untouched so validatio doesn't automatically get applied (if no value is set);
      // without this, a newly enabled field may be shown with an error;
      // we dont want an error shown on fields that the user hasnt interacted with;
      // if a value is already defined, then it's ok to show a validation error;
      if (control.value === null || control.value === '') {
        control.markAsUntouched();
      }
      control.enable();
    });
  }

  reset (controls: AbstractControl[]): void {
    controls.forEach(control => {
      // the field is currently enabled;
      // we want to clear out any values, and prevent any error message from being displayed;
      // but only if a value is currently applied to the field;
      if (control.value) {
        control.markAsUntouched();
        control.setValue(null);
      }
    });
  }
}
