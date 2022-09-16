export const configPayment = {
  // credit card values for the `/payment` route;
  creditCardMonths: [
    {
      name: 'January',
      value: '01'
    },
    {
      name: 'Febuary',
      value: '02'
    },
    {
      name: 'March',
      value: '03'
    },
    {
      name: 'April',
      value: '04'
    },
    {
      name: 'May',
      value: '05'
    },
    {
      name: 'June',
      value: '06'
    },
    {
      name: 'July',
      value: '07'
    },
    {
      name: 'August',
      value: '08'
    },
    {
      name: 'September',
      value: '09'
    },
    {
      name: 'October',
      value: '10'
    },
    {
      name: 'November',
      value: '11'
    },
    {
      name: 'December',
      value: '12'
    }
  ],

  // credit card values for the `/payment` route;
  creditCardYears: setCreditCardYears
};

// dynamically build the CC years into the future (so the values dont have to be updated each Januaray);
export function setCreditCardYears () {
  const years = [];
  const year = (new Date()).getFullYear();
  let step;

  // get 10 years into the future;
  for (step = 0; step < 11; step++) {
    const yearAsString = (year + step).toString();

    years.push({
      name: yearAsString,
      value: yearAsString.substr(-2)
    });
  }

  return years;
}
