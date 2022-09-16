import { BehaviorSubject,  Subject } from 'rxjs';
import { cloneDeep as _cloneDeep } from 'lodash';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { takeUntil } from 'rxjs/operators';

import { BlockingIndicatorService } from '../../services/blocking-indicator/blocking-indicator.service';
import { config } from '../../config/config';
import { CountriesService } from '../../services/countries/countries.service';
import { DataService } from '../../services/data/data.service';
import { ManageFields } from '../../classes/manage-fields';
import { PostService } from '../../services/post/post.service';
import { SecurityService } from '../../services/security/security.service';
import { SelectOptgroup} from '../../interfaces/select-optgroup.interface';
import { SelectOption } from '../../interfaces/select-option.interface';
import { States } from '../../interfaces/states.interface';
import { StatesService } from '../../services/states/states.service';
import { TimeoutService } from '../../services/timeout/timeout.service';
import { ValidateCreditCardNumber } from '../../validators/credit-card-number.validator';
import { ValidateDateCreditCard } from '../../validators/date-credit-card.validator';


// let TypeScript ignore the global Payeezy object;
declare var Payeezy: any;

@Component({
  selector: 'nsc-order-payment',
  templateUrl: './order-payment.component.html',
  styleUrls: ['./order-payment.component.scss']
})
export class OrderPaymentComponent implements OnDestroy, OnInit {
  formGroup: FormGroup;
  unsubscribe$ = new Subject();

  content = {
    totalFees: this.dataService.get().response.orderHeader.totalFee,

    hintZip: config.address.hintZipDomestic,
    hintZipDomestic: config.address.hintZipDomestic,
    hintZipInternational: config.address.hintZipInternational,

    labelState: config.address.labelStateUS,
    labelStateUS: config.address.labelStateUS,
    labelStateCA: config.address.labelStateCA,
    labelStateInternational: config.address.labelStateInternational
  };

  masks = {
    securityCode: [/\d/, /\d/, /\d/, /\d/]
  };

