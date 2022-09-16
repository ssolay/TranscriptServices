import { Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges } from '@angular/core';

import { DataService } from '../../../services/data/data.service';


@Component({
  selector: 'nsc-recipient-delivery-method-fees',
  templateUrl: './recipient-delivery-method-fees.component.html',
  styleUrls: ['./recipient-delivery-method-fees.component.scss']
})
export class RecipientDeliveryMethodFeesComponent implements OnChanges, OnInit {
  @Input() deliveryMethod: number;
  @Input() quantity: number;
  @Input() transcriptType: number;

  @Output() totalFeesUpdated = new EventEmitter();

  data = this.dataService.get();

  content = {
    deliveryMethodFee: 0,
    deliveryMethodLabel: null,
    onlineProcessingFee: 0,
    quantityFee: 0,
    shippingHandlingFee: 0,
    totalFees: 0,
    transcriptTypeFee: 0
  };

  values = {
    deliveryMethod: null,
    orderProcessFeePaidBySchool: this.data.schoolProfile.orderProcessFeePaidBySchool,
    quantity: null,
    transcriptType: null
  };

  constructor (private dataService: DataService) {}

  ngOnInit () {
    this.setValueObjects();
    this.setFeeValues();
  }

  ngOnChanges (changes: SimpleChanges) {
    this.setValueObjects();
    this.setFeeValues();
  }

  getHandlingFee (): number {
    // define the boolean values used to determine if the handling fee should be shown;
    const handleFeePaidByIsValid = this.data.schoolProfile.handleFeePaidBy === 'R';
    const orderProcessFeePaidBySchoolIsValid = this.values.orderProcessFeePaidBySchool === 'N';

    // if any of the conditions are true, then return a handling fee, otherwise zero (which will hide the fee);
    return handleFeePaidByIsValid && orderProcessFeePaidBySchoolIsValid && this.dataService.isFeePathTypeF()
      ? this.values.deliveryMethod.handleFee
      : 0;
  }

  setValueObjects (): void {
    // take the ids passed into this component, and get the full object data from the school profile;
    // this way we can pull labels and fees out of the school profile;
    this.values.deliveryMethod = this.dataService.getDeliveryMethodObject(this.deliveryMethod);
    this.values.quantity = this.dataService.getQuantityObject(this.quantity);
    this.values.transcriptType = this.dataService.getTranscriptTypeObject(this.transcriptType);
  }

  setFeeValues (): void {
    // reset all the fees;
    this.content.quantityFee = 0;
    this.content.deliveryMethodFee = 0;
    this.content.transcriptTypeFee = 0;
    this.content.shippingHandlingFee = 0;
    this.content.onlineProcessingFee = 0;

    // set the quantity fee if a quantity has been selected;
    if (this.values.quantity) {
      this.content.quantityFee = this.values.quantity.fee;
    }

    // set the delivery method fee if a delivery method has been selected;
    if (this.values.deliveryMethod) {
      this.content.deliveryMethodFee = this.values.deliveryMethod.fee;
      this.content.deliveryMethodLabel = this.values.deliveryMethod.deliveryMethodType === 'E'
        ? 'Secure Electronic PDF Fee'
        : 'Delivery Fee';
    }

    // set the transcript type fee if a transcript type has been selected;
    if (this.values.transcriptType) {
      this.content.transcriptTypeFee = this.values.transcriptType.fee;
    }

    // set shipping and handling fee if the quanity is defined (since quantity is used to calculate the fee);
    if (this.values.quantity) {
      const isPrint = this.values.deliveryMethod.isPrint === 'Y';
      const isArchiveStudentN = this.data.response.orderHeader.archiveStudent !== 'Y';
      const isHandleFeePaidByR = this.data.schoolProfile.handleFeePaidBy === 'R';

      this.content.shippingHandlingFee = isPrint && isArchiveStudentN && isHandleFeePaidByR
        ? this.values.quantity.quantity * this.values.deliveryMethod.handleFee
        : 0;
    }

    // set online processing fee;
    const isFeePathTypeP = this.dataService.isFeePathTypeP();
    const isHideOpFeeN = this.data.schoolProfile.hideOpFee === 'N';

    this.content.onlineProcessingFee = isFeePathTypeP && isHideOpFeeN
      ? this.data.schoolProfile.baseOpFee
      : 0;

    // now that all fees have been calculated, calculate the total fee;
    this.content.totalFees = this.content.quantityFee
      + this.content.deliveryMethodFee
      + this.content.transcriptTypeFee
      + this.content.shippingHandlingFee
      + this.content.onlineProcessingFee;

    // let other components know that the total has been calculated;
    this.totalFeesUpdated.emit(this.content.totalFees);
  }
}
