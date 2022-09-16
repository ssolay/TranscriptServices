
package com.nsc.tsui.model.generated.recipients;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "toRecipientId",
    "toOrderId",
    "suborderNumber",
    "scOrderStatusId",
    "orderStatus",
    "sendToType",
    "organization",
    "street1",
    "city",
    "state",
    "zip",
    "country",
    "processingOption",
    "deliveryMethodId",
    "quantityId",
    "orderTotal",
    "baseOpFee",
    "orderProcessFee",
    "credits",
    "offerPdfDelivery",
    "pdfDeliveryFee",
    "offerDigitalRightsOption",
    "digitalSignatureFee",
    "rightsManagmentFee",
    "electronicDeliveryFeePaidBy",
    "maxNumberViews",
    "pdfDeliverySubtype",
    "totalFee",
    "frFeeReduction",
    "noFeeFlag",
    "totalFeePaid",
    "paymentStatus",
    "amountToSchool",
    "amountToCh",
    "allowRevocation",
    "toRecipientCategory",
    "createdTimestamp",
    "statusEffDate",
    "timestamp",
    "addWatermark",
    "visibleDigitalSignature",
    "schoolPaidProcessFee",
    "hasCertificate",
    "addDynamicWatermark",
    "handleFee",
    "printFulfillment",
    "printOption",
    "handleFeePaidBy",
    "printVendorDeliveryFeePaidBy",
    "addPrintTemplate",
    "allowFormatEtx",
    "allowStaticDocUpload",
    "isVerifiedAddress",
    "isAckgInvalidAddress"
})
public class Recipient {

    @JsonProperty("toRecipientId")
    public Integer toRecipientId;
    @JsonProperty("toOrderId")
    public Integer toOrderId;
    @JsonProperty("suborderNumber")
    public Integer suborderNumber;
    @JsonProperty("scOrderStatusId")
    public Integer scOrderStatusId;
    @JsonProperty("orderStatus")
    public String orderStatus;
    @JsonProperty("sendToType")
    public String sendToType;
    @JsonProperty("organization")
    public String organization;
    @JsonProperty("street1")
    public String street1;
    @JsonProperty("city")
    public String city;
    @JsonProperty("state")
    public String state;
    @JsonProperty("zip")
    public String zip;
    @JsonProperty("country")
    public String country;
    @JsonProperty("processingOption")
    public String processingOption;
    @JsonProperty("deliveryMethodId")
    public Integer deliveryMethodId;
    @JsonProperty("quantityId")
    public Integer quantityId;
    @JsonProperty("orderTotal")
    public Integer orderTotal;
    @JsonProperty("baseOpFee")
    public Integer baseOpFee;
    @JsonProperty("orderProcessFee")
    public Integer orderProcessFee;
    @JsonProperty("credits")
    public Integer credits;
    @JsonProperty("offerPdfDelivery")
    public String offerPdfDelivery;
    @JsonProperty("pdfDeliveryFee")
    public Integer pdfDeliveryFee;
    @JsonProperty("offerDigitalRightsOption")
    public String offerDigitalRightsOption;
    @JsonProperty("digitalSignatureFee")
    public Integer digitalSignatureFee;
    @JsonProperty("rightsManagmentFee")
    public Integer rightsManagmentFee;
    @JsonProperty("electronicDeliveryFeePaidBy")
    public String electronicDeliveryFeePaidBy;
    @JsonProperty("maxNumberViews")
    public Integer maxNumberViews;
    @JsonProperty("pdfDeliverySubtype")
    public String pdfDeliverySubtype;
    @JsonProperty("totalFee")
    public Integer totalFee;
    @JsonProperty("frFeeReduction")
    public Integer frFeeReduction;
    @JsonProperty("noFeeFlag")
    public Integer noFeeFlag;
    @JsonProperty("totalFeePaid")
    public Integer totalFeePaid;
    @JsonProperty("paymentStatus")
    public String paymentStatus;
    @JsonProperty("amountToSchool")
    public Integer amountToSchool;
    @JsonProperty("amountToCh")
    public Integer amountToCh;
    @JsonProperty("allowRevocation")
    public String allowRevocation;
    @JsonProperty("toRecipientCategory")
    public String toRecipientCategory;
    @JsonProperty("createdTimestamp")
    public String createdTimestamp;
    @JsonProperty("statusEffDate")
    public String statusEffDate;
    @JsonProperty("timestamp")
    public String timestamp;
    @JsonProperty("addWatermark")
    public String addWatermark;
    @JsonProperty("visibleDigitalSignature")
    public String visibleDigitalSignature;
    @JsonProperty("schoolPaidProcessFee")
    public Double schoolPaidProcessFee;
    @JsonProperty("hasCertificate")
    public String hasCertificate;
    @JsonProperty("addDynamicWatermark")
    public String addDynamicWatermark;
    @JsonProperty("handleFee")
    public Integer handleFee;
    @JsonProperty("printFulfillment")
    public String printFulfillment;
    @JsonProperty("printOption")
    public Integer printOption;
    @JsonProperty("handleFeePaidBy")
    public String handleFeePaidBy;
    @JsonProperty("printVendorDeliveryFeePaidBy")
    public String printVendorDeliveryFeePaidBy;
    @JsonProperty("addPrintTemplate")
    public String addPrintTemplate;
    @JsonProperty("allowFormatEtx")
    public String allowFormatEtx;
    @JsonProperty("allowStaticDocUpload")
    public String allowStaticDocUpload;
    @JsonProperty("isVerifiedAddress")
    public String isVerifiedAddress;
    @JsonProperty("isAckgInvalidAddress")
    public String isAckgInvalidAddress;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
