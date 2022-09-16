import * as moment from 'moment';
import { Component, Inject, OnDestroy, OnInit } from '@angular/core';
import { CurrencyPipe } from '@angular/common';
import { filter as _filter, get as _get, sortBy as _sortBy } from 'lodash';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';

import { config } from '../../config/config';
import { ConvertDeliveryMethod } from '../../classes/convert-delivery-method';
import { DataService } from '../../services/data/data.service';
import { ManageFields } from '../../classes/manage-fields';
import {
  SchoolProfileDeliveryMethod,
  SchoolProfileProcessingOption,
  SchoolProfileQuantity,
  SchoolProfileTranscriptPurpose,
  SchoolProfileTranscriptType
} from '../../interfaces/api-response-school-profile.interface';
import { SecurityService } from '../../services/security/security.service';
import { SelectOption } from '../../interfaces/select-option.interface';
import { TimeoutService } from '../../services/timeout/timeout.service';


@Component({
  selector: 'nsc-recipient-delivery-method',
  templateUrl: './recipient-delivery-method.component.html',
  styleUrls: ['./recipient-delivery-method.component.scss'],
  providers: [ CurrencyPipe ]
})
export class RecipientDeliveryMethodComponent implements OnDestroy, OnInit {
  data = this.dataService.get();
  formGroup: FormGroup;
  hasN = false;
  schoolProfile = this.data.schoolProfile;
  unsubscribe$ = new Subject();

  content = {
    allowedFileTypes: [],
    allowUploads: (this.schoolProfile.allowDocUpload === 'Y'),
    attachmentCount: (this.schoolProfile.docUploadLimit) ? this.schoolProfile.docUploadLimit : null,
    deliveryMethodHelpText: null,
    deliveryMethodDisplay: null,
    deliveryMethodType: null,
    // changes based on answer to "when do you want to have your transcript(s) sent" question;
    requireDegree: false,
    requireTerm: false,
    requireYear: false
  };

  masks = {
    year: [/\d/, /\d/, /\d/, /\d/]
  };

  show = {
    additionalWhenQuestions: false,
    labelForG: false,
    labelForD: false,
    processingMethods: false,
    transcriptWhen: true,
    transcriptPurposes: this.schoolProfile.askXcriptPurpose,
    transcriptTypes: this.schoolProfile.askXcriptType
  };

  values = {
    deliveryMethods: [],
    deliveryMethodsNonEtxG: [],
    deliveryMethodsNonEtxR: [],
    deliveryMethodsEtxG: [],
    deliveryMethodsEtxR: [],
    howMany: null,
    howManyAll: null,
    howManyElectronic: null,
    options: this.dataService.getFeePathType(),
    processingMethods: [
      {
        name: 'Standard Processing',
        value: 'G'
      },
      {
        name: 'Rush Processing',
        value: 'R'
      },
    ],
    totalFees: 0, // value to be emitted from `fee-summary` component;
    transcriptWhen: null,
    transcriptTypes: null,
    transcriptPurposes: null,
    yes: config.values.yes, // used in `continue` button logic (in template);
    yearValidationOptional: null, // set after year calculation is done in initForm();
    yearValidationRequired: null
  };

  constructor (
    private convertDeliveryMethod: ConvertDeliveryMethod,
    private currencyPipe: CurrencyPipe,
    private dataService: DataService,
    private formBuilder: FormBuilder,
    private manageFields: ManageFields,
    private router: Router,
    private securityService: SecurityService,
    private timeoutService: TimeoutService
  ) {}

  ngOnInit () {
    this.initAllowedFileTypes();
    this.initTranscriptWhenValues();
    this.initDeliveryMethodValues();
    this.initTranscriptTypeValues();
    this.initTranscriptPurposeValues();
    this.initHowManyValues();
    this.initForm();
    this.setDeliveryMethodContent();
    this.initProcessingOptionsListener();
    this.initWhenListener();
    this.initCopiesValue();
    this.initTermsValue();
  }

  ngOnDestroy () {
    this.unsubscribe$.next();
    this.unsubscribe$.complete();
  }

