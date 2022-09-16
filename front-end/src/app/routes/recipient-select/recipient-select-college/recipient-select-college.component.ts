import { BehaviorSubject,  Subject } from 'rxjs';
import { Component, Input, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { FormGroup, Validators } from '@angular/forms';
import { takeUntil } from 'rxjs/operators';

import { AutocompleteOption } from '../../../interfaces/autocomplete-option.interface';
import { ApiResponseRecipient } from '../../../interfaces/api-response-recipient.interface';
import { BlockingIndicatorService } from '../../../services/blocking-indicator/blocking-indicator.service';
import { config } from '../../../config/config';
import { CountriesService } from '../../../services/countries/countries.service';
import { DataService } from '../../../services/data/data.service';
import { ManageFields } from '../../../classes/manage-fields';
import { RecipientSelectDepartmentComponent } from '../recipient-select-department/recipient-select-department.component';
import { SchoolsByStateService } from '../../../services/schools-by-state/schools-by-state.service';
import { SelectOption } from '../../../interfaces/select-option.interface';
import { SelectOptgroup} from '../../../interfaces/select-optgroup.interface';
import { States } from '../../../interfaces/states.interface';
import { StatesService } from '../../../services/states/states.service';
import { ValidateSchoolAutocomplete } from '../../../validators/school-autocomplete.validator';


@Component({
  selector: 'nsc-recipient-select-college',
  templateUrl: './recipient-select-college.component.html',
  styleUrls: ['./recipient-select-college.component.scss']
})
export class RecipientSelectCollegeComponent implements OnDestroy, OnInit {
  @Input() formGroup: FormGroup;
  @ViewChild(RecipientSelectDepartmentComponent) recipientSelectDepartmentComponent: RecipientSelectDepartmentComponent;

  data = this.dataService.get();
  who = this.data.form.recipient.who;
  loadingInterval: number;
  unsubscribe$ = new Subject();

  loadingSchools = false;

  content = {
    // label values for State SELECT form field;
    // value of the label changes based on the selected Country;
    labelState: config.address.labelStateUS,
    labelStateUS: config.address.labelStateUS,
    labelStateCA: config.address.labelStateCA,

    // label values for School AUTOCOMPLETE form field;
    // value of the label changes during loading of values through a service call;
    labelSchool: null,
    labelSchoolLoaded: 'Select your School',
    labelSchoolLoading: 'Loading Schools'
  };

  show = {
    // used to determine if the school fields should be shown;
    // can be shown while still disabled (during loading of School values);
    school: this.who.school !== null
  };

  values = {
    // SELECT values populated by service call;
    countries$: new BehaviorSubject(<SelectOption[]>[]),
    states$: new BehaviorSubject(<SelectOptgroup[]>[]),

    // AUTOCOMPLETE values populated by service call;
    schools$: new BehaviorSubject(<AutocompleteOption[]>[]),

    // states$ value transformed into US and Canda SELECT values;
    statesUS: <SelectOptgroup[]>[],
    statesCA: <SelectOptgroup[]>[]
  };

  constructor (
    public blockingIndicatorService: BlockingIndicatorService,
    private countriesService: CountriesService,
    private dataService: DataService,
    private manageFields: ManageFields,
    private schoolsByStateService: SchoolsByStateService,
    private statesService: StatesService
  ) {}

  ngOnInit () {
    this.initServiceValues();
    this.initCountryListener();
    this.initStateListener();
    this.initSchoolListener();
  }

  ngOnDestroy () {
    this.unsubscribe$.next();
    this.unsubscribe$.complete();
  }

  initServiceValues (): void {
    this.countriesService.data$
      .pipe(
        takeUntil(this.unsubscribe$)
      )
      .subscribe((json: SelectOption[]) => this.values.countries$.next(json));

    // convert the states object into individual lists per country;
    this.statesService.data$
      .pipe(
        takeUntil(this.unsubscribe$)
      )
      .subscribe((json: States) => {
        this.values.statesUS = json.us;
        this.values.statesCA = json.canada;

        // determine if selected value is CA or US so we can populate the state list;
        const isCA = this.formGroup.controls.country.value === config.values.country.ca;
        const isUS = this.formGroup.controls.country.value === config.values.country.us;

        // set default list value;
        if (isCA) {
          this.values.states$.next(this.values.statesCA);
        } else if (isUS) {
          this.values.states$.next(this.values.statesUS);
        }
      });

    // if a school is already, then we're editing the page;
    // and we need to grab the schools for this state or country (in case the user changes the autocomplete field);
    if (this.who.school) {
      this.getSchools(this.who.state || this.who.country);
    }
  }

  initCountryListener (): void {
    const controls = this.formGroup.controls;

    // watch the `country` field because when toggled we want to change content on other fields;
    controls.country.valueChanges
      .pipe(
        takeUntil(this.unsubscribe$)
      )
      .subscribe((value: string) => {
        const isUS = value === config.values.country.us;
        const isCA = value === config.values.country.ca;
        const isDomestic = isUS || isCA;

        if (value) {
          // always clear out the fields dependent on this fields value;
          this.manageFields.disable([
            controls.amcasTranscriptIdNumber,
            controls.aamcAccountNumber,
            controls.casId,
            controls.department,
            controls.departmentNotInList,
            controls.lsacAccountNumber,
            controls.school,
            controls.schoolNotInList
          ]);

          this.formGroup.patchValue({
            recipientResponse: null,
            state: null
          });

          this.show.school = false;

          // configure states (labels and values) based on country;
          if (isDomestic) {
            if (isUS) {
              this.content.labelState = this.content.labelStateUS;
              this.values.states$.next(this.values.statesUS);
            } else {
              this.content.labelState = this.content.labelStateCA;
              this.values.states$.next(this.values.statesCA);
            }

            this.manageFields.enable([
              controls.state
            ]);
          // or disable the state field if international;
          // and get the schools for the selected country;
          } else {
            this.manageFields.disable([
              controls.state
            ]);

            this.getSchools(value);
          }
        }
      });
  }

  initStateListener (): void {
    const controls = this.formGroup.controls;

    // wach the `state` field, and when it changes get the next questions ready;
    controls.state.valueChanges
      .pipe(
        takeUntil(this.unsubscribe$)
      )
      .subscribe((value: string) => {
        // show the school if we have a state selected;
        if (value) {
          // always clear out the fields we will hide/show;
          this.manageFields.disable([
            controls.amcasTranscriptIdNumber,
            controls.aamcAccountNumber,
            controls.casId,
            controls.department,
            controls.departmentNotInList,
            controls.lsacAccountNumber,
            controls.school,
            controls.schoolNotInList
          ]);

          controls.recipientResponse.setValue(null);

          this.show.school = false;

          this.getSchools(value);
        }
      });
  }

  initSchoolListener (): void {
    const controls = this.formGroup.controls;

    // wach the `school` field, and when it changes get the next questions ready;
    controls.school.valueChanges
      .pipe(
        takeUntil(this.unsubscribe$)
      )
      .subscribe((value: string) => {
        if (value) {
          this.manageFields.disable([
            controls.department,
            controls.departmentNotInList
          ]);

          controls.recipientResponse.setValue(null);

          // determine if the departments field should be shown;
          this.recipientSelectDepartmentComponent.changeRecipient(controls.school, this.values.schools$.value);

          // determine if the 'not in list' field should be shown;
          this.setSchoolNotInList();
        }
      });
  }

  getSchools (state: string): void {
    const controls = this.formGroup.controls;
    this.loadingSchools = true;

    // enable progress bar, it will be disabled after the Ajax call has returned schools;
    // this.blockingIndicatorService.open();

    // get the new school list for the selected state and reenable the autocomplete;
    // every change of state is a new list, no caching;
    this.schoolsByStateService.getData(state)
      .pipe(
        takeUntil(this.unsubscribe$)
      )
      .subscribe((json: ApiResponseRecipient[]) => {
        const newValue = json.map((option: ApiResponseRecipient) => {
          return {
            name: option.schlName,
            value: option.schlName.toUpperCase(),
            ficeCode: option.ficeCode // used when determining department visibility;
          };
        });

        // assign the data so it binds to the autocomplete;
        // then enables the autocomplete form field;
        this.values.schools$.next(newValue);

        // set the validation for the autocomplete NOW that we know the valid options for this field;
        // validation needs to be reapplied with each Ajax call;
        controls.school.setValidators([
          Validators.required,
          ValidateSchoolAutocomplete(this.values.schools$.value)
        ]);

        this.show.school = true;
        this.setLabel(true);

        // ensure that the loading state will display for at least X seconds;
        // then disable the loading indicators;
        window.setTimeout(() => {
          this.setLabel(false);
          this.loadingSchools = false;
          // the field is not disabled on edit;
          // and we dont want to trigger a change event, so check before enabling the field;
          if (controls.school.disabled) {
            this.manageFields.enable([
              controls.school
            ]);
          }
        }, config.values.loading.delay);
      });
  }

  // set the label for the autocomplete;
  // since the autocomplete values come from an Ajax call, let the user know that loading is happening;
  setLabel (loading: boolean): void {
    // control the number of periods after the label;
    // this will loop from 0 to 3 periods, to appear animated;
    let count = 0;
    const countMax = 3;

    // build the new label based on the count value;
    const setLabel = () => {
      let newLabel = this.content.labelSchoolLoading;

      if (count !== 0) {
        for (let index = 1; index <= count; index++) {
          newLabel += '.';
        }
      }

      count = count === countMax ? 0 : count + 1;

      this.content.labelSchool = newLabel;
    };

    // if loading, define the interval that will set the 'animated' label;
    // otherwise, clear the interval and set the loaded label;
    if (loading) {
      this.content.labelSchool = this.content.labelSchoolLoading;
      this.loadingInterval = window.setInterval(setLabel, config.values.loading.interval);
    } else {
      window.clearInterval(this.loadingInterval);
      this.content.labelSchool = this.content.labelSchoolLoaded;
    }
  }

  setSchoolNotInList (): void {
    const controls = this.formGroup.controls;
    const schoolValue = controls.school.value;
    const isNotInList = schoolValue && schoolValue.toUpperCase() === config.values.autocomplete.notInList.name.toUpperCase();
    const isValid = controls.school.valid;

    if (schoolValue && isNotInList && isValid) {
      this.manageFields.enable([
        controls.schoolNotInList
      ]);
    } else {
      this.manageFields.disable([
        controls.schoolNotInList
      ]);
    }
  }
}
