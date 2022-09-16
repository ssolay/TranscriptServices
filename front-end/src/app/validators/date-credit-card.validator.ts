import { AbstractControl } from '@angular/forms';
import { isEmpty as _isEmpty } from 'lodash';


export function ValidateDateCreditCard (monthControlName, yearControlName) {
  return (abstractControl: AbstractControl) => {
    const monthControl = abstractControl.get(monthControlName);
    const yearControl = abstractControl.get(yearControlName);
    const errors = monthControl.errors || {};

    const monthValue = Number(monthControl.value);
    let yearValue = Number(yearControl.value);

    // only run the validation is both values are set;
    if (monthValue && yearValue) {
      // transform a 2 digit year into 4;
      // do this after the IF statement so an error message doesn't appear after selecting just a month;
      yearValue = yearValue + 2000;

      // build dates to compare (month is a zero-based index, so subtract one from our selected value);
      const dateCreditCard = new Date(yearValue, monthValue - 1);
      const dateNow = new Date();

      // if the expiration date is less than now, throw an error;
      if (dateCreditCard < dateNow) {
        errors.dateCreditCard = true;
      } else {
        delete errors.dateCreditCard;
      }

      // if there are no errors present, return null;
      // angular will present an error even with an empty error object;
      monthControl.setErrors(_isEmpty(errors) ? null : errors);
    }
  };
}
