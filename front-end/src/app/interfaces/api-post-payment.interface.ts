export interface ApiPostPayment {
  billCity: string;
  billCountry: string;
  billPhone: string;
  billState: string;
  billStreet1: string;
  billStreet2: string;
  billZip: string;
  ccAmount: number;
  ccExpiryMonth: string;
  ccExpiryYear: string;
  ccName: string;
  ccType: string;
  payeezyToken: string;
  paymentId?: number;
}
