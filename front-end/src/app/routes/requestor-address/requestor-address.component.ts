import { BehaviorSubject,  Subject } from 'rxjs';
import { Component, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { get as _get } from 'lodash';
import { Router } from '@angular/router';
import { takeUntil } from 'rxjs/operators';

import { ApiResponseOrder } from '../../interfaces/api-response-order.interface';
import { BlockingIndicatorService } from '../../services/blocking-indicator/blocking-indicator.service';
import { config } from '../../config/config';
import { CountriesService } from '../../services/countries/countries.service';
import { DataService } from '../../services/data/data.service';
import { FormFieldInputComponent } from '../../components/form-field-input/form-field-input.component';
import { ManageFields } from '../../classes/manage-fields';
import { PostService } from '../../services/post/post.service';
import { SecurityService } from '../../services/security/security.service';
import { SelectOption } from '../../interfaces/select-option.interface';
import { SelectOptgroup} from '../../interfaces/select-optgroup.interface';
import { States } from '../../interfaces/states.interface';
import { StatesService } from '../../services/states/states.service';
import { TimeoutService } from '../../services/timeout/timeout.service';
import { ValidateMatch } from '../../validators/match.validator';


@Component({
  selector: 'nsc-requestor-address',
  templateUrl: './requestor-address.component.html',
  styleUrls: ['./requestor-address.component.scss']
})
export class RequestorAddressComponent implements OnDestroy, OnInit {
  @ViewChild('phone') private phoneInput: FormFieldInputComponent;

  data = this.dataService.get();
  formGroup: FormGroup;
  unsubscribe$ = new Subject();

  content = {
    hintPhone: config.address.hintPhoneDomestic,
    hintPhoneDomestic: config.address.hintPhoneDomestic,
    hintPhoneInternational: config.address.hintPhoneInternational,

    hintZip: config.address.hintZipDomestic,
    hintZipDomestic: config.address.hintZipDomestic,
    hintZipInternational: config.address.hintZipInternational,

    labelState: config.address.labelStateUS,
    labelStateUS: config.address.labelStateUS,
    labelStateCA: config.address.labelStateCA,
    labelStateInternational: config.address.labelStateInternational
  };

  masks = {
    phonemask: ['(', /[1-9]/, /\d/, /\d/, ')', ' ', /\d/, /\d/, /\d/, '-', /\d/, /\d/, /\d/, /\d/]
  };

  show = {
    updateRecords: _get(this.data.schoolProfile, 'askUpdateScRec')
  };

  values = {
    countries$: new BehaviorSubject(<SelectOption[]>[]),

    states$: new BehaviorSubject(<SelectOptgroup[]>[]),
    statesUS: <SelectOptgroup[]>[], // populated by the states API;
    statesCA: <SelectOptgroup[]>[], // populated by the states API;
    stateInternational: null, // to be defined with a value from the state API;

    validationPhoneDomestic: config.address.validationPhoneDomestic(),
    validationPhoneInternational: config.address.validationPhoneInternational(),
    validationZipCA: config.address.validationZipCA(),
    validationZipUS: config.address.validationZipUS(),
  };

  constructor (
    private blockingIndicatorService: BlockingIndicatorService,
    private countriesService: CountriesService,
    private dataService: DataService,
    private formBuilder: FormBuilder,
    private manageFields: ManageFields,
    private postService: PostService,
    private router: Router,
    private securityService: SecurityService,
    private statesService: StatesService,
    private timeoutService: TimeoutService
  ) {}

  ngOnInit () {
    // default phone validation isn't required - but phone is required on this view;
    this.values.validationPhoneDomestic.push(Validators.required);
    this.values.validationPhoneInternational.push(Validators.required);

    this.initServiceValues();
    this.initForm();
    this.initIsDomestic();
  }

  ngOnDestroy () {
    this.unsubscribe$.next();
    this.unsubscribe$.complete();
  }

  initServiceValues (): void {
    // get Ajax values for the SELECT fields;
    this.countriesService.data$
      .pipe(
        takeUntil(this.unsubscribe$)
      )
      .subscribe((json: SelectOption[]) => this.values.countries$.next(json));

    // break the states up by their country;
    this.statesService.data$
      .pipe(
        takeUntil(this.unsubscribe$)
      )
      .subscribe((json: States) => {
        this.values.statesUS = json.us;
        this.values.statesCA = json.canada;
        this.values.stateInternational = json.international;

        // set default value;
        this.values.states$.next(this.values.statesUS);
      });
  }

  initForm (): void {
    const requestor = this.data.form.requestor.contact;

    const updateRecordsValue = this.show.updateRecords
      ? config.values.yes
      : config.values.nullDisabled;

    const textUpdatesValue = this.isDomestic(requestor.country)
      ? requestor.textUpdates
      : config.values.nullDisabled;

    this.formGroup = this.formBuilder.group({
      addressLine1: new FormControl(requestor.addressLine1, [ Validators.required ]),
      addressLine2: new FormControl(requestor.addressLine2),
      zip: new FormControl(requestor.zip, this.values.validationZipUS),
      city: new FormControl(requestor.city, [ Validators.required, Validators.minLength(2) ]),
      state: new FormControl(requestor.state, [ Validators.required ]),
      country: new FormControl(requestor.country, [ Validators.required ]),
      emailPrimary: new FormControl(requestor.emailPrimary, [ Validators.required, Validators.email ]),
      emailConfirm: new FormControl(requestor.emailPrimary, [ Validators.required, Validators.email ]),
      phone: new FormControl(requestor.phone, this.values.validationPhoneDomestic),
      textUpdates: new FormControl(textUpdatesValue, [ Validators.required ]),
      updateRecords: new FormControl(updateRecordsValue)
    }, {
      // run custom validators;
      // make to make sure the confirm fields are equal;
      // and that we have a valid zip for the selected country;
      validator: [
        ValidateMatch('emailPrimary', 'emailConfirm')
      ]
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

  isDomestic (value: string): boolean {
    const isUS = value === config.values.country.us;
    const isCA = value === config.values.country.ca;

    return isUS || isCA;
  }

  initIsDomestic (): void {
    const controls = this.formGroup.controls;

    // watch the `country` field because when toggled we want to change content on other fields;
    this.formGroup.controls.country.valueChanges
      .pipe(
        takeUntil(this.unsubscribe$)
      )
      .subscribe((value: string) => {
        const isUS = value === config.values.country.us;
        const isDomestic = this.isDomestic(value);

        this.content.hintPhone = isDomestic ? this.content.hintPhoneDomestic : this.content.hintPhoneInternational;

        // configure phone;
        // domestic vs international formats;
        if (isDomestic) {
          controls.phone.setValidators(this.values.validationPhoneDomestic);
          this.phoneInput.mask = this.masks.phonemask;
        } else {
          controls.phone.setValidators(this.values.validationPhoneInternational);
          this.phoneInput.mask = false;
        }

        // validation rules may have changed, but we dont want to show a validation error;
        // remove any previously entered value, and reset the field;
        this.manageFields.reset([
          controls.phone
        ]);

        // configure zip;
        // us & canda have different validations;
        if (isDomestic) {
          controls.zip.setValidators(isUS ? this.values.validationZipUS : this.values.validationZipCA);
          this.content.hintZip = this.content.hintZipDomestic;
        // international has no zip validation;
        } else {
          controls.zip.clearValidators();
          this.content.hintZip = this.content.hintZipInternational;
        }

        // validation rules may have changed, but we dont want to show a validation error;
        // remove any previously entered value, and reset the field;
        this.manageFields.reset([
          controls.zip
        ]);

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
        } else {
          this.content.labelState = this.content.labelStateInternational;

          this.manageFields.disable([
            controls.state
          ]);
        }

        // configure texting question;
        if (isDomestic) {
          this.manageFields.enable([
            controls.textUpdates
          ]);
        } else {
          this.manageFields.disable([
            controls.textUpdates
          ]);
        }
      });
  }

  cancel (): void {
    this.securityService.cancelOrder();
  }

  continue (): void {
    this.dataService.resetRequestorAddress();
    this.dataService.save(this.formGroup.value, 'form.requestor.contact');

    // determine what the next route is;
    const askDegreeQuestions = this.dataService.showDegreeQuestions();
    const askProgramQuestions = this.dataService.showProgramQuestions();
    const showAttendRoute = askDegreeQuestions || askProgramQuestions;
    const go = () => {
      const routeNext = showAttendRoute
        ? config.routes.requestorAttend
        : config.routes.recipientSelect;

      this.securityService.setDeactivateWarning(false);

      this.router.navigate([routeNext], config.routes.extras);
    };

    // if the next route is the attend route, just go;
    // but if the next route is the recipient, then we need to post the collected student information;
    if (showAttendRoute) {
      go();
    } else {
      this.blockingIndicatorService.open();

      this.postService.student()
        .pipe(
          takeUntil(this.unsubscribe$)
        )
        .subscribe(() => {
          window.setTimeout(() => {
            go();
          }, config.values.loading.delay);
        });
    }
  }
}
