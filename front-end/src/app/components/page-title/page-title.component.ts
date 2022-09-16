import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { Title } from '@angular/platform-browser';

import { config } from '../../config/config';
import { DataService } from '../../services/data/data.service';


@Component({
  selector: 'nsc-page-title',
  templateUrl: './page-title.component.html',
  styleUrls: ['./page-title.component.scss']
})
export class PageTitleComponent implements OnChanges, OnInit {
  @Input('route') route: string;

  content = {
    appTitle: 'National Student Clearinghouse Transcript Services',
    pageTitle: null,
    recipient: null
  };

  constructor (
    private dataService: DataService,
    private title: Title
  ) {}

  ngOnInit () {}

  ngOnChanges (changes: SimpleChanges) {
    this.setPageTitleConfig(this.route);
  }

  // set the content to display based on the current route;
  setPageTitleConfig (route: string): void {
    switch (route) {
      case config.routes.schoolSelect:
      case config.routes.schoolWelcome:
      case config.routes.messageComplete:
      case config.routes.messageError:
      case config.routes.messageTimeout:
        this.content.pageTitle = null;
        this.content.recipient = null;
        break;

      case config.routes.requestorIdentification:
      case config.routes.requestorAddress:
      case config.routes.requestorAttend:
        this.content.pageTitle = 'Enter Personal Information';
        this.content.recipient = null;
        break;

      case config.routes.recipientSelect:
        this.content.pageTitle = 'Select Transcript and Delivery Details';
        this.content.recipient = null;
        break;

      case config.routes.recipientDeliveryMethod:
        this.content.pageTitle = 'Select Transcript and Delivery Details';
        this.content.recipient = this.dataService.getRecipient();
        break;

      case config.routes.recipientAddress:
      case config.routes.recipientEmail:
        this.content.pageTitle = 'Provide Delivery Information';
        this.content.recipient = this.dataService.getRecipient();
        break;

      case config.routes.orderReview:
      case config.routes.orderConsent:
      case config.routes.orderPayment:
        this.content.pageTitle = 'Confirm Order and Checkout';
        this.content.recipient = null;
        break;

      case config.routes.orderConfirmation:
        this.content.pageTitle = 'Order Confirmation';
        this.content.recipient = null;
        break;
    }

    // change the TITLE tag based on the route;
    const newTitle = this.content.pageTitle
      ? `${ this.content.pageTitle } · ${ this.content.appTitle }`
      : this.content.appTitle;

    this.title.setTitle(newTitle);
  }
}
