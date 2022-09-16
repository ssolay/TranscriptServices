
package com.nsc.tsui.model.mvn.generated;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * TOScprofileDetail
 * <p>
 * A detail version of the TO School Profile that includes all custom configurations
 * 
 */
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
    "zeroFeePrgmId",
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
    "feePathDesc",
    "baseOpFee",
    "hideOpFee",
    "overnightCarrier",
    "sssReleaseForm",
    "showDataFilter",
    "allowFeeReduct",
    "chargeResend",
    "dateEdited",
    "qtyExpression",
    "qtyExpressionF",
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
    "urlDataExchange",
    "displaySendToSchoolOption",
    "allowDocUpload",
    "docUploadFormats",
    "docUploadLimit",
    "consentPSelf",
    "consentPThird",
    "consentSSelf",
    "consentSThird",
    "multipleStatusEmailHeader",
    "multipleStatusEmailFooter",
    "proceedWithHoldAllowed",
    "oborDeliveryEligibilityQuestion",
    "electronicDeliveryEligibilityQuestion",
    "studentIdLabel",
    "integrationProvider",
    "profileType",
    "inclDocForDeliv",
    "printOption",
    "handleFeePaidBy",
    "printVendorDeliveryFeePaidBy",
    "addPrintTemplate",
    "allowPrintCustomFee",
    "allowFormatEtx",
    "allowStaticDocUpload",
    "sssPathPlaceOrderOnly",
    "holdForPickup"
})
public class ResourceToscprofileDetail {

    @JsonProperty("payOptions")
    private PayOptions payOptions;
    @JsonProperty("freeOptions")
    private PayOptions freeOptions;
    @JsonProperty("processingOptions")
    @JsonDeserialize(as = LinkedHashSet.class)
    private Set<ProcessingOption> processingOptions = new LinkedHashSet<ProcessingOption>();
    @JsonProperty("pdfDeliveryProfiles")
    private List<PdfDeliveryProfile> pdfDeliveryProfiles = new ArrayList<PdfDeliveryProfile>();
    @JsonProperty("scOrderStatuses")
    @JsonDeserialize(as = LinkedHashSet.class)
    private Set<ScOrderStatus> scOrderStatuses = new LinkedHashSet<ScOrderStatus>();
    @JsonProperty("toSchoolNotes")
    @JsonDeserialize(as = LinkedHashSet.class)
    private Set<ToSchoolNote> toSchoolNotes = new LinkedHashSet<ToSchoolNote>();
    @JsonProperty("transcriptPurposes")
    @JsonDeserialize(as = LinkedHashSet.class)
    private Set<TranscriptPurpose> transcriptPurposes = new LinkedHashSet<TranscriptPurpose>();
    @JsonProperty("deptProcessingOptionInfos")
    @JsonDeserialize(as = LinkedHashSet.class)
    private Set<DeptProcessingOptionInfo> deptProcessingOptionInfos = new LinkedHashSet<DeptProcessingOptionInfo>();
    @JsonProperty("networkInfos")
    @JsonDeserialize(as = LinkedHashSet.class)
    private Set<NetworkInfo> networkInfos = new LinkedHashSet<NetworkInfo>();
    @JsonProperty("scCampus")
    @JsonDeserialize(as = LinkedHashSet.class)
    private Set<ScCampu> scCampus = new LinkedHashSet<ScCampu>();
    @JsonProperty("toScprofilDynmicIntgrtn")
    @JsonDeserialize(as = LinkedHashSet.class)
    private Set<ToScprofilDynmicIntgrtn> toScprofilDynmicIntgrtn = new LinkedHashSet<ToScprofilDynmicIntgrtn>();
    @JsonProperty("toSchoolHeader")
    private ToSchoolHeader toSchoolHeader;
    @JsonProperty("toScprofilId")
    private Integer toScprofilId;
    /**
     * Our of march scope. Need some refactoring in backend
     * 
     */
    @JsonProperty("zeroFeePrgmId")
    @JsonPropertyDescription("Our of march scope. Need some refactoring in backend")
    private Integer zeroFeePrgmId;
    @JsonProperty("scprofilToken")
    private Integer scprofilToken;
    @JsonProperty("ficeCode")
    private String ficeCode;
    @JsonProperty("schlName")
    private String schlName;
    @JsonProperty("city")
    private String city;
    @JsonProperty("state")
    private String state;
    /**
     * Not needed for UI
     * 
     */
    @JsonProperty("stdtPopulation")
    @JsonPropertyDescription("Not needed for UI")
    private Integer stdtPopulation;
    @JsonProperty("status")
    private String status;
    /**
     * Not needed for UI. This is for schools only use our delivery features
     * 
     */
    @JsonProperty("deliveryServiceOnly")
    @JsonPropertyDescription("Not needed for UI. This is for schools only use our delivery features")
    private String deliveryServiceOnly;
    @JsonProperty("askSsn")
    private String askSsn;
    @JsonProperty("askStudentId")
    private String askStudentId;
    @JsonProperty("askConfirmStId")
    private String askConfirmStId;
    @JsonProperty("askFirstXcript")
    private String askFirstXcript;
    @JsonProperty("askCurrEnrolled")
    private String askCurrEnrolled;
    @JsonProperty("askSchools")
    private String askSchools;
    @JsonProperty("askSchoolsYears")
    private String askSchoolsYears;
    @JsonProperty("allowCampusTracking")
    private String allowCampusTracking;
    @JsonProperty("attendSchoolLabels")
    private List<String> attendSchoolLabels = new ArrayList<String>();
    @JsonProperty("askEnrollYears")
    private String askEnrollYears;
    @JsonProperty("askDegrees")
    private String askDegrees;
    @JsonProperty("askStamped")
    private String askStamped;
    @JsonProperty("askXcriptType")
    private String askXcriptType;
    @JsonProperty("askXcriptPurpose")
    private String askXcriptPurpose;
    @JsonProperty("askTermYear")
    private String askTermYear;
    @JsonProperty("askUpdateScRec")
    private String askUpdateScRec;
    @JsonProperty("certOptions")
    private String certOptions;
    @JsonProperty("askCertSuboption")
    private String askCertSuboption;
    @JsonProperty("askCertColleges")
    private String askCertColleges;
    @JsonProperty("askSpecialInstr")
    private String askSpecialInstr;
    @JsonProperty("offerFax")
    private String offerFax;
    @JsonProperty("offerFaxF")
    private String offerFaxF;
    @JsonProperty("offerPickup")
    private String offerPickup;
    @JsonProperty("offerPickupF")
    private String offerPickupF;
    @JsonProperty("offerPublicaccess")
    private String offerPublicaccess;
    @JsonProperty("offerSelectschool")
    private String offerSelectschool;
    @JsonProperty("offerDocumentFee")
    private String offerDocumentFee;
    @JsonProperty("docShowFeeRpt")
    private String docShowFeeRpt;
    @JsonProperty("docNetFee")
    private Double docNetFee;
    @JsonProperty("docBaseOpFee")
    private Double docBaseOpFee;
    @JsonProperty("docTotalFee")
    private Double docTotalFee;
    @JsonProperty("offerPdfDelivery")
    private String offerPdfDelivery;
    @JsonProperty("pdfDeliveryFee")
    private Double pdfDeliveryFee;
    @JsonProperty("offerDigitalRightsOption")
    private String offerDigitalRightsOption;
    @JsonProperty("hasCertificate")
    private String hasCertificate;
    @JsonProperty("digitalSignatureFee")
    private Double digitalSignatureFee;
    @JsonProperty("rightsManagementFee")
    private Double rightsManagementFee;
    @JsonProperty("electronicDeliveryFeePaidBy")
    private String electronicDeliveryFeePaidBy;
    @JsonProperty("maxNumberViews")
    private Integer maxNumberViews;
    @JsonProperty("pdfDeliverySubtype")
    private String pdfDeliverySubtype;
    @JsonProperty("orderProcessFeePaidBySchool")
    private String orderProcessFeePaidBySchool;
    @JsonProperty("stIdMaxLimit")
    private Double stIdMaxLimit;
    @JsonProperty("feePathTypePub")
    private String feePathTypePub;
    @JsonProperty("feePathTypeSss")
    private String feePathTypeSss;
    @JsonProperty("feePathDesc")
    private String feePathDesc;
    @JsonProperty("baseOpFee")
    private Double baseOpFee;
    @JsonProperty("hideOpFee")
    private String hideOpFee;
    @JsonProperty("overnightCarrier")
    private String overnightCarrier;
    @JsonProperty("sssReleaseForm")
    private String sssReleaseForm;
    @JsonProperty("showDataFilter")
    private String showDataFilter;
    @JsonProperty("allowFeeReduct")
    private String allowFeeReduct;
    @JsonProperty("chargeResend")
    private String chargeResend;
    @JsonProperty("dateEdited")
    private String dateEdited;
    @JsonProperty("qtyExpression")
    private String qtyExpression;
    @JsonProperty("qtyExpressionF")
    private String qtyExpressionF;
    @JsonProperty("outXmitMethod")
    private String outXmitMethod;
    @JsonProperty("outDataExchange")
    private String outDataExchange;
    @JsonProperty("outFileFormat")
    private String outFileFormat;
    @JsonProperty("outMapVersion")
    private String outMapVersion;
    @JsonProperty("outAcceptAttachments")
    private String outAcceptAttachments;
    @JsonProperty("cronExpression")
    private String cronExpression;
    @JsonProperty("inXmitMethod")
    private String inXmitMethod;
    @JsonProperty("inFileFormat")
    private String inFileFormat;
    @JsonProperty("xmitMailbox")
    private String xmitMailbox;
    @JsonProperty("outJobName")
    private String outJobName;
    @JsonProperty("outJobGroup")
    private String outJobGroup;
    @JsonProperty("outJobAlert")
    private Double outJobAlert;
    @JsonProperty("newOrderAlert")
    private String newOrderAlert;
    @JsonProperty("allowMultiSchAccess")
    private String allowMultiSchAccess;
    @JsonProperty("addWatermark")
    private String addWatermark;
    @JsonProperty("visibleDigitalSignature")
    private String visibleDigitalSignature;
    @JsonProperty("addDynamicWatermark")
    private String addDynamicWatermark;
    @JsonProperty("paperlessConsentForm")
    private String paperlessConsentForm;
    @JsonProperty("allowEtxOverride")
    private String allowEtxOverride;
    @JsonProperty("urlDataExchange")
    private String urlDataExchange;
    @JsonProperty("displaySendToSchoolOption")
    private String displaySendToSchoolOption;
    @JsonProperty("allowDocUpload")
    private String allowDocUpload;
    @JsonProperty("docUploadFormats")
    private String docUploadFormats;
    @JsonProperty("docUploadLimit")
    private Double docUploadLimit;
    @JsonProperty("consentPSelf")
    private String consentPSelf;
    @JsonProperty("consentPThird")
    private String consentPThird;
    @JsonProperty("consentSSelf")
    private String consentSSelf;
    @JsonProperty("consentSThird")
    private String consentSThird;
    @JsonProperty("multipleStatusEmailHeader")
    private String multipleStatusEmailHeader;
    @JsonProperty("multipleStatusEmailFooter")
    private String multipleStatusEmailFooter;
    @JsonProperty("proceedWithHoldAllowed")
    private String proceedWithHoldAllowed;
    @JsonProperty("oborDeliveryEligibilityQuestion")
    private String oborDeliveryEligibilityQuestion;
    @JsonProperty("electronicDeliveryEligibilityQuestion")
    private String electronicDeliveryEligibilityQuestion;
    @JsonProperty("studentIdLabel")
    private String studentIdLabel;
    @JsonProperty("integrationProvider")
    private String integrationProvider;
    @JsonProperty("profileType")
    private String profileType;
    @JsonProperty("inclDocForDeliv")
    private String inclDocForDeliv;
    @JsonProperty("printOption")
    private Integer printOption;
    @JsonProperty("handleFeePaidBy")
    private String handleFeePaidBy;
    @JsonProperty("printVendorDeliveryFeePaidBy")
    private String printVendorDeliveryFeePaidBy;
    @JsonProperty("addPrintTemplate")
    private String addPrintTemplate;
    @JsonProperty("allowPrintCustomFee")
    private String allowPrintCustomFee;
    @JsonProperty("allowFormatEtx")
    private String allowFormatEtx;
    @JsonProperty("allowStaticDocUpload")
    private String allowStaticDocUpload;
    @JsonProperty("sssPathPlaceOrderOnly")
    private String sssPathPlaceOrderOnly;
    @JsonProperty("holdForPickup")
    private String holdForPickup;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("payOptions")
    public PayOptions getPayOptions() {
        return payOptions;
    }