  initAllowedFileTypes (): void {
    // break up the formats into an array and parse out any invalid formats;
    if (this.schoolProfile.docUploadFormats) {
      const schoolFormats = this.schoolProfile.docUploadFormats.toLowerCase().split('|');
      const allowedExtensions = ['jpg', 'jpeg', 'gif', 'png', 'tif', 'tiff', 'pdf', 'doc', 'docx'];

      schoolFormats.forEach(extension => {
        if (allowedExtensions.indexOf(extension) > -1) {
          this.content.allowedFileTypes.push(extension);
        }
      });
    }
  }

  initTranscriptWhenValues (): void {
    // convert `processingOptions` to a usable array for a SELECT;
    this.values.transcriptWhen = this.schoolProfile.processingOptions.map((option: SchoolProfileProcessingOption) => {
      return {
        name: option.description,
        value: option.code
      };
    });

    // alphabetize the array;
    this.values.transcriptWhen = _sortBy(this.values.transcriptWhen, 'name');

    // find out if the available processing options have "current transcript" (identified by the code property);
    let indexN;
    this.values.transcriptWhen.map((option: SelectOption, index: number) => {
      if (option.value === 'N') {
        indexN = index;
        this.hasN = true;
      }
    });

    // move the "current transcript" value to the top;
    if (indexN) {
      this.values.transcriptWhen.splice(0, 0, this.values.transcriptWhen.splice(indexN, 1)[0]);
    }

    // hide the question if there are no values to display;
    if (this.values.transcriptWhen.length === 0) {
      this.show.transcriptWhen = false;
    }
  }

  initDeliveryMethodValues (): void {
    // convert `deliveryMethods` to a usable array for a SELECT;
    // need to "fix" the electronic display because the back-end is serving up content we dont want the user to see;

    // split up the delivery methods into two groups, general and rush;
    // but only if there are delivery methods for those groups;
    // be default assume neither group are available to display;
    let hasG = false;
    let hasR = false;

    this.values.options.deliveryMethods.map((option: SchoolProfileDeliveryMethod) => {
      const display = this.convertDeliveryMethod.get(option.displayWithFee);
      const isOptionETX = option.deliveryMethodType === 'T';
      const isCurrentlyEnrolled = this.data.response.student.currEnrolled === config.values.yes;
      const isDeliveryMethodVisible = () => {
        // if the target is ETX, then only show ETX options to the user, if they answered the `enrolledBefore` question properly;
        // if the target is NOT ETX, then only show the non-ETX options to the user;
        return this.isElectronicExchange()
          ? isOptionETX && isCurrentlyEnrolled
          : !isOptionETX;
      };
      const pushDeliveryMethod = (array, name, value): void => {
        array.push({
          name: name,
          value: value
        });
      };

      // determine which array to populate with this option;
      const deliveryMethodsG = this.isElectronicExchange() && isOptionETX
        ? this.values.deliveryMethodsEtxG
        : this.values.deliveryMethodsNonEtxG;
      const deliveryMethodsR = this.isElectronicExchange() && isOptionETX
        ? this.values.deliveryMethodsEtxR
        : this.values.deliveryMethodsNonEtxR;

      // if the user attended school prior to electronic delivery being available, dont show the option to the user;
      if (isDeliveryMethodVisible()) {
        switch (option.deliveryMethodCategory) {
          case this.values.processingMethods[0].value:
            hasG = true;
            pushDeliveryMethod(deliveryMethodsG, display, option.deliveryMethodId);
            break;

          case this.values.processingMethods[1].value:
            hasR = true;
            pushDeliveryMethod(deliveryMethodsR, display, option.deliveryMethodId);
            break;
        }
      }
    });

    // sort the non-ETX delivery methods;
    // dont need to sort the ETX delivery methods, there should be only one;
    this.values.deliveryMethodsNonEtxG = _sortBy(this.values.deliveryMethodsNonEtxG, 'name');
    this.values.deliveryMethodsNonEtxR = _sortBy(this.values.deliveryMethodsNonEtxR, 'name');

    if (hasG && hasR) {
      this.show.processingMethods = true;
    }
  }

