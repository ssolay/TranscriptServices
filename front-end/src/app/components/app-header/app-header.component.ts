import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { Router } from '@angular/router';

import { config } from '../../config/config';
import { DataService } from '../../services/data/data.service';
import { SecurityService } from '../../services/security/security.service';
import { WebAimContrastChecker } from '../../classes/web-aim-contrast-checker';


@Component({
  selector: 'nsc-app-header',
  templateUrl: './app-header.component.html',
  styleUrls: ['./app-header.component.scss']
})
export class AppHeaderComponent implements OnChanges, OnInit {
  @Input('route') route: string;

  content = {
    headerBackgroundColorDefault: '#ffffff',
    headerBackgroundColor: null,
    pageTitle: null,
    schoolLogoSrc: null,
    schoolLogoAlt: null,
    schoolName: null,
    shoppingCartCount: 0
  };

  show = {
    cart: false,
    darkHeader: false,
    link: false
  };

  constructor (
    private dataService: DataService,
    private router: Router,
    private securityService: SecurityService,
    private webAimContrastChecker: WebAimContrastChecker
  ) {}

  ngOnInit () {
    this.content.headerBackgroundColor = this.content.headerBackgroundColorDefault;

    this.initShoppingCartCount();
  }

  // on route init, or change, configure what to display based on the route;
  ngOnChanges (changes: SimpleChanges) {
    if (this.route) {
      this.setHeaderConfig();

      // dont enable the link on the order review route;
      // since the link points to this route;
      this.show.link = this.route !== config.routes.orderReview;
    }
  }

  initShoppingCartCount (): void {
    // set initial value;
    this.content.shoppingCartCount = this.dataService.get().form.recipients.length;

    // listen for changes to the recipients and update the shopping cart;
    this.dataService.recipientsUpdated.subscribe((count: number) => {
      this.content.shoppingCartCount = count;
    });
  }

  setHeaderConfig (): void {
    const setSchoolValues = () => {
      const schoolProfile = this.dataService.get().schoolProfile;
      const logo = schoolProfile.toSchoolHeader;

      // if the logo is defined, then show it, otherwise do not;
      if (logo && logo.contentType && logo.logoBase64) {
        this.content.schoolLogoSrc = `data:${ logo.contentType };base64,${ logo.logoBase64 }`;
        this.content.schoolLogoAlt = logo.alternateText;
        this.content.headerBackgroundColor = logo.bgColor;
        // show the dark header if the light color combo don't have enough contrast;
        this.show.darkHeader = !this.webAimContrastChecker.hasEnoughContrast('#000000', logo.bgColor);
      } else {
        this.content.schoolName = schoolProfile.schlName;
      }
    };

    // set configuration based on the route;
    switch (this.route) {
      case config.routes.schoolSelect:
      case config.routes.messageComplete:
      case config.routes.messageError:
      case config.routes.messageTimeout:
        this.content.schoolLogoSrc = null;
        this.content.headerBackgroundColor = this.content.headerBackgroundColorDefault;
        this.content.schoolName = null;
        this.show.darkHeader = false;
        this.show.cart = false;
        break;

      case config.routes.schoolWelcome:
      case config.routes.orderConsent:
      case config.routes.orderPayment:
      case config.routes.orderConfirmation:
        setSchoolValues();
        this.show.cart = false;
        break;

      case config.routes.requestorIdentification:
      case config.routes.requestorAddress:
      case config.routes.requestorAttend:
      case config.routes.recipientSelect:
      case config.routes.recipientDeliveryMethod:
      case config.routes.recipientAddress:
      case config.routes.recipientEmail:
      case config.routes.orderReview:
        setSchoolValues();
        this.show.cart = true;
        break;
    }
  }

  goToOrderReview (): void {
    const go = () => {
      this.securityService.setDeactivateWarning(false);

      this.router.navigate([config.routes.orderReview], config.routes.extras);
    };
    const routesToConfirm = [
      config.routes.recipientSelect,
      config.routes.recipientDeliveryMethod,
      config.routes.recipientAddress,
      config.routes.recipientEmail
    ];

    // if we should confirm navigation before happening;
    if (routesToConfirm.indexOf(this.route) > -1) {
      if (window.confirm('If you leave this page now, you will lose any incomplete order information for the current recipient. Do you wish to continue?')) {
        go();
      }
    // otherwise just go;
    } else {
      go();
    }
  }
}