    @JsonProperty("payOptions")
    public void setPayOptions(PayOptions payOptions) {
        this.payOptions = payOptions;
    }

    @JsonProperty("freeOptions")
    public PayOptions getFreeOptions() {
        return freeOptions;
    }

    @JsonProperty("freeOptions")
    public void setFreeOptions(PayOptions freeOptions) {
        this.freeOptions = freeOptions;
    }

    @JsonProperty("processingOptions")
    public Set<ProcessingOption> getProcessingOptions() {
        return processingOptions;
    }

    @JsonProperty("processingOptions")
    public void setProcessingOptions(Set<ProcessingOption> processingOptions) {
        this.processingOptions = processingOptions;
    }

    @JsonProperty("pdfDeliveryProfiles")
    public List<PdfDeliveryProfile> getPdfDeliveryProfiles() {
        return pdfDeliveryProfiles;
    }

    @JsonProperty("pdfDeliveryProfiles")
    public void setPdfDeliveryProfiles(List<PdfDeliveryProfile> pdfDeliveryProfiles) {
        this.pdfDeliveryProfiles = pdfDeliveryProfiles;
    }

    @JsonProperty("scOrderStatuses")
    public Set<ScOrderStatus> getScOrderStatuses() {
        return scOrderStatuses;
    }

    @JsonProperty("scOrderStatuses")
    public void setScOrderStatuses(Set<ScOrderStatus> scOrderStatuses) {
        this.scOrderStatuses = scOrderStatuses;
    }

    @JsonProperty("toSchoolNotes")
    public Set<ToSchoolNote> getToSchoolNotes() {
        return toSchoolNotes;
    }

    @JsonProperty("toSchoolNotes")
    public void setToSchoolNotes(Set<ToSchoolNote> toSchoolNotes) {
        this.toSchoolNotes = toSchoolNotes;
    }

    @JsonProperty("transcriptPurposes")
    public Set<TranscriptPurpose> getTranscriptPurposes() {
        return transcriptPurposes;
    }

    @JsonProperty("transcriptPurposes")
    public void setTranscriptPurposes(Set<TranscriptPurpose> transcriptPurposes) {
        this.transcriptPurposes = transcriptPurposes;
    }

    @JsonProperty("deptProcessingOptionInfos")
    public Set<DeptProcessingOptionInfo> getDeptProcessingOptionInfos() {
        return deptProcessingOptionInfos;
    }

