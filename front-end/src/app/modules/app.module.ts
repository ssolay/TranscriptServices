import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BrowserModule } from '@angular/platform-browser';
import { filter, first } from 'rxjs/operators';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { Location } from '@angular/common';
import {
  MatButtonModule,
  MatButtonToggleModule,
  MatCardModule,
  MatCheckboxModule,
  MatChipsModule,
  MatDatepickerModule,
  MatDialogModule,
  MatExpansionModule,
  MatFormFieldModule,
  MatGridListModule,
  MatIconModule,
  MatInputModule,
  MatListModule,
  MatMenuModule,
  MatNativeDateModule,
  MatPaginatorModule,
  MatProgressSpinnerModule,
  MatRadioButton,
  MatRadioModule,
  MatRippleModule,
  MatSelectModule,
  MatSidenavModule,
  MatSliderModule,
  MatSlideToggleModule,
  MatSnackBarModule,
  MatSortModule,
  MatTableModule,
  MatTabsModule,
  MatToolbarModule,
  MatTooltipModule,
  MatStepperModule
} from '@angular/material';
import { NgModule } from '@angular/core';
import { NavigationCancel, NavigationEnd, Router } from '@angular/router';
import { TextMaskModule } from 'angular2-text-mask';

// classes;
import { CheckApiResponse } from '../classes/check-api-response';
import { ConvertDeliveryMethod } from '../classes/convert-delivery-method';
import { ManageFields } from '../classes/manage-fields';
import { ValidationMessage } from '../classes/validation-message';
import { WebAimContrastChecker } from '../classes/web-aim-contrast-checker';

// directives:
import { FileUploadModule } from 'ng2-file-upload';

// components;
import { AppRootComponent } from '../components/app-root/app-root.component';
import { AppFooterComponent } from '../components/app-footer/app-footer.component';
import { AppHeaderComponent } from '../components/app-header/app-header.component';
import { BlockingIndicatorComponent } from '../components/blocking-indicator/blocking-indicator.component';
import { CardComponent } from '../components/card/card.component';
import { CardTitleComponent } from '../components/card-title/card-title.component';
import { CardContentComponent } from '../components/card-content/card-content.component';
import { CartItemComponent } from '../components/cart-item/cart-item.component';
import { DialogHelpComponent } from '../components/dialog-help/dialog-help.component';
import { DialogTimeoutComponent } from '../components/dialog-timeout/dialog-timeout.component';
import { FormFieldFilesComponent } from '../components/form-field-files/form-field-files.component';
import { FormFieldSelectComponent } from '../components/form-field-select/form-field-select.component';
import { FormFieldToggleComponent } from '../components/form-field-toggle/form-field-toggle.component';
import { FormFieldInputComponent } from '../components/form-field-input/form-field-input.component';
import { FormFieldConfirmComponent } from '../components/form-field-confirm/form-field-confirm.component';
import { FormFieldSelectOptgroupComponent } from '../components/form-field-select-optgroup/form-field-select-optgroup.component';
import { FormFieldAutocompleteComponent } from '../components/form-field-autocomplete/form-field-autocomplete.component';
import { PageTitleComponent } from '../components/page-title/page-title.component';
import { ScrollToTopComponent } from '../components/scroll-to-top/scroll-to-top.component';
import { SpacerComponent } from '../components/spacer/spacer.component';
import { StepperComponent } from '../components/stepper/stepper.component';

// modules;
import { AppRoutingModule } from './app-routing.module';
import { OverlayModule } from '@angular/cdk/overlay';

// routes & route specific components;
import { MessageComponent } from '../routes/message/message.component';
import { OrderConfirmationComponent } from '../routes/order-confirmation/order-confirmation.component';
import { OrderConsentComponent } from '../routes/order-consent/order-consent.component';
import { OrderPaymentComponent } from '../routes/order-payment/order-payment.component';
import { OrderReviewComponent } from '../routes/order-review/order-review.component';
import { RecipientAddressComponent } from '../routes/recipient-address/recipient-address.component';
import { RecipientDeliveryMethodComponent } from '../routes/recipient-delivery-method/recipient-delivery-method.component';
import { RecipientDeliveryMethodFeesComponent } from '../routes/recipient-delivery-method/recipient-delivery-method-fees/recipient-delivery-method-fees.component';
import { RecipientEmailComponent } from '../routes/recipient-email/recipient-email.component';
import { RecipientSelectCollegeComponent } from '../routes/recipient-select/recipient-select-college/recipient-select-college.component';
import { RecipientSelectComponent } from '../routes/recipient-select/recipient-select.component';
import { RecipientSelectDepartmentComponent } from '../routes/recipient-select/recipient-select-department/recipient-select-department.component';
import { RecipientSelectOrganizationComponent } from '../routes/recipient-select/recipient-select-organization/recipient-select-organization.component';
import { RequestorAddressComponent } from '../routes/requestor-address/requestor-address.component';
import { RequestorAttendComponent } from '../routes/requestor-attend/requestor-attend.component';
import { RequestorIdentificationComponent } from '../routes/requestor-identification/requestor-identification.component';
import { SchoolRedirectComponent } from '../routes/school-redirect/school-redirect.component';
import { SchoolSelectComponent } from '../routes/school-select/school-select.component';
import { SchoolWelcomeComponent } from '../routes/school-welcome/school-welcome.component';

