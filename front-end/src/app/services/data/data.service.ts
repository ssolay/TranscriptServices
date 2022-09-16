import {
  cloneDeep as _cloneDeep,
  filter as _filter,
  get as _get,
  trim as _trim
} from 'lodash';
import { EventEmitter, Injectable } from '@angular/core';

import { config } from '../../config/config';
import { Data } from '../../interfaces/data.interface';
import {
  SchoolProfilePathOptions,
  SchoolProfileProcessingOption,
  SchoolProfileDeliveryMethod,
  SchoolProfileTranscriptType,
  SchoolProfileQuantity
} from '../../interfaces/api-response-school-profile.interface';


@Injectable() export class DataService {
  // emitter to let other components know when a recipient has been added to the data.form.recipients object;
  // lets the header know so it can update the shopping cart;
  recipientsUpdated = new EventEmitter();

  dataEmpty: Data;

  data: Data = {
    // school profile data obj;
    schoolProfile: null,

    // POST response data that drive application configuration/data;
    // only track the latest response;
    // not all POST responses matter, but if they do, they override the previous response;
    response: null,

    // user entered form data;
    form: {
      // information about the person making the transcript request;
      requestor: {
        // Personal Information;
        personal: {
          dob: null,
          enrolledBefore: null,
          enrolledCurrently: null,
          enrolledYearFrom: null,
          enrolledYearTo: null,
          nameChanged: null,
          nameChangedFirst: null,
          nameChangedLast: null,
          nameChangedMiddle: null,
          nameFirst: null,
          nameLast: null,
          nameMiddle: null,
          path: null,
          ssnConfirm: null,
          ssnPrimary: null,
          studentIdConfirm: null,
          studentIdPrimary: null
        },

        // Contact Information;
        contact: {
          addressLine1: null,
          addressLine2: null,
          city: null,
          country: config.values.country.us,
          emailConfirm: null,
          emailPrimary: null,
          phone: null,
          state: null,
          textUpdates: null,
          updateRecords: config.values.no,
          zip: null
        },

        // School Information;
        attend: {
          degree1: null,
          degree2: null,
          degree3: null,
          degree4: null,
          programs: null,
          year1: null,
          year2: null,
          year3: null,
          year4: null
        }
      },

      // information about who will recieve the transcript;
      recipient: {
        index: null,
        totalFee: null,

        // recipient route;
        who: {
          aamcAccountNumber: null,
          amcasTranscriptIdNumber: null,
          business: null,
          casId: null,
          country: config.values.country.us,
          department: null,
          departmentNotInList: null,
          lsacAccountNumber: null,
          organization: null,
          organizationNotInList: null,
          recipientFiceCode: null,
          recipientResponse: null,
          recipientType: null,
          school: null,
          schoolNotInList: null,
          state: null
        },

        // delivery-method route;
        delivery: {
          acceptTerms: null,
          course1: null,
          course2: null,
          degreeTitle: null,
          deliveryMethod: null,
          howMany: null,
          processingMethod: null,
          specialInstructions: null,
          term: null,
          transcriptWhen: null,
          transcriptPurpose: null,
          transcriptType: null,
          year: null
        },

        // recipient-address & recipient-address-electronic routes;
        address: {
          addressLine1: null,
          addressLine2: null,
          attention: null,
          city: null,
          country: config.values.country.us,
          emailConfirm: null,
          emailPrimary: null,
          phone: null,
          recipient: null,
          state: null,
          zip: null
        }
      },

      // all recipients for the order;
      recipients: [],

      // consent form route;
      consent: {
        date: null,
        signature: null
      },

      // payment route;
      payment: {
        addressLine1: null,
        addressLine2: null,
        ccAmount: null,
        ccType: null,
        city: null,
        country: null,
        creditCardNumber: null,
        expirationMonth: null,
        expirationYear: null,
        name: null,
        payeezyToken: null,
        securityCode: null,
        state: null,
        useContactInfo: config.values.no,
        zip: null
      }
    }
  };

