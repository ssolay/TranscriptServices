export interface SelectOption {
  category?: string; // used in optgroup creation;
  name: string;
  value: any; // should be string | number;

  // used in recipients;
  ficeCode?: string;
  orgType?: string;
  sourceType?: string;
}