    @JsonProperty("deptProcessingOptionInfos")
    public void setDeptProcessingOptionInfos(Set<DeptProcessingOptionInfo> deptProcessingOptionInfos) {
        this.deptProcessingOptionInfos = deptProcessingOptionInfos;
    }

    @JsonProperty("networkInfos")
    public Set<NetworkInfo> getNetworkInfos() {
        return networkInfos;
    }

    @JsonProperty("networkInfos")
    public void setNetworkInfos(Set<NetworkInfo> networkInfos) {
        this.networkInfos = networkInfos;
    }

    @JsonProperty("scCampus")
    public Set<ScCampu> getScCampus() {
        return scCampus;
    }

    @JsonProperty("scCampus")
    public void setScCampus(Set<ScCampu> scCampus) {
        this.scCampus = scCampus;
    }

    @JsonProperty("toScprofilDynmicIntgrtn")
    public Set<ToScprofilDynmicIntgrtn> getToScprofilDynmicIntgrtn() {
        return toScprofilDynmicIntgrtn;
    }

    @JsonProperty("toScprofilDynmicIntgrtn")
    public void setToScprofilDynmicIntgrtn(Set<ToScprofilDynmicIntgrtn> toScprofilDynmicIntgrtn) {
        this.toScprofilDynmicIntgrtn = toScprofilDynmicIntgrtn;
    }

    @JsonProperty("toSchoolHeader")
    public ToSchoolHeader getToSchoolHeader() {
        return toSchoolHeader;
    }

    @JsonProperty("toSchoolHeader")
    public void setToSchoolHeader(ToSchoolHeader toSchoolHeader) {
        this.toSchoolHeader = toSchoolHeader;
    }

    @JsonProperty("toScprofilId")
    public Integer getToScprofilId() {
        return toScprofilId;
    }

    @JsonProperty("toScprofilId")
    public void setToScprofilId(Integer toScprofilId) {
        this.toScprofilId = toScprofilId;
    }

    /**
     * Our of march scope. Need some refactoring in backend
     * 
     */
    @JsonProperty("zeroFeePrgmId")
    public Integer getZeroFeePrgmId() {
        return zeroFeePrgmId;
    }

    /**
     * Our of march scope. Need some refactoring in backend
     * 
     */
    @JsonProperty("zeroFeePrgmId")
    public void setZeroFeePrgmId(Integer zeroFeePrgmId) {
        this.zeroFeePrgmId = zeroFeePrgmId;
    }

    @JsonProperty("scprofilToken")
    public Integer getScprofilToken() {
        return scprofilToken;
    }

    @JsonProperty("scprofilToken")
    public void setScprofilToken(Integer scprofilToken) {
        this.scprofilToken = scprofilToken;
    }

    @JsonProperty("ficeCode")
    public String getFiceCode() {
        return ficeCode;
    }

    @JsonProperty("ficeCode")
    public void setFiceCode(String ficeCode) {
        this.ficeCode = ficeCode;
    }

    @JsonProperty("schlName")
    public String getSchlName() {
        return schlName;
    }