  constructor () {
    this.dataEmpty = _cloneDeep(this.data);
  }

  transformContent (content) {
    const addressKeys = [
      'recipient',
      'attention',
      'addressLine1',
      'addressLine2',
      'city'
    ];

    // trim all string values;
    // and convert to uppercase;
    Object.keys(content).forEach((key, index) => {
      if (typeof content[key] === 'string') {
        content[key] = _trim(content[key].toUpperCase());

        // for address fields we need to remove the pipe character;
        if (addressKeys.indexOf(key) > -1) {
          content[key] = content[key].replace(/\|/gi, '');
        }
      }
    });

    return content;
  }

  save (newContentObject, dataProperty?): void {
    const assignTarget = dataProperty ? _get(this.data, dataProperty) : this.data;
    Object.assign(assignTarget, this.transformContent(newContentObject));

    console.log(_cloneDeep(this.data));
  }

  saveRecipient (): void {
    const recipient = _cloneDeep(this.data.form.recipient);
    const index = this.data.form.recipient.index;
    const recipients = this.data.form.recipients;

    // if in edit mode, replace the old recipient with the new recipient;
    // and reset the edit index because we're no longer editing a recipient;
    if (index !== null) {
      recipients[index] = recipient;

    // otherwise save the new recipient;
    } else {
      recipients.push(recipient);
    }

    // update the shopping cart count;
    this.emitRecipientCount();

    // reset the recipient since we're done with it;
    this.resetRecipient();

    console.log(_cloneDeep(this.data));
  }

  resetDataObject (): void {
    this.data = _cloneDeep(this.dataEmpty);
  }

  resetUserData (): void {
    this.data.form = _cloneDeep(this.dataEmpty.form);
    this.data.response = _cloneDeep(this.dataEmpty.response);
  }

  resetRequestorAddress (): void {
    this.data.form.requestor.contact = _cloneDeep(this.dataEmpty.form.requestor.contact);
  }

  resetRequestorAttend (): void {
    this.data.form.requestor.attend = _cloneDeep(this.dataEmpty.form.requestor.attend);
  }

  resetRequestorIdentification (): void {
    this.data.form.requestor.personal = _cloneDeep(this.dataEmpty.form.requestor.personal);
  }

  resetRecipientAddress (): void {
    this.data.form.recipient.address = _cloneDeep(this.dataEmpty.form.recipient.address);
  }

  resetRecipientDeliveryMethod (): void {
    this.data.form.recipient.delivery = _cloneDeep(this.dataEmpty.form.recipient.delivery);
  }

  resetRecipientEmail (): void {
    this.data.form.recipient.address = _cloneDeep(this.dataEmpty.form.recipient.address);
  }

  resetRecipientSelect (): void {
    this.data.form.recipient.who = _cloneDeep(this.dataEmpty.form.recipient.who);
  }

  // preserveIndex is for when a recipient is in edit mode, but changed;
  // without preserveIndex, then the app would act like a new recipient is being generated, and not replace the one being edited;
  resetRecipient (preserveIndex = false): void {
    const index = preserveIndex ? this.data.form.recipient.index : null;
    this.data.form.recipient = _cloneDeep(this.dataEmpty.form.recipient);

    if (index !== null) {
      this.data.form.recipient.index = index;
    }
  }

  resetOrderConsent (): void {
    this.data.form.consent = _cloneDeep(this.dataEmpty.form.consent);
  }

  resetOrderPayment (): void {
    this.data.form.payment = _cloneDeep(this.dataEmpty.form.payment);
  }

  editRecipient (index: number): void {
    this.data.form.recipient = _cloneDeep(this.data.form.recipients[index]);

    // record the index so when done editing, we can replace the value;
    this.data.form.recipient.index = index;

    console.log(_cloneDeep(this.data));
  }

  deleteRecipient (index: number): void {
    this.data.form.recipients.splice(index, 1);
    this.emitRecipientCount();

    console.log(_cloneDeep(this.data));
  }

