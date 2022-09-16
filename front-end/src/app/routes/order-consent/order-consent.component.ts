import * as moment from 'moment';
import { AfterViewInit, Component, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';

import { config } from '../../config/config';
import { DataService } from '../../services/data/data.service';
import { PostService } from '../../services/post/post.service';
import { SecurityService } from '../../services/security/security.service';
import { TimeoutService } from '../../services/timeout/timeout.service';


// let TypeScript ignore the global jQuery object;
declare var $: any;

@Component({
  selector: 'nsc-order-consent',
  templateUrl: './order-consent.component.html',
  styleUrls: ['./order-consent.component.scss']
})
export class OrderConsentComponent implements AfterViewInit, OnDestroy, OnInit {
  data = this.dataService.get();
  formGroup: FormGroup;
  unsubscribe$ = new Subject();

  content = {
    orderId: this.dataService.get().response.orderHeader.toOrderId,
    recipients: this.dataService.get().response.recipients,
    requestor: this.dataService.getFullName()
  };

  show = {
    electronicConsentForm: this.data.response.orderHeader.consentTypeAllowed === 'PPPL',
    printableConsentForm: true,
    signatureError: false
  };

  values = {
    disableAcceptButton: true,
    disableClearButton: true,
    signatureDate: null,
    signatureSelector: '#signature',
    signatureValidators: this.show.electronicConsentForm ? [ Validators.required ] : []
  };

  constructor (
    private dataService: DataService,
    private formBuilder: FormBuilder,
    private postService: PostService,
    private router: Router,
    private securityService: SecurityService,
    private timeoutService: TimeoutService
   ) {}

  ngOnInit () {
    this.formGroup = this.formBuilder.group({
      signature: new FormControl(null, this.values.signatureValidators)
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

  ngOnDestroy () {
    this.unsubscribe$.next();
    this.unsubscribe$.complete();
  }

  ngAfterViewInit () {
    // init the jQuery plugin after the view has initalized (DOM is available);
    $(this.values.signatureSelector).signature({
      background: '#f4f4f4',
      guideline: true,
      guidelineColor: '#d8d8d8',
      guidelineOffset: 20,
      guidelineIndent: 0,
      change: () => {
        // extend the timeout based on user activity;
        this.timeoutService.startWarningCountdown();

        const signatureLength = $(this.values.signatureSelector).signature('toJSON').length;

        if (signatureLength < 500) {
          this.show.signatureError = true;
          this.values.disableAcceptButton = true;
          this.values.disableClearButton = false;
        } else {
          this.show.signatureError = false;
          this.values.disableAcceptButton = false;
          this.values.disableClearButton = false;
        }
      }
    });
  }

  clearSignature (): void {
    // clear out the current signature so the user can try again;
    $(this.values.signatureSelector).signature('clear');
    this.show.signatureError = false;
    this.values.disableAcceptButton = true;
    this.values.disableClearButton = true;
  }

  captureSignature (): void {
    // get a JSON signature from the jQuery pluin;
    // and then disable form controls so the user can't capture again;
    const signatureJson = JSON.parse($(this.values.signatureSelector).signature('toJSON'));

    // save the data;
    this.formGroup.patchValue({
      signature: signatureJson
    });

    // create a date/time to display;
    this.values.signatureDate = moment().format(config.values.consentDateFormat);

    // stop the user from using the signature field anymore;
    $(this.values.signatureSelector).signature('disable');

    // disable (the now non-functional) clear button;
    this.values.disableAcceptButton = true;
    this.values.disableClearButton = true;

    // update the form status;
    this.formGroup.controls.signature.updateValueAndValidity();

    // hide the download form section;
    this.show.printableConsentForm = false;
  }

  cancel (): void {
    this.securityService.cancelOrder();
  }

  continue (): void {
    this.dataService.resetOrderConsent();

    this.dataService.save({
      signature: this.formGroup.controls.signature.value,
      date: this.values.signatureDate
    }, 'form.consent');

    this.securityService.setDeactivateWarning(false);

    // go to the payment page if there is a fee for this order;
    // otherwise POST the consent data and send the user to the order confifmation screen, the order is done;
    if (this.dataService.get().response.orderHeader.totalFee) {
      this.router.navigate([config.routes.orderPayment], config.routes.extras);
    } else {
      this.postService.consent()
        .pipe(
          takeUntil(this.unsubscribe$)
        )
        .subscribe(() => {
          window.setTimeout(() => {
            this.router.navigate([config.routes.orderConfirmation], config.routes.extras);
          }, config.values.loading.delay);
        });
    }
  }
}
