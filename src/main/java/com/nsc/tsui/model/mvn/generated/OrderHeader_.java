
package com.nsc.tsui.model.mvn.generated;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "toOrderId",
    "toScprofilId",
    "chFlag",
    "referMethod",
    "reqIdentifierType",
    "requireReleaseFm",
    "preauthPaymentId",
    "paymentStatus",
    "scOrderStatusId",
    "orderStatus",
    "orderDate",
    "userIp",
    "feePathType",
    "feePathDesc",
    "preauthFee",
    "totalFee",
    "totalFeePaid",
    "prfNotifiedDt",
    "createdTimestamp",
    "paperlessConsentFormAllowed",
    "consentTypeUsed",
    "consentTypeAllowed",
    "archiveStudent"
})
public class OrderHeader_ {

    @JsonProperty("toOrderId")
    private Integer toOrderId;
    @JsonProperty("toScprofilId")
    private Integer toScprofilId;
    @JsonProperty("chFlag")
    private String chFlag;
    @JsonProperty("referMethod")
    private String referMethod;
    @JsonProperty("reqIdentifierType")
    private Integer reqIdentifierType;
    @JsonProperty("requireReleaseFm")
    private String requireReleaseFm;
    @JsonProperty("preauthPaymentId")
    private Integer preauthPaymentId;
    @JsonProperty("paymentStatus")
    private String paymentStatus;
    @JsonProperty("scOrderStatusId")
    private Integer scOrderStatusId;
    @JsonProperty("orderStatus")
    private String orderStatus;
    /**
     * The date and time (YYYY-MM-DD HH:mm:ss:SSS) that the order was created
     * 
     */
    @JsonProperty("orderDate")
    @JsonPropertyDescription("The date and time (YYYY-MM-DD HH:mm:ss:SSS) that the order was created")
    private String orderDate;
    @JsonProperty("userIp")
    private String userIp;
    @JsonProperty("feePathType")
    private String feePathType;
    @JsonProperty("feePathDesc")
    private String feePathDesc;
    @JsonProperty("preauthFee")
    private Double preauthFee;
    @JsonProperty("totalFee")
    private Double totalFee;
    @JsonProperty("totalFeePaid")
    private Double totalFeePaid;
    @JsonProperty("prfNotifiedDt")
    private Object prfNotifiedDt;
    @JsonProperty("createdTimestamp")
    private String createdTimestamp;
    @JsonProperty("paperlessConsentFormAllowed")
    private String paperlessConsentFormAllowed;
    @JsonProperty("consentTypeUsed")
    private String consentTypeUsed;
    @JsonProperty("consentTypeAllowed")
    private String consentTypeAllowed;
    @JsonProperty("archiveStudent")
    private String archiveStudent;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("toOrderId")
    public Integer getToOrderId() {
        return toOrderId;
    }

    @JsonProperty("toOrderId")
    public void setToOrderId(Integer toOrderId) {
        this.toOrderId = toOrderId;
    }

    @JsonProperty("toScprofilId")
    public Integer getToScprofilId() {
        return toScprofilId;
    }

    @JsonProperty("toScprofilId")
    public void setToScprofilId(Integer toScprofilId) {
        this.toScprofilId = toScprofilId;
    }

    @JsonProperty("chFlag")
    public String getChFlag() {
        return chFlag;
    }

    @JsonProperty("chFlag")
    public void setChFlag(String chFlag) {
        this.chFlag = chFlag;
    }

    @JsonProperty("referMethod")
    public String getReferMethod() {
        return referMethod;
    }

    @JsonProperty("referMethod")
    public void setReferMethod(String referMethod) {
        this.referMethod = referMethod;
    }

    @JsonProperty("reqIdentifierType")
    public Integer getReqIdentifierType() {
        return reqIdentifierType;
    }

    @JsonProperty("reqIdentifierType")
    public void setReqIdentifierType(Integer reqIdentifierType) {
        this.reqIdentifierType = reqIdentifierType;
    }

    @JsonProperty("requireReleaseFm")
    public String getRequireReleaseFm() {
        return requireReleaseFm;
    }

    @JsonProperty("requireReleaseFm")
    public void setRequireReleaseFm(String requireReleaseFm) {
        this.requireReleaseFm = requireReleaseFm;
    }

    @JsonProperty("preauthPaymentId")
    public Integer getPreauthPaymentId() {
        return preauthPaymentId;
    }

    @JsonProperty("preauthPaymentId")
    public void setPreauthPaymentId(Integer preauthPaymentId) {
        this.preauthPaymentId = preauthPaymentId;
    }

    @JsonProperty("paymentStatus")
    public String getPaymentStatus() {
        return paymentStatus;
    }

    @JsonProperty("paymentStatus")
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
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

    /**
     * The date and time (YYYY-MM-DD HH:mm:ss:SSS) that the order was created
     * 
     */
    @JsonProperty("orderDate")
    public String getOrderDate() {
        return orderDate;
    }

    /**
     * The date and time (YYYY-MM-DD HH:mm:ss:SSS) that the order was created
     * 
     */
    @JsonProperty("orderDate")
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    @JsonProperty("userIp")
    public String getUserIp() {
        return userIp;
    }

    @JsonProperty("userIp")
    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    @JsonProperty("feePathType")
    public String getFeePathType() {
        return feePathType;
    }

    @JsonProperty("feePathType")
    public void setFeePathType(String feePathType) {
        this.feePathType = feePathType;
    }

    @JsonProperty("feePathDesc")
    public String getFeePathDesc() {
        return feePathDesc;
    }

    @JsonProperty("feePathDesc")
    public void setFeePathDesc(String feePathDesc) {
        this.feePathDesc = feePathDesc;
    }