  values = {
    countries$: new BehaviorSubject(<SelectOption[]>[]),
    creditCardMonths: config.payment.creditCardMonths,
    creditCardYears: config.payment.creditCardYears(),

    states$: new BehaviorSubject(<SelectOptgroup[]>[]),
    statesUS: <SelectOptgroup[]>[], // populated by the states API;
    statesCA: <SelectOptgroup[]>[], // populated by the states API;
    stateInternational: null, // to be defined with a value from the state API;

    validationZipCA: config.address.validationZipCA(),
    validationZipUS: config.address.validationZipUS()
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
    this.initServiceValues();
    this.initForm();
    this.initIsDomestic();
    this.initUseContactInfo();
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
    // initialize the form with the default required fields;
    // required fields will change based on selected options and parameters;
    this.formGroup = this.formBuilder.group({
      name: new FormControl(null, [ Validators.required ]),
      creditCardNumber: new FormControl(null, [ Validators.required, ValidateCreditCardNumber ]),
      expirationMonth: new FormControl(null, [ Validators.required ]),
      expirationYear: new FormControl(null, [ Validators.required ]),
      securityCode: new FormControl(null, [ Validators.required, Validators.minLength(3) ]),
      useContactInfo: new FormControl(),
      addressLine1: new FormControl(null, [ Validators.required ]),
      addressLine2: new FormControl(),
      zip: new FormControl(null, this.values.validationZipUS),
      city: new FormControl(null, [ Validators.required, Validators.minLength(2) ]),
      state: new FormControl(null, [ Validators.required ]),
      country: new FormControl(config.values.country.us, [ Validators.required ])
    }, {
      validator: [ ValidateDateCreditCard('expirationMonth', 'expirationYear') ]
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

  initIsDomestic (): void {
    const controls = this.formGroup.controls;

    // watch the `country` field because when toggled we want to change content on other fields;
    this.formGroup.controls.country.valueChanges
      .pipe(
        takeUntil(this.unsubscribe$)
      )
      .subscribe((value: string) => {
        const isUS = value === config.values.country.us;
        const isCA = value === config.values.country.ca;
        const isDomestic = isUS || isCA;

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
        this.manageFields.enable([
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
      });
  }

  initUseContactInfo (): void {
    const controls = this.formGroup.controls;

    // watch the `useContactInfo` field because when toggled we want to fill/empty form fields;
    controls.useContactInfo.valueChanges
      .pipe(
        takeUntil(this.unsubscribe$)
      )
      .subscribe((value: string) => {
        const requestor = this.dataService.get().response.student;
        let newValues = {
          addressLine1: null,
          addressLine2: null,
          zip: null,
          city: null,
          state: null,
          country: config.values.country.us
        };

        // if the user says to use their contact Info, pull it from the Data service;
        if (value === config.values.yes) {
          newValues = {
            addressLine1: requestor.street1,
            addressLine2: requestor.street2,
            zip: requestor.zip,
            city: requestor.city,
            state: requestor.state,
            country: requestor.country
          };
        }

        this.manageFields.reset([
          controls.addressLine1,
          controls.zip,
          controls.city,
          controls.state
        ]);

        this.formGroup.patchValue(newValues);
      });
  }

  getCreditCardType (ccNumber: string): string {
    const regExAmericanExpress = new RegExp(config.values.creditCard.patternAmericanExpress());
    const regExDinersClub = new RegExp(config.values.creditCard.patternDinersClub());
    const regExDiscover = new RegExp(config.values.creditCard.patternDiscover());
    const regExJCB = new RegExp(config.values.creditCard.patternJCB());
    const regExMastercard = new RegExp(config.values.creditCard.patternMastercard());
    const regExVisa = new RegExp(config.values.creditCard.patternVisa());

    const testAmericanExpress = regExAmericanExpress.test(ccNumber);
    const testDinersClub = regExDinersClub.test(ccNumber);
    const testDiscover = regExDiscover.test(ccNumber);
    const testJCB = regExJCB.test(ccNumber);
    const testMastercard = regExMastercard.test(ccNumber);
    const testVisa = regExVisa.test(ccNumber);

    let cardType;

    if (testAmericanExpress) {
      cardType = 'American Express';
    } else if (testDinersClub) {
      cardType = 'Diners Club';
    } else if (testDiscover) {
      cardType = 'Discover';
    } else if (testJCB) {
      cardType = 'JCB';
    } else if (testMastercard) {
      cardType = 'Mastercard';
    } else if (testVisa) {
      cardType = 'Visa';
    }

    return cardType;
  }

  cancel (): void {
    this.securityService.cancelOrder();
  }

  continue (): void {
    const controls = this.formGroup.controls;
    const payeezyData = {
      card_type: this.getCreditCardType(controls.creditCardNumber.value),
      cardholder_name: controls.name.value,
      cc_number: controls.creditCardNumber.value,
      exp_month: controls.expirationMonth.value,
      exp_year: controls.expirationYear.value,
      cvv_code: controls.securityCode.value,
      city: controls.city.value,
      country: controls.country.value,
      street: controls.addressLine1.value,
      state_province: controls.state.value,
      zip_postal_code: controls.zip.value
    };

    this.blockingIndicatorService.open();

    Payeezy.setAuth(true);
    Payeezy.setApiKey('zYuCJsk4YmJ1seQEdcPEMZCC9QUavIwy');
    Payeezy.setJs_Security_Key('js-8a0761042c5bc461451c432cf2738cef8a0761042c5bc461');
    Payeezy.setTa_token('NOIW');
    Payeezy.createToken((status, results) => {
      // create a clone of the form data so we can append payeezy data before submitting to the data service;
      const data = _cloneDeep(this.formGroup.value);

      // add values to our data object to store;
      // these are not present in the Angular form, but are needed for the PostService;
      data.payeezyToken = results.token.value;
      data.ccType = payeezyData.card_type;

      this.dataService.resetOrderPayment();

      this.dataService.save(data, 'form.payment');

      // post the data to the back-end;
      // once that's complete move onto the order-confirmation route;
      this.postService.payment()
        .pipe(
          takeUntil(this.unsubscribe$)
        )
        .subscribe(() => {
          const continueToOrderConfirmation = () => {
            window.setTimeout(() => {
              this.securityService.setDeactivateWarning(false);

              this.router.navigate([config.routes.orderConfirmation], config.routes.extras);
            }, config.values.loading.delay);
          };

          // if there is a signature to post, do it, otherwise move on;
          if (this.dataService.get().form.consent.signature) {
            this.postService.consent()
              .pipe(
                takeUntil(this.unsubscribe$)
              )
              .subscribe(() => {
                continueToOrderConfirmation();
              });
          } else {
            continueToOrderConfirmation();
          }
        });
    }, payeezyData);
  }
}
