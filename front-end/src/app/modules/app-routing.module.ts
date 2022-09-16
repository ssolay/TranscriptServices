import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { config } from '../config/config';
import { MessageComponent } from '../routes/message/message.component';
import { OrderConfirmationComponent } from '../routes/order-confirmation/order-confirmation.component';
import { OrderConsentComponent } from '../routes/order-consent/order-consent.component';
import { OrderPaymentComponent } from '../routes/order-payment/order-payment.component';
import { OrderReviewComponent } from '../routes/order-review/order-review.component';
import { RecipientAddressComponent } from '../routes/recipient-address/recipient-address.component';
import { RecipientDeliveryMethodComponent } from '../routes/recipient-delivery-method/recipient-delivery-method.component';
import { RecipientEmailComponent } from '../routes/recipient-email/recipient-email.component';
import { RecipientSelectComponent } from '../routes/recipient-select/recipient-select.component';
import { RequestorAddressComponent } from '../routes/requestor-address/requestor-address.component';
import { RequestorAttendComponent } from '../routes/requestor-attend/requestor-attend.component';
import { RequestorIdentificationComponent } from '../routes/requestor-identification/requestor-identification.component';
import { SchoolRedirectComponent } from '../routes/school-redirect/school-redirect.component';
import { SchoolSelectComponent } from '../routes/school-select/school-select.component';
import { SchoolWelcomeComponent } from '../routes/school-welcome/school-welcome.component';
import { SecurityService } from '../services/security/security.service';


const routes: Routes = [
  {
    path: config.routes.messageWithReason,
    component: MessageComponent
  },
  {
    path: config.routes.orderReview,
    component: OrderReviewComponent,
    canActivate: [SecurityService],
    canDeactivate: [SecurityService]
  },
  {
    path: config.routes.orderConfirmation,
    component: OrderConfirmationComponent,
    canActivate: [SecurityService]
  },
  {
    path: config.routes.orderConsent,
    component: OrderConsentComponent,
    canActivate: [SecurityService],
    canDeactivate: [SecurityService]
  },
  {
    path: config.routes.orderPayment,
    component: OrderPaymentComponent,
    canActivate: [SecurityService],
    canDeactivate: [SecurityService]
  },
  {
    path: config.routes.recipientSelect,
    component: RecipientSelectComponent,
    canActivate: [SecurityService],
    canDeactivate: [SecurityService]
  },
  {
    path: config.routes.recipientDeliveryMethod,
    component: RecipientDeliveryMethodComponent,
    canActivate: [SecurityService],
    canDeactivate: [SecurityService]
  },
  {
    path: config.routes.recipientAddress,
    component: RecipientAddressComponent,
    canActivate: [SecurityService],
    canDeactivate: [SecurityService]
  },
  {
    path: config.routes.recipientEmail,
    component: RecipientEmailComponent,
    canActivate: [SecurityService],
    canDeactivate: [SecurityService]
  },
  {
    path: config.routes.requestorAddress,
    component: RequestorAddressComponent,
    canActivate: [SecurityService],
    canDeactivate: [SecurityService]
  },
  {
    path: config.routes.requestorAttend,
    component: RequestorAttendComponent,
    canActivate: [SecurityService],
    canDeactivate: [SecurityService]
  },
  {
    path: config.routes.requestorIdentification,
    component: RequestorIdentificationComponent,
    canActivate: [SecurityService],
    canDeactivate: [SecurityService]
  },
  {
    path: config.routes.schoolWithFiceCode,
    component: SchoolRedirectComponent
  },
  {
    path: config.routes.schoolSelect,
    component: SchoolSelectComponent
  },
  {
    path: config.routes.schoolWelcome,
    component: SchoolWelcomeComponent,
    canActivate: [SecurityService]
  },
  {
    path: '',
    redirectTo: config.routes.schoolSelect,
    pathMatch: 'full',
  },
  {
    path: '**',
    redirectTo: config.routes.schoolSelect,
    pathMatch: 'full',
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {}
