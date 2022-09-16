import { AbstractControl } from '@angular/forms';


export function ValidateRequireEither (primaryControlName, secondaryControlName) {
  return (abstractControl: AbstractControl) => {
    const primaryControl = abstractControl.get(primaryControlName);
    const primaryValue = primaryControl.value;
    const secondaryControl = abstractControl.get(secondaryControlName);
    const secondaryValue = secondaryControl.value;

    // dont need to show a specific field validation error;
    // but return an error so the form is invalid;
    // the error isn't assigned to a form field because we don't know which one to put it on since both share the requirement;
    if (!(primaryValue && primaryValue.length || secondaryValue && secondaryValue.length)) {
      return {
        atLeastOne: true
      };
    }
  };
}
