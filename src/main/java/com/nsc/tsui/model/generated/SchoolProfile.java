
package com.nsc.tsui.model.generated;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "payOptions",
    "freeOptions",
    "processingOptions",
    "pdfDeliveryProfiles",
    "scOrderStatuses",
    "toSchoolNotes",
    "transcriptPurposes",
    "deptProcessingOptionInfos",
    "networkInfos",
    "scCampus",
    "toScprofilDynmicIntgrtn",
    "toSchoolHeader",
    "toScprofilId",
    "scprofilToken",
    "ficeCode",
    "schlName",
    "city",
    "state",
    "stdtPopulation",
    "status",
    "deliveryServiceOnly",
    "askSsn",
    "askStudentId",
    "askConfirmStId",
    "askFirstXcript",
    "askCurrEnrolled",
    "askSchools",
    "askSchoolsYears",
    "allowCampusTracking",
    "attendSchoolLabels",
    "askEnrollYears",
    "askDegrees",
    "askStamped",
    "askXcriptType",
    "askXcriptPurpose",
    "askTermYear",
    "askUpdateScRec",
    "certOptions",
    "askCertSuboption",
    "askCertColleges",
    "askSpecialInstr",
    "offerFax",
    "offerFaxF",
    "offerPickup",
    "offerPickupF",
    "offerPublicaccess",
    "offerSelectschool",
    "offerDocumentFee",
    "docShowFeeRpt",
    "docNetFee",
    "docBaseOpFee",
    "docTotalFee",
    "offerPdfDelivery",
    "pdfDeliveryFee",
    "offerDigitalRightsOption",
    "hasCertificate",
    "digitalSignatureFee",
    "rightsManagementFee",
    "electronicDeliveryFeePaidBy",
    "maxNumberViews",
    "pdfDeliverySubtype",
    "orderProcessFeePaidBySchool",
    "stIdMaxLimit",
    "feePathTypePub",
    "feePathTypeSss",
    "baseOpFee",
    "hideOpFee",
    "overnightCarrier",
    "sssReleaseForm",
    "showDataFilter",
    "allowFeeReduct",
    "dateEdited",
    "qtyExpression",
    "outXmitMethod",
    "outDataExchange",
    "outFileFormat",
    "outMapVersion",
    "outAcceptAttachments",
    "cronExpression",
    "inXmitMethod",
    "inFileFormat",
    "xmitMailbox",
    "outJobName",
    "outJobGroup",
    "outJobAlert",
    "newOrderAlert",
    "allowMultiSchAccess",
    "addWatermark",
    "visibleDigitalSignature",
    "addDynamicWatermark",
    "paperlessConsentForm",
    "allowEtxOverride",
    "displaySendToSchoolOption",
    "allowDocUpload",
    "docUploadFormats",
    "docUploadLimit",
    "consentPSelf",
    "consentPThird",
    "consentSSelf",
    "consentSThird",
    "proceedWithHoldAllowed",
    "studentIdLabel",
    "profileType",
    "inclDocForDeliv",
    "printOption",
    "handleFeePaidBy",
    "printVendorDeliveryFeePaidBy",
    "addPrintTemplate",
    "allowPrintCustomFee",
    "allowFormatEtx",
    "allowStaticDocUpload",
    "holdForPickup"
})
public class SchoolProfile {

