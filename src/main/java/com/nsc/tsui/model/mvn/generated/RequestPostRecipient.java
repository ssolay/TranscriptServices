
package com.nsc.tsui.model.mvn.generated;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * RecipientDetail
 * <p>
 * An object including recipient details
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "toRecipientId",
    "toOrderId",
    "suborderNumber",
    "exchangeNetworkTypeCode",
    "deptProcessingOption",
    "deptReferenceNumber",
    "docReviewComplete",
    "resendTranscript",
    "etxRgtryUboxId",
    "sendToSchoolElectronic",
    "scOrderStatusId",
    "orderStatus",
    "actionRequested",
    "sendToType",
    "organization",
    "ficeCode",
    "attention",
    "street1",
    "street2",
    "city",
    "state",
    "zip",
    "country",
    "phone",
    "fax",
    "email",
    "processingOption",
    "term",
    "year",
    "degreeTitle",
    "courseName1",
    "courseName2",
    "stamped",
    "xcriptTypeId",
    "xcriptPurposeId",
    "deliveryMethodId",
    "quantityId",
    "certOption",
    "certSuboption",
    "certCollege1",
    "certState1",
    "certCollege2",
    "certState2",
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
    "licenseIdentifier",
    "transcriptSubPurposeId",
    "pdfDeliverySubtype",
    "totalFee",
    "frFeeReduction",
    "frExplanation",
    "frOperatorId",
    "sourceFlag",
    "prToRecipientId",
    "noFeeFlag",
    "totalFeePaid",
    "paymentStatus",
    "paymentDate",
    "paymentXhistId",
    "amountToSchool",
    "amountToCh",
    "specialInstr",
    "overnightCarrier",
    "overnightTracking",
    "allowRevocation",
    "schlRespondDate",
    "toRecipientCategory",
    "createdTimestamp",
    "consentFormDate",
    "scCompletedDate",
    "statusEffDate",
    "timestamp",
    "addWatermark",
    "visibleDigitalSignature",
    "etxDeliveryFileFormat",
    "etxDeptRecipientId",
    "instrForUpload",
    "schoolPaidProcessFee",
    "hasCertificate",
    "pdfDeliveryProfileId",
    "addDynamicWatermark",
    "integrationProvider",
    "etxMatchingParams",
    "handleFee",
    "printFulfillment",
    "printOption",
    "handleFeePaidBy",
    "printVendorDeliveryFeePaidBy",
    "addPrintTemplate",
    "zeroFeePrgmId",
    "isZeroFeePrgrmEligible",
    "allowFormatEtx",
    "allowStaticDocUpload",
    "isVerifiedAddress",
    "isAckgInvalidAddress",
    "emailUbox",
    "delivMethodTxt",
    "processingOptionTxt",
    "quantityTxt",
    "xcriptTypeTxtFee",
    "lsacId",
    "amcasId",
    "amcasTranscriptId",
    "liaisonCasId",
    "attachments"
})
public class RequestPostRecipient {