  initTranscriptTypeValues (): void {
    // convert `transcriptTypes` to a usable array for a SELECT;
    this.values.transcriptTypes = this.values.options.transcriptTypes.map((option: SchoolProfileTranscriptType) => {
      return {
        name: option.displayWithFee,
        value: option.xcriptTypeId
      };
    });

    // alphabetize the array;
    this.values.transcriptTypes = _sortBy(this.values.transcriptTypes, 'name');

    // hide the question if there are no values to display;
    if (this.values.transcriptTypes.length === 0) {
      this.show.transcriptTypes = false;
    }
  }

  initTranscriptPurposeValues (): void {
    // convert `transcriptPurposes` to a usable array for a SELECT;
    this.values.transcriptPurposes = this.schoolProfile.transcriptPurposes.map((option: SchoolProfileTranscriptPurpose) => {
      return {
        name: option.display,
        value: option.xcriptPurposeId
      };
    });

    // alphabetize the array;
    this.values.transcriptPurposes = _sortBy(this.values.transcriptPurposes, 'name');

    // hide the question if there are no values to display;
    if (this.values.transcriptPurposes.length === 0) {
      this.show.transcriptPurposes = false;
    }
  }

  initHowManyValues (): void {
    // convert `quantities` to a usable array for a SELECT;
    // but the options to display are based on the delivery method;
    // if electronic - only show one (1) - can't order 15 PDFs, but you can order 15 paper transcripts;
    // so we parse the values into two arrays;
    // and display the appropriate array based on the selected delivery method;
    this.values.howManyAll = this.values.options.quantities.map((option: SchoolProfileQuantity) => {
      return {
        name: option.displayWithFee,
        value: option.quantityId
      };
    });

    this.values.howManyElectronic = [this.values.howManyAll[0]];

    // now that the values are organized into two arrays, lets determine which array to init the form with;
    // init the "how many copies" field based off the selected "delivery method";
    const selectedDeliveryMethod = this.dataService.getDeliveryMethodObject(this.data.form.recipient.delivery.deliveryMethod);

    // if a value was found, and it's electronic, show only the electronic values for the howMany question;
    if (selectedDeliveryMethod) {
      if (config.values.deliveryMethod.electronicValues.indexOf(selectedDeliveryMethod.deliveryMethodType) > -1) {
        this.values.howMany = this.values.howManyElectronic;
      } else {
        this.values.howMany = this.values.howManyAll;
      }
    } else {
      this.values.howMany = this.values.howManyAll;
    }
  }

  initForm (): void {
    const currentYear = moment().year();
    const maxYear = currentYear + 10;
    const minYear = currentYear - 1;
    const delivery = this.data.form.recipient.delivery;

    this.values.yearValidationOptional = [ Validators.minLength(4), Validators.max(maxYear), Validators.min(minYear) ];
    this.values.yearValidationRequired = [ Validators.minLength(4), Validators.max(maxYear), Validators.min(minYear), Validators.required ];

    const specialInstructionsValue = this.data.schoolProfile.askSpecialInstr === 'O'
      ? delivery.specialInstructions
      : config.values.nullDisabled;

    this.formGroup = this.formBuilder.group({
      transcriptWhen: new FormControl(
        this.show.transcriptWhen ? delivery.transcriptWhen ? delivery.transcriptWhen : this.hasN ? 'N' : null : config.values.nullDisabled,
        [ Validators.required ]
      ),
      transcriptType: new FormControl(
        this.show.transcriptTypes ? delivery.transcriptType : config.values.nullDisabled,
        [ Validators.required ]
      ),
      transcriptPurpose: new FormControl(
        this.show.transcriptPurposes ? delivery.transcriptPurpose : config.values.nullDisabled,
        [ Validators.required ]
      ),
      processingMethod: new FormControl(
        this.show.processingMethods
          ? delivery.processingMethod || this.values.processingMethods[0].value
          : config.values.nullDisabled,
        [ Validators.required ]
      ),
      deliveryMethod: new FormControl(this.data.form.recipient.delivery.deliveryMethod, [ Validators.required ]),
      acceptTerms: new FormControl(delivery.acceptTerms, [ Validators.required ]),
      howMany: new FormControl(delivery.howMany || this.values.howMany[0].value, [ Validators.required ]),
      course1: new FormControl(delivery.course1 || config.values.nullDisabled, [ Validators.required ]),
      course2: new FormControl(delivery.course2 || config.values.nullDisabled),
      term: new FormControl(delivery.term || config.values.nullDisabled),
      year: new FormControl(delivery.year || config.values.nullDisabled, this.values.yearValidationOptional),
      degreeTitle: new FormControl(delivery.degreeTitle || config.values.nullDisabled),
      specialInstructions: new FormControl(specialInstructionsValue)
    });

    // any change to the form means the user is actively using the app, so extend the system timeout;
    this.formGroup.valueChanges
      .pipe(
        takeUntil(this.unsubscribe$)
      )
      .subscribe(value => {
        this.timeoutService.startWarningCountdown();
      });

    // now that the form is set, we can set the delivery methods;
    // couldn't do this during the initValues method because we needed the form control;
    this.setDeliveryMethods();
  }

