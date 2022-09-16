// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `.angular-cli.json`.

export const environment = {
  local: false,
  production: false,

  countriesServiceURL: '/api/system/config/countries',
  oldApplicationURL: 'https://demosecure.studentclearinghouse.org/tsorder/schoolwelcome',
  organizationsServiceURL: '/api/recipient-organization/eo',
  recipientServiceURL: '/api/recipient-organization/exchange-detail',
  recipientTypesServiceURL: '/api/system/config/send-to-types',
  schoolsByStateServiceURL: '/api/recipient-organization/institution/state',
  schoolServiceURL: '/api/school/ficecode',
  schoolsServiceURL: '/api/school',
  statesServiceURL: '/api/system/config/states'
};
