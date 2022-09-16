import * as moment from 'moment';
import { AbstractControl } from '@angular/forms';


export function ValidateDateOfBirth (abstractControl: AbstractControl) {
  if (abstractControl.value) {
    const dateFormat = 'MM/DD/YYYY';
    const yearModifier = 11;
    const momentDate = moment(abstractControl.value, dateFormat);
    const dateRangePast = moment('01/01/1930', dateFormat);
    const today = new Date();
    const dateRangeFuture = moment(today).year(today.getFullYear() - yearModifier);
    let errors = false;

    // moment will allow a single slash and figure things out, but that's not allowed per the reqs;
    // reqs allow two different formats, so check for both;
    if (abstractControl.value.length === 10) {
      // is date valid;
      if (momentDate.isValid()) {
        // is date less than 1930;
        if (momentDate.isBefore(dateRangePast)) {
          errors = true;
        // is date less greater than now - 11 years;
        } else if (momentDate.isAfter(dateRangeFuture)) {
          errors = true;
        }
      // otherwise invalid;
      } else {
        errors = true;
      }
    // otherwise invalid;
    } else {
      errors = true;
    }

    if (errors) {
      return {
        dateOfBirth: true
      };
    }
  }
}
