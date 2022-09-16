import { ActivatedRouteSnapshot, CanActivate, CanDeactivate, Router, RouterStateSnapshot } from '@angular/router';
import { empty as observableEmpty,  Observable } from 'rxjs';
import { Injectable } from '@angular/core';

import { config } from '../../config/config';
import { DataService } from '../data/data.service';


@Injectable() export class SecurityService implements CanActivate, CanDeactivate<any> {
  showDeactivateWarning = false;

  constructor (
    private router: Router,
    private dataService: DataService
  ) {}

  canDeactivate (): boolean {
    return this.showDeactivateWarning
      ? window.confirm('We do not recommend using the browser back button if you want to proceed with this order. To exit the Transcript Ordering Center, please select ‘OK’.  If you would like to continue with your order but require changes, select ‘Cancel’ and review the available editing options.')
      : true;
  }

  canActivate (route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    switch (state.url.replace('/', '')) {
      // these routes requite a school to be selected;
      case config.routes.schoolWelcome:
      case config.routes.requestorIdentification:
      case config.routes.requestorAddress:
      case config.routes.requestorAttend:
      case config.routes.recipientSelect:
        if (this.dataService.isSchoolNull()) {
          this.loadSafeURL();
          return false;
        }
        break;

      // these routes require a school to be selected and a recipient started;
      case config.routes.recipientDeliveryMethod:
      case config.routes.recipientAddress:
      case config.routes.recipientEmail:
        if (this.dataService.isSchoolNull() || this.dataService.isRecipientNull()) {
          this.loadSafeURL();
          return false;
        }
        break;

      // these routes require a school to be selected and at least one finished recipient;
      case config.routes.orderReview:
      case config.routes.orderConsent:
      case config.routes.orderPayment:
      case config.routes.orderConfirmation:
        if (this.dataService.isSchoolNull() || this.dataService.isRecipientsEmpty()) {
          this.loadSafeURL();
          return false;
        }
        break;
    }

    // if all those checks were passed, load the route;
    return true;
  }

  setDeactivateWarning (value: boolean): void {
    this.showDeactivateWarning = value;
  }

  // if any security check fails, load the school-select route;
  loadSafeURL (): void {
    this.setDeactivateWarning(false);

    this.router.navigate([config.routes.schoolSelect], config.routes.extras);
  }

  // `cancel order` button click;
  // reset any user entered data, then load the school-select route;
  cancelOrder (): void {
    this.dataService.resetUserData();

    this.setDeactivateWarning(false);

    this.router.navigate([config.routes.schoolSelect], config.routes.extras);
  }

  catchResponse (error): Observable<never> {
    console.error(error);

    // clear all data for security reasons;
    this.dataService.resetDataObject();

    this.setDeactivateWarning(false);

    // send the user to the thank you page;
    this.router.navigate([config.routes.messageError], config.routes.extras);

    // stop the chain, so the subscribe method doesn't fire;
    return observableEmpty();
  }
}
