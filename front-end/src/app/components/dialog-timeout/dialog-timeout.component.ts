import { BehaviorSubject, interval as observableInterval, Observable, Subscription } from 'rxjs';
import { Component, Inject, OnInit } from '@angular/core';
import { map } from 'rxjs/operators';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';

import { TimeoutService } from '../../services/timeout/timeout.service';


@Component({
  selector: 'nsc-dialog-timeout',
  templateUrl: './dialog-timeout.component.html',
  styleUrls: ['./dialog-timeout.component.scss']
})
export class DialogTimeoutComponent implements OnInit {
  countdown$: Observable<number>;
  countdownSubscription: Subscription;

  values = {
    countdownFrom: 120, // number of seconds until the user session is ended;
    count: 120
  };

  content = {
    message: this.returnMessage(this.returnTime(this.values.countdownFrom))
  };

  constructor (
    public dialogRef: MatDialogRef<DialogTimeoutComponent>,
    private timeoutService: TimeoutService
  ) {}

  ngOnInit () {
    // start the countdown with an interval;
    // on each interval set the new number of seconds that will used to generate the displayed time;
    this.countdown$ = observableInterval(1000)
      .pipe(
        map(n => {
          return this.values.count = this.values.countdownFrom - n;
        })
      );

    // create a subscription that listens to the observable;
    this.countdownSubscription = this.countdown$.subscribe(n => {
      // parse the time based on the number of seconds;
      const time = this.returnTime(n);
      // determine if the timer has reached zero;
      const atZero = n === 0;

      // set the message based on the amount of time left;
      this.content.message = this.returnMessage(time);

      // once the countdown hits zero;
      // kill the subscription (for to save memory);
      // and end the user session;
      if (atZero) {
        this.countdownSubscription.unsubscribe();
        this.timeoutService.endSession();
        this.dialogRef.close();
      }
    });
  }

  // abstracted to its own method so it can be used in in the subscription and during initalization;
  returnMessage (time: string): string {
    return `Your session is about to expire in ${ time } minutes. Please select OK to renew the session, or your work might be lost.`;
  }

  // abstracted to its own method so it can be used in in the subscription and during initalization;
  returnTime (n: number): string {
    return new Date(n * 1000).toISOString().substr(15, 4);
  }

  // start the countdown again when the user clicks OK;
  resetCountdown (): void {
    this.countdownSubscription.unsubscribe();
    this.dialogRef.close();

    // if there was time left, that means the user session is still valid;
    // so start the timer again;
    if (this.values.count) {
      this.timeoutService.startWarningCountdown();
    }
  }
}
