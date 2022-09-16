// cf. https://gist.github.com/slavafomin/17ded0e723a7d3216fb3d8bf845c2f30
import { AbstractControl } from '@angular/forms';
import { isEmpty as _isEmpty } from 'lodash';


export function ValidateMatch (primaryControlName, secondaryControlName, secondaryRequired = true) {
  return (abstractControl: AbstractControl) => {
    const primaryControl = abstractControl.get(primaryControlName);
    const secondaryControl = abstractControl.get(secondaryControlName);
    const errors = secondaryControl.errors || {};

    // only run if the secondary control is required;
    // or the user has entered an optional value;
    // so no value is allowed, or a matching value;
    if (secondaryRequired || secondaryControl.value) {
      // only run if both values have been entered, otherwise .toLowerCase() blows up;
      if (primaryControl.value && secondaryControl.value) {
        // if the values dont match, set a match error;
        // there may be other errors, dont overwrite them;
        // if they do match, make sure the match error is removed;
        if (primaryControl.value.toLowerCase() !== secondaryControl.value.toLowerCase()) {
          errors.match = true;
        } else {
          delete errors.match;
        }
      }
    }

    // if there are no errors present, return null;
    // angular will present an error even with an empty error object;
    secondaryControl.setErrors(_isEmpty(errors) ? null : errors);
  };
}
