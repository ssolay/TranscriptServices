export const configRoutes = {
  schoolWithFiceCode: 'school/redirect/:ficeCode',
  schoolSelect: 'school/select',
  schoolWelcome: 'school/welcome',

  requestorIdentification: 'requestor/identification',
  requestorAddress: 'requestor/address',
  requestorAttend: 'requestor/attend',

  recipientSelect: 'recipient/select',
  recipientDeliveryMethod: 'recipient/delivery-method',
  recipientAddress: 'recipient/address',
  recipientEmail: 'recipient/email',

  orderReview: 'order/review',
  orderConsent: 'order/consent',
  orderPayment: 'order/payment',
  orderConfirmation: 'order/confirmation',

  messageWithReason: 'message/reason/:reason',
  messageComplete: 'message/reason/complete',
  messageError: 'message/reason/error',
  messageTimeout: 'message/reason/timeout',

  // pass in router.navigate(commands, extras) calls when we want to NOT add history to the browser;
  extras: { replaceUrl: true }
};