    @JsonProperty("preauthFee")
    public Double getPreauthFee() {
        return preauthFee;
    }

    @JsonProperty("preauthFee")
    public void setPreauthFee(Double preauthFee) {
        this.preauthFee = preauthFee;
    }

    @JsonProperty("totalFee")
    public Double getTotalFee() {
        return totalFee;
    }

    @JsonProperty("totalFee")
    public void setTotalFee(Double totalFee) {
        this.totalFee = totalFee;
    }

    @JsonProperty("totalFeePaid")
    public Double getTotalFeePaid() {
        return totalFeePaid;
    }

    @JsonProperty("totalFeePaid")
    public void setTotalFeePaid(Double totalFeePaid) {
        this.totalFeePaid = totalFeePaid;
    }

    @JsonProperty("prfNotifiedDt")
    public Object getPrfNotifiedDt() {
        return prfNotifiedDt;
    }

    @JsonProperty("prfNotifiedDt")
    public void setPrfNotifiedDt(Object prfNotifiedDt) {
        this.prfNotifiedDt = prfNotifiedDt;
    }

    @JsonProperty("createdTimestamp")
    public String getCreatedTimestamp() {
        return createdTimestamp;
    }

    @JsonProperty("createdTimestamp")
    public void setCreatedTimestamp(String createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    @JsonProperty("paperlessConsentFormAllowed")
    public String getPaperlessConsentFormAllowed() {
        return paperlessConsentFormAllowed;
    }

    @JsonProperty("paperlessConsentFormAllowed")
    public void setPaperlessConsentFormAllowed(String paperlessConsentFormAllowed) {
        this.paperlessConsentFormAllowed = paperlessConsentFormAllowed;
    }

    @JsonProperty("consentTypeUsed")
    public String getConsentTypeUsed() {
        return consentTypeUsed;
    }

    @JsonProperty("consentTypeUsed")
    public void setConsentTypeUsed(String consentTypeUsed) {
        this.consentTypeUsed = consentTypeUsed;
    }

    @JsonProperty("consentTypeAllowed")
    public String getConsentTypeAllowed() {
        return consentTypeAllowed;
    }

    @JsonProperty("consentTypeAllowed")
    public void setConsentTypeAllowed(String consentTypeAllowed) {
        this.consentTypeAllowed = consentTypeAllowed;
    }

    @JsonProperty("archiveStudent")
    public String getArchiveStudent() {
        return archiveStudent;
    }

    @JsonProperty("archiveStudent")
    public void setArchiveStudent(String archiveStudent) {
        this.archiveStudent = archiveStudent;
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
        return new ToStringBuilder(this).append("toOrderId", toOrderId).append("toScprofilId", toScprofilId).append("chFlag", chFlag).append("referMethod", referMethod).append("reqIdentifierType", reqIdentifierType).append("requireReleaseFm", requireReleaseFm).append("preauthPaymentId", preauthPaymentId).append("paymentStatus", paymentStatus).append("scOrderStatusId", scOrderStatusId).append("orderStatus", orderStatus).append("orderDate", orderDate).append("userIp", userIp).append("feePathType", feePathType).append("feePathDesc", feePathDesc).append("preauthFee", preauthFee).append("totalFee", totalFee).append("totalFeePaid", totalFeePaid).append("prfNotifiedDt", prfNotifiedDt).append("createdTimestamp", createdTimestamp).append("paperlessConsentFormAllowed", paperlessConsentFormAllowed).append("consentTypeUsed", consentTypeUsed).append("consentTypeAllowed", consentTypeAllowed).append("archiveStudent", archiveStudent).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(feePathDesc).append(orderStatus).append(requireReleaseFm).append(totalFeePaid).append(toScprofilId).append(preauthFee).append(prfNotifiedDt).append(reqIdentifierType).append(referMethod).append(paymentStatus).append(consentTypeAllowed).append(feePathType).append(toOrderId).append(consentTypeUsed).append(createdTimestamp).append(paperlessConsentFormAllowed).append(preauthPaymentId).append(archiveStudent).append(totalFee).append(scOrderStatusId).append(userIp).append(chFlag).append(additionalProperties).append(orderDate).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof OrderHeader_) == false) {
            return false;
        }
        OrderHeader_ rhs = ((OrderHeader_) other);
        return new EqualsBuilder().append(feePathDesc, rhs.feePathDesc).append(orderStatus, rhs.orderStatus).append(requireReleaseFm, rhs.requireReleaseFm).append(totalFeePaid, rhs.totalFeePaid).append(toScprofilId, rhs.toScprofilId).append(preauthFee, rhs.preauthFee).append(prfNotifiedDt, rhs.prfNotifiedDt).append(reqIdentifierType, rhs.reqIdentifierType).append(referMethod, rhs.referMethod).append(paymentStatus, rhs.paymentStatus).append(consentTypeAllowed, rhs.consentTypeAllowed).append(feePathType, rhs.feePathType).append(toOrderId, rhs.toOrderId).append(consentTypeUsed, rhs.consentTypeUsed).append(createdTimestamp, rhs.createdTimestamp).append(paperlessConsentFormAllowed, rhs.paperlessConsentFormAllowed).append(preauthPaymentId, rhs.preauthPaymentId).append(archiveStudent, rhs.archiveStudent).append(totalFee, rhs.totalFee).append(scOrderStatusId, rhs.scOrderStatusId).append(userIp, rhs.userIp).append(chFlag, rhs.chFlag).append(additionalProperties, rhs.additionalProperties).append(orderDate, rhs.orderDate).isEquals();
    }

}
