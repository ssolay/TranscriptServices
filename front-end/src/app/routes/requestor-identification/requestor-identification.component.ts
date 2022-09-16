import * as moment from 'moment';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { filter as _filter, get as _get, merge as _merge } from 'lodash';
import { Router } from '@angular/router';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';

import { config } from '../../config/config';
import { DataService } from '../../services/data/data.service';
import { ManageFields } from '../../classes/manage-fields';
import { SecurityService } from '../../services/security/security.service';
import { TimeoutService } from '../../services/timeout/timeout.service';
import { ValidateDateEnrolled } from '../../validators/date-enrolled.validator';
import { ValidateDateOfBirth } from '../../validators/date-of-birth.validator';
import { ValidateRequireEither } from '../../validators/require-either.validator';
import { ValidateMatch } from '../../validators/match.validator';


@Component({
  selector: 'nsc-requestor-identification',
  templateUrl: './requestor-identification.component.html',
  styleUrls: ['./requestor-identification.component.scss']
})
export class RequestorIdentificationComponent implements OnDestroy, OnInit {
  data = this.dataService.get();
  formGroup: FormGroup;
  unsubscribe$ = new Subject();

  content = {
    enrolledBeforeQuestion: this.data.schoolProfile.electronicDeliveryEligibilityQuestion,
    labelStudentId: this.data.schoolProfile.studentIdLabel || 'Student ID',
    pathQuestion: _get(this.data.schoolProfile, 'feePathDesc'),
    pathHelp: this.dataService.getNote('39')
  };

  masks = {
    date: [/\d/, /\d/, '/', /\d/, /\d/, '/', /\d/, /\d/, /\d/, /\d/],
    ssn: [/\d/, /\d/, /\d/, '-', /\d/, /\d/, '-', /\d/, /\d/, /\d/, /\d/],
    year: [/\d/, /\d/, /\d/, /\d/]
  };

  require = {
    enrolledBeforeQuestion: this.content.enrolledBeforeQuestion !== undefined && this.content.enrolledBeforeQuestion !== null,
    one: this.data.schoolProfile.askSsn === 'B' && this.data.schoolProfile.askStudentId === 'B',
    ssn: config.values.born.require.indexOf(this.data.schoolProfile.askSsn) > -1,
    studentIdPrimary: config.values.born.require.indexOf(this.data.schoolProfile.askStudentId) > -1,
    studentIdConfirm: config.values.born.require.indexOf(this.data.schoolProfile.askConfirmStId) > -1
  };

  show = {
    deliveryUnavailable: false,
    enrolledBeforeQuestion: this.data.form.requestor.personal.enrolledCurrently === config.values.no,
    pathQuestion: this.data.schoolProfile.feePathTypePub === 'B' && this.data.schoolProfile.feePathDesc,
    ssn: config.values.born.show.indexOf(this.data.schoolProfile.askSsn) > -1,
    studentIdPrimary: config.values.born.show.indexOf(this.data.schoolProfile.askStudentId) > -1,
    studentIdConfirm: config.values.born.show.indexOf(this.data.schoolProfile.askConfirmStId) > -1
  };

  values = {
    // validators initialized here;
    // updated on form init;
    // used again if only ssn or student id are required (this.require.one);
    ssnValidators: [ Validators.minLength(11) ],
    studentIdPrimaryValidators: [],
    studentIdConfirmValidators: [],
    studentIdMaxLength: this.data.schoolProfile.stIdMaxLimit || 20
  };

  constructor (
    private dataService: DataService,
    private formBuilder: FormBuilder,
    private manageFields: ManageFields,
    private router: Router,
    private securityService: SecurityService,
    private timeoutService: TimeoutService
  ) {}

  ngOnInit () {
    this.initForm();
    this.initNameChangedListener();
    this.initEnrolledCurrentlyListener();
    this.initEnrolledBeforeListner();
    this.initPathListner();
  }

  ngOnDestroy () {
    this.unsubscribe$.next();
    this.unsubscribe$.complete();
  }

