import { BehaviorSubject,  Subject } from 'rxjs';
import { cloneDeep as _cloneDeep } from 'lodash';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { sortBy as _sortBy } from 'lodash';
import { takeUntil } from 'rxjs/operators';

import { config } from '../../config/config';
import { BlockingIndicatorService } from '../../services/blocking-indicator/blocking-indicator.service';
import { DataService } from '../../services/data/data.service';
import { ManageFields } from '../../classes/manage-fields';
import { RecipientTypesService } from '../../services/recipient-types/recipient-types.service';
import { SecurityService } from '../../services/security/security.service';
import { SelectOption } from '../../interfaces/select-option.interface';
import { TimeoutService } from '../../services/timeout/timeout.service';
import { ValidateCasId } from '../../validators/cas-id.validator';


@Component({
  selector: 'nsc-recipient-select',
  templateUrl: './recipient-select.component.html',
  styleUrls: ['./recipient-select.component.scss']
})
export class RecipientSelectComponent implements OnDestroy, OnInit {
  data = this.dataService.get();
  who = this.data.form.recipient.who;

  formGroup: FormGroup;
  unsubscribe$ = new Subject();

  values = {
    // value to compare against (used to show additional fields when selected);
    business: config.values.recipientType.business,
    college: config.values.recipientType.college,
    organization: config.values.recipientType.organization,

    // SELECT values populated by service call;
    recipientTypes$: new BehaviorSubject(<SelectOption[]>[])
  };

  constructor (
    public blockingIndicatorService: BlockingIndicatorService,
    private dataService: DataService,
    private formBuilder: FormBuilder,
    private manageFields: ManageFields,
    private recipientTypesService: RecipientTypesService,
    private router: Router,
    private securityService: SecurityService,
    private timeoutService: TimeoutService
  ) {}

  ngOnInit () {
    this.initServiceValues();
    this.initForm();
    this.initRecipientListener();
  }

  ngOnDestroy () {
    this.unsubscribe$.next();
    this.unsubscribe$.complete();
  }

  initForm (): void {
    // initialize the form with the default required fields;
    // required fields will change based on selected options and parameters;
    this.formGroup = this.formBuilder.group({
      recipientType: new FormControl(this.who.recipientType, [ Validators.required ]),
      recipientFiceCode: new FormControl(this.who.recipientFiceCode), // not visible to the user, used on edit to load form values;
      recipientResponse: new FormControl(this.who.recipientResponse), // not visible to the user, used on edit to load form values;

      // school recipient;
      country: new FormControl(this.who.country || config.values.nullDisabled, [ Validators.required ]),
      state: new FormControl(this.who.state || config.values.nullDisabled, [ Validators.required ]),
      school: new FormControl(this.who.school || config.values.nullDisabled),
      schoolNotInList: new FormControl(
        this.who.schoolNotInList || config.values.nullDisabled,
        [ Validators.required, Validators.minLength(3) ]
      ),

      // organization recipient;
      organization: new FormControl(this.who.organization || config.values.nullDisabled, [ Validators.required ]),
      organizationNotInList: new FormControl(
        this.who.organizationNotInList || config.values.nullDisabled,
        [ Validators.required, Validators.minLength(2) ]
      ),
      aamcAccountNumber: new FormControl(
        this.who.aamcAccountNumber || config.values.nullDisabled,
        [ Validators.required, Validators.minLength(8) ]
      ),
      amcasTranscriptIdNumber: new FormControl(
        this.who.amcasTranscriptIdNumber || config.values.nullDisabled,
        [ Validators.required, Validators.minLength(7) ]
      ),
      casId: new FormControl(
        this.who.casId || config.values.nullDisabled,
        [ Validators.required, Validators.minLength(10), ValidateCasId ]
      ),
      lsacAccountNumber: new FormControl(
        this.who.lsacAccountNumber || config.values.nullDisabled,
        [ Validators.required, Validators.minLength(9) ]
      ),

      // business recipient;
      business: new FormControl(
        this.who.business || config.values.nullDisabled,
        [ Validators.required, Validators.minLength(2) ]
      ),

      // school and organization recipient;
      department: new FormControl(
        this.who.department || config.values.nullDisabled,
        [ Validators.required ]
      ),
      departmentNotInList: new FormControl(this.who.departmentNotInList || config.values.nullDisabled)
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

  initServiceValues (): void {
    this.recipientTypesService.data$
      .pipe(
        takeUntil(this.unsubscribe$)
      )
      .subscribe((json: SelectOption[]) => this.values.recipientTypes$.next(json));
  }

  initRecipientListener (): void {
    const controls = this.formGroup.controls;

    // watch the `recipient` field because when a college is selected we want to hide/show form fields, and adjust required fields;
    controls.recipientType.valueChanges
      .pipe(
        takeUntil(this.unsubscribe$)
      )
      .subscribe((value: string) => {
        const isCollege = value === this.values.college;
        const isOrganization = value === this.values.organization;
        const isBusiness = value === this.values.business;

        if (value) {
          // clear all previously entered recipient data;
          // any previous data no longer applies since the user has started down a different recipient path;
          // pass true so the index is preserved;
          // true allows this recipient to be edited, without true, then the index is blown away, and a new recipient will be generated;
          this.dataService.resetRecipient(true);

          // disable these fields no matter what the selected recipient type is;
          // they will be enabled based on other selected values;
          this.manageFields.disable([
            controls.amcasTranscriptIdNumber,
            controls.aamcAccountNumber,
            controls.business,
            controls.casId,
            controls.country,
            controls.department,
            controls.departmentNotInList,
            controls.lsacAccountNumber,
            controls.organization,
            controls.organizationNotInList,
            controls.school,
            controls.schoolNotInList,
            controls.state
          ]);

          // null out any selected recipient;
          // this isn't a field visible to the user;
          // don't disable, just nullify;
          // if disabled, the value wouldn't be saved;
          controls.recipientResponse.setValue(null);

          // show the appropriate fields based on the newly selected recipient type;

          if (isCollege) {
            controls.country.setValue(config.values.country.us);

            this.manageFields.enable([
              controls.country,
              controls.state
            ]);
          }

          if (isBusiness) {
            this.manageFields.enable([
              controls.business
            ]);
          }

          if (isOrganization) {
            this.manageFields.enable([
              controls.organization
            ]);
          }
        }
      });
  }

  cancel (): void {
    if (this.data.form.recipients.length) {
      this.securityService.setDeactivateWarning(false);

      this.router.navigate([config.routes.orderReview], config.routes.extras);
    } else {
      this.securityService.cancelOrder();
    }
  }

  continue (): void {
    // we need to clear out any previous content before saving to prevent orphaned content (like not in list values);
    this.dataService.resetRecipientSelect();

    this.dataService.save(this.formGroup.value, 'form.recipient.who');

    this.securityService.setDeactivateWarning(false);

    this.router.navigate([config.routes.recipientDeliveryMethod], config.routes.extras);
  }
}
