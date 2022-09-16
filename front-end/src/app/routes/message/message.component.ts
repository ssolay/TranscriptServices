import { ActivatedRoute } from '@angular/router';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';

import { config } from '../../config/config';
import { DataService } from '../../services/data/data.service';
import { BlockingIndicatorService } from '../../services/blocking-indicator/blocking-indicator.service';


@Component({
  selector: 'nsc-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.scss']
})
export class MessageComponent implements OnInit, OnDestroy {
  unsubscribe$ = new Subject();

  content = {
    title: '',
    message: '',

    error: {
      title: 'Temporary Service Interruption',
      message: 'A temporary service error was identified. Unfortunately, you will need to initiate a new transcript order request. We are sorry for this inconvenience. Please contact our customer service department at <a href="mailto:transcripts@studentclearinghouse.org">transcripts@studentclearinghouse.org</a> for further assistance if this error reoccurs. Thank you'
    },

    timeout: {
      title: 'Inactivity Timeout',
      message: 'The session has timed out due to inactivity and your order information has been cleared. Please restart the order.'
    },

    complete: {
      title: 'Additional Clearinghouse Information',
      message: 'Payment will be accepted, if a cost is involved, with any major credit or debit card. Your credit or debit card is not charged until your school sends your transcript(s). However, if you use a debit card, your bank may put a hold on your funds when we pre-authorize your payment. If you have questions on the pre-authorization, please contact your bank.'
    }
  };

  constructor (
    private activatedRoute: ActivatedRoute,
    private dataService: DataService,
    private blockingIndicatorService: BlockingIndicatorService,
    private router: Router
  ) {}

  ngOnInit () {
    this.dataService.resetDataObject();

    this.activatedRoute.params
      .pipe(
        takeUntil(this.unsubscribe$)
      )
      .subscribe(params => {
        if (this.content[params.reason]) {
          this.content.title = this.content[params.reason].title;
          this.content.message = this.content[params.reason].message;
        } else {
          this.restart();
        }
      });
  }

  ngOnDestroy () {
    this.unsubscribe$.next();
    this.unsubscribe$.complete();
  }

  restart (): void {
    this.router.navigate([config.routes.schoolSelect], config.routes.extras);
  }
}