  initForm (): void {
    const requestor = this.data.form.requestor.personal;
    const hasNameChanged = requestor.nameChanged === config.values.yes;
    const formValidators = [ ValidateDateEnrolled('enrolledYearFrom', 'enrolledYearTo') ];

    // may not need to validate that student ids match;
    // because we may not be showing both fields;
    // but if we show them, make sure their values match;
    if (this.show.studentIdPrimary && this.show.studentIdConfirm) {
      formValidators.push(ValidateMatch('studentIdPrimary', 'studentIdConfirm', this.require.studentIdConfirm));
    }

    // if we show one SSN field, we show the other;
    // if we show them, make sure their values match;
    if (this.show.ssn) {
      formValidators.push(ValidateMatch('ssnPrimary', 'ssnConfirm'));
    }

    // if only one identifier (SSN or Student ID) is required;
    // set a validator making sure at least one value is entered;
    // dont need to check the confirm fields;
    // because those validations will be triggered when the user enters a value in the primary field;
    if (this.require.one) {
      formValidators.push(ValidateRequireEither('studentIdPrimary', 'ssnPrimary'));
    }

    // set validators for the student id fields;
    // just because they are visible does not mean they are required;
    // but only do that when the requirements aren't `require one of the two`;
    if (this.require.one === false) {
      if (this.require.studentIdPrimary) {
        this.values.studentIdPrimaryValidators.push(Validators.required);
      }

      if (this.require.studentIdConfirm) {
        this.values.studentIdConfirmValidators.push(Validators.required);
      }

      if (this.require.ssn) {
        this.values.ssnValidators.push(Validators.required);
      }
    }

    // set the default values based on their visiblity;
    // we need to have the fields disabled if they aren't shown so they won't impede form submission;
    const studentIdPrimaryValue = this.show.studentIdPrimary
      ? requestor.studentIdPrimary
      : config.values.nullDisabled;

    const studentIdConfirmValue = this.show.studentIdConfirm
      ? requestor.studentIdPrimary
      : config.values.nullDisabled;

    const ssnPrimaryValue = this.show.ssn
      ? requestor.ssnPrimary
      : config.values.nullDisabled;

    const ssnConfirmValue = this.show.ssn
      ? requestor.ssnPrimary
      : config.values.nullDisabled;

    const enrolledBeforeValue = this.require.enrolledBeforeQuestion
      ? requestor.enrolledBefore
      : config.values.nullDisabled;

    // initialize the form now that all configuration is set;
    this.formGroup = this.formBuilder.group({
      nameFirst: new FormControl(requestor.nameFirst, [ Validators.required ]),
      nameMiddle: new FormControl(requestor.nameMiddle),
      nameLast: new FormControl(requestor.nameLast, [ Validators.required ]),
      dob: new FormControl(requestor.dob, [ Validators.required, ValidateDateOfBirth ]),
      nameChanged: new FormControl(requestor.nameChanged, [ Validators.required ]),
      nameChangedFirst: new FormControl(hasNameChanged ? requestor.nameChangedFirst : config.values.nullDisabled, [ Validators.required ]),
      nameChangedMiddle: new FormControl(hasNameChanged ? requestor.nameChangedMiddle : config.values.nullDisabled),
      nameChangedLast: new FormControl(hasNameChanged ? requestor.nameChangedLast : config.values.nullDisabled, [ Validators.required ]),
      studentIdPrimary: new FormControl(studentIdPrimaryValue, this.values.studentIdPrimaryValidators),
      studentIdConfirm: new FormControl(studentIdConfirmValue, this.values.studentIdConfirmValidators),
      ssnPrimary: new FormControl(ssnPrimaryValue, this.values.ssnValidators),
      ssnConfirm: new FormControl(ssnConfirmValue, this.values.ssnValidators),
      path: new FormControl(this.show.pathQuestion ? requestor.path : config.values.nullDisabled, [ Validators.required ]),
      enrolledCurrently: new FormControl(requestor.enrolledCurrently, [ Validators.required ]),
      enrolledBefore: new FormControl(enrolledBeforeValue, [ Validators.required ]),
      enrolledYearFrom: new FormControl(
        requestor.enrolledYearFrom || config.values.nullDisabled,
        [
          Validators.required,
          Validators.minLength(4),
          Validators.min(1940),
          Validators.max(moment().year() + 1)
        ]
      ),
      enrolledYearTo: new FormControl(
        requestor.enrolledYearTo || config.values.nullDisabled,
        [
          Validators.required,
          Validators.minLength(4),
          Validators.min(1940)
        ]
      )
    }, {
      validator: formValidators
    });

    // any change to the form means the user is actively using the app, so extend the system timeout;
    this.formGroup.valueChanges
      .pipe(
        takeUntil(this.unsubscribe$)
      )
      .subscribe(value => {
        this.timeoutService.startWarningCountdown();
      });
  }

