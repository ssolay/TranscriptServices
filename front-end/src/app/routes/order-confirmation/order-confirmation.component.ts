import * as moment from 'moment';
import { Component, OnInit } from '@angular/core';
import { sortedUniq as _sortedUniq } from 'lodash';

import { config } from '../../config/config';
import { DataService } from '../../services/data/data.service';


@Component({
  selector: 'nsc-order-confirmation',
  templateUrl: './order-confirmation.component.html',
  styleUrls: ['./order-confirmation.component.scss']
})
export class OrderConfirmationComponent implements OnInit {
  data = this.dataService.get();

  content = {
    attachments: [],
    orderId: this.data.response.orderHeader.toOrderId,
    recipients: [],
    requestor: this.data.response.student,
    schoolProfile: this.data.schoolProfile,
    orderDate: null,
    totalFees: this.data.response.orderHeader.totalFee
  };

  values = {
    yes: config.values.yes
  };

  constructor (private dataService: DataService) {}

  ngOnInit () {
    this.setSignatureDate();
    this.setRecipients();
  }

  setSignatureDate (): void {
    const consentFormDate = this.data.response.recipients[0].consentFormDate;

    // convert the string into a moment date, then format the date;
    // oddly the date has a period in it, so remove whatever comes after the period;
    if (consentFormDate) {
      const orderDate = moment(consentFormDate.split('.')[0], config.values.consentDateFormat);

      this.content.orderDate = orderDate.format(config.values.confirmationDateFormat);
    }
  }

  setRecipients (): void {
    const unsortedAttachments = [];

    this.data.response.recipients.forEach(recipient => {
      // convert into a structure that the cart-item is expecting;
      this.content.recipients.push({
        address: {
          addressLine1: recipient.street1,
          addressLine2: recipient.street2,
          attention: recipient.attention,
          city: recipient.city,
          country: recipient.country,
          emailPrimary: recipient.email,
          phone: recipient.phone,
          recipient: recipient.organization,
          state: recipient.state,
          zip: recipient.zip
        },
        delivery: {
          deliveryMethod: recipient.deliveryMethodId,
          howMany: recipient.quantityId,
          specialInstructions: recipient.specialInstr,
          transcriptPurpose: recipient.xcriptPurposeId,
          transcriptType: recipient.xcriptTypeId,
          transcriptWhen: recipient.processingOption
        },
        who: {
          recipientType: recipient.sendToType
        }
      });

      // if there are attachments for the recipient, save them so we can display all the attachments in a single list;
      if (recipient.attachments) {
        recipient.attachments.forEach(attachment => {
          unsortedAttachments.push(attachment.originalFileName);
        });
      }
    });

    // if there are attachments, sort them and remove duplicates;
    if (unsortedAttachments.length) {
      this.content.attachments = _sortedUniq(unsortedAttachments);
    }
  }
}
