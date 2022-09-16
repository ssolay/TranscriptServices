import { BehaviorSubject,  Subject } from 'rxjs';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { filter as _filter } from 'lodash';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { takeUntil } from 'rxjs/operators';

import { AutocompleteOption } from '../../interfaces/autocomplete-option.interface';
import { config } from '../../config/config';
import { DataService } from '../../services/data/data.service';
import { environment } from '../../../environments/environment';
import { SchoolService } from '../../services/school/school.service';
import { SchoolsService } from '../../services/schools/schools.service';
import { SecurityService } from '../../services/security/security.service';
import { ValidateSchoolAutocomplete } from '../../validators/school-autocomplete.validator';
import { BlockingIndicatorService } from '../../services/blocking-indicator/blocking-indicator.service';


@Component({
  selector: 'nsc-school-select',
  templateUrl: './school-select.component.html',
  styleUrls: ['./school-select.component.scss']
})
export class SchoolSelectComponent implements OnDestroy, OnInit {
  formGroup: FormGroup;
  loadingInterval: number;
  unsubscribe$ = new Subject();
  loadingSchools = false;

  content = {
    labelSchool: null,
    labelSchoolLoaded: 'Select school you want to order from',
    labelSchoolLoading: 'Loading Schools'
  };

  values = {
    schools$: new BehaviorSubject(<AutocompleteOption[]>[]) // complete list for autocomplete to filter down;
  };

  constructor (
    private dataService: DataService,
    private formBuilder: FormBuilder,
    private blockingIndicatorService: BlockingIndicatorService,
    private router: Router,
    private schoolService: SchoolService,
    private schoolsService: SchoolsService,
    private securityService: SecurityService
  ) {}

  ngOnInit () {
    this.setLabel(true);
    this.initForm();
    this.getSchools();
  }

  ngOnDestroy () {
    this.unsubscribe$.next();
    this.unsubscribe$.complete();
  }

  initForm (): void {
    // set control to be disabled on load, will be enabled after Ajax content is loaded;
    this.formGroup = this.formBuilder.group({
      school: new FormControl(config.values.nullDisabled)
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

  getSchools (): void {
    const controls = this.formGroup.controls;
    this.loadingSchools = true;

    // get all schools and then set the value to schools and filteredSchools so the form can now work;
    this.schoolsService.data$
      .pipe(
        takeUntil(this.unsubscribe$)
      )
      .subscribe((json: AutocompleteOption[]) => {
        if (json.length) {
          // set the autocomplete content and enable the form field;
          // set the validator now that we know the valid options;
          this.values.schools$.next(json);

          controls.school.setValidators([
            Validators.required,
            ValidateSchoolAutocomplete(this.values.schools$.value)
          ]);

          // ensure that the loading state will display for at least X seconds;
          // then disable the loading indicators;
          window.setTimeout(() => {
            this.setLabel(false);
            controls.school.enable();
            this.loadingSchools = false;
          }, config.values.loading.delay);
        }
      });
  }

  continue (): void {
    // find the school object based on the entered name;
    const nameToMatch = this.formGroup.controls.school.value.toLowerCase();
    const schoolArray = _filter(this.values.schools$.value, o => o.name.toLowerCase() === nameToMatch);
    const school = schoolArray.length ? schoolArray[0] : null;

    // if a school was found, move on;
    if (school) {
      // if the school isn't configured to use this application, send them to the app they should use;
      if (school.uiVersion !== '2.0') {
        // window.location.href = `${ environment.oldApplicationURL }?ficecode=${ school.ficeCode }`;
      }

      // enable progress bar, it will be disabled after route change;
      this.blockingIndicatorService.open();

      // get the full school profile based on the selected school;
      // then move to the next page;
      this.schoolService.getData(school.ficeCode)
        .pipe(
          takeUntil(this.unsubscribe$)
        )
        .subscribe(() => {
          // force a small delay;
          window.setTimeout(() => {
            this.router.navigate([config.routes.schoolWelcome]);
          }, config.values.loading.delay);
        });
    }
  }
}
