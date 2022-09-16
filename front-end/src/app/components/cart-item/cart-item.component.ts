import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';

import { config } from '../../config/config';
import { ConvertDeliveryMethod } from '../../classes/convert-delivery-method';
import { DataRecipient } from '../../interfaces/data.interface';
import { DataService } from '../../services/data/data.service';


@Component({
  selector: 'nsc-cart-item',
  templateUrl: './cart-item.component.html',
  styleUrls: ['./cart-item.component.scss']
})
export class CartItemComponent implements OnInit {
  @Input() processingFee: number;
  @Input() recipient: DataRecipient;

  @Output() deleteRecipient = new EventEmitter();
  @Output() editRecipient = new EventEmitter();

  data = this.dataService.get();
  schoolProfile = this.data.schoolProfile;

  content = {
    deliveryMethodDisplay: null,
    deliveryMethodType: null,
    deliveryMethodFee: 0,
    deliveryMethodHelpText: null,
    howMany: null,
    howManyFee: 0,
    processingOptionDisplay: null,
    transcriptTypeDisplay: null,
    transcriptTypeFee: 0
  };

  show = {
    buttons: false,
    electronic: false,
    onlineProcessingFee: this.dataService.getOnlineProcessingFeeVisibility()
  };

  values = {
    options: this.dataService.getFeePathType()
  };

  constructor (
    private convertDeliveryMethod: ConvertDeliveryMethod,
    private dataService: DataService
  ) {}

  ngOnInit (): void {
    this.show.buttons = this.editRecipient.observers.length > 0 && this.deleteRecipient.observers.length > 0;

    this.setDeliveryMethodValues();
    this.setHowManyValues();
    this.setProcessingOptionValues();
    this.setTranscriptTypeValues();
  }

  setDeliveryMethodValues (): void {
    const deliveryMethod = this.dataService.getDeliveryMethodObject(this.recipient.delivery.deliveryMethod);

    this.content.deliveryMethodDisplay = this.convertDeliveryMethod.get(deliveryMethod.display);
    this.content.deliveryMethodType = deliveryMethod.deliveryMethodType;
    this.content.deliveryMethodFee = deliveryMethod.fee;
    this.content.deliveryMethodHelpText = deliveryMethod.helpText;

    this.show.electronic = config.values.deliveryMethod.electronicValues.indexOf(this.content.deliveryMethodType) > -1;
  }

  setHowManyValues (): void {
    const quantity = this.dataService.getQuantityObject(this.recipient.delivery.howMany);

    this.content.howMany = quantity.quantity;
    this.content.howManyFee = quantity.fee;
  }

  setProcessingOptionValues (): void {
    const processingOption = this.dataService.getProcessingOptionObject(this.recipient.delivery.transcriptWhen);

    this.content.processingOptionDisplay = processingOption.description;
  }

  setTranscriptTypeValues (): void {
    const transcriptType = this.dataService.getTranscriptTypeObject(this.recipient.delivery.transcriptType);

    if (transcriptType) {
      this.content.transcriptTypeDisplay = transcriptType.display;
      this.content.transcriptTypeFee = transcriptType.fee;
    }
  }

  edit (): void {
    this.editRecipient.emit();
  }

  delete (): void {
    this.deleteRecipient.emit();
  }
}