// services;
import { CountriesService } from '../services/countries/countries.service';
import { DataService } from '../services/data/data.service';
import { OrganizationsService } from '../services/organizations/organizations.service';
import { PostService } from '../services/post/post.service';
import { BlockingIndicatorService } from '../services/blocking-indicator/blocking-indicator.service';
import { RecipientService } from '../services/recipient/recipient.service';
import { RecipientTypesService } from '../services/recipient-types/recipient-types.service';
import { SchoolsByStateService } from '../services/schools-by-state/schools-by-state.service';
import { SchoolService } from '../services/school/school.service';
import { SchoolsService } from '../services/schools/schools.service';
import { SecurityService } from '../services/security/security.service';
import { StatesService } from '../services/states/states.service';
import { SystemMessagesService } from '../services/system-messages/system-messages.service';
import { TimeoutService } from '../services/timeout/timeout.service';

@NgModule({
  declarations: [
    AppFooterComponent,
    AppHeaderComponent,
    AppRootComponent,
    BlockingIndicatorComponent,
    CardComponent,
    CardContentComponent,
    CardTitleComponent,
    CartItemComponent,
    DialogHelpComponent,
    DialogTimeoutComponent,
    FormFieldAutocompleteComponent,
    FormFieldConfirmComponent,
    FormFieldFilesComponent,
    FormFieldInputComponent,
    FormFieldSelectComponent,
    FormFieldSelectOptgroupComponent,
    FormFieldToggleComponent,
    MessageComponent,
    OrderConfirmationComponent,
    OrderConsentComponent,
    OrderPaymentComponent,
    OrderReviewComponent,
    PageTitleComponent,
    RecipientAddressComponent,
    RecipientDeliveryMethodComponent,
    RecipientDeliveryMethodFeesComponent,
    RecipientEmailComponent,
    RecipientSelectCollegeComponent,
    RecipientSelectComponent,
    RecipientSelectDepartmentComponent,
    RecipientSelectOrganizationComponent,
    RequestorAddressComponent,
    RequestorAttendComponent,
    RequestorIdentificationComponent,
    SchoolRedirectComponent,
    SchoolSelectComponent,
    SchoolWelcomeComponent,
    ScrollToTopComponent,
    SpacerComponent,
    StepperComponent
  ],
  entryComponents: [
    BlockingIndicatorComponent,
    DialogHelpComponent,
    DialogTimeoutComponent
  ],
  imports: [
    AppRoutingModule,
    BrowserAnimationsModule,
    BrowserModule,
    FileUploadModule,
    FormsModule,
    HttpClientModule,
    MatButtonModule,
    MatButtonToggleModule,
    MatCardModule,
    MatCheckboxModule,
    MatDatepickerModule,
    MatDialogModule,
    MatFormFieldModule,
    MatIconModule,
    MatInputModule,
    MatNativeDateModule,
    MatRadioModule,
    MatSelectModule,
    MatSlideToggleModule,
    MatTableModule,
    ReactiveFormsModule,
    TextMaskModule
  ],
  providers: [
    CheckApiResponse,
    ConvertDeliveryMethod,
    CountriesService,
    DataService,
    ManageFields,
    OrganizationsService,
    PostService,
    RecipientService,
    RecipientTypesService,
    SchoolsByStateService,
    SchoolService,
    SchoolsService,
    SecurityService,
    StatesService,
    SystemMessagesService,
    TimeoutService,
    ValidationMessage,
    WebAimContrastChecker
  ],
  bootstrap: [
    AppRootComponent
  ]
})

export class AppModule {
  constructor (
    private location: Location,
    private blockingIndicatorService: BlockingIndicatorService,
    private router: Router,
    private securityService: SecurityService
  ) {
    this.initRouteListener();
    this.initLocationListener();
  }

  initRouteListener (): void {
    // set up a listener for route changes so we can consolidate code that needs to execute on every route change;
    this.router.events
      .pipe(
        filter(event => event instanceof NavigationCancel || event instanceof NavigationEnd)
      )
      .subscribe(val => {
        // hide the progress bar now that the new route has been loaded;
        // this way each route component doesn't have to set the prop to `false` after route change;
        this.blockingIndicatorService.close();

        // enable the `showDeactivateWarning` prop;
        // because before each route change (except the back button) the prop is set to `false` so the user isn't warned;
        // this way each route component doesn't have to set the prop to `true` on init;
        this.securityService.setDeactivateWarning(true);
      });
  }

  initLocationListener (): void {
    // cf. https://github.com/angular/angular/pull/13922
    // fix for broken history management in canDeactivate;
    // if a user cancels a route change, there is a bug that still changes the browser history;
    // this code listens for a canceled route change, and moves the history forward if that happens (back to where the user is currently);
    // without this fix, the user can hit back, cancel, hit back, accept, and go back two pages instead of one;
    this.location
      .subscribe(locationEvent => {
        this.router.events
          .pipe(
            filter(event => event instanceof NavigationCancel || event instanceof NavigationEnd),
            first(),
            filter(event => event instanceof NavigationCancel),
            filter((event: NavigationCancel) => event.url === locationEvent.url)
          )
          .subscribe(cancelEvent => {
            this.location.replaceState(cancelEvent.url);
            this.location.forward();
          });
      });
  }
}
