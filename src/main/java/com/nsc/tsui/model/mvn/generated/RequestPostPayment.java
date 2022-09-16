
package com.nsc.tsui.model.mvn.generated;

import java.util.HashMap;
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
 * PaymentDetail
 * <p>
 * An object including payment details
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "paymentId",
    "payeezyToken",
    "ccAmount",
    "ccType",
    "ccExpiryMonth",
    "ccExpiryYear",
    "ccName",
    "billStreet1",
    "billStreet2",
    "billCity",
    "billState",
    "billZip",
    "billCountry",
    "billPhone"
})
public class RequestPostPayment {

    @JsonProperty("paymentId")
    private Integer paymentId;
    @JsonProperty("payeezyToken")
    private String payeezyToken;
    @JsonProperty("ccAmount")
    private Double ccAmount;
    @JsonProperty("ccType")
    private String ccType;
    @JsonProperty("ccExpiryMonth")
    private String ccExpiryMonth;
    @JsonProperty("ccExpiryYear")
    private String ccExpiryYear;
    @JsonProperty("ccName")
    private String ccName;
    @JsonProperty("billStreet1")
    private String billStreet1;
    @JsonProperty("billStreet2")
    private String billStreet2;
    @JsonProperty("billCity")
    private String billCity;
    @JsonProperty("billState")
    private String billState;
    @JsonProperty("billZip")
    private String billZip;
    @JsonProperty("billCountry")
    private String billCountry;
    @JsonProperty("billPhone")
    private String billPhone;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("paymentId")
    public Integer getPaymentId() {
        return paymentId;
    }

    @JsonProperty("paymentId")
    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    @JsonProperty("payeezyToken")
    public String getPayeezyToken() {
        return payeezyToken;
    }

    @JsonProperty("payeezyToken")
    public void setPayeezyToken(String payeezyToken) {
        this.payeezyToken = payeezyToken;
    }

    @JsonProperty("ccAmount")
    public Double getCcAmount() {
        return ccAmount;
    }

    @JsonProperty("ccAmount")
    public void setCcAmount(Double ccAmount) {
        this.ccAmount = ccAmount;
    }

    @JsonProperty("ccType")
    public String getCcType() {
        return ccType;
    }

    @JsonProperty("ccType")
    public void setCcType(String ccType) {
        this.ccType = ccType;
    }

    @JsonProperty("ccExpiryMonth")
    public String getCcExpiryMonth() {
        return ccExpiryMonth;
    }

    @JsonProperty("ccExpiryMonth")
    public void setCcExpiryMonth(String ccExpiryMonth) {
        this.ccExpiryMonth = ccExpiryMonth;
    }

    @JsonProperty("ccExpiryYear")
    public String getCcExpiryYear() {
        return ccExpiryYear;
    }

    @JsonProperty("ccExpiryYear")
    public void setCcExpiryYear(String ccExpiryYear) {
        this.ccExpiryYear = ccExpiryYear;
    }

    @JsonProperty("ccName")
    public String getCcName() {
        return ccName;
    }

    @JsonProperty("ccName")
    public void setCcName(String ccName) {
        this.ccName = ccName;
    }

    @JsonProperty("billStreet1")
    public String getBillStreet1() {
        return billStreet1;
    }

    @JsonProperty("billStreet1")
    public void setBillStreet1(String billStreet1) {
        this.billStreet1 = billStreet1;
    }

    @JsonProperty("billStreet2")
    public String getBillStreet2() {
        return billStreet2;
    }

    @JsonProperty("billStreet2")
    public void setBillStreet2(String billStreet2) {
        this.billStreet2 = billStreet2;
    }

    @JsonProperty("billCity")
    public String getBillCity() {
        return billCity;
    }

    @JsonProperty("billCity")
    public void setBillCity(String billCity) {
        this.billCity = billCity;
    }

    @JsonProperty("billState")
    public String getBillState() {
        return billState;
    }

    @JsonProperty("billState")
    public void setBillState(String billState) {
        this.billState = billState;
    }

    @JsonProperty("billZip")
    public String getBillZip() {
        return billZip;
    }

    @JsonProperty("billZip")
    public void setBillZip(String billZip) {
        this.billZip = billZip;
    }

    @JsonProperty("billCountry")
    public String getBillCountry() {
        return billCountry;
    }

    @JsonProperty("billCountry")
    public void setBillCountry(String billCountry) {
        this.billCountry = billCountry;
    }

    @JsonProperty("billPhone")
    public String getBillPhone() {
        return billPhone;
    }

    @JsonProperty("billPhone")
    public void setBillPhone(String billPhone) {
        this.billPhone = billPhone;
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
        return new ToStringBuilder(this).append("paymentId", paymentId).append("payeezyToken", payeezyToken).append("ccAmount", ccAmount).append("ccType", ccType).append("ccExpiryMonth", ccExpiryMonth).append("ccExpiryYear", ccExpiryYear).append("ccName", ccName).append("billStreet1", billStreet1).append("billStreet2", billStreet2).append("billCity", billCity).append("billState", billState).append("billZip", billZip).append("billCountry", billCountry).append("billPhone", billPhone).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(ccExpiryMonth).append(payeezyToken).append(ccExpiryYear).append(ccAmount).append(billState).append(billZip).append(ccName).append(billCity).append(ccType).append(billStreet1).append(billPhone).append(paymentId).append(billCountry).append(additionalProperties).append(billStreet2).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RequestPostPayment) == false) {
            return false;
        }
        RequestPostPayment rhs = ((RequestPostPayment) other);
        return new EqualsBuilder().append(ccExpiryMonth, rhs.ccExpiryMonth).append(payeezyToken, rhs.payeezyToken).append(ccExpiryYear, rhs.ccExpiryYear).append(ccAmount, rhs.ccAmount).append(billState, rhs.billState).append(billZip, rhs.billZip).append(ccName, rhs.ccName).append(billCity, rhs.billCity).append(ccType, rhs.ccType).append(billStreet1, rhs.billStreet1).append(billPhone, rhs.billPhone).append(paymentId, rhs.paymentId).append(billCountry, rhs.billCountry).append(additionalProperties, rhs.additionalProperties).append(billStreet2, rhs.billStreet2).isEquals();
    }

}