  initNameChangedListener (): void {
    // watch the `nameChanged` field because when toggled we want to hide/show form fields, and adjust required fields;
    this.formGroup.controls.nameChanged.valueChanges
      .pipe(
        takeUntil(this.unsubscribe$)
      )
      .subscribe((value: string) => {
        const controls = this.formGroup.controls;

        if (value) {
          switch (value) {
            case config.values.yes:
              // enable validation on the now visible form fields;
              this.manageFields.enable([
                controls.nameChangedFirst,
                controls.nameChangedMiddle,
                controls.nameChangedLast
              ]);
              break;

            case config.values.no:
              // remove the hidden fields from the validation model;
              this.manageFields.disable([
                controls.nameChangedFirst,
                controls.nameChangedMiddle,
                controls.nameChangedLast
              ]);
              break;
          }
        }
      });
  }

  initEnrolledCurrentlyListener (): void {
    // watch the `enrolledCurrently` field because when toggled we want to hide/show form fields;
    this.formGroup.controls.enrolledCurrently.valueChanges
      .pipe(
        takeUntil(this.unsubscribe$)
      )
      .subscribe((value: string) => {
        const controls = this.formGroup.controls;

        if (value) {
          // control the visibility of the `enrolledBefore` question;
          // preselect NO if the question is required, but we aren't going to show the question;
          const enrolledBeforeValue = (value === config.values.yes && this.require.enrolledBeforeQuestion)
            ? config.values.no
            : null;

          this.formGroup.patchValue({
            enrolledBefore: enrolledBeforeValue
          });

          // if `enrolledBefore` is required, determine if it should be shown;
          if (this.require.enrolledBeforeQuestion) {
            this.show.enrolledBeforeQuestion = value === config.values.no;
          }

          // if the user is currently enrolled the enrolledBefore question has been hidden, so we should hide the year fields;
          if (value === config.values.yes) {
            this.manageFields.disable([
              controls.enrolledYearFrom,
              controls.enrolledYearTo
            ]);
          }
        }
      });
  }

  initEnrolledBeforeListner (): void {
    this.formGroup.controls.enrolledBefore.valueChanges
      .pipe(
        takeUntil(this.unsubscribe$)
      )
      .subscribe((value: string) => {
        const controls = this.formGroup.controls;

        if (value) {
          // show the year qustions (doesn't matter what value the user selected);
          this.manageFields.enable([
            controls.enrolledYearFrom,
            controls.enrolledYearTo
          ]);

          // determine if the delivery unavailable message should display, since it is dependant on this fields value;
          this.setShowDeliveryUnavailable();
        }
      });
  }

  initPathListner (): void {
    this.formGroup.controls.path.valueChanges
      .pipe(
        takeUntil(this.unsubscribe$)
      )
      .subscribe((value: string) => {
        if (value) {
          // determine if the delivery unavailable message should display, since it is dependant on this fields value;
          this.setShowDeliveryUnavailable();
        }
      });
  }

  setShowDeliveryUnavailable (): void {
    const enrolledBeforeYes = this.formGroup.controls.enrolledBefore.value === config.values.yes;
    const deliveryMethodCountIsZero = this.getNonElectronicDeliveryMethodCount() === 0;

    // show/hide the warning message about no delivery methods being available;
    // electronic options aren't available for people who answer yes to this question;
    // if there are no delivery methods available, there's no reason to continue with the order;
    this.show.deliveryUnavailable = enrolledBeforeYes && deliveryMethodCountIsZero;
  }

  // determine if there are any available delivery methods once the electronic options are filtered out;
  getNonElectronicDeliveryMethodCount (): number {
    const payDeliveryMethods = this.data.schoolProfile.payOptions.deliveryMethods;
    const freeDeliveryMethods = this.data.schoolProfile.freeOptions.deliveryMethods;

    let deliveryMethods;

    switch (this.data.schoolProfile.feePathTypePub) {
      case 'B':
        // if the user is suppose to answer the path quesiton, but hasn't, we can't determine the deliveryMethods;
        if (this.show.pathQuestion && this.formGroup.controls.path.value === null) {
          return null;
        } else {
          deliveryMethods = this.formGroup.controls.path.value === 'F'
            ? freeDeliveryMethods
            : payDeliveryMethods;
        }
        break;

      case 'F':
        deliveryMethods = freeDeliveryMethods;
        break;

      case 'P':
        deliveryMethods = payDeliveryMethods;
        break;
    }

    const filteredDeliveryMethods = _filter(deliveryMethods, method => ['E', 'T'].indexOf(method.deliveryMethodType) === -1);

    return filteredDeliveryMethods.length;
  }

  cancel (): void {
    this.securityService.cancelOrder();
  }

  continue (): void {
    this.dataService.resetRequestorIdentification();
    this.dataService.save(this.formGroup.value, 'form.requestor.personal');

    this.securityService.setDeactivateWarning(false);

    this.router.navigate([config.routes.requestorAddress], config.routes.extras);
  }
}
