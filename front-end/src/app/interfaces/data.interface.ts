import { ApiResponseSchoolProfile } from './api-response-school-profile.interface';
import { ApiResponseOrder } from './api-response-order.interface';
import { ApiResponseRecipientProfile } from './api-response-recipient-profile.interface';

export interface Data {
  schoolProfile: ApiResponseSchoolProfile;
  response: ApiResponseOrder;
  form: {
    consent: {
      date: string;
      signature: {
        lines: any
      };
    };
    payment: {
      addressLine1: string;
      addressLine2: string;
      ccAmount: string;
      ccType: string;
      city: string;
      country: string;
      creditCardNumber: string;
      expirationMonth: string;
      expirationYear: string;
      name: string;
      payeezyToken: string;
      securityCode: string;
      state: string;
      useContactInfo: string;
      zip: string;
    };
    recipient: DataRecipient;
    recipients: DataRecipient[];
    requestor: {
      attend: {
        degree1: string;
        degree2: string;
        degree3: string;
        degree4: string;
        programs: DataProgram[];
        year1: string;
        year2: string;
        year3: string;
        year4: string;
      };
      contact: {
        addressLine1: string;
        addressLine2: string;
        city: string;
        country: string;
        emailConfirm: string;
        emailPrimary: string;
        phone: string;
        state: string;
        textUpdates: string;
        updateRecords: string;
        zip: string;
      };
      personal: {
        dob: string;
        enrolledBefore: string;
        enrolledCurrently: string;
        enrolledYearFrom: string;
        enrolledYearTo: string;
        nameChanged: string;
        nameChangedFirst: string;
        nameChangedLast: string;
        nameChangedMiddle: string;
        nameFirst: string;
        nameLast: string;
        nameMiddle: string;
        path: string;
        ssnConfirm: string;
        ssnPrimary: string;
        studentIdConfirm: string;
        studentIdPrimary: string;
      };
    };
  };
}

export interface DataProgram {
  program: boolean;
  yearFrom?: string;
  yearTo?: string;
}

export interface DataRecipient {
  index?: number;
  totalFee?: number;
  address: {
    addressLine1: string;
    addressLine2: string;
    attention: string;
    city: string;
    country: string;
    emailConfirm: string;
    emailPrimary: string;
    phone: string;
    recipient: string;
    state: string;
    zip: string;
  };
  delivery: {
    acceptTerms: string;
    course1: string;
    course2: string;
    degreeTitle: string;
    deliveryMethod: number;
    howMany: number;
    processingMethod: string;
    specialInstructions: string;
    term: string;
    transcriptWhen: string;
    transcriptPurpose: number;
    transcriptType: number;
    year: string;
  };
  who: {
    aamcAccountNumber: string;
    amcasTranscriptIdNumber: string;
    business: string;
    casId: string;
    country: string;
    department: number;
    departmentNotInList: string;
    lsacAccountNumber: string;
    organization: string;
    organizationNotInList: string;
    recipientFiceCode: string;
    recipientResponse: ApiResponseRecipientProfile;
    recipientType: string;
    school: string;
    schoolNotInList: string;
    state: string;
  };
}