    @JsonProperty("toRecipientId")
    private Integer toRecipientId;
    @JsonProperty("toOrderId")
    private Integer toOrderId;
    @JsonProperty("suborderNumber")
    private Integer suborderNumber;
    @JsonProperty("exchangeNetworkTypeCode")
    private String exchangeNetworkTypeCode;
    @JsonProperty("deptProcessingOption")
    private String deptProcessingOption;
    @JsonProperty("deptReferenceNumber")
    private String deptReferenceNumber;
    @JsonProperty("docReviewComplete")
    private String docReviewComplete;
    @JsonProperty("resendTranscript")
    private String resendTranscript;
    @JsonProperty("etxRgtryUboxId")
    private Integer etxRgtryUboxId;
    @JsonProperty("sendToSchoolElectronic")
    private String sendToSchoolElectronic;
    @JsonProperty("scOrderStatusId")
    private Integer scOrderStatusId;
    @JsonProperty("orderStatus")
    private String orderStatus;
    @JsonProperty("actionRequested")
    private String actionRequested;
    @JsonProperty("sendToType")
    private String sendToType;
    @JsonProperty("organization")
    private String organization;
    @JsonProperty("ficeCode")
    private String ficeCode;
    @JsonProperty("attention")
    private String attention;
    @JsonProperty("street1")
    private String street1;
    @JsonProperty("street2")
    private String street2;
    @JsonProperty("city")
    private String city;
    @JsonProperty("state")
    private String state;
    @JsonProperty("zip")
    private String zip;
    @JsonProperty("country")
    private String country;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("fax")
    private String fax;
    @JsonProperty("email")
    private String email;
    @JsonProperty("processingOption")
    private String processingOption;
    @JsonProperty("term")
    private String term;
    @JsonProperty("year")
    private String year;
    @JsonProperty("degreeTitle")
    private String degreeTitle;
    @JsonProperty("courseName1")
    private String courseName1;
    @JsonProperty("courseName2")
    private String courseName2;
    @JsonProperty("stamped")
    private String stamped;
    @JsonProperty("xcriptTypeId")
    private Integer xcriptTypeId;
    @JsonProperty("xcriptPurposeId")
    private Integer xcriptPurposeId;
    @JsonProperty("deliveryMethodId")
    private Integer deliveryMethodId;
    @JsonProperty("quantityId")
    private Integer quantityId;
    @JsonProperty("certOption")
    private String certOption;
    @JsonProperty("certSuboption")
    private String certSuboption;
    @JsonProperty("certCollege1")
    private String certCollege1;
    @JsonProperty("certState1")
    private String certState1;
    @JsonProperty("certCollege2")
    private String certCollege2;
    @JsonProperty("certState2")
    private String certState2;
    @JsonProperty("orderTotal")
    private Double orderTotal;
    @JsonProperty("baseOpFee")
    private Double baseOpFee;
    @JsonProperty("orderProcessFee")
    private Double orderProcessFee;
    @JsonProperty("credits")
    private Double credits;
    @JsonProperty("offerPdfDelivery")
    private String offerPdfDelivery;
    @JsonProperty("pdfDeliveryFee")
    private Double pdfDeliveryFee;
    @JsonProperty("offerDigitalRightsOption")
    private String offerDigitalRightsOption;
    @JsonProperty("digitalSignatureFee")
    private Double digitalSignatureFee;
    @JsonProperty("rightsManagmentFee")
    private Double rightsManagmentFee;
    @JsonProperty("electronicDeliveryFeePaidBy")
    private String electronicDeliveryFeePaidBy;
    @JsonProperty("maxNumberViews")
    private Integer maxNumberViews;
    @JsonProperty("licenseIdentifier")
    private String licenseIdentifier;
    @JsonProperty("transcriptSubPurposeId")
    private Integer transcriptSubPurposeId;
    @JsonProperty("pdfDeliverySubtype")
    private String pdfDeliverySubtype;
    @JsonProperty("totalFee")
    private Double totalFee;
    @JsonProperty("frFeeReduction")
    private Double frFeeReduction;
    @JsonProperty("frExplanation")
    private String frExplanation;
    @JsonProperty("frOperatorId")
    private String frOperatorId;
    @JsonProperty("sourceFlag")
    private String sourceFlag;
    @JsonProperty("prToRecipientId")
    private Integer prToRecipientId;
    @JsonProperty("noFeeFlag")
    private Integer noFeeFlag;
    @JsonProperty("totalFeePaid")
    private Double totalFeePaid;
    @JsonProperty("paymentStatus")
    private String paymentStatus;
    @JsonProperty("paymentDate")
    private Double paymentDate;
    @JsonProperty("paymentXhistId")
    private Integer paymentXhistId;
    @JsonProperty("amountToSchool")
    private Double amountToSchool;
    @JsonProperty("amountToCh")
    private Double amountToCh;
    @JsonProperty("specialInstr")
    private String specialInstr;
    @JsonProperty("overnightCarrier")
    private String overnightCarrier;
    @JsonProperty("overnightTracking")
    private String overnightTracking;
    @JsonProperty("allowRevocation")
    private String allowRevocation;
    @JsonProperty("schlRespondDate")
    private Double schlRespondDate;
    @JsonProperty("toRecipientCategory")
    private String toRecipientCategory;
    @JsonProperty("createdTimestamp")
    private Double createdTimestamp;
    @JsonProperty("consentFormDate")
    private Double consentFormDate;
    @JsonProperty("scCompletedDate")
    private Double scCompletedDate;
    @JsonProperty("statusEffDate")
    private Double statusEffDate;
    @JsonProperty("timestamp")
    private Double timestamp;
    @JsonProperty("addWatermark")
    private String addWatermark;
    @JsonProperty("visibleDigitalSignature")
    private String visibleDigitalSignature;
    @JsonProperty("etxDeliveryFileFormat")
    private String etxDeliveryFileFormat;
    @JsonProperty("etxDeptRecipientId")
    private String etxDeptRecipientId;
    @JsonProperty("instrForUpload")
    private String instrForUpload;
    @JsonProperty("schoolPaidProcessFee")
    private Double schoolPaidProcessFee;
    @JsonProperty("hasCertificate")
    private String hasCertificate;
    @JsonProperty("pdfDeliveryProfileId")
    private Integer pdfDeliveryProfileId;
    @JsonProperty("addDynamicWatermark")
    private String addDynamicWatermark;
    @JsonProperty("integrationProvider")
    private String integrationProvider;
    @JsonProperty("etxMatchingParams")
    private String etxMatchingParams;
    @JsonProperty("handleFee")
    private Double handleFee;
    @JsonProperty("printFulfillment")
    private String printFulfillment;
    @JsonProperty("printOption")
    private Integer printOption;
    @JsonProperty("handleFeePaidBy")
    private String handleFeePaidBy;
    @JsonProperty("printVendorDeliveryFeePaidBy")
    private String printVendorDeliveryFeePaidBy;
    @JsonProperty("addPrintTemplate")
    private String addPrintTemplate;
    @JsonProperty("zeroFeePrgmId")
    private Integer zeroFeePrgmId;
    @JsonProperty("isZeroFeePrgrmEligible")
    private String isZeroFeePrgrmEligible;
    @JsonProperty("allowFormatEtx")
    private String allowFormatEtx;
    @JsonProperty("allowStaticDocUpload")
    private String allowStaticDocUpload;
    @JsonProperty("isVerifiedAddress")
    private String isVerifiedAddress;
    @JsonProperty("isAckgInvalidAddress")
    private String isAckgInvalidAddress;
    @JsonProperty("emailUbox")
    private String emailUbox;
    @JsonProperty("delivMethodTxt")
    private String delivMethodTxt;
    @JsonProperty("processingOptionTxt")
    private String processingOptionTxt;
    @JsonProperty("quantityTxt")
    private String quantityTxt;
    @JsonProperty("xcriptTypeTxtFee")
    private String xcriptTypeTxtFee;
    @JsonProperty("lsacId")
    private String lsacId;
    @JsonProperty("amcasId")
    private String amcasId;
    @JsonProperty("amcasTranscriptId")
    private String amcasTranscriptId;
    @JsonProperty("liaisonCasId")
    private String liaisonCasId;
    @JsonProperty("attachments")
    private List<Attachment> attachments = new ArrayList<Attachment>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("toRecipientId")
    public Integer getToRecipientId() {
        return toRecipientId;
    }

    @JsonProperty("toRecipientId")
    public void setToRecipientId(Integer toRecipientId) {
        this.toRecipientId = toRecipientId;
    }

    @JsonProperty("toOrderId")
    public Integer getToOrderId() {
        return toOrderId;
    }

    @JsonProperty("toOrderId")
    public void setToOrderId(Integer toOrderId) {
        this.toOrderId = toOrderId;
    }

    @JsonProperty("suborderNumber")
    public Integer getSuborderNumber() {
        return suborderNumber;
    }

    @JsonProperty("suborderNumber")
    public void setSuborderNumber(Integer suborderNumber) {
        this.suborderNumber = suborderNumber;
    }

    @JsonProperty("exchangeNetworkTypeCode")
    public String getExchangeNetworkTypeCode() {
        return exchangeNetworkTypeCode;
    }

    @JsonProperty("exchangeNetworkTypeCode")
    public void setExchangeNetworkTypeCode(String exchangeNetworkTypeCode) {
        this.exchangeNetworkTypeCode = exchangeNetworkTypeCode;
    }

    @JsonProperty("deptProcessingOption")
    public String getDeptProcessingOption() {
        return deptProcessingOption;
    }

    @JsonProperty("deptProcessingOption")
    public void setDeptProcessingOption(String deptProcessingOption) {
        this.deptProcessingOption = deptProcessingOption;
    }

    @JsonProperty("deptReferenceNumber")
    public String getDeptReferenceNumber() {
        return deptReferenceNumber;
    }

    @JsonProperty("deptReferenceNumber")
    public void setDeptReferenceNumber(String deptReferenceNumber) {
        this.deptReferenceNumber = deptReferenceNumber;
    }

    @JsonProperty("docReviewComplete")
    public String getDocReviewComplete() {
        return docReviewComplete;
    }

    @JsonProperty("docReviewComplete")
    public void setDocReviewComplete(String docReviewComplete) {
        this.docReviewComplete = docReviewComplete;
    }

    @JsonProperty("resendTranscript")
    public String getResendTranscript() {
        return resendTranscript;
    }

    @JsonProperty("resendTranscript")
    public void setResendTranscript(String resendTranscript) {
        this.resendTranscript = resendTranscript;
    }