  // the processing options isn't always visible;
  // but when it is, it controls the visibility and content of the delivery method question;
  initProcessingOptionsListener (): void {
    this.formGroup.controls.processingMethod.valueChanges
      .pipe(
        takeUntil(this.unsubscribe$)
      )
      .subscribe((value) => {
        if (value) {
          this.setDeliveryMethods();
        }
      });
  }

  initWhenListener (): void {
    // hide/show additional questions based on the transcriptWhen;
    this.formGroup.controls.transcriptWhen.valueChanges
      .pipe(
        takeUntil(this.unsubscribe$)
      )
      .subscribe((value) => {
        if (value) {
          this.showAdditionalTranscriptWhenQuestions(value);
        }
      });

    // run onLoad, and pass the onChange prop as false to the values don't get erased when the fields are shown;
    this.showAdditionalTranscriptWhenQuestions(this.formGroup.controls.transcriptWhen.value, false);
  }

  initCopiesValue (): void {
    // if a user has selected `electronic pdf` then prevent the user from selecting more than one copy;
    // NSC isn't going to send an email with 5 PDF attachements that are all the same;
    this.formGroup.controls.deliveryMethod.valueChanges
      .pipe(
        takeUntil(this.unsubscribe$)
      )
      .subscribe((value) => {
        // if a selection has been made, we can now show and manipulate the rest of the form;
        if (value) {
          this.setDeliveryMethodContent();
        }
      });
  }

  initTermsValue (): void {
    // when the user changes the delivery method, reset the terms question back to no;
    // even if they previously selected yes, they selected yes for a different question/delivery method;
    this.formGroup.controls.deliveryMethod.valueChanges
      .pipe(
        takeUntil(this.unsubscribe$)
      )
      .subscribe((value) => {
        if (value) {
          this.formGroup.patchValue({
            acceptTerms: null
          });
        }
      });
  }

  setTotalFees (totalFees: number): void {
    // total fees are calculated within the fee-summary component and emited;
    // we need to record the total value here to make calculation on the order-review page easier;
    this.values.totalFees = totalFees;
  }

