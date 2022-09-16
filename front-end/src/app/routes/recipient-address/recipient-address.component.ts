import { BehaviorSubject,  Subject } from 'rxjs';
import { clone as _clone, get as _get } from 'lodash';
import { Component, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { takeUntil } from 'rxjs/operators';

import { config } from '../../config/config';
import { CountriesService } from '../../services/countries/countries.service';
import { DataService } from '../../services/data/data.service';
import { FormFieldInputComponent } from '../../components/form-field-input/form-field-input.component';
import { ManageFields } from '../../classes/manage-fields';
import { SecurityService } from '../../services/security/security.service';
import { SelectOptgroup} from '../../interfaces/select-optgroup.interface';
import { SelectOption } from '../../interfaces/select-option.interface';
import { States } from '../../interfaces/states.interface';
import { StatesService } from '../../services/states/states.service';
import { TimeoutService } from '../../services/timeout/timeout.service';


@Component({
  selector: 'nsc-recipient-address',
  templateUrl: './recipient-address.component.html',
  styleUrls: ['./recipient-address.component.scss']
})
export class RecipientAddressComponent implements OnDestroy, OnInit {
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

  require = {
    attention: false,
    phone: false
  };

  values = {
    countries$: new BehaviorSubject(<SelectOption[]>[]),

    recipientReadonly: this.data.form.recipient.who.recipientType !== config.values.recipientType.organization,

    states$: new BehaviorSubject(<SelectOptgroup[]>[]),
    statesUS: <SelectOptgroup[]>[], // populated by the states API;
    statesCA: <SelectOptgroup[]>[], // populated by the states API;
    stateInternational: null, // to be defined with a value from the state API;

    validatorsAttention: [],
    validationPhoneDomestic: config.address.validationPhoneDomestic(),
    validationPhoneInternational: config.address.validationPhoneInternational(),
    validationZipCA: config.address.validationZipCA(),
    validationZipUS: config.address.validationZipUS(),
  };

  constructor (
    private countriesService: CountriesService,
    private dataService: DataService,
    private formBuilder: FormBuilder,
    private manageFields: ManageFields,
    private router: Router,
    private securityService: SecurityService,
    private statesService: StatesService,
    private timeoutService: TimeoutService
  ) {}

  ngOnInit () {
    this.initServiceValues();
    this.initDeliveryMethodValidators();
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

  initDeliveryMethodValidators (): void {
    const deliveryMethod = this.dataService.getDeliveryMethodObject(this.data.form.recipient.delivery.deliveryMethod);

    if (deliveryMethod) {
      const deliveryMethodType = deliveryMethod.deliveryMethodType;

      if (['B', 'O'].indexOf(deliveryMethodType) > -1) {
        this.require.attention = true;
        this.values.validatorsAttention.push(Validators.required);
      }
      if (['B', 'O', 'F'].indexOf(deliveryMethodType) > -1) {
        this.require.phone = true;
        this.values.validationPhoneDomestic.push(Validators.required);
        this.values.validationPhoneInternational.push(Validators.required);
      }
    }
  }

  initForm (): void {
    const recipient = this.data.form.recipient;
    const address = recipient.address;
    const deliveryMethod = this.dataService.getDeliveryMethodObject(recipient.delivery.deliveryMethod);
    const isDeliveryExpress = deliveryMethod.deliveryMethodType === 'O';
    const isRecipientMe = recipient.who.recipientType === config.values.recipientType.me;
    const isExpressMe = isDeliveryExpress && isRecipientMe;

    // if the delivery method is express mail, and the recipient is me, then the attention line is me;
    // or if a department was entered, that's the default attention value;
    const attention = address.attention || isExpressMe
      ? this.dataService.getFullName()
      : recipient.who.departmentNotInList;

    this.formGroup = this.formBuilder.group({
      recipient: new FormControl(address.recipient || this.dataService.getRecipient(), [ Validators.required ]),
      attention: new FormControl(attention, this.values.validatorsAttention),
      addressLine1: new FormControl(address.addressLine1, [ Validators.required ]),
      addressLine2: new FormControl(address.addressLine2),
      zip: new FormControl(address.zip, this.values.validationZipUS),
      city: new FormControl(address.city, [ Validators.required, Validators.minLength(2) ]),
      state: new FormControl(address.state, [ Validators.required ]),
      country: new FormControl(address.country, [ Validators.required ]),
      phone: new FormControl(address.phone, this.values.validationPhoneDomestic)
    });

    // now update the form settings based on the country, if a country is supplied (on edit, or `me` recipient);
    if (address.country) {
      this.setControlAttributes(address.country);
    }

    // any change to the form means the user is actively using the app, so extend the system timeout;
    this.formGroup.valueChanges
      .pipe(
        takeUntil(this.unsubscribe$)
      )
      .subscribe(value => {
        this.timeoutService.startWarningCountdown();
      });
  }

  initIsDomestic (): void {
    const controls = this.formGroup.controls;

    // watch the `country` field because when toggled we want to change content on other fields;
    this.formGroup.controls.country.valueChanges
      .pipe(
        takeUntil(this.unsubscribe$)
      )
      .subscribe((value: string) => {
        this.setControlAttributes(value);

        // reset the fields that are dependant upon country;
        // the reset is not done within `setControlAttributes` because we don't want it done on page init;
        // otherwise preselected values would be cleared out;
        this.manageFields.reset([
          controls.phone,
          controls.state,
          controls.zip
        ]);
      });
  }

  setControlAttributes (countryValue: string): void {
    const controls = this.formGroup.controls;

    const isUS = countryValue === config.values.country.us;
    const isCA = countryValue === config.values.country.ca;
    const isDomestic = isUS || isCA;

    this.content.hintPhone = isDomestic ? this.content.hintPhoneDomestic : this.content.hintPhoneInternational;

    // configure phone;
    // domestic vs international formats;
    if (this.require.phone) {
      if (isDomestic) {
        controls.phone.setValidators(this.values.validationPhoneDomestic);
        this.phoneInput.mask = this.masks.phonemask;
      } else {
        controls.phone.setValidators(this.values.validationPhoneInternational);
        this.phoneInput.mask = false;
      }
    }

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
  }

  previous (): void {
    if (window.confirm(config.values.warningLoseInformation)) {
      this.dataService.resetRecipientAddress();

      this.securityService.setDeactivateWarning(false);

      this.router.navigate([config.routes.recipientDeliveryMethod], config.routes.extras);
    }
  }

  cancel (): void {
    this.securityService.cancelOrder();
  }

  continue (): void {
    // we need to clear out any previous content before saving to prevent orphaned content (like state/phone);
    this.dataService.resetRecipientAddress();

    this.dataService.save(this.formGroup.value, 'form.recipient.address');
    this.dataService.saveRecipient();

    this.securityService.setDeactivateWarning(false);

    this.router.navigate([config.routes.orderReview], config.routes.extras);
  }
}