    @JsonProperty("etxRgtryUboxId")
    public Integer getEtxRgtryUboxId() {
        return etxRgtryUboxId;
    }

    @JsonProperty("etxRgtryUboxId")
    public void setEtxRgtryUboxId(Integer etxRgtryUboxId) {
        this.etxRgtryUboxId = etxRgtryUboxId;
    }

    @JsonProperty("sendToSchoolElectronic")
    public String getSendToSchoolElectronic() {
        return sendToSchoolElectronic;
    }

    @JsonProperty("sendToSchoolElectronic")
    public void setSendToSchoolElectronic(String sendToSchoolElectronic) {
        this.sendToSchoolElectronic = sendToSchoolElectronic;
    }

    @JsonProperty("scOrderStatusId")
    public Integer getScOrderStatusId() {
        return scOrderStatusId;
    }

    @JsonProperty("scOrderStatusId")
    public void setScOrderStatusId(Integer scOrderStatusId) {
        this.scOrderStatusId = scOrderStatusId;
    }

    @JsonProperty("orderStatus")
    public String getOrderStatus() {
        return orderStatus;
    }

    @JsonProperty("orderStatus")
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @JsonProperty("actionRequested")
    public String getActionRequested() {
        return actionRequested;
    }

    @JsonProperty("actionRequested")
    public void setActionRequested(String actionRequested) {
        this.actionRequested = actionRequested;
    }

    @JsonProperty("sendToType")
    public String getSendToType() {
        return sendToType;
    }

    @JsonProperty("sendToType")
    public void setSendToType(String sendToType) {
        this.sendToType = sendToType;
    }

    @JsonProperty("organization")
    public String getOrganization() {
        return organization;
    }

    @JsonProperty("organization")
    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @JsonProperty("ficeCode")
    public String getFiceCode() {
        return ficeCode;
    }

    @JsonProperty("ficeCode")
    public void setFiceCode(String ficeCode) {
        this.ficeCode = ficeCode;
    }

    @JsonProperty("attention")
    public String getAttention() {
        return attention;
    }

    @JsonProperty("attention")
    public void setAttention(String attention) {
        this.attention = attention;
    }

    @JsonProperty("street1")
    public String getStreet1() {
        return street1;
    }

    @JsonProperty("street1")
    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    @JsonProperty("street2")
    public String getStreet2() {
        return street2;
    }

    @JsonProperty("street2")
    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("zip")
    public String getZip() {
        return zip;
    }