  showAdditionalTranscriptWhenQuestions (value, onChange = true): void {
    const controls = this.formGroup.controls;

    this.show.labelForG = false;
    this.show.labelForD = false;

    controls.course1.disable();
    controls.course2.disable();
    controls.term.disable();
    controls.year.disable();
    controls.degreeTitle.disable();

    // reset the validation for the following fields;
    this.content.requireDegree = false;
    this.content.requireTerm = false;
    this.content.requireYear = false;
    controls.degreeTitle.clearValidators();
    controls.term.clearValidators();
    controls.year.setValidators(this.values.yearValidationOptional);

    // always clear out the fields we will hide/show;
    // but only on change, not on init (otherwise their value would be lost on edit);
    if (onChange) {
      this.formGroup.patchValue({
        course1: null,
        course2: null,
        term: null,
        year: null,
        degreeTitle: null
      });
    }

    if (value) {
      switch (value) {
        // after grade(s) is changed;
        case 'C':
          this.show.additionalWhenQuestions = true;

          this.manageFields.enable([
            controls.course1,
            controls.course2,
            controls.term,
            controls.year
          ]);
          break;

        // after degree is awarded;
        case 'D':
          this.show.additionalWhenQuestions = true;
          this.show.labelForD = true;

          this.manageFields.enable([
            controls.degreeTitle,
            controls.term,
            controls.year
          ]);

          // change the validation for the following fields;
          this.content.requireDegree = true;
          this.content.requireTerm = true;
          this.content.requireYear = true;
          controls.degreeTitle.setValidators([ Validators.required ]);
          controls.term.setValidators([ Validators.required ]);
          controls.year.setValidators(this.values.yearValidationRequired);
          break;

        // hold for fall term grades;
        case 'F':
          this.show.additionalWhenQuestions = true;

          this.manageFields.enable([
            controls.term,
            controls.year
          ]);
          break;

        // after grades are posted;
        case 'G':
          if (this.data.schoolProfile.askTermYear === 'O') {
            this.show.additionalWhenQuestions = true;
            this.show.labelForG = true;

            this.manageFields.enable([
              controls.term,
              controls.year
            ]);

            this.content.requireTerm = true;
            this.content.requireYear = true;
            controls.term.setValidators([ Validators.required ]);
            controls.year.setValidators(this.values.yearValidationRequired);
          }
          break;

        // after honors statement is posted;
        case 'H':
          this.show.additionalWhenQuestions = true;

          this.manageFields.enable([
            controls.term,
            controls.year
          ]);
          break;

        // after correspondence corse is completed;
        case 'R':
          this.show.additionalWhenQuestions = true;

          this.manageFields.enable([
            controls.course1,
            controls.course2
          ]);
          break;

        // after degree completion statement is posted;
        case 'S':
          this.show.additionalWhenQuestions = true;

          this.manageFields.enable([
            controls.degreeTitle,
            controls.term,
            controls.year
          ]);
          break;

        // spring term grades;
        case 'T':
          this.show.additionalWhenQuestions = true;

          this.manageFields.enable([
            controls.term,
            controls.year
          ]);
          break;

        // hold for current term schedule to appear;
        case 'U':
          this.show.additionalWhenQuestions = true;

          this.manageFields.enable([
            controls.term,
            controls.year
          ]);
          break;

        default:
          this.show.additionalWhenQuestions = false;
          break;
      }
    }
  }

  isElectronicExchange (): boolean {
    const who = this.data.form.recipient.who;

    // we know if this is an ETX recipient if a recipient had a response object, and the value isn't "not in list";
    return who.recipientResponse !== null && who.department !== config.values.select.notInList.value;
  }

  setDeliveryMethods (): void {
    // determine which delivery methods to use, standard or rush;
    const deliveryMethodsG = this.isElectronicExchange() ? this.values.deliveryMethodsEtxG : this.values.deliveryMethodsNonEtxG;
    const deliveryMethodsR = this.isElectronicExchange() ? this.values.deliveryMethodsEtxR : this.values.deliveryMethodsNonEtxR;

    // if the processing method value is set, then it's standard if it's equal to the first option;
    // otherwise use stantard if values are present, otherwise use rush;
    const processingMethodValue = this.formGroup.controls.processingMethod.value;
    const isStandardProcessing = processingMethodValue !== null
      ? processingMethodValue === this.values.processingMethods[0].value
      : deliveryMethodsG.length > 0;

    this.values.deliveryMethods = isStandardProcessing ? deliveryMethodsG : deliveryMethodsR;

    // if the selected value is not in the array, update the value;
    // if it is in the array, do nothing, we dont want to erase that value;
    if (_filter(this.values.deliveryMethods, { value: this.formGroup.controls.deliveryMethod.value }).length === 0) {
      const singleDeliveryMethod = this.values.deliveryMethods.length === 1;

      // now that the delivery methods have been set, if there is only one to choose from, select it;
      this.formGroup.patchValue({
        deliveryMethod: singleDeliveryMethod
          ? this.values.deliveryMethods[0].value
          : null
      });

      // if there are more than a single delivery method to select, the value has been cleared;
      // don't show an error message to the user, until they interact with this "new" control;
      if (singleDeliveryMethod === false) {
        this.formGroup.controls.deliveryMethod.markAsUntouched();
      }
    }
  }