    @JsonProperty("payOptions")
    public PayOptions payOptions;
    @JsonProperty("freeOptions")
    public FreeOptions freeOptions;
    @JsonProperty("processingOptions")
    public List<ProcessingOption> processingOptions = null;
    @JsonProperty("pdfDeliveryProfiles")
    public List<Object> pdfDeliveryProfiles = null;
    @JsonProperty("scOrderStatuses")
    public List<Object> scOrderStatuses = null;
    @JsonProperty("toSchoolNotes")
    public List<ToSchoolNote> toSchoolNotes = null;
    @JsonProperty("transcriptPurposes")
    public List<TranscriptPurpose> transcriptPurposes = null;
    @JsonProperty("deptProcessingOptionInfos")
    public List<Object> deptProcessingOptionInfos = null;
    @JsonProperty("networkInfos")
    public List<Object> networkInfos = null;
    @JsonProperty("scCampus")
    public List<Object> scCampus = null;
    @JsonProperty("toScprofilDynmicIntgrtn")
    public List<Object> toScprofilDynmicIntgrtn = null;
    @JsonProperty("toSchoolHeader")
    public ToSchoolHeader toSchoolHeader;
    @JsonProperty("toScprofilId")
    public Integer toScprofilId;
    @JsonProperty("scprofilToken")
    public Integer scprofilToken;
    @JsonProperty("ficeCode")
    public String ficeCode;
    @JsonProperty("schlName")
    public String schlName;
    @JsonProperty("city")
    public String city;
    @JsonProperty("state")
    public String state;
    @JsonProperty("stdtPopulation")
    public Integer stdtPopulation;
    @JsonProperty("status")
    public String status;
    @JsonProperty("deliveryServiceOnly")
    public String deliveryServiceOnly;
    @JsonProperty("askSsn")
    public String askSsn;
    @JsonProperty("askStudentId")
    public String askStudentId;
    @JsonProperty("askConfirmStId")
    public String askConfirmStId;
    @JsonProperty("askFirstXcript")
    public String askFirstXcript;
    @JsonProperty("askCurrEnrolled")
    public String askCurrEnrolled;
    @JsonProperty("askSchools")
    public String askSchools;
    @JsonProperty("askSchoolsYears")
    public String askSchoolsYears;
    @JsonProperty("allowCampusTracking")
    public String allowCampusTracking;
    @JsonProperty("attendSchoolLabels")
    public List<String> attendSchoolLabels = null;
    @JsonProperty("askEnrollYears")
    public String askEnrollYears;
    @JsonProperty("askDegrees")
    public String askDegrees;
    @JsonProperty("askStamped")
    public String askStamped;
    @JsonProperty("askXcriptType")
    public String askXcriptType;
    @JsonProperty("askXcriptPurpose")
    public String askXcriptPurpose;
    @JsonProperty("askTermYear")
    public String askTermYear;
    @JsonProperty("askUpdateScRec")
    public String askUpdateScRec;
    @JsonProperty("certOptions")
    public String certOptions;
    @JsonProperty("askCertSuboption")
    public String askCertSuboption;
    @JsonProperty("askCertColleges")
    public String askCertColleges;
    @JsonProperty("askSpecialInstr")
    public String askSpecialInstr;
    @JsonProperty("offerFax")
    public String offerFax;
    @JsonProperty("offerFaxF")
    public String offerFaxF;
    @JsonProperty("offerPickup")
    public String offerPickup;
    @JsonProperty("offerPickupF")
    public String offerPickupF;
    @JsonProperty("offerPublicaccess")
    public String offerPublicaccess;
    @JsonProperty("offerSelectschool")
    public String offerSelectschool;
    @JsonProperty("offerDocumentFee")
    public String offerDocumentFee;
    @JsonProperty("docShowFeeRpt")
    public String docShowFeeRpt;
    @JsonProperty("docNetFee")
    public Double docNetFee;
    @JsonProperty("docBaseOpFee")
    public Double docBaseOpFee;
    @JsonProperty("docTotalFee")
    public Double docTotalFee;
    @JsonProperty("offerPdfDelivery")
    public String offerPdfDelivery;
    @JsonProperty("pdfDeliveryFee")
    public Double pdfDeliveryFee;
    @JsonProperty("offerDigitalRightsOption")
    public String offerDigitalRightsOption;
    @JsonProperty("hasCertificate")
    public String hasCertificate;
    @JsonProperty("digitalSignatureFee")
    public Double digitalSignatureFee;
    @JsonProperty("rightsManagementFee")
    public Double rightsManagementFee;
    @JsonProperty("electronicDeliveryFeePaidBy")
    public String electronicDeliveryFeePaidBy;
    @JsonProperty("maxNumberViews")
    public Integer maxNumberViews;
    @JsonProperty("pdfDeliverySubtype")
    public String pdfDeliverySubtype;
    @JsonProperty("orderProcessFeePaidBySchool")
    public String orderProcessFeePaidBySchool;
    @JsonProperty("stIdMaxLimit")
    public Double stIdMaxLimit;
    @JsonProperty("feePathTypePub")
    public String feePathTypePub;
    @JsonProperty("feePathTypeSss")
    public String feePathTypeSss;
    @JsonProperty("baseOpFee")
    public Double baseOpFee;
    @JsonProperty("hideOpFee")
    public String hideOpFee;
    @JsonProperty("overnightCarrier")
    public String overnightCarrier;
    @JsonProperty("sssReleaseForm")
    public String sssReleaseForm;
    @JsonProperty("showDataFilter")
    public String showDataFilter;
    @JsonProperty("allowFeeReduct")
    public String allowFeeReduct;
    @JsonProperty("dateEdited")
    public String dateEdited;
    @JsonProperty("qtyExpression")
    public String qtyExpression;
    @JsonProperty("outXmitMethod")
    public String outXmitMethod;
    @JsonProperty("outDataExchange")
    public String outDataExchange;
    @JsonProperty("outFileFormat")
    public String outFileFormat;
    @JsonProperty("outMapVersion")
    public String outMapVersion;
    @JsonProperty("outAcceptAttachments")
    public String outAcceptAttachments;
    @JsonProperty("cronExpression")
    public String cronExpression;
    @JsonProperty("inXmitMethod")
    public String inXmitMethod;
    @JsonProperty("inFileFormat")
    public String inFileFormat;
    @JsonProperty("xmitMailbox")
    public String xmitMailbox;
    @JsonProperty("outJobName")
    public String outJobName;
    @JsonProperty("outJobGroup")
    public String outJobGroup;
    @JsonProperty("outJobAlert")
    public Double outJobAlert;
    @JsonProperty("newOrderAlert")
    public String newOrderAlert;
    @JsonProperty("allowMultiSchAccess")
    public String allowMultiSchAccess;
    @JsonProperty("addWatermark")
    public String addWatermark;
    @JsonProperty("visibleDigitalSignature")
    public String visibleDigitalSignature;
    @JsonProperty("addDynamicWatermark")
    public String addDynamicWatermark;
    @JsonProperty("paperlessConsentForm")
    public String paperlessConsentForm;
    @JsonProperty("allowEtxOverride")
    public String allowEtxOverride;
    @JsonProperty("displaySendToSchoolOption")
    public String displaySendToSchoolOption;
    @JsonProperty("allowDocUpload")
    public String allowDocUpload;
    @JsonProperty("docUploadFormats")
    public String docUploadFormats;
    @JsonProperty("docUploadLimit")
    public Double docUploadLimit;
    @JsonProperty("consentPSelf")
    public String consentPSelf;
    @JsonProperty("consentPThird")
    public String consentPThird;
    @JsonProperty("consentSSelf")
    public String consentSSelf;
    @JsonProperty("consentSThird")
    public String consentSThird;
    @JsonProperty("proceedWithHoldAllowed")
    public String proceedWithHoldAllowed;
    @JsonProperty("studentIdLabel")
    public String studentIdLabel;
    @JsonProperty("profileType")
    public String profileType;
    @JsonProperty("inclDocForDeliv")
    public String inclDocForDeliv;
    @JsonProperty("printOption")
    public Integer printOption;
    @JsonProperty("handleFeePaidBy")
    public String handleFeePaidBy;
    @JsonProperty("printVendorDeliveryFeePaidBy")
    public String printVendorDeliveryFeePaidBy;
    @JsonProperty("addPrintTemplate")
    public String addPrintTemplate;
    @JsonProperty("allowPrintCustomFee")
    public String allowPrintCustomFee;
    @JsonProperty("allowFormatEtx")
    public String allowFormatEtx;
    @JsonProperty("allowStaticDocUpload")
    public String allowStaticDocUpload;
    @JsonProperty("holdForPickup")
    public String holdForPickup;
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
