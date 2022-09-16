import { AbstractControl } from '@angular/forms';
import { cloneDeep as _cloneDeep, filter as _filter } from 'lodash';

import { AutocompleteOption } from '../interfaces/autocomplete-option.interface';
import { config } from '../config/config';


export function ValidateSchoolAutocomplete (validValues: AutocompleteOption[]) {
  const validValuesClone = _cloneDeep(validValues);

  // not in list is a valid value that doesn't exist in the validValues;
  // we used a cloned version of the array so the not in list value doesn't get appended to the view;
  validValuesClone.push(config.values.autocomplete.notInList);

  return (abstractControl: AbstractControl) => {
    const controlValue = abstractControl.value;

    if (controlValue) {
      // reduce the possible values down to find a match to the entered value;
      // transform case since the dataService will transform the content after save;
      // if we dont transform the content, then on edit they won't match;
      const filterdValues = _filter(validValuesClone, (value: AutocompleteOption) => {
        return value.name.toUpperCase() === controlValue.toUpperCase();
      });

      // if we didn't find exactly one, then it's an invalid entry;
      if (filterdValues.length !== 1) {
        return {
          schoolAutocomplete: true
        };
      }
    }
  };
}
