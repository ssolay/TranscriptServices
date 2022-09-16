import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';

import { config } from '../../config/config';
import { DataService } from '../../services/data/data.service';
import { SecurityService } from '../../services/security/security.service';
import { TimeoutService } from '../../services/timeout/timeout.service';
import { ValidateMatch } from '../../validators/match.validator';


@Component({
  selector: 'nsc-recipient-email',
  templateUrl: './recipient-email.component.html',
  styleUrls: ['./recipient-email.component.scss']
})
export class RecipientEmailComponent implements OnDestroy, OnInit {
  formGroup: FormGroup;
  unsubscribe$ = new Subject();

  constructor (
    private dataService: DataService,
    private formBuilder: FormBuilder,
    private router: Router,
    private securityService: SecurityService,
    private timeoutService: TimeoutService
  ) {}

  ngOnInit () {
    this.initForm();
  }

  ngOnDestroy () {
    this.unsubscribe$.next();
    this.unsubscribe$.complete();
  }

  initForm (): void {
    const address = this.dataService.get().form.recipient.address;

    this.formGroup = this.formBuilder.group({
      recipient: new FormControl(this.dataService.getRecipient(), [ Validators.required ]),
      emailPrimary: new FormControl(address.emailPrimary, [ Validators.required, Validators.email ]),
      emailConfirm: new FormControl(address.emailConfirm, [ Validators.required, Validators.email ]),
    }, {
      // run custom validators to make sure the both fields are equal;
      validator: [ ValidateMatch('emailPrimary', 'emailConfirm') ]
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
    this.dataService.resetRecipientEmail();

    this.dataService.save(this.formGroup.value, 'form.recipient.address');
    this.dataService.saveRecipient();

    this.securityService.setDeactivateWarning(false);

    this.router.navigate([config.routes.orderReview], config.routes.extras);
  }
}
