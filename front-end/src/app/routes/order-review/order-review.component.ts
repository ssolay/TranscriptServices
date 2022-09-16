import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';

import { ApiResponseOrder } from '../../interfaces/api-response-order.interface';
import { config } from '../../config/config';
import { DataService } from '../../services/data/data.service';
import { PostService } from '../../services/post/post.service';
import { BlockingIndicatorService } from '../../services/blocking-indicator/blocking-indicator.service';
import { SecurityService } from '../../services/security/security.service';


@Component({
  selector: 'nsc-order-review',
  templateUrl: './order-review.component.html',
  styleUrls: ['./order-review.component.scss']
})
export class OrderReviewComponent implements OnDestroy, OnInit {
  unsubscribe$ = new Subject();

  content = {
    recipients: this.dataService.get().form.recipients,
    totalFees: this.dataService.getTotalFees(),
    processingFee: this.dataService.get().schoolProfile.baseOpFee
  };

  values = {
    maxRecipients: 50
  };

  constructor (
    private dataService: DataService,
    private postService: PostService,
    private blockingIndicatorService: BlockingIndicatorService,
    private router: Router,
    private securityService: SecurityService
  ) {}

  ngOnInit () {
    // clear out any inprogress recipient data;
    // the recipient has already been saved, or abandoned when this route loads;
    this.dataService.resetRecipient();
  }

  ngOnDestroy () {
    this.unsubscribe$.next();
    this.unsubscribe$.complete();
  }

  addRecipient (): void {
    this.securityService.setDeactivateWarning(false);

    this.router.navigate([config.routes.recipientSelect], config.routes.extras);
  }

  editRecipient (index: number): void {
    this.dataService.editRecipient(index);

    this.securityService.setDeactivateWarning(false);

    // now that we've set the current recipient, we can go back and edit the content;
    this.router.navigate([config.routes.recipientSelect], config.routes.extras);
  }

  deleteRecipient (index: number): void {
    const recipient = this.content.recipients[index].address.recipient;

    // make sure the user wanted to delete the recipient;
    if (window.confirm(`You are removing this recipient (${ recipient }) from the order. Are you sure you want to continue?`)) {
      this.dataService.deleteRecipient(index);

      // now that the data has been updated in the service, update our locate copy;
      this.content.totalFees = this.dataService.getTotalFees(),
      this.content.recipients = this.dataService.get().form.recipients;
    }
  }

  cancel (): void {
    this.securityService.cancelOrder();
  }

  continue (): void {
    this.blockingIndicatorService.open();

    // post the data to the back-end;
    // once that's complete, save the response, and move onto the next oute;
    this.postService.recipients()
      .pipe(
        takeUntil(this.unsubscribe$)
      )
      .subscribe((json: ApiResponseOrder) => {
        window.setTimeout(() => {
          const route = json.orderHeader.requireReleaseFm === 'N'
            ? this.dataService.get().response.orderHeader.totalFee
              ? config.routes.orderPayment
              : config.routes.orderConfirmation
            : config.routes.orderConsent;

          this.securityService.setDeactivateWarning(false);

          this.router.navigate([route], config.routes.extras);
        }, config.values.loading.delay);
      });
  }
}
