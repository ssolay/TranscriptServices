import { EventEmitter, Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { SecurityService } from '../../services/security/security.service';

import { config } from '../../config/config';


@Injectable() export class TimeoutService {
  showWarning = new EventEmitter(); // used by the dialog-timeout component to know when to show the dialog;
  timeout: number; // container for the setTimeout, so it can be cleared when the user interacts with the page;
  durationWarning = 120 * 60 * 1000; // minutes * seconds * milliseconds;

  constructor (
    private router: Router,
    private securityService: SecurityService
  ) {}

  // called by the timeout dialog;
  // the timeout dialog controls when so the UI matches when the session ends;
  // don't want the timer in the dialog to hit zero and then not end the session;
  endSession (): void {
    this.securityService.setDeactivateWarning(false);

    this.router.navigate([config.routes.messageTimeout], config.routes.extras);
  }

  startWarningCountdown (): void {
    // clear out any existing timeout;
    window.clearTimeout(this.timeout);

    // start the countdown till the warning dialog is shown;
    this.timeout = window.setTimeout(() => {
      this.showWarning.emit(true);
    }, this.durationWarning);
  }
}
