import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';

import { config } from '../../config/config';


@Component({
  selector: 'nsc-stepper',
  templateUrl: './stepper.component.html',
  styleUrls: ['./stepper.component.scss']
})
export class StepperComponent implements OnChanges, OnInit {
  @Input('route') route: string;

  content = {
    classEmpty: '',
    classProgress: 'nsc-stepper__indicator--progress',
    classPast: 'nsc-stepper__indicator--past',

    line1Class: null,
    line2Class: null,

    step1Selected: null,
    step2Selected: null,
    step3Selected: null
  };

  show = {
    stepper: null
  };

  values = {
    step1Routes: [
      config.routes.schoolSelect,
      config.routes.schoolWelcome,
      config.routes.requestorIdentification,
      config.routes.requestorAddress
    ],
    step2Routes: [
      config.routes.recipientSelect,
      config.routes.recipientDeliveryMethod,
      config.routes.recipientAddress,
      config.routes.recipientEmail
    ],
    step3Routes: [
      config.routes.orderReview,
      config.routes.orderConsent,
      config.routes.orderPayment,
      config.routes.orderConfirmation
    ]
  };

  constructor () {}

  ngOnInit () {}

  ngOnChanges (changes: SimpleChanges) {
    this.setStepperConfig(this.route);
    this.setStepperVisibility(this.route);
  }

  // set the classes that will determine how the stepper is displayed (step 1, 2, or 3);
  setStepperConfig (route: string): void {
    if (this.values.step1Routes.indexOf(route) > -1) {
      this.content.step1Selected = true;
      this.content.step2Selected = false;
      this.content.step3Selected = false;
      this.content.line1Class = this.content.classProgress;
      this.content.line2Class = this.content.classEmpty;
    }

    if (this.values.step2Routes.indexOf(route) > -1) {
      this.content.step1Selected = false;
      this.content.step2Selected = true;
      this.content.step3Selected = false;
      this.content.line1Class = this.content.classPast;
      this.content.line2Class = this.content.classProgress;
    }

    if (this.values.step3Routes.indexOf(route) > -1) {
      this.content.step1Selected = false;
      this.content.step2Selected = false;
      this.content.step3Selected = true;
      this.content.line1Class = this.content.classPast;
      this.content.line2Class = this.content.classPast;
    }
  }

  setStepperVisibility (route: string): void {
    // use split on the routes because we dont care about the route params being passed in;
    const hideStepperRoutes = [
      config.routes.schoolSelect,
      config.routes.schoolWelcome,
      config.routes.schoolWithFiceCode.split('/')[0],
      config.routes.messageWithReason.split('/')[0]
    ];

    if (this.route) {
      this.show.stepper = hideStepperRoutes.indexOf(this.route.split('/')[0]) === -1;
    }
  }
}