    @JsonProperty("zip")
    public void setZip(String zip) {
        this.zip = zip;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    @JsonProperty("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JsonProperty("fax")
    public String getFax() {
        return fax;
    }

    @JsonProperty("fax")
    public void setFax(String fax) {
        this.fax = fax;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("processingOption")
    public String getProcessingOption() {
        return processingOption;
    }

    @JsonProperty("processingOption")
    public void setProcessingOption(String processingOption) {
        this.processingOption = processingOption;
    }

    @JsonProperty("term")
    public String getTerm() {
        return term;
    }

    @JsonProperty("term")
    public void setTerm(String term) {
        this.term = term;
    }

    @JsonProperty("year")
    public String getYear() {
        return year;
    }

    @JsonProperty("year")
    public void setYear(String year) {
        this.year = year;
    }

    @JsonProperty("degreeTitle")
    public String getDegreeTitle() {
        return degreeTitle;
    }

    @JsonProperty("degreeTitle")
    public void setDegreeTitle(String degreeTitle) {
        this.degreeTitle = degreeTitle;
    }

    @JsonProperty("courseName1")
    public String getCourseName1() {
        return courseName1;
    }

    @JsonProperty("courseName1")
    public void setCourseName1(String courseName1) {
        this.courseName1 = courseName1;
    }

    @JsonProperty("courseName2")
    public String getCourseName2() {
        return courseName2;
    }

    @JsonProperty("courseName2")
    public void setCourseName2(String courseName2) {
        this.courseName2 = courseName2;
    }

    @JsonProperty("stamped")
    public String getStamped() {
        return stamped;
    }

    @JsonProperty("stamped")
    public void setStamped(String stamped) {
        this.stamped = stamped;
    }

    @JsonProperty("xcriptTypeId")
    public Integer getXcriptTypeId() {
        return xcriptTypeId;
    }

    @JsonProperty("xcriptTypeId")
    public void setXcriptTypeId(Integer xcriptTypeId) {
        this.xcriptTypeId = xcriptTypeId;
    }

    @JsonProperty("xcriptPurposeId")
    public Integer getXcriptPurposeId() {
        return xcriptPurposeId;
    }

    @JsonProperty("xcriptPurposeId")
    public void setXcriptPurposeId(Integer xcriptPurposeId) {
        this.xcriptPurposeId = xcriptPurposeId;
    }

    @JsonProperty("deliveryMethodId")
    public Integer getDeliveryMethodId() {
        return deliveryMethodId;
    }

    @JsonProperty("deliveryMethodId")
    public void setDeliveryMethodId(Integer deliveryMethodId) {
        this.deliveryMethodId = deliveryMethodId;
    }

    @JsonProperty("quantityId")
    public Integer getQuantityId() {
        return quantityId;
    }

    @JsonProperty("quantityId")
    public void setQuantityId(Integer quantityId) {
        this.quantityId = quantityId;
    }

    @JsonProperty("certOption")
    public String getCertOption() {
        return certOption;
    }

    @JsonProperty("certOption")
    public void setCertOption(String certOption) {
        this.certOption = certOption;
    }

    @JsonProperty("certSuboption")
    public String getCertSuboption() {
        return certSuboption;
    }

    @JsonProperty("certSuboption")
    public void setCertSuboption(String certSuboption) {
        this.certSuboption = certSuboption;
    }

    @JsonProperty("certCollege1")
    public String getCertCollege1() {
        return certCollege1;
    }

    @JsonProperty("certCollege1")
    public void setCertCollege1(String certCollege1) {
        this.certCollege1 = certCollege1;
    }

    @JsonProperty("certState1")
    public String getCertState1() {
        return certState1;
    }

    @JsonProperty("certState1")
    public void setCertState1(String certState1) {
        this.certState1 = certState1;
    }

    @JsonProperty("certCollege2")
    public String getCertCollege2() {
        return certCollege2;
    }

    @JsonProperty("certCollege2")
    public void setCertCollege2(String certCollege2) {
        this.certCollege2 = certCollege2;
    }

    @JsonProperty("certState2")
    public String getCertState2() {
        return certState2;
    }

    @JsonProperty("certState2")
    public void setCertState2(String certState2) {
        this.certState2 = certState2;
    }

    @JsonProperty("orderTotal")
    public Double getOrderTotal() {
        return orderTotal;
    }

    @JsonProperty("orderTotal")
    public void setOrderTotal(Double orderTotal) {
        this.orderTotal = orderTotal;
    }

    @JsonProperty("baseOpFee")
    public Double getBaseOpFee() {
        return baseOpFee;
    }

    @JsonProperty("baseOpFee")
    public void setBaseOpFee(Double baseOpFee) {
        this.baseOpFee = baseOpFee;
    }

    @JsonProperty("orderProcessFee")
    public Double getOrderProcessFee() {
        return orderProcessFee;
    }

    @JsonProperty("orderProcessFee")
    public void setOrderProcessFee(Double orderProcessFee) {
        this.orderProcessFee = orderProcessFee;
    }

    @JsonProperty("credits")
    public Double getCredits() {
        return credits;
    }

    @JsonProperty("credits")
    public void setCredits(Double credits) {
        this.credits = credits;
    }

    @JsonProperty("offerPdfDelivery")
    public String getOfferPdfDelivery() {
        return offerPdfDelivery;
    }

    @JsonProperty("offerPdfDelivery")
    public void setOfferPdfDelivery(String offerPdfDelivery) {
        this.offerPdfDelivery = offerPdfDelivery;
    }

    @JsonProperty("pdfDeliveryFee")
    public Double getPdfDeliveryFee() {
        return pdfDeliveryFee;
    }

    @JsonProperty("pdfDeliveryFee")
    public void setPdfDeliveryFee(Double pdfDeliveryFee) {
        this.pdfDeliveryFee = pdfDeliveryFee;
    }

    @JsonProperty("offerDigitalRightsOption")
    public String getOfferDigitalRightsOption() {
        return offerDigitalRightsOption;
    }

    @JsonProperty("offerDigitalRightsOption")
    public void setOfferDigitalRightsOption(String offerDigitalRightsOption) {
        this.offerDigitalRightsOption = offerDigitalRightsOption;
    }

    @JsonProperty("digitalSignatureFee")
    public Double getDigitalSignatureFee() {
        return digitalSignatureFee;
    }

    @JsonProperty("digitalSignatureFee")
    public void setDigitalSignatureFee(Double digitalSignatureFee) {
        this.digitalSignatureFee = digitalSignatureFee;
    }

    @JsonProperty("rightsManagmentFee")
    public Double getRightsManagmentFee() {
        return rightsManagmentFee;
    }

    @JsonProperty("rightsManagmentFee")
    public void setRightsManagmentFee(Double rightsManagmentFee) {
        this.rightsManagmentFee = rightsManagmentFee;
    }

    @JsonProperty("electronicDeliveryFeePaidBy")
    public String getElectronicDeliveryFeePaidBy() {
        return electronicDeliveryFeePaidBy;
    }

    @JsonProperty("electronicDeliveryFeePaidBy")
    public void setElectronicDeliveryFeePaidBy(String electronicDeliveryFeePaidBy) {
        this.electronicDeliveryFeePaidBy = electronicDeliveryFeePaidBy;
    }

    @JsonProperty("maxNumberViews")
    public Integer getMaxNumberViews() {
        return maxNumberViews;
    }

    @JsonProperty("maxNumberViews")
    public void setMaxNumberViews(Integer maxNumberViews) {
        this.maxNumberViews = maxNumberViews;
    }

    @JsonProperty("licenseIdentifier")
    public String getLicenseIdentifier() {
        return licenseIdentifier;
    }

    @JsonProperty("licenseIdentifier")
    public void setLicenseIdentifier(String licenseIdentifier) {
        this.licenseIdentifier = licenseIdentifier;
    }

    @JsonProperty("transcriptSubPurposeId")
    public Integer getTranscriptSubPurposeId() {
        return transcriptSubPurposeId;
    }

    @JsonProperty("transcriptSubPurposeId")
    public void setTranscriptSubPurposeId(Integer transcriptSubPurposeId) {
        this.transcriptSubPurposeId = transcriptSubPurposeId;
    }

    @JsonProperty("pdfDeliverySubtype")
    public String getPdfDeliverySubtype() {
        return pdfDeliverySubtype;
    }

    @JsonProperty("pdfDeliverySubtype")
    public void setPdfDeliverySubtype(String pdfDeliverySubtype) {
        this.pdfDeliverySubtype = pdfDeliverySubtype;
    }

    @JsonProperty("totalFee")
    public Double getTotalFee() {
        return totalFee;
    }

    @JsonProperty("totalFee")
    public void setTotalFee(Double totalFee) {
        this.totalFee = totalFee;
    }

    @JsonProperty("frFeeReduction")
    public Double getFrFeeReduction() {
        return frFeeReduction;
    }

    @JsonProperty("frFeeReduction")
    public void setFrFeeReduction(Double frFeeReduction) {
        this.frFeeReduction = frFeeReduction;
    }

    @JsonProperty("frExplanation")
    public String getFrExplanation() {
        return frExplanation;
    }

    @JsonProperty("frExplanation")
    public void setFrExplanation(String frExplanation) {
        this.frExplanation = frExplanation;
    }

    @JsonProperty("frOperatorId")
    public String getFrOperatorId() {
        return frOperatorId;
    }

    @JsonProperty("frOperatorId")
    public void setFrOperatorId(String frOperatorId) {
        this.frOperatorId = frOperatorId;
    }

    @JsonProperty("sourceFlag")
    public String getSourceFlag() {
        return sourceFlag;
    }

    @JsonProperty("sourceFlag")
    public void setSourceFlag(String sourceFlag) {
        this.sourceFlag = sourceFlag;
    }

    @JsonProperty("prToRecipientId")
    public Integer getPrToRecipientId() {
        return prToRecipientId;
    }

    @JsonProperty("prToRecipientId")
    public void setPrToRecipientId(Integer prToRecipientId) {
        this.prToRecipientId = prToRecipientId;
    }

    @JsonProperty("noFeeFlag")
    public Integer getNoFeeFlag() {
        return noFeeFlag;
    }

    @JsonProperty("noFeeFlag")
    public void setNoFeeFlag(Integer noFeeFlag) {
        this.noFeeFlag = noFeeFlag;
    }

    @JsonProperty("totalFeePaid")
    public Double getTotalFeePaid() {
        return totalFeePaid;
    }

    @JsonProperty("totalFeePaid")
    public void setTotalFeePaid(Double totalFeePaid) {
        this.totalFeePaid = totalFeePaid;
    }

    @JsonProperty("paymentStatus")
    public String getPaymentStatus() {
        return paymentStatus;
    }

    @JsonProperty("paymentStatus")
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @JsonProperty("paymentDate")
    public Double getPaymentDate() {
        return paymentDate;
    }

    @JsonProperty("paymentDate")
    public void setPaymentDate(Double paymentDate) {
        this.paymentDate = paymentDate;
    }

    @JsonProperty("paymentXhistId")
    public Integer getPaymentXhistId() {
        return paymentXhistId;
    }

    @JsonProperty("paymentXhistId")
    public void setPaymentXhistId(Integer paymentXhistId) {
        this.paymentXhistId = paymentXhistId;
    }

    @JsonProperty("amountToSchool")
    public Double getAmountToSchool() {
        return amountToSchool;
    }

    @JsonProperty("amountToSchool")
    public void setAmountToSchool(Double amountToSchool) {
        this.amountToSchool = amountToSchool;
    }

    @JsonProperty("amountToCh")
    public Double getAmountToCh() {
        return amountToCh;
    }

    @JsonProperty("amountToCh")
    public void setAmountToCh(Double amountToCh) {
        this.amountToCh = amountToCh;
    }

    @JsonProperty("specialInstr")
    public String getSpecialInstr() {
        return specialInstr;
    }

    @JsonProperty("specialInstr")
    public void setSpecialInstr(String specialInstr) {
        this.specialInstr = specialInstr;
    }

    @JsonProperty("overnightCarrier")
    public String getOvernightCarrier() {
        return overnightCarrier;
    }

    @JsonProperty("overnightCarrier")
    public void setOvernightCarrier(String overnightCarrier) {
        this.overnightCarrier = overnightCarrier;
    }

    @JsonProperty("overnightTracking")
    public String getOvernightTracking() {
        return overnightTracking;
    }

    @JsonProperty("overnightTracking")
    public void setOvernightTracking(String overnightTracking) {
        this.overnightTracking = overnightTracking;
    }

    @JsonProperty("allowRevocation")
    public String getAllowRevocation() {
        return allowRevocation;
    }

    @JsonProperty("allowRevocation")
    public void setAllowRevocation(String allowRevocation) {
        this.allowRevocation = allowRevocation;
    }

    @JsonProperty("schlRespondDate")
    public Double getSchlRespondDate() {
        return schlRespondDate;
    }

    @JsonProperty("schlRespondDate")
    public void setSchlRespondDate(Double schlRespondDate) {
        this.schlRespondDate = schlRespondDate;
    }

    @JsonProperty("toRecipientCategory")
    public String getToRecipientCategory() {
        return toRecipientCategory;
    }

    @JsonProperty("toRecipientCategory")
    public void setToRecipientCategory(String toRecipientCategory) {
        this.toRecipientCategory = toRecipientCategory;
    }

    @JsonProperty("createdTimestamp")
    public Double getCreatedTimestamp() {
        return createdTimestamp;
    }

    @JsonProperty("createdTimestamp")
    public void setCreatedTimestamp(Double createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    @JsonProperty("consentFormDate")
    public Double getConsentFormDate() {
        return consentFormDate;
    }

    @JsonProperty("consentFormDate")
    public void setConsentFormDate(Double consentFormDate) {
        this.consentFormDate = consentFormDate;
    }

    @JsonProperty("scCompletedDate")
    public Double getScCompletedDate() {
        return scCompletedDate;
    }

    @JsonProperty("scCompletedDate")
    public void setScCompletedDate(Double scCompletedDate) {
        this.scCompletedDate = scCompletedDate;
    }

    @JsonProperty("statusEffDate")
    public Double getStatusEffDate() {
        return statusEffDate;
    }

    @JsonProperty("statusEffDate")
    public void setStatusEffDate(Double statusEffDate) {
        this.statusEffDate = statusEffDate;
    }

    @JsonProperty("timestamp")
    public Double getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(Double timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty("addWatermark")
    public String getAddWatermark() {
        return addWatermark;
    }

    @JsonProperty("addWatermark")
    public void setAddWatermark(String addWatermark) {
        this.addWatermark = addWatermark;
    }

    @JsonProperty("visibleDigitalSignature")
    public String getVisibleDigitalSignature() {
        return visibleDigitalSignature;
    }

    @JsonProperty("visibleDigitalSignature")
    public void setVisibleDigitalSignature(String visibleDigitalSignature) {
        this.visibleDigitalSignature = visibleDigitalSignature;
    }

    @JsonProperty("etxDeliveryFileFormat")
    public String getEtxDeliveryFileFormat() {
        return etxDeliveryFileFormat;
    }

    @JsonProperty("etxDeliveryFileFormat")
    public void setEtxDeliveryFileFormat(String etxDeliveryFileFormat) {
        this.etxDeliveryFileFormat = etxDeliveryFileFormat;
    }

    @JsonProperty("etxDeptRecipientId")
    public String getEtxDeptRecipientId() {
        return etxDeptRecipientId;
    }

    @JsonProperty("etxDeptRecipientId")
    public void setEtxDeptRecipientId(String etxDeptRecipientId) {
        this.etxDeptRecipientId = etxDeptRecipientId;
    }

    @JsonProperty("instrForUpload")
    public String getInstrForUpload() {
        return instrForUpload;
    }

    @JsonProperty("instrForUpload")
    public void setInstrForUpload(String instrForUpload) {
        this.instrForUpload = instrForUpload;
    }

    @JsonProperty("schoolPaidProcessFee")
    public Double getSchoolPaidProcessFee() {
        return schoolPaidProcessFee;
    }

    @JsonProperty("schoolPaidProcessFee")
    public void setSchoolPaidProcessFee(Double schoolPaidProcessFee) {
        this.schoolPaidProcessFee = schoolPaidProcessFee;
    }

    @JsonProperty("hasCertificate")
    public String getHasCertificate() {
        return hasCertificate;
    }

    @JsonProperty("hasCertificate")
    public void setHasCertificate(String hasCertificate) {
        this.hasCertificate = hasCertificate;
    }

    @JsonProperty("pdfDeliveryProfileId")
    public Integer getPdfDeliveryProfileId() {
        return pdfDeliveryProfileId;
    }

    @JsonProperty("pdfDeliveryProfileId")
    public void setPdfDeliveryProfileId(Integer pdfDeliveryProfileId) {
        this.pdfDeliveryProfileId = pdfDeliveryProfileId;
    }

    @JsonProperty("addDynamicWatermark")
    public String getAddDynamicWatermark() {
        return addDynamicWatermark;
    }

    @JsonProperty("addDynamicWatermark")
    public void setAddDynamicWatermark(String addDynamicWatermark) {
        this.addDynamicWatermark = addDynamicWatermark;
    }

    @JsonProperty("integrationProvider")
    public String getIntegrationProvider() {
        return integrationProvider;
    }

    @JsonProperty("integrationProvider")
    public void setIntegrationProvider(String integrationProvider) {
        this.integrationProvider = integrationProvider;
    }

    @JsonProperty("etxMatchingParams")
    public String getEtxMatchingParams() {
        return etxMatchingParams;
    }

    @JsonProperty("etxMatchingParams")
    public void setEtxMatchingParams(String etxMatchingParams) {
        this.etxMatchingParams = etxMatchingParams;
    }

    @JsonProperty("handleFee")
    public Double getHandleFee() {
        return handleFee;
    }

    @JsonProperty("handleFee")
    public void setHandleFee(Double handleFee) {
        this.handleFee = handleFee;
    }

    @JsonProperty("printFulfillment")
    public String getPrintFulfillment() {
        return printFulfillment;
    }

    @JsonProperty("printFulfillment")
    public void setPrintFulfillment(String printFulfillment) {
        this.printFulfillment = printFulfillment;
    }

    @JsonProperty("printOption")
    public Integer getPrintOption() {
        return printOption;
    }

    @JsonProperty("printOption")
    public void setPrintOption(Integer printOption) {
        this.printOption = printOption;
    }

    @JsonProperty("handleFeePaidBy")
    public String getHandleFeePaidBy() {
        return handleFeePaidBy;
    }

    @JsonProperty("handleFeePaidBy")
    public void setHandleFeePaidBy(String handleFeePaidBy) {
        this.handleFeePaidBy = handleFeePaidBy;
    }

    @JsonProperty("printVendorDeliveryFeePaidBy")
    public String getPrintVendorDeliveryFeePaidBy() {
        return printVendorDeliveryFeePaidBy;
    }

    @JsonProperty("printVendorDeliveryFeePaidBy")
    public void setPrintVendorDeliveryFeePaidBy(String printVendorDeliveryFeePaidBy) {
        this.printVendorDeliveryFeePaidBy = printVendorDeliveryFeePaidBy;
    }

    @JsonProperty("addPrintTemplate")
    public String getAddPrintTemplate() {
        return addPrintTemplate;
    }

    @JsonProperty("addPrintTemplate")
    public void setAddPrintTemplate(String addPrintTemplate) {
        this.addPrintTemplate = addPrintTemplate;
    }

    @JsonProperty("zeroFeePrgmId")
    public Integer getZeroFeePrgmId() {
        return zeroFeePrgmId;
    }

    @JsonProperty("zeroFeePrgmId")
    public void setZeroFeePrgmId(Integer zeroFeePrgmId) {
        this.zeroFeePrgmId = zeroFeePrgmId;
    }

    @JsonProperty("isZeroFeePrgrmEligible")
    public String getIsZeroFeePrgrmEligible() {
        return isZeroFeePrgrmEligible;
    }

    @JsonProperty("isZeroFeePrgrmEligible")
    public void setIsZeroFeePrgrmEligible(String isZeroFeePrgrmEligible) {
        this.isZeroFeePrgrmEligible = isZeroFeePrgrmEligible;
    }

    @JsonProperty("allowFormatEtx")
    public String getAllowFormatEtx() {
        return allowFormatEtx;
    }

    @JsonProperty("allowFormatEtx")
    public void setAllowFormatEtx(String allowFormatEtx) {
        this.allowFormatEtx = allowFormatEtx;
    }

    @JsonProperty("allowStaticDocUpload")
    public String getAllowStaticDocUpload() {
        return allowStaticDocUpload;
    }

    @JsonProperty("allowStaticDocUpload")
    public void setAllowStaticDocUpload(String allowStaticDocUpload) {
        this.allowStaticDocUpload = allowStaticDocUpload;
    }

    @JsonProperty("isVerifiedAddress")
    public String getIsVerifiedAddress() {
        return isVerifiedAddress;
    }

    @JsonProperty("isVerifiedAddress")
    public void setIsVerifiedAddress(String isVerifiedAddress) {
        this.isVerifiedAddress = isVerifiedAddress;
    }

    @JsonProperty("isAckgInvalidAddress")
    public String getIsAckgInvalidAddress() {
        return isAckgInvalidAddress;
    }

    @JsonProperty("isAckgInvalidAddress")
    public void setIsAckgInvalidAddress(String isAckgInvalidAddress) {
        this.isAckgInvalidAddress = isAckgInvalidAddress;
    }

    @JsonProperty("emailUbox")
    public String getEmailUbox() {
        return emailUbox;
    }

    @JsonProperty("emailUbox")
    public void setEmailUbox(String emailUbox) {
        this.emailUbox = emailUbox;
    }

    @JsonProperty("delivMethodTxt")
    public String getDelivMethodTxt() {
        return delivMethodTxt;
    }

    @JsonProperty("delivMethodTxt")
    public void setDelivMethodTxt(String delivMethodTxt) {
        this.delivMethodTxt = delivMethodTxt;
    }

    @JsonProperty("processingOptionTxt")
    public String getProcessingOptionTxt() {
        return processingOptionTxt;
    }

    @JsonProperty("processingOptionTxt")
    public void setProcessingOptionTxt(String processingOptionTxt) {
        this.processingOptionTxt = processingOptionTxt;
    }

    @JsonProperty("quantityTxt")
    public String getQuantityTxt() {
        return quantityTxt;
    }

    @JsonProperty("quantityTxt")
    public void setQuantityTxt(String quantityTxt) {
        this.quantityTxt = quantityTxt;
    }

    @JsonProperty("xcriptTypeTxtFee")
    public String getXcriptTypeTxtFee() {
        return xcriptTypeTxtFee;
    }

    @JsonProperty("xcriptTypeTxtFee")
    public void setXcriptTypeTxtFee(String xcriptTypeTxtFee) {
        this.xcriptTypeTxtFee = xcriptTypeTxtFee;
    }

    @JsonProperty("lsacId")
    public String getLsacId() {
        return lsacId;
    }

    @JsonProperty("lsacId")
    public void setLsacId(String lsacId) {
        this.lsacId = lsacId;
    }

    @JsonProperty("amcasId")
    public String getAmcasId() {
        return amcasId;
    }

    @JsonProperty("amcasId")
    public void setAmcasId(String amcasId) {
        this.amcasId = amcasId;
    }

    @JsonProperty("amcasTranscriptId")
    public String getAmcasTranscriptId() {
        return amcasTranscriptId;
    }

    @JsonProperty("amcasTranscriptId")
    public void setAmcasTranscriptId(String amcasTranscriptId) {
        this.amcasTranscriptId = amcasTranscriptId;
    }

    @JsonProperty("liaisonCasId")
    public String getLiaisonCasId() {
        return liaisonCasId;
    }

    @JsonProperty("liaisonCasId")
    public void setLiaisonCasId(String liaisonCasId) {
        this.liaisonCasId = liaisonCasId;
    }

    @JsonProperty("attachments")
    public List<Attachment> getAttachments() {
        return attachments;
    }

    @JsonProperty("attachments")
    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("toRecipientId", toRecipientId).append("toOrderId", toOrderId).append("suborderNumber", suborderNumber).append("exchangeNetworkTypeCode", exchangeNetworkTypeCode).append("deptProcessingOption", deptProcessingOption).append("deptReferenceNumber", deptReferenceNumber).append("docReviewComplete", docReviewComplete).append("resendTranscript", resendTranscript).append("etxRgtryUboxId", etxRgtryUboxId).append("sendToSchoolElectronic", sendToSchoolElectronic).append("scOrderStatusId", scOrderStatusId).append("orderStatus", orderStatus).append("actionRequested", actionRequested).append("sendToType", sendToType).append("organization", organization).append("ficeCode", ficeCode).append("attention", attention).append("street1", street1).append("street2", street2).append("city", city).append("state", state).append("zip", zip).append("country", country).append("phone", phone).append("fax", fax).append("email", email).append("processingOption", processingOption).append("term", term).append("year", year).append("degreeTitle", degreeTitle).append("courseName1", courseName1).append("courseName2", courseName2).append("stamped", stamped).append("xcriptTypeId", xcriptTypeId).append("xcriptPurposeId", xcriptPurposeId).append("deliveryMethodId", deliveryMethodId).append("quantityId", quantityId).append("certOption", certOption).append("certSuboption", certSuboption).append("certCollege1", certCollege1).append("certState1", certState1).append("certCollege2", certCollege2).append("certState2", certState2).append("orderTotal", orderTotal).append("baseOpFee", baseOpFee).append("orderProcessFee", orderProcessFee).append("credits", credits).append("offerPdfDelivery", offerPdfDelivery).append("pdfDeliveryFee", pdfDeliveryFee).append("offerDigitalRightsOption", offerDigitalRightsOption).append("digitalSignatureFee", digitalSignatureFee).append("rightsManagmentFee", rightsManagmentFee).append("electronicDeliveryFeePaidBy", electronicDeliveryFeePaidBy).append("maxNumberViews", maxNumberViews).append("licenseIdentifier", licenseIdentifier).append("transcriptSubPurposeId", transcriptSubPurposeId).append("pdfDeliverySubtype", pdfDeliverySubtype).append("totalFee", totalFee).append("frFeeReduction", frFeeReduction).append("frExplanation", frExplanation).append("frOperatorId", frOperatorId).append("sourceFlag", sourceFlag).append("prToRecipientId", prToRecipientId).append("noFeeFlag", noFeeFlag).append("totalFeePaid", totalFeePaid).append("paymentStatus", paymentStatus).append("paymentDate", paymentDate).append("paymentXhistId", paymentXhistId).append("amountToSchool", amountToSchool).append("amountToCh", amountToCh).append("specialInstr", specialInstr).append("overnightCarrier", overnightCarrier).append("overnightTracking", overnightTracking).append("allowRevocation", allowRevocation).append("schlRespondDate", schlRespondDate).append("toRecipientCategory", toRecipientCategory).append("createdTimestamp", createdTimestamp).append("consentFormDate", consentFormDate).append("scCompletedDate", scCompletedDate).append("statusEffDate", statusEffDate).append("timestamp", timestamp).append("addWatermark", addWatermark).append("visibleDigitalSignature", visibleDigitalSignature).append("etxDeliveryFileFormat", etxDeliveryFileFormat).append("etxDeptRecipientId", etxDeptRecipientId).append("instrForUpload", instrForUpload).append("schoolPaidProcessFee", schoolPaidProcessFee).append("hasCertificate", hasCertificate).append("pdfDeliveryProfileId", pdfDeliveryProfileId).append("addDynamicWatermark", addDynamicWatermark).append("integrationProvider", integrationProvider).append("etxMatchingParams", etxMatchingParams).append("handleFee", handleFee).append("printFulfillment", printFulfillment).append("printOption", printOption).append("handleFeePaidBy", handleFeePaidBy).append("printVendorDeliveryFeePaidBy", printVendorDeliveryFeePaidBy).append("addPrintTemplate", addPrintTemplate).append("zeroFeePrgmId", zeroFeePrgmId).append("isZeroFeePrgrmEligible", isZeroFeePrgrmEligible).append("allowFormatEtx", allowFormatEtx).append("allowStaticDocUpload", allowStaticDocUpload).append("isVerifiedAddress", isVerifiedAddress).append("isAckgInvalidAddress", isAckgInvalidAddress).append("emailUbox", emailUbox).append("delivMethodTxt", delivMethodTxt).append("processingOptionTxt", processingOptionTxt).append("quantityTxt", quantityTxt).append("xcriptTypeTxtFee", xcriptTypeTxtFee).append("lsacId", lsacId).append("amcasId", amcasId).append("amcasTranscriptId", amcasTranscriptId).append("liaisonCasId", liaisonCasId).append("attachments", attachments).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(pdfDeliveryProfileId).append(year).append(scCompletedDate).append(printVendorDeliveryFeePaidBy).append(allowFormatEtx).append(deptReferenceNumber).append(certSuboption).append(noFeeFlag).append(state).append(fax).append(deptProcessingOption).append(rightsManagmentFee).append(transcriptSubPurposeId).append(zip).append(isVerifiedAddress).append(printFulfillment).append(lsacId).append(instrForUpload).append(consentFormDate).append(phone).append(allowRevocation).append(certState1).append(ficeCode).append(certState2).append(offerPdfDelivery).append(addPrintTemplate).append(additionalProperties).append(etxRgtryUboxId).append(baseOpFee).append(attachments).append(city).append(pdfDeliveryFee).append(overnightTracking).append(stamped).append(licenseIdentifier).append(totalFeePaid).append(xcriptTypeTxtFee).append(processingOptionTxt).append(delivMethodTxt).append(street1).append(term).append(street2).append(email).append(timestamp).append(exchangeNetworkTypeCode).append(frExplanation).append(schoolPaidProcessFee).append(paymentXhistId).append(createdTimestamp).append(resendTranscript).append(certCollege2).append(certCollege1).append(statusEffDate).append(etxMatchingParams).append(amcasTranscriptId).append(actionRequested).append(allowStaticDocUpload).append(organization).append(frOperatorId).append(orderProcessFee).append(addDynamicWatermark).append(country).append(digitalSignatureFee).append(deliveryMethodId).append(toRecipientId).append(etxDeliveryFileFormat).append(emailUbox).append(printOption).append(zeroFeePrgmId).append(certOption).append(electronicDeliveryFeePaidBy).append(overnightCarrier).append(maxNumberViews).append(sourceFlag).append(etxDeptRecipientId).append(isAckgInvalidAddress).append(quantityTxt).append(amountToSchool).append(amountToCh).append(sendToType).append(integrationProvider).append(scOrderStatusId).append(processingOption).append(courseName2).append(offerDigitalRightsOption).append(courseName1).append(docReviewComplete).append(sendToSchoolElectronic).append(schlRespondDate).append(isZeroFeePrgrmEligible).append(hasCertificate).append(orderStatus).append(prToRecipientId).append(addWatermark).append(suborderNumber).append(specialInstr).append(credits).append(paymentStatus).append(handleFeePaidBy).append(toOrderId).append(quantityId).append(toRecipientCategory).append(handleFee).append(orderTotal).append(liaisonCasId).append(degreeTitle).append(visibleDigitalSignature).append(totalFee).append(attention).append(frFeeReduction).append(amcasId).append(xcriptTypeId).append(paymentDate).append(xcriptPurposeId).append(pdfDeliverySubtype).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RequestPostRecipient) == false) {
            return false;
        }
        RequestPostRecipient rhs = ((RequestPostRecipient) other);
        return new EqualsBuilder().append(pdfDeliveryProfileId, rhs.pdfDeliveryProfileId).append(year, rhs.year).append(scCompletedDate, rhs.scCompletedDate).append(printVendorDeliveryFeePaidBy, rhs.printVendorDeliveryFeePaidBy).append(allowFormatEtx, rhs.allowFormatEtx).append(deptReferenceNumber, rhs.deptReferenceNumber).append(certSuboption, rhs.certSuboption).append(noFeeFlag, rhs.noFeeFlag).append(state, rhs.state).append(fax, rhs.fax).append(deptProcessingOption, rhs.deptProcessingOption).append(rightsManagmentFee, rhs.rightsManagmentFee).append(transcriptSubPurposeId, rhs.transcriptSubPurposeId).append(zip, rhs.zip).append(isVerifiedAddress, rhs.isVerifiedAddress).append(printFulfillment, rhs.printFulfillment).append(lsacId, rhs.lsacId).append(instrForUpload, rhs.instrForUpload).append(consentFormDate, rhs.consentFormDate).append(phone, rhs.phone).append(allowRevocation, rhs.allowRevocation).append(certState1, rhs.certState1).append(ficeCode, rhs.ficeCode).append(certState2, rhs.certState2).append(offerPdfDelivery, rhs.offerPdfDelivery).append(addPrintTemplate, rhs.addPrintTemplate).append(additionalProperties, rhs.additionalProperties).append(etxRgtryUboxId, rhs.etxRgtryUboxId).append(baseOpFee, rhs.baseOpFee).append(attachments, rhs.attachments).append(city, rhs.city).append(pdfDeliveryFee, rhs.pdfDeliveryFee).append(overnightTracking, rhs.overnightTracking).append(stamped, rhs.stamped).append(licenseIdentifier, rhs.licenseIdentifier).append(totalFeePaid, rhs.totalFeePaid).append(xcriptTypeTxtFee, rhs.xcriptTypeTxtFee).append(processingOptionTxt, rhs.processingOptionTxt).append(delivMethodTxt, rhs.delivMethodTxt).append(street1, rhs.street1).append(term, rhs.term).append(street2, rhs.street2).append(email, rhs.email).append(timestamp, rhs.timestamp).append(exchangeNetworkTypeCode, rhs.exchangeNetworkTypeCode).append(frExplanation, rhs.frExplanation).append(schoolPaidProcessFee, rhs.schoolPaidProcessFee).append(paymentXhistId, rhs.paymentXhistId).append(createdTimestamp, rhs.createdTimestamp).append(resendTranscript, rhs.resendTranscript).append(certCollege2, rhs.certCollege2).append(certCollege1, rhs.certCollege1).append(statusEffDate, rhs.statusEffDate).append(etxMatchingParams, rhs.etxMatchingParams).append(amcasTranscriptId, rhs.amcasTranscriptId).append(actionRequested, rhs.actionRequested).append(allowStaticDocUpload, rhs.allowStaticDocUpload).append(organization, rhs.organization).append(frOperatorId, rhs.frOperatorId).append(orderProcessFee, rhs.orderProcessFee).append(addDynamicWatermark, rhs.addDynamicWatermark).append(country, rhs.country).append(digitalSignatureFee, rhs.digitalSignatureFee).append(deliveryMethodId, rhs.deliveryMethodId).append(toRecipientId, rhs.toRecipientId).append(etxDeliveryFileFormat, rhs.etxDeliveryFileFormat).append(emailUbox, rhs.emailUbox).append(printOption, rhs.printOption).append(zeroFeePrgmId, rhs.zeroFeePrgmId).append(certOption, rhs.certOption).append(electronicDeliveryFeePaidBy, rhs.electronicDeliveryFeePaidBy).append(overnightCarrier, rhs.overnightCarrier).append(maxNumberViews, rhs.maxNumberViews).append(sourceFlag, rhs.sourceFlag).append(etxDeptRecipientId, rhs.etxDeptRecipientId).append(isAckgInvalidAddress, rhs.isAckgInvalidAddress).append(quantityTxt, rhs.quantityTxt).append(amountToSchool, rhs.amountToSchool).append(amountToCh, rhs.amountToCh).append(sendToType, rhs.sendToType).append(integrationProvider, rhs.integrationProvider).append(scOrderStatusId, rhs.scOrderStatusId).append(processingOption, rhs.processingOption).append(courseName2, rhs.courseName2).append(offerDigitalRightsOption, rhs.offerDigitalRightsOption).append(courseName1, rhs.courseName1).append(docReviewComplete, rhs.docReviewComplete).append(sendToSchoolElectronic, rhs.sendToSchoolElectronic).append(schlRespondDate, rhs.schlRespondDate).append(isZeroFeePrgrmEligible, rhs.isZeroFeePrgrmEligible).append(hasCertificate, rhs.hasCertificate).append(orderStatus, rhs.orderStatus).append(prToRecipientId, rhs.prToRecipientId).append(addWatermark, rhs.addWatermark).append(suborderNumber, rhs.suborderNumber).append(specialInstr, rhs.specialInstr).append(credits, rhs.credits).append(paymentStatus, rhs.paymentStatus).append(handleFeePaidBy, rhs.handleFeePaidBy).append(toOrderId, rhs.toOrderId).append(quantityId, rhs.quantityId).append(toRecipientCategory, rhs.toRecipientCategory).append(handleFee, rhs.handleFee).append(orderTotal, rhs.orderTotal).append(liaisonCasId, rhs.liaisonCasId).append(degreeTitle, rhs.degreeTitle).append(visibleDigitalSignature, rhs.visibleDigitalSignature).append(totalFee, rhs.totalFee).append(attention, rhs.attention).append(frFeeReduction, rhs.frFeeReduction).append(amcasId, rhs.amcasId).append(xcriptTypeId, rhs.xcriptTypeId).append(paymentDate, rhs.paymentDate).append(xcriptPurposeId, rhs.xcriptPurposeId).append(pdfDeliverySubtype, rhs.pdfDeliverySubtype).isEquals();
    }

}
