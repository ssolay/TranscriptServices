import { Validators } from '@angular/forms';


// reusable address values and validations;
// works for whenever address fields are in use (requestor, recipient, payment);
export const configAddress = {
  hintZipDomestic: '',
  hintZipInternational: '(Optional)',

  hintPhoneDomestic: '(XXX) XXX-XXXX',
  hintPhoneInternational: 'Include the country and area/city codes',

  labelStateUS: 'State/Territory/APO',
  labelStateCA: 'Province/Territory',
  labelStateInternational: 'State/Province/Territory',

  validationPhoneDomestic: validationPhoneDomestic,
  validationPhoneInternational: validationPhoneInternational,
  validationZipCA: validationZipCA,
  validationZipUS: validationZipUS
};

export function validationZipCA () {
  return [
    Validators.required,
    Validators.minLength(3),
    Validators.pattern(/^[A-Za-z]\d[A-Za-z](( )?\d[A-Za-z]\d)?$/)
  ];
}

export function validationZipUS () {
  return [
    Validators.required,
    Validators.minLength(5),
    Validators.pattern(/^\d{5}(-\d{4})?$/)
  ];
}

export function validationPhoneDomestic () {
  return [
    Validators.minLength(10),
    Validators.pattern(/^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/)
  ];
}

export function validationPhoneInternational () {
  return [
    Validators.minLength(10)
  ];
}