    @JsonProperty("schlName")
    public void setSchlName(String schlName) {
        this.schlName = schlName;
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

    /**
     * Not needed for UI
     * 
     */
    @JsonProperty("stdtPopulation")
    public Integer getStdtPopulation() {
        return stdtPopulation;
    }

    /**
     * Not needed for UI
     * 
     */
    @JsonProperty("stdtPopulation")
    public void setStdtPopulation(Integer stdtPopulation) {
        this.stdtPopulation = stdtPopulation;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Not needed for UI. This is for schools only use our delivery features
     * 
     */
    @JsonProperty("deliveryServiceOnly")
    public String getDeliveryServiceOnly() {
        return deliveryServiceOnly;
    }

    /**
     * Not needed for UI. This is for schools only use our delivery features
     * 
     */
    @JsonProperty("deliveryServiceOnly")
    public void setDeliveryServiceOnly(String deliveryServiceOnly) {
        this.deliveryServiceOnly = deliveryServiceOnly;
    }

    @JsonProperty("askSsn")
    public String getAskSsn() {
        return askSsn;
    }

    @JsonProperty("askSsn")
    public void setAskSsn(String askSsn) {
        this.askSsn = askSsn;
    }

    @JsonProperty("askStudentId")
    public String getAskStudentId() {
        return askStudentId;
    }

    @JsonProperty("askStudentId")
    public void setAskStudentId(String askStudentId) {
        this.askStudentId = askStudentId;
    }

    @JsonProperty("askConfirmStId")
    public String getAskConfirmStId() {
        return askConfirmStId;
    }

    @JsonProperty("askConfirmStId")
    public void setAskConfirmStId(String askConfirmStId) {
        this.askConfirmStId = askConfirmStId;
    }

    @JsonProperty("askFirstXcript")
    public String getAskFirstXcript() {
        return askFirstXcript;
    }

    @JsonProperty("askFirstXcript")
    public void setAskFirstXcript(String askFirstXcript) {
        this.askFirstXcript = askFirstXcript;
    }

    @JsonProperty("askCurrEnrolled")
    public String getAskCurrEnrolled() {
        return askCurrEnrolled;
    }

    @JsonProperty("askCurrEnrolled")
    public void setAskCurrEnrolled(String askCurrEnrolled) {
        this.askCurrEnrolled = askCurrEnrolled;
    }

    @JsonProperty("askSchools")
    public String getAskSchools() {
        return askSchools;
    }

    @JsonProperty("askSchools")
    public void setAskSchools(String askSchools) {
        this.askSchools = askSchools;
    }

    @JsonProperty("askSchoolsYears")
    public String getAskSchoolsYears() {
        return askSchoolsYears;
    }

    @JsonProperty("askSchoolsYears")
    public void setAskSchoolsYears(String askSchoolsYears) {
        this.askSchoolsYears = askSchoolsYears;
    }

    @JsonProperty("allowCampusTracking")
    public String getAllowCampusTracking() {
        return allowCampusTracking;
    }

    @JsonProperty("allowCampusTracking")
    public void setAllowCampusTracking(String allowCampusTracking) {
        this.allowCampusTracking = allowCampusTracking;
    }

    @JsonProperty("attendSchoolLabels")
    public List<String> getAttendSchoolLabels() {
        return attendSchoolLabels;
    }

    @JsonProperty("attendSchoolLabels")
    public void setAttendSchoolLabels(List<String> attendSchoolLabels) {
        this.attendSchoolLabels = attendSchoolLabels;
    }

    @JsonProperty("askEnrollYears")
    public String getAskEnrollYears() {
        return askEnrollYears;
    }

    @JsonProperty("askEnrollYears")
    public void setAskEnrollYears(String askEnrollYears) {
        this.askEnrollYears = askEnrollYears;
    }

    @JsonProperty("askDegrees")
    public String getAskDegrees() {
        return askDegrees;
    }

    @JsonProperty("askDegrees")
    public void setAskDegrees(String askDegrees) {
        this.askDegrees = askDegrees;
    }

    @JsonProperty("askStamped")
    public String getAskStamped() {
        return askStamped;
    }

    @JsonProperty("askStamped")
    public void setAskStamped(String askStamped) {
        this.askStamped = askStamped;
    }

    @JsonProperty("askXcriptType")
    public String getAskXcriptType() {
        return askXcriptType;
    }

    @JsonProperty("askXcriptType")
    public void setAskXcriptType(String askXcriptType) {
        this.askXcriptType = askXcriptType;
    }

    @JsonProperty("askXcriptPurpose")
    public String getAskXcriptPurpose() {
        return askXcriptPurpose;
    }

    @JsonProperty("askXcriptPurpose")
    public void setAskXcriptPurpose(String askXcriptPurpose) {
        this.askXcriptPurpose = askXcriptPurpose;
    }

    @JsonProperty("askTermYear")
    public String getAskTermYear() {
        return askTermYear;
    }

    @JsonProperty("askTermYear")
    public void setAskTermYear(String askTermYear) {
        this.askTermYear = askTermYear;
    }

    @JsonProperty("askUpdateScRec")
    public String getAskUpdateScRec() {
        return askUpdateScRec;
    }

    @JsonProperty("askUpdateScRec")
    public void setAskUpdateScRec(String askUpdateScRec) {
        this.askUpdateScRec = askUpdateScRec;
    }

    @JsonProperty("certOptions")
    public String getCertOptions() {
        return certOptions;
    }

    @JsonProperty("certOptions")
    public void setCertOptions(String certOptions) {
        this.certOptions = certOptions;
    }

    @JsonProperty("askCertSuboption")
    public String getAskCertSuboption() {
        return askCertSuboption;
    }

    @JsonProperty("askCertSuboption")
    public void setAskCertSuboption(String askCertSuboption) {
        this.askCertSuboption = askCertSuboption;
    }

    @JsonProperty("askCertColleges")
    public String getAskCertColleges() {
        return askCertColleges;
    }

    @JsonProperty("askCertColleges")
    public void setAskCertColleges(String askCertColleges) {
        this.askCertColleges = askCertColleges;
    }

    @JsonProperty("askSpecialInstr")
    public String getAskSpecialInstr() {
        return askSpecialInstr;
    }

    @JsonProperty("askSpecialInstr")
    public void setAskSpecialInstr(String askSpecialInstr) {
        this.askSpecialInstr = askSpecialInstr;
    }

    @JsonProperty("offerFax")
    public String getOfferFax() {
        return offerFax;
    }

    @JsonProperty("offerFax")
    public void setOfferFax(String offerFax) {
        this.offerFax = offerFax;
    }

    @JsonProperty("offerFaxF")
    public String getOfferFaxF() {
        return offerFaxF;
    }

    @JsonProperty("offerFaxF")
    public void setOfferFaxF(String offerFaxF) {
        this.offerFaxF = offerFaxF;
    }

    @JsonProperty("offerPickup")
    public String getOfferPickup() {
        return offerPickup;
    }

    @JsonProperty("offerPickup")
    public void setOfferPickup(String offerPickup) {
        this.offerPickup = offerPickup;
    }

    @JsonProperty("offerPickupF")
    public String getOfferPickupF() {
        return offerPickupF;
    }

    @JsonProperty("offerPickupF")
    public void setOfferPickupF(String offerPickupF) {
        this.offerPickupF = offerPickupF;
    }

    @JsonProperty("offerPublicaccess")
    public String getOfferPublicaccess() {
        return offerPublicaccess;
    }

    @JsonProperty("offerPublicaccess")
    public void setOfferPublicaccess(String offerPublicaccess) {
        this.offerPublicaccess = offerPublicaccess;
    }

    @JsonProperty("offerSelectschool")
    public String getOfferSelectschool() {
        return offerSelectschool;
    }

    @JsonProperty("offerSelectschool")
    public void setOfferSelectschool(String offerSelectschool) {
        this.offerSelectschool = offerSelectschool;
    }

    @JsonProperty("offerDocumentFee")
    public String getOfferDocumentFee() {
        return offerDocumentFee;
    }

    @JsonProperty("offerDocumentFee")
    public void setOfferDocumentFee(String offerDocumentFee) {
        this.offerDocumentFee = offerDocumentFee;
    }

    @JsonProperty("docShowFeeRpt")
    public String getDocShowFeeRpt() {
        return docShowFeeRpt;
    }

    @JsonProperty("docShowFeeRpt")
    public void setDocShowFeeRpt(String docShowFeeRpt) {
        this.docShowFeeRpt = docShowFeeRpt;
    }

    @JsonProperty("docNetFee")
    public Double getDocNetFee() {
        return docNetFee;
    }

    @JsonProperty("docNetFee")
    public void setDocNetFee(Double docNetFee) {
        this.docNetFee = docNetFee;
    }

    @JsonProperty("docBaseOpFee")
    public Double getDocBaseOpFee() {
        return docBaseOpFee;
    }

    @JsonProperty("docBaseOpFee")
    public void setDocBaseOpFee(Double docBaseOpFee) {
        this.docBaseOpFee = docBaseOpFee;
    }

    @JsonProperty("docTotalFee")
    public Double getDocTotalFee() {
        return docTotalFee;
    }

    @JsonProperty("docTotalFee")
    public void setDocTotalFee(Double docTotalFee) {
        this.docTotalFee = docTotalFee;
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

    @JsonProperty("hasCertificate")
    public String getHasCertificate() {
        return hasCertificate;
    }

    @JsonProperty("hasCertificate")
    public void setHasCertificate(String hasCertificate) {
        this.hasCertificate = hasCertificate;
    }

    @JsonProperty("digitalSignatureFee")
    public Double getDigitalSignatureFee() {
        return digitalSignatureFee;
    }

    @JsonProperty("digitalSignatureFee")
    public void setDigitalSignatureFee(Double digitalSignatureFee) {
        this.digitalSignatureFee = digitalSignatureFee;
    }

    @JsonProperty("rightsManagementFee")
    public Double getRightsManagementFee() {
        return rightsManagementFee;
    }

    @JsonProperty("rightsManagementFee")
    public void setRightsManagementFee(Double rightsManagementFee) {
        this.rightsManagementFee = rightsManagementFee;
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

    @JsonProperty("pdfDeliverySubtype")
    public String getPdfDeliverySubtype() {
        return pdfDeliverySubtype;
    }

    @JsonProperty("pdfDeliverySubtype")
    public void setPdfDeliverySubtype(String pdfDeliverySubtype) {
        this.pdfDeliverySubtype = pdfDeliverySubtype;
    }

    @JsonProperty("orderProcessFeePaidBySchool")
    public String getOrderProcessFeePaidBySchool() {
        return orderProcessFeePaidBySchool;
    }

    @JsonProperty("orderProcessFeePaidBySchool")
    public void setOrderProcessFeePaidBySchool(String orderProcessFeePaidBySchool) {
        this.orderProcessFeePaidBySchool = orderProcessFeePaidBySchool;
    }

    @JsonProperty("stIdMaxLimit")
    public Double getStIdMaxLimit() {
        return stIdMaxLimit;
    }

    @JsonProperty("stIdMaxLimit")
    public void setStIdMaxLimit(Double stIdMaxLimit) {
        this.stIdMaxLimit = stIdMaxLimit;
    }

    @JsonProperty("feePathTypePub")
    public String getFeePathTypePub() {
        return feePathTypePub;
    }

    @JsonProperty("feePathTypePub")
    public void setFeePathTypePub(String feePathTypePub) {
        this.feePathTypePub = feePathTypePub;
    }

    @JsonProperty("feePathTypeSss")
    public String getFeePathTypeSss() {
        return feePathTypeSss;
    }

    @JsonProperty("feePathTypeSss")
    public void setFeePathTypeSss(String feePathTypeSss) {
        this.feePathTypeSss = feePathTypeSss;
    }

    @JsonProperty("feePathDesc")
    public String getFeePathDesc() {
        return feePathDesc;
    }

    @JsonProperty("feePathDesc")
    public void setFeePathDesc(String feePathDesc) {
        this.feePathDesc = feePathDesc;
    }

    @JsonProperty("baseOpFee")
    public Double getBaseOpFee() {
        return baseOpFee;
    }

    @JsonProperty("baseOpFee")
    public void setBaseOpFee(Double baseOpFee) {
        this.baseOpFee = baseOpFee;
    }

    @JsonProperty("hideOpFee")
    public String getHideOpFee() {
        return hideOpFee;
    }

    @JsonProperty("hideOpFee")
    public void setHideOpFee(String hideOpFee) {
        this.hideOpFee = hideOpFee;
    }

    @JsonProperty("overnightCarrier")
    public String getOvernightCarrier() {
        return overnightCarrier;
    }

    @JsonProperty("overnightCarrier")
    public void setOvernightCarrier(String overnightCarrier) {
        this.overnightCarrier = overnightCarrier;
    }

    @JsonProperty("sssReleaseForm")
    public String getSssReleaseForm() {
        return sssReleaseForm;
    }

    @JsonProperty("sssReleaseForm")
    public void setSssReleaseForm(String sssReleaseForm) {
        this.sssReleaseForm = sssReleaseForm;
    }

    @JsonProperty("showDataFilter")
    public String getShowDataFilter() {
        return showDataFilter;
    }

    @JsonProperty("showDataFilter")
    public void setShowDataFilter(String showDataFilter) {
        this.showDataFilter = showDataFilter;
    }

    @JsonProperty("allowFeeReduct")
    public String getAllowFeeReduct() {
        return allowFeeReduct;
    }

    @JsonProperty("allowFeeReduct")
    public void setAllowFeeReduct(String allowFeeReduct) {
        this.allowFeeReduct = allowFeeReduct;
    }

    @JsonProperty("chargeResend")
    public String getChargeResend() {
        return chargeResend;
    }

    @JsonProperty("chargeResend")
    public void setChargeResend(String chargeResend) {
        this.chargeResend = chargeResend;
    }

    @JsonProperty("dateEdited")
    public String getDateEdited() {
        return dateEdited;
    }

    @JsonProperty("dateEdited")
    public void setDateEdited(String dateEdited) {
        this.dateEdited = dateEdited;
    }

    @JsonProperty("qtyExpression")
    public String getQtyExpression() {
        return qtyExpression;
    }

    @JsonProperty("qtyExpression")
    public void setQtyExpression(String qtyExpression) {
        this.qtyExpression = qtyExpression;
    }

    @JsonProperty("qtyExpressionF")
    public String getQtyExpressionF() {
        return qtyExpressionF;
    }

    @JsonProperty("qtyExpressionF")
    public void setQtyExpressionF(String qtyExpressionF) {
        this.qtyExpressionF = qtyExpressionF;
    }

    @JsonProperty("outXmitMethod")
    public String getOutXmitMethod() {
        return outXmitMethod;
    }

    @JsonProperty("outXmitMethod")
    public void setOutXmitMethod(String outXmitMethod) {
        this.outXmitMethod = outXmitMethod;
    }

    @JsonProperty("outDataExchange")
    public String getOutDataExchange() {
        return outDataExchange;
    }

    @JsonProperty("outDataExchange")
    public void setOutDataExchange(String outDataExchange) {
        this.outDataExchange = outDataExchange;
    }

    @JsonProperty("outFileFormat")
    public String getOutFileFormat() {
        return outFileFormat;
    }

    @JsonProperty("outFileFormat")
    public void setOutFileFormat(String outFileFormat) {
        this.outFileFormat = outFileFormat;
    }

    @JsonProperty("outMapVersion")
    public String getOutMapVersion() {
        return outMapVersion;
    }

    @JsonProperty("outMapVersion")
    public void setOutMapVersion(String outMapVersion) {
        this.outMapVersion = outMapVersion;
    }

    @JsonProperty("outAcceptAttachments")
    public String getOutAcceptAttachments() {
        return outAcceptAttachments;
    }

    @JsonProperty("outAcceptAttachments")
    public void setOutAcceptAttachments(String outAcceptAttachments) {
        this.outAcceptAttachments = outAcceptAttachments;
    }

    @JsonProperty("cronExpression")
    public String getCronExpression() {
        return cronExpression;
    }

    @JsonProperty("cronExpression")
    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    @JsonProperty("inXmitMethod")
    public String getInXmitMethod() {
        return inXmitMethod;
    }

    @JsonProperty("inXmitMethod")
    public void setInXmitMethod(String inXmitMethod) {
        this.inXmitMethod = inXmitMethod;
    }

    @JsonProperty("inFileFormat")
    public String getInFileFormat() {
        return inFileFormat;
    }

    @JsonProperty("inFileFormat")
    public void setInFileFormat(String inFileFormat) {
        this.inFileFormat = inFileFormat;
    }

    @JsonProperty("xmitMailbox")
    public String getXmitMailbox() {
        return xmitMailbox;
    }

    @JsonProperty("xmitMailbox")
    public void setXmitMailbox(String xmitMailbox) {
        this.xmitMailbox = xmitMailbox;
    }

    @JsonProperty("outJobName")
    public String getOutJobName() {
        return outJobName;
    }

    @JsonProperty("outJobName")
    public void setOutJobName(String outJobName) {
        this.outJobName = outJobName;
    }

    @JsonProperty("outJobGroup")
    public String getOutJobGroup() {
        return outJobGroup;
    }

    @JsonProperty("outJobGroup")
    public void setOutJobGroup(String outJobGroup) {
        this.outJobGroup = outJobGroup;
    }

    @JsonProperty("outJobAlert")
    public Double getOutJobAlert() {
        return outJobAlert;
    }

    @JsonProperty("outJobAlert")
    public void setOutJobAlert(Double outJobAlert) {
        this.outJobAlert = outJobAlert;
    }

    @JsonProperty("newOrderAlert")
    public String getNewOrderAlert() {
        return newOrderAlert;
    }

    @JsonProperty("newOrderAlert")
    public void setNewOrderAlert(String newOrderAlert) {
        this.newOrderAlert = newOrderAlert;
    }

    @JsonProperty("allowMultiSchAccess")
    public String getAllowMultiSchAccess() {
        return allowMultiSchAccess;
    }

    @JsonProperty("allowMultiSchAccess")
    public void setAllowMultiSchAccess(String allowMultiSchAccess) {
        this.allowMultiSchAccess = allowMultiSchAccess;
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

    @JsonProperty("addDynamicWatermark")
    public String getAddDynamicWatermark() {
        return addDynamicWatermark;
    }

    @JsonProperty("addDynamicWatermark")
    public void setAddDynamicWatermark(String addDynamicWatermark) {
        this.addDynamicWatermark = addDynamicWatermark;
    }

    @JsonProperty("paperlessConsentForm")
    public String getPaperlessConsentForm() {
        return paperlessConsentForm;
    }

    @JsonProperty("paperlessConsentForm")
    public void setPaperlessConsentForm(String paperlessConsentForm) {
        this.paperlessConsentForm = paperlessConsentForm;
    }

    @JsonProperty("allowEtxOverride")
    public String getAllowEtxOverride() {
        return allowEtxOverride;
    }

    @JsonProperty("allowEtxOverride")
    public void setAllowEtxOverride(String allowEtxOverride) {
        this.allowEtxOverride = allowEtxOverride;
    }

    @JsonProperty("urlDataExchange")
    public String getUrlDataExchange() {
        return urlDataExchange;
    }

    @JsonProperty("urlDataExchange")
    public void setUrlDataExchange(String urlDataExchange) {
        this.urlDataExchange = urlDataExchange;
    }

    @JsonProperty("displaySendToSchoolOption")
    public String getDisplaySendToSchoolOption() {
        return displaySendToSchoolOption;
    }

    @JsonProperty("displaySendToSchoolOption")
    public void setDisplaySendToSchoolOption(String displaySendToSchoolOption) {
        this.displaySendToSchoolOption = displaySendToSchoolOption;
    }

    @JsonProperty("allowDocUpload")
    public String getAllowDocUpload() {
        return allowDocUpload;
    }

    @JsonProperty("allowDocUpload")
    public void setAllowDocUpload(String allowDocUpload) {
        this.allowDocUpload = allowDocUpload;
    }

    @JsonProperty("docUploadFormats")
    public String getDocUploadFormats() {
        return docUploadFormats;
    }

    @JsonProperty("docUploadFormats")
    public void setDocUploadFormats(String docUploadFormats) {
        this.docUploadFormats = docUploadFormats;
    }

    @JsonProperty("docUploadLimit")
    public Double getDocUploadLimit() {
        return docUploadLimit;
    }

    @JsonProperty("docUploadLimit")
    public void setDocUploadLimit(Double docUploadLimit) {
        this.docUploadLimit = docUploadLimit;
    }

    @JsonProperty("consentPSelf")
    public String getConsentPSelf() {
        return consentPSelf;
    }

    @JsonProperty("consentPSelf")
    public void setConsentPSelf(String consentPSelf) {
        this.consentPSelf = consentPSelf;
    }

    @JsonProperty("consentPThird")
    public String getConsentPThird() {
        return consentPThird;
    }

    @JsonProperty("consentPThird")
    public void setConsentPThird(String consentPThird) {
        this.consentPThird = consentPThird;
    }

    @JsonProperty("consentSSelf")
    public String getConsentSSelf() {
        return consentSSelf;
    }

    @JsonProperty("consentSSelf")
    public void setConsentSSelf(String consentSSelf) {
        this.consentSSelf = consentSSelf;
    }

    @JsonProperty("consentSThird")
    public String getConsentSThird() {
        return consentSThird;
    }

    @JsonProperty("consentSThird")
    public void setConsentSThird(String consentSThird) {
        this.consentSThird = consentSThird;
    }

    @JsonProperty("multipleStatusEmailHeader")
    public String getMultipleStatusEmailHeader() {
        return multipleStatusEmailHeader;
    }

    @JsonProperty("multipleStatusEmailHeader")
    public void setMultipleStatusEmailHeader(String multipleStatusEmailHeader) {
        this.multipleStatusEmailHeader = multipleStatusEmailHeader;
    }

    @JsonProperty("multipleStatusEmailFooter")
    public String getMultipleStatusEmailFooter() {
        return multipleStatusEmailFooter;
    }

    @JsonProperty("multipleStatusEmailFooter")
    public void setMultipleStatusEmailFooter(String multipleStatusEmailFooter) {
        this.multipleStatusEmailFooter = multipleStatusEmailFooter;
    }

    @JsonProperty("proceedWithHoldAllowed")
    public String getProceedWithHoldAllowed() {
        return proceedWithHoldAllowed;
    }

    @JsonProperty("proceedWithHoldAllowed")
    public void setProceedWithHoldAllowed(String proceedWithHoldAllowed) {
        this.proceedWithHoldAllowed = proceedWithHoldAllowed;
    }

    @JsonProperty("oborDeliveryEligibilityQuestion")
    public String getOborDeliveryEligibilityQuestion() {
        return oborDeliveryEligibilityQuestion;
    }

    @JsonProperty("oborDeliveryEligibilityQuestion")
    public void setOborDeliveryEligibilityQuestion(String oborDeliveryEligibilityQuestion) {
        this.oborDeliveryEligibilityQuestion = oborDeliveryEligibilityQuestion;
    }

    @JsonProperty("electronicDeliveryEligibilityQuestion")
    public String getElectronicDeliveryEligibilityQuestion() {
        return electronicDeliveryEligibilityQuestion;
    }

    @JsonProperty("electronicDeliveryEligibilityQuestion")
    public void setElectronicDeliveryEligibilityQuestion(String electronicDeliveryEligibilityQuestion) {
        this.electronicDeliveryEligibilityQuestion = electronicDeliveryEligibilityQuestion;
    }

    @JsonProperty("studentIdLabel")
    public String getStudentIdLabel() {
        return studentIdLabel;
    }

    @JsonProperty("studentIdLabel")
    public void setStudentIdLabel(String studentIdLabel) {
        this.studentIdLabel = studentIdLabel;
    }

    @JsonProperty("integrationProvider")
    public String getIntegrationProvider() {
        return integrationProvider;
    }

    @JsonProperty("integrationProvider")
    public void setIntegrationProvider(String integrationProvider) {
        this.integrationProvider = integrationProvider;
    }

    @JsonProperty("profileType")
    public String getProfileType() {
        return profileType;
    }

    @JsonProperty("profileType")
    public void setProfileType(String profileType) {
        this.profileType = profileType;
    }

    @JsonProperty("inclDocForDeliv")
    public String getInclDocForDeliv() {
        return inclDocForDeliv;
    }

    @JsonProperty("inclDocForDeliv")
    public void setInclDocForDeliv(String inclDocForDeliv) {
        this.inclDocForDeliv = inclDocForDeliv;
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

    @JsonProperty("allowPrintCustomFee")
    public String getAllowPrintCustomFee() {
        return allowPrintCustomFee;
    }

    @JsonProperty("allowPrintCustomFee")
    public void setAllowPrintCustomFee(String allowPrintCustomFee) {
        this.allowPrintCustomFee = allowPrintCustomFee;
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

    @JsonProperty("sssPathPlaceOrderOnly")
    public String getSssPathPlaceOrderOnly() {
        return sssPathPlaceOrderOnly;
    }

    @JsonProperty("sssPathPlaceOrderOnly")
    public void setSssPathPlaceOrderOnly(String sssPathPlaceOrderOnly) {
        this.sssPathPlaceOrderOnly = sssPathPlaceOrderOnly;
    }

    @JsonProperty("holdForPickup")
    public String getHoldForPickup() {
        return holdForPickup;
    }

    @JsonProperty("holdForPickup")
    public void setHoldForPickup(String holdForPickup) {
        this.holdForPickup = holdForPickup;
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
        return new ToStringBuilder(this).append("payOptions", payOptions).append("freeOptions", freeOptions).append("processingOptions", processingOptions).append("pdfDeliveryProfiles", pdfDeliveryProfiles).append("scOrderStatuses", scOrderStatuses).append("toSchoolNotes", toSchoolNotes).append("transcriptPurposes", transcriptPurposes).append("deptProcessingOptionInfos", deptProcessingOptionInfos).append("networkInfos", networkInfos).append("scCampus", scCampus).append("toScprofilDynmicIntgrtn", toScprofilDynmicIntgrtn).append("toSchoolHeader", toSchoolHeader).append("toScprofilId", toScprofilId).append("zeroFeePrgmId", zeroFeePrgmId).append("scprofilToken", scprofilToken).append("ficeCode", ficeCode).append("schlName", schlName).append("city", city).append("state", state).append("stdtPopulation", stdtPopulation).append("status", status).append("deliveryServiceOnly", deliveryServiceOnly).append("askSsn", askSsn).append("askStudentId", askStudentId).append("askConfirmStId", askConfirmStId).append("askFirstXcript", askFirstXcript).append("askCurrEnrolled", askCurrEnrolled).append("askSchools", askSchools).append("askSchoolsYears", askSchoolsYears).append("allowCampusTracking", allowCampusTracking).append("attendSchoolLabels", attendSchoolLabels).append("askEnrollYears", askEnrollYears).append("askDegrees", askDegrees).append("askStamped", askStamped).append("askXcriptType", askXcriptType).append("askXcriptPurpose", askXcriptPurpose).append("askTermYear", askTermYear).append("askUpdateScRec", askUpdateScRec).append("certOptions", certOptions).append("askCertSuboption", askCertSuboption).append("askCertColleges", askCertColleges).append("askSpecialInstr", askSpecialInstr).append("offerFax", offerFax).append("offerFaxF", offerFaxF).append("offerPickup", offerPickup).append("offerPickupF", offerPickupF).append("offerPublicaccess", offerPublicaccess).append("offerSelectschool", offerSelectschool).append("offerDocumentFee", offerDocumentFee).append("docShowFeeRpt", docShowFeeRpt).append("docNetFee", docNetFee).append("docBaseOpFee", docBaseOpFee).append("docTotalFee", docTotalFee).append("offerPdfDelivery", offerPdfDelivery).append("pdfDeliveryFee", pdfDeliveryFee).append("offerDigitalRightsOption", offerDigitalRightsOption).append("hasCertificate", hasCertificate).append("digitalSignatureFee", digitalSignatureFee).append("rightsManagementFee", rightsManagementFee).append("electronicDeliveryFeePaidBy", electronicDeliveryFeePaidBy).append("maxNumberViews", maxNumberViews).append("pdfDeliverySubtype", pdfDeliverySubtype).append("orderProcessFeePaidBySchool", orderProcessFeePaidBySchool).append("stIdMaxLimit", stIdMaxLimit).append("feePathTypePub", feePathTypePub).append("feePathTypeSss", feePathTypeSss).append("feePathDesc", feePathDesc).append("baseOpFee", baseOpFee).append("hideOpFee", hideOpFee).append("overnightCarrier", overnightCarrier).append("sssReleaseForm", sssReleaseForm).append("showDataFilter", showDataFilter).append("allowFeeReduct", allowFeeReduct).append("chargeResend", chargeResend).append("dateEdited", dateEdited).append("qtyExpression", qtyExpression).append("qtyExpressionF", qtyExpressionF).append("outXmitMethod", outXmitMethod).append("outDataExchange", outDataExchange).append("outFileFormat", outFileFormat).append("outMapVersion", outMapVersion).append("outAcceptAttachments", outAcceptAttachments).append("cronExpression", cronExpression).append("inXmitMethod", inXmitMethod).append("inFileFormat", inFileFormat).append("xmitMailbox", xmitMailbox).append("outJobName", outJobName).append("outJobGroup", outJobGroup).append("outJobAlert", outJobAlert).append("newOrderAlert", newOrderAlert).append("allowMultiSchAccess", allowMultiSchAccess).append("addWatermark", addWatermark).append("visibleDigitalSignature", visibleDigitalSignature).append("addDynamicWatermark", addDynamicWatermark).append("paperlessConsentForm", paperlessConsentForm).append("allowEtxOverride", allowEtxOverride).append("urlDataExchange", urlDataExchange).append("displaySendToSchoolOption", displaySendToSchoolOption).append("allowDocUpload", allowDocUpload).append("docUploadFormats", docUploadFormats).append("docUploadLimit", docUploadLimit).append("consentPSelf", consentPSelf).append("consentPThird", consentPThird).append("consentSSelf", consentSSelf).append("consentSThird", consentSThird).append("multipleStatusEmailHeader", multipleStatusEmailHeader).append("multipleStatusEmailFooter", multipleStatusEmailFooter).append("proceedWithHoldAllowed", proceedWithHoldAllowed).append("oborDeliveryEligibilityQuestion", oborDeliveryEligibilityQuestion).append("electronicDeliveryEligibilityQuestion", electronicDeliveryEligibilityQuestion).append("studentIdLabel", studentIdLabel).append("integrationProvider", integrationProvider).append("profileType", profileType).append("inclDocForDeliv", inclDocForDeliv).append("printOption", printOption).append("handleFeePaidBy", handleFeePaidBy).append("printVendorDeliveryFeePaidBy", printVendorDeliveryFeePaidBy).append("addPrintTemplate", addPrintTemplate).append("allowPrintCustomFee", allowPrintCustomFee).append("allowFormatEtx", allowFormatEtx).append("allowStaticDocUpload", allowStaticDocUpload).append("sssPathPlaceOrderOnly", sssPathPlaceOrderOnly).append("holdForPickup", holdForPickup).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(askCurrEnrolled).append(docBaseOpFee).append(scOrderStatuses).append(toSchoolHeader).append(stIdMaxLimit).append(qtyExpressionF).append(printVendorDeliveryFeePaidBy).append(chargeResend).append(pdfDeliveryProfiles).append(offerFax).append(outJobName).append(allowFormatEtx).append(outXmitMethod).append(profileType).append(askConfirmStId).append(askXcriptPurpose).append(offerPublicaccess).append(consentSThird).append(allowCampusTracking).append(state).append(docUploadLimit).append(offerDocumentFee).append(deptProcessingOptionInfos).append(docTotalFee).append(urlDataExchange).append(outJobGroup).append(askUpdateScRec).append(toSchoolNotes).append(ficeCode).append(offerPdfDelivery).append(addPrintTemplate).append(askStamped).append(outDataExchange).append(additionalProperties).append(offerPickupF).append(hideOpFee).append(sssReleaseForm).append(askCertColleges).append(status).append(scCampus).append(schlName).append(processingOptions).append(baseOpFee).append(allowPrintCustomFee).append(docNetFee).append(city).append(studentIdLabel).append(sssPathPlaceOrderOnly).append(pdfDeliveryFee).append(oborDeliveryEligibilityQuestion).append(feePathTypePub).append(docShowFeeRpt).append(displaySendToSchoolOption).append(holdForPickup).append(askEnrollYears).append(feePathTypeSss).append(networkInfos).append(deliveryServiceOnly).append(certOptions).append(allowStaticDocUpload).append(askSpecialInstr).append(inFileFormat).append(addDynamicWatermark).append(askDegrees).append(offerPickup).append(digitalSignatureFee).append(newOrderAlert).append(proceedWithHoldAllowed).append(feePathDesc).append(askXcriptType).append(inclDocForDeliv).append(orderProcessFeePaidBySchool).append(multipleStatusEmailFooter).append(scprofilToken).append(consentPSelf).append(toScprofilId).append(zeroFeePrgmId).append(printOption).append(electronicDeliveryFeePaidBy).append(overnightCarrier).append(askSchoolsYears).append(dateEdited).append(maxNumberViews).append(outMapVersion).append(rightsManagementFee).append(attendSchoolLabels).append(offerFaxF).append(outJobAlert).append(allowMultiSchAccess).append(askStudentId).append(paperlessConsentForm).append(integrationProvider).append(allowEtxOverride).append(inXmitMethod).append(electronicDeliveryEligibilityQuestion).append(offerDigitalRightsOption).append(allowDocUpload).append(toScprofilDynmicIntgrtn).append(transcriptPurposes).append(askTermYear).append(hasCertificate).append(showDataFilter).append(addWatermark).append(consentPThird).append(offerSelectschool).append(allowFeeReduct).append(qtyExpression).append(askSsn).append(outFileFormat).append(handleFeePaidBy).append(outAcceptAttachments).append(stdtPopulation).append(xmitMailbox).append(askFirstXcript).append(docUploadFormats).append(payOptions).append(cronExpression).append(visibleDigitalSignature).append(askSchools).append(multipleStatusEmailHeader).append(askCertSuboption).append(freeOptions).append(consentSSelf).append(pdfDeliverySubtype).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ResourceToscprofileDetail) == false) {
            return false;
        }
        ResourceToscprofileDetail rhs = ((ResourceToscprofileDetail) other);
        return new EqualsBuilder().append(askCurrEnrolled, rhs.askCurrEnrolled).append(docBaseOpFee, rhs.docBaseOpFee).append(scOrderStatuses, rhs.scOrderStatuses).append(toSchoolHeader, rhs.toSchoolHeader).append(stIdMaxLimit, rhs.stIdMaxLimit).append(qtyExpressionF, rhs.qtyExpressionF).append(printVendorDeliveryFeePaidBy, rhs.printVendorDeliveryFeePaidBy).append(chargeResend, rhs.chargeResend).append(pdfDeliveryProfiles, rhs.pdfDeliveryProfiles).append(offerFax, rhs.offerFax).append(outJobName, rhs.outJobName).append(allowFormatEtx, rhs.allowFormatEtx).append(outXmitMethod, rhs.outXmitMethod).append(profileType, rhs.profileType).append(askConfirmStId, rhs.askConfirmStId).append(askXcriptPurpose, rhs.askXcriptPurpose).append(offerPublicaccess, rhs.offerPublicaccess).append(consentSThird, rhs.consentSThird).append(allowCampusTracking, rhs.allowCampusTracking).append(state, rhs.state).append(docUploadLimit, rhs.docUploadLimit).append(offerDocumentFee, rhs.offerDocumentFee).append(deptProcessingOptionInfos, rhs.deptProcessingOptionInfos).append(docTotalFee, rhs.docTotalFee).append(urlDataExchange, rhs.urlDataExchange).append(outJobGroup, rhs.outJobGroup).append(askUpdateScRec, rhs.askUpdateScRec).append(toSchoolNotes, rhs.toSchoolNotes).append(ficeCode, rhs.ficeCode).append(offerPdfDelivery, rhs.offerPdfDelivery).append(addPrintTemplate, rhs.addPrintTemplate).append(askStamped, rhs.askStamped).append(outDataExchange, rhs.outDataExchange).append(additionalProperties, rhs.additionalProperties).append(offerPickupF, rhs.offerPickupF).append(hideOpFee, rhs.hideOpFee).append(sssReleaseForm, rhs.sssReleaseForm).append(askCertColleges, rhs.askCertColleges).append(status, rhs.status).append(scCampus, rhs.scCampus).append(schlName, rhs.schlName).append(processingOptions, rhs.processingOptions).append(baseOpFee, rhs.baseOpFee).append(allowPrintCustomFee, rhs.allowPrintCustomFee).append(docNetFee, rhs.docNetFee).append(city, rhs.city).append(studentIdLabel, rhs.studentIdLabel).append(sssPathPlaceOrderOnly, rhs.sssPathPlaceOrderOnly).append(pdfDeliveryFee, rhs.pdfDeliveryFee).append(oborDeliveryEligibilityQuestion, rhs.oborDeliveryEligibilityQuestion).append(feePathTypePub, rhs.feePathTypePub).append(docShowFeeRpt, rhs.docShowFeeRpt).append(displaySendToSchoolOption, rhs.displaySendToSchoolOption).append(holdForPickup, rhs.holdForPickup).append(askEnrollYears, rhs.askEnrollYears).append(feePathTypeSss, rhs.feePathTypeSss).append(networkInfos, rhs.networkInfos).append(deliveryServiceOnly, rhs.deliveryServiceOnly).append(certOptions, rhs.certOptions).append(allowStaticDocUpload, rhs.allowStaticDocUpload).append(askSpecialInstr, rhs.askSpecialInstr).append(inFileFormat, rhs.inFileFormat).append(addDynamicWatermark, rhs.addDynamicWatermark).append(askDegrees, rhs.askDegrees).append(offerPickup, rhs.offerPickup).append(digitalSignatureFee, rhs.digitalSignatureFee).append(newOrderAlert, rhs.newOrderAlert).append(proceedWithHoldAllowed, rhs.proceedWithHoldAllowed).append(feePathDesc, rhs.feePathDesc).append(askXcriptType, rhs.askXcriptType).append(inclDocForDeliv, rhs.inclDocForDeliv).append(orderProcessFeePaidBySchool, rhs.orderProcessFeePaidBySchool).append(multipleStatusEmailFooter, rhs.multipleStatusEmailFooter).append(scprofilToken, rhs.scprofilToken).append(consentPSelf, rhs.consentPSelf).append(toScprofilId, rhs.toScprofilId).append(zeroFeePrgmId, rhs.zeroFeePrgmId).append(printOption, rhs.printOption).append(electronicDeliveryFeePaidBy, rhs.electronicDeliveryFeePaidBy).append(overnightCarrier, rhs.overnightCarrier).append(askSchoolsYears, rhs.askSchoolsYears).append(dateEdited, rhs.dateEdited).append(maxNumberViews, rhs.maxNumberViews).append(outMapVersion, rhs.outMapVersion).append(rightsManagementFee, rhs.rightsManagementFee).append(attendSchoolLabels, rhs.attendSchoolLabels).append(offerFaxF, rhs.offerFaxF).append(outJobAlert, rhs.outJobAlert).append(allowMultiSchAccess, rhs.allowMultiSchAccess).append(askStudentId, rhs.askStudentId).append(paperlessConsentForm, rhs.paperlessConsentForm).append(integrationProvider, rhs.integrationProvider).append(allowEtxOverride, rhs.allowEtxOverride).append(inXmitMethod, rhs.inXmitMethod).append(electronicDeliveryEligibilityQuestion, rhs.electronicDeliveryEligibilityQuestion).append(offerDigitalRightsOption, rhs.offerDigitalRightsOption).append(allowDocUpload, rhs.allowDocUpload).append(toScprofilDynmicIntgrtn, rhs.toScprofilDynmicIntgrtn).append(transcriptPurposes, rhs.transcriptPurposes).append(askTermYear, rhs.askTermYear).append(hasCertificate, rhs.hasCertificate).append(showDataFilter, rhs.showDataFilter).append(addWatermark, rhs.addWatermark).append(consentPThird, rhs.consentPThird).append(offerSelectschool, rhs.offerSelectschool).append(allowFeeReduct, rhs.allowFeeReduct).append(qtyExpression, rhs.qtyExpression).append(askSsn, rhs.askSsn).append(outFileFormat, rhs.outFileFormat).append(handleFeePaidBy, rhs.handleFeePaidBy).append(outAcceptAttachments, rhs.outAcceptAttachments).append(stdtPopulation, rhs.stdtPopulation).append(xmitMailbox, rhs.xmitMailbox).append(askFirstXcript, rhs.askFirstXcript).append(docUploadFormats, rhs.docUploadFormats).append(payOptions, rhs.payOptions).append(cronExpression, rhs.cronExpression).append(visibleDigitalSignature, rhs.visibleDigitalSignature).append(askSchools, rhs.askSchools).append(multipleStatusEmailHeader, rhs.multipleStatusEmailHeader).append(askCertSuboption, rhs.askCertSuboption).append(freeOptions, rhs.freeOptions).append(consentSSelf, rhs.consentSSelf).append(pdfDeliverySubtype, rhs.pdfDeliverySubtype).isEquals();
    }

}
