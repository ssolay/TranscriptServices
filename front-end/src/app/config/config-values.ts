export const configValues = {
  autocomplete: {
    // message to dispaly in the autocomplete when there are no matches;
    noMatch: {
      name: 'There is no match for the school entered',
      disabled: true // make sure this value isn't selectable;
    },
    // used when adding a Not in List value to an autocomplete form field;
    notInList: {
      name: 'Not in List'
    }
  },

  creditCard: {
    patternAmericanExpress: patternAmericanExpress,
    patternDinersClub: patternDinersClub,
    patternDiscover: patternDiscover,
    patternJCB: patternJCB,
    patternMastercard: patternMastercard,
    patternVisa: patternVisa
  },

  select: {
    // used when adding a Not in List value to a SELECT form field;
    notInList: {
      name: 'Not in List',
      value: 'NOT IN LIST'
    }
  },

  // yes/no values which will be passed to the back-end, and used in logic checks;
  no: 'N',
  yes: 'Y',

  // recipient address values are based on the delivery methods;
  recipientType: {
    college: 'S',
    organization: 'A',
    business: 'O',
    me: 'M'
  },

  // country values used to determine internation/domestic validation requirements;
  country: {
    us: 'US',
    ca: 'CA'
  },

  // delivery method value used to determine route and `how many copies...` values;
  deliveryMethod: {
    electronicValues: ['E', 'T'], // value that triggers an electronic delivery method (route and display values);
    electronicDisplaySource: ['Electronic PDF', 'Electronic Exchange'], // value to convert from;
    electronicDisplayTarget: 'Electronic' // value to convert to;
  },

  // value for disabled form fields;
  nullDisabled: {
    value: null,
    disabled: true
  },

  consentDateFormat: 'hh:mm:ss MM/DD/YYYY',
  confirmationDateFormat: 'MM/DD/YYYY hh:mm:ss',

  // API values used to indicate a field should be displayed and/or required;
  born: {
    require: ['B', 'R'],
    show: ['B', 'O', 'R']
  },

  // timeout values used when working with the loading indicator (progress-bar);
  loading: {
    delay: 2000,
    interval: 500
  },

  warningLoseInformation: 'You will lose the information entered on this page. Are you sure you want to continue back?'
};

export function patternAmericanExpress () {
  return /^3[47][0-9]{13}$/;
}

export function patternDinersClub () {
  return /^3(?:0[0-5]|[68][0-9])[0-9]{11}$/;
}

export function patternDiscover () {
  return /^6(?:011|5[0-9]{2})[0-9]{12}$/;
}

export function patternJCB () {
  return /^(?:2131|1800|35\d{3})\d{11}$/;
}

export function patternMastercard () {
  return /^(?:5[1-5][0-9]{2}|222[1-9]|22[3-9][0-9]|2[3-6][0-9]{2}|27[01][0-9]|2720)[0-9]{12}$/;
}

export function patternVisa () {
  return /^4[0-9]{12}(?:[0-9]{3})?$/;
}