  emitRecipientCount (): void {
    this.recipientsUpdated.emit(this.data.form.recipients.length);
  }

  get () {
    // return a read only clone so a controller can't manipulate the data directly;
    return _cloneDeep(this.data);
  }

  getFullName (): string {
    const response = this.data.response.student;

    return `${ response.firstName } ${ response.middleName || '' } ${ response.lastName }`.replace('  ', ' ');
  }

  getRecipient (index: number = null): string {
    // index is defined when we want to get the recipient name for a recipient in the recipients[] array;
    // if index isn't defined, then we're dealing with the active recipient;
    const who = index !== null
      ? this.data.form.recipients[index].who
      : this.data.form.recipient.who;
    const isCollege = who.recipientType === config.values.recipientType.college;
    const isCollegeNotInList = who.school === config.values.autocomplete.notInList.name.toUpperCase();
    const collegeValue = isCollegeNotInList ? who.schoolNotInList : who.school;

    const isOrganization = who.recipientType === config.values.recipientType.organization;
    const isOrganizationNotInList = who.organization === config.values.autocomplete.notInList.name.toUpperCase();
    const organizationValue = isOrganizationNotInList ? who.organizationNotInList : who.organization;

    const isBusiness = who.recipientType === config.values.recipientType.business;
    const businessValue = who.business;

    // return either the college name, or the users name;
    return isCollege
      ? collegeValue
      : isOrganization
        ? organizationValue
        : isBusiness
          ? businessValue
          : this.getFullName();
  }

  getTotalFees (): number {
    let totalFee = 0;

    this.data.form.recipients.forEach(recipient => {
      totalFee += recipient.totalFee;
    });

    return totalFee;
  }

  getOnlineProcessingFeeVisibility (): boolean {
    return !(this.data.schoolProfile.hideOpFee === 'N' && this.isFeePathTypeP());
  }

  getFeePathType (): SchoolProfilePathOptions {
    return this.isFeePathTypeP()
      ? this.data.schoolProfile.payOptions
      : this.data.schoolProfile.freeOptions;
  }

  getProcessingOptionObject (code): SchoolProfileProcessingOption {
    return _filter(this.data.schoolProfile.processingOptions, { code: code })[0];
  }

  getDeliveryMethodObject (id): SchoolProfileDeliveryMethod {
    return _filter(this.getFeePathType().deliveryMethods, { deliveryMethodId: id })[0];
  }

  getTranscriptTypeObject (id): SchoolProfileTranscriptType {
    return _filter(this.getFeePathType().transcriptTypes, { xcriptTypeId: id })[0];
  }

  getQuantityObject (id): SchoolProfileQuantity {
    return _filter(this.getFeePathType().quantities, { quantityId: id })[0];
  }

  getNote (notesType: string): string {
    const notesArray = _filter(this.data.schoolProfile.toSchoolNotes, { notesType: notesType });

    return notesArray.length
      ? notesArray[0].notes
      : null;
  }

  showDegreeQuestions (): boolean {
    return this.data.schoolProfile.askDegrees === 'O';
  }

  showProgramQuestions (): boolean {
    const showQuestions = ['O', 'R'].indexOf(this.data.schoolProfile.askSchools) > -1;
    const haveQuestions = this.data.schoolProfile.attendSchoolLabels.length > 0;

    // only show the questions, if there we are suppose to, and there are questions to ask;
    return showQuestions && haveQuestions;
  }

  isFeePathTypeF (): boolean {
    return this.data.response.orderHeader.feePathType === 'F';
  }

  isFeePathTypeP (): boolean {
    return this.data.response.orderHeader.feePathType === 'P';
  }

  // used in the security route checks;
  // if these return true (different routes have different checks), then the route won't be loaded;
  isSchoolNull (): boolean {
    return this.data.schoolProfile === null;
  }

  isRecipientNull (): boolean {
    return this.data.form.recipient.who.recipientType === null;
  }

  isRecipientsEmpty (): boolean {
    return this.data.form.recipients.length === 0;
  }
}
