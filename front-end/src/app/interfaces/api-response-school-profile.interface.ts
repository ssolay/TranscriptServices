export interface ApiResponseSchoolProfile {
  addDynamicWatermark: string;
  addPrintTemplate: string;
  addWatermark: string;
  allowCampusTracking: string;
  allowDocUpload: string;
  allowEtxOverride?: string;
  allowFeeReduct: string;
  allowFormatEtx: string;
  allowMultiSchAccess: string;
  allowPrintCustomFee: string;
  allowStaticDocUpload: string;
  askCertColleges: string;
  askCertSuboption: string;
  askConfirmStId: string;
  askCurrEnrolled: string;
  askDegrees: string;
  askEnrollYears: string;
  askFirstXcript: string;
  askSchools: string;
  askSchoolsYears: string;
  askSpecialInstr: string;
  askSsn: string;
  askStamped: string;
  askStudentId: string;
  askTermYear: string;
  askUpdateScRec: string;
  askXcriptPurpose: string;
  askXcriptType: string;
  attendSchoolLabels: string[];
  baseOpFee?: number;
  certOptions: string;
  chargeResend?: string;
  city: string;
  consentPSelf: string;
  consentPThird: string;
  consentSSelf: string;
  consentSThird: string;
  cronExpression?: string;
  dateEdited: string;
  deliveryServiceOnly: string;
  deptProcessingOptionInfos: any[];
  digitalSignatureFee: number;
  displaySendToSchoolOption: string;
  docBaseOpFee: number;
  docNetFee: number;
  docShowFeeRpt: string;
  docTotalFee: number;
  docUploadFormats?: string;
  docUploadLimit: number;
  electronicDeliveryEligibilityQuestion?: string;
  electronicDeliveryFeePaidBy: string;
  feePathDesc?: string;
  feePathTypePub: string;
  feePathTypeSss: string;
  ficeCode: string;
  freeOptions: SchoolProfilePathOptions;
  handleFeePaidBy: string;
  hasCertificate: string;
  hideOpFee: string;
  holdForPickup: string;
  inclDocForDeliv: string;
  inFileFormat: string;
  integrationProvider?: string;
  inXmitMethod: string;
  maxNumberViews: number;
  multipleStatusEmailFooter?: string;
  multipleStatusEmailHeader?: string;
  networkInfos: {
    exchangeNetworkTypeCode: string;
    ficeCode: string;
    networkCode?: string;
    priorityLevel: number;
    status: string;
    supportedFileTypes: string;
    toScprofilId: number;
    toScprofilNetworkInfoId: number;
  }[];
  newOrderAlert: string;
  offerDigitalRightsOption: string;
  offerDocumentFee: string;
  offerFax: string;
  offerFaxF: string;
  offerPdfDelivery: string;
  offerPickup: string;
  offerPickupF: string;
  offerPublicaccess: string;
  offerSelectschool: string;
  orderProcessFeePaidBySchool: string;
  outAcceptAttachments: string;
  outDataExchange: string;
  outFileFormat: string;
  outJobAlert: number;
  outJobGroup: string;
  outJobName: string;
  outMapVersion: string;
  outXmitMethod: string;
  overnightCarrier: string;
  paperlessConsentForm: string;
  payOptions: SchoolProfilePathOptions;
  pdfDeliveryFee: number;
  pdfDeliveryProfiles: any[];
  pdfDeliverySubtype: string;
  printOption: number;
  printVendorDeliveryFeePaidBy: string;
  proceedWithHoldAllowed: string;
  processingOptions: SchoolProfileProcessingOption[];
  profileType: string;
  qtyExpression: string;
  qtyExpressionF?: string;
  rightsManagementFee: number;
  scCampus: any[];
  schlName: string;
  scOrderStatuses: any[];
  scprofilToken: number;
  showDataFilter: string;
  sssPathPlaceOrderOnly?: string;
  sssReleaseForm: string;
  state: string;
  status: string;
  stdtPopulation: number;
  stIdMaxLimit?: number;
  studentIdLabel?: string;
  toSchoolHeader?: {
    alternateText: string;
    bgColor: string;
    contentType: string;
    headerStyle: string;
    imgHeight: string;
    imgWidth: string;
    logoBase64: string;
    subHeaderStyle: string;
  };
  toSchoolNotes: {
    notes: string;
    notesType: string;
    scpfNotesId: number;
    status: string;
    toScprofilId: number;
  }[];
  toScprofilDynmicIntgrtn: any[];
  toScprofilId: number;
  transcriptPurposes: SchoolProfileTranscriptPurpose[];
  visibleDigitalSignature: string;
  xmitMailbox: string;
}

export interface SchoolProfilePathOptions {
  deliveryMethods: SchoolProfileDeliveryMethod[];
  quantities: SchoolProfileQuantity[];
  transcriptTypes: SchoolProfileTranscriptType[];
}

export interface SchoolProfileDeliveryMethod {
  deliveryMethodCategory: string;
  deliveryMethodId: number;
  deliveryMethodType: string;
  display: string;
  displayWithFee: string;
  fee: number;
  feePathType: string;
  handleFee: number;
  helpText: string;
  isPrint: string;
  printVendorFee: number;
  requestorFee: number;
  status: string;
  toScprofilId: number;
  xmitCodeId: number;
}

export interface SchoolProfileQuantity {
  displayWithFee: string;
  fee: number;
  feePathType: string;
  quantity: number;
  quantityId: number;
  status: string;
  toScprofilId: number;
}

export interface SchoolProfileTranscriptType {
  display: string;
  displayWithFee: string;
  fee: number;
  feePathType: string;
  status: string;
  toScprofilId: number;
  xcriptTypeId: number;
  xmitCodeId: number;
}

export interface SchoolProfileProcessingOption {
  code: string;
  description: string;
  processingOptionId: number;
  status: string;
  toScprofilId: number;
}

export interface SchoolProfileTranscriptPurpose {
  display: string;
  status: string;
  toScprofilId: number;
  xcriptPurposeId: number;
  xmitCodeId: number;
}
