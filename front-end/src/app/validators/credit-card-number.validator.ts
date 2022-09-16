import { AbstractControl } from '@angular/forms';

import { config } from '../config/config';


export function ValidateCreditCardNumber (abstractControl: AbstractControl) {
  const value = abstractControl.value;

  const regExAmericanExpress = new RegExp(config.values.creditCard.patternAmericanExpress());
  const regExDinersClub = new RegExp(config.values.creditCard.patternDinersClub());
  const regExDiscover = new RegExp(config.values.creditCard.patternDiscover());
  const regExJCB = new RegExp(config.values.creditCard.patternJCB());
  const regExMastercard = new RegExp(config.values.creditCard.patternMastercard());
  const regExVisa = new RegExp(config.values.creditCard.patternVisa());

  if (value) {
    const testAmericanExpress = regExAmericanExpress.test(value);
    const testDinersClub = regExDinersClub.test(value);
    const testDiscover = regExDiscover.test(value);
    const testJCB = regExJCB.test(value);
    const testMastercard = regExMastercard.test(value);
    const testVisa = regExVisa.test(value);

    // if none of them are valid, return an error;
    if (!(testAmericanExpress || testDinersClub || testDiscover || testJCB || testMastercard || testVisa)) {
      return {
        creditCardNumber: true
      };
    }
  }
}