  setDeliveryMethodContent (): void {
    const deliveryMethod = this.dataService.getDeliveryMethodObject(this.formGroup.controls.deliveryMethod.value);

    // set the content based on the selected delivery method;
    if (deliveryMethod) {
      this.content.deliveryMethodHelpText = deliveryMethod.helpText;
      this.content.deliveryMethodDisplay = deliveryMethod.display;
      this.content.deliveryMethodType = deliveryMethod.deliveryMethodType;

      // alter the available answers for the `How many copies...` question;
      // electronic vs all others;
      if (config.values.deliveryMethod.electronicValues.indexOf(this.content.deliveryMethodType) > -1) {
        this.values.howMany = this.values.howManyElectronic;
      } else {
        this.values.howMany = this.values.howManyAll;
      }

      this.formGroup.patchValue({
        howMany: this.values.howMany[0].value
      });
    }
  }

  previous (): void {
    if (window.confirm(config.values.warningLoseInformation)) {
      this.dataService.resetRecipientDeliveryMethod();

      this.securityService.setDeactivateWarning(false);

      this.router.navigate([config.routes.recipientSelect], config.routes.extras);
    }
  }

  cancel (): void {
    this.securityService.cancelOrder();
  }

  continue (): void {
    // we need to clear out any previous content before saving to prevent orphaned content (like courses);
    this.dataService.resetRecipientDeliveryMethod();
    this.dataService.save(this.formGroup.value, 'form.recipient.delivery');

    // save the fee to make calculations on the `order-review` route simplier;
    this.dataService.save({ totalFee: this.values.totalFees }, 'form.recipient');

    // if recipient is 'Me' then we prepopulate the delivery address with the user's address
    const recipientIsMe = this.data.form.recipient.who.recipientType === config.values.recipientType.me;

    if (recipientIsMe) {
      const requestor = this.data.response.student;
      const isUS = requestor.country === config.values.country.us;
      const isCA = requestor.country === config.values.country.ca;
      const isDomestic = isUS || isCA;

      this.dataService.save({
        addressLine1: requestor.street1,
        addressLine2: requestor.street2 || null,
        zip: requestor.zip,
        city: requestor.city,
        state: isDomestic ? requestor.state : null,
        country: requestor.country,
        phone: requestor.phone,
        emailPrimary: requestor.email,
        emailConfirm: requestor.email
      }, 'form.recipient.address');
    }

    // now move to the next route (depending on what delivery method was selected);
    // if the selected delivery method is ETX, skip the address route;
    // if the delivery method is electronic, go to the electronic address form;
    // otherwise go to the mail address form;
    const deliveryMethodObject = this.dataService.getDeliveryMethodObject(this.formGroup.controls.deliveryMethod.value);
    const isOrderReviewRoute = deliveryMethodObject.deliveryMethodType === 'T';
    const isElectronicRoute = deliveryMethodObject.deliveryMethodType === 'E';

    const routeNext = isOrderReviewRoute
      ? config.routes.orderReview
      : isElectronicRoute
        ? config.routes.recipientEmail
        : config.routes.recipientAddress;

    // if we're skipping the address route, save this recipient so it'll show up on the order-review route;
    if (isOrderReviewRoute) {
      // clear out any previous content before saving to prevent orphaned content (like state/phone);
      this.dataService.resetRecipientAddress();
      this.dataService.saveRecipient();
    }

    this.securityService.setDeactivateWarning(false);

    this.router.navigate([routeNext], config.routes.extras);
  }
}
