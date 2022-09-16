
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
    "deliveryMethodId",
    "toScprofilId",
    "fee",
    "displayWithFee",
    "helpText",
    "feePathType",
    "xmitCodeId",
    "display",
    "status",
    "printVendorFee",
    "handleFee",
    "isPrint",
    "emailHelpText",
    "deliveryMethodType",
    "requestorFee",
    "deliveryMethodCategory"
})
public class DeliveryMethod {

    /**
     * The unique identifier for a delivery method
     * (Required)
     * 
     */
    @JsonProperty("deliveryMethodId")
    @JsonPropertyDescription("The unique identifier for a delivery method")
    private Integer deliveryMethodId;
    /**
     * The TO school profile the delivery method is associated with
     * 
     */
    @JsonProperty("toScprofilId")
    @JsonPropertyDescription("The TO school profile the delivery method is associated with")
    private Integer toScprofilId;
    /**
     * todo
     * (Required)
     * 
     */
    @JsonProperty("fee")
    @JsonPropertyDescription("todo")
    private Double fee;
    /**
     * todo
     * (Required)
     * 
     */
    @JsonProperty("displayWithFee")
    @JsonPropertyDescription("todo")
    private String displayWithFee;
    /**
     * todo
     * 
     */
    @JsonProperty("helpText")
    @JsonPropertyDescription("todo")
    private String helpText;
    /**
     * todo
     * (Required)
     * 
     */
    @JsonProperty("feePathType")
    @JsonPropertyDescription("todo")
    private String feePathType;
    /**
     * todo
     * 
     */
    @JsonProperty("xmitCodeId")
    @JsonPropertyDescription("todo")
    private Integer xmitCodeId;
    /**
     * todo
     * 
     */
    @JsonProperty("display")
    @JsonPropertyDescription("todo")
    private String display;
    /**
     * todo
     * 
     */
    @JsonProperty("status")
    @JsonPropertyDescription("todo")
    private String status;
    /**
     * todo
     * 
     */
    @JsonProperty("printVendorFee")
    @JsonPropertyDescription("todo")
    private Double printVendorFee;
    /**
     * todo
     * 
     */
    @JsonProperty("handleFee")
    @JsonPropertyDescription("todo")
    private Double handleFee;
    /**
     * todo
     * 
     */
    @JsonProperty("isPrint")
    @JsonPropertyDescription("todo")
    private String isPrint;
    /**
     * todo
     * 
     */
    @JsonProperty("emailHelpText")
    @JsonPropertyDescription("todo")
    private String emailHelpText;
    @JsonProperty("deliveryMethodType")
    private String deliveryMethodType;
    /**
     * todo
     * 
     */
    @JsonProperty("requestorFee")
    @JsonPropertyDescription("todo")
    private Double requestorFee;
    /**
     * The delivery method category G (standard) or R (rush)
     * 
     */
    @JsonProperty("deliveryMethodCategory")
    @JsonPropertyDescription("The delivery method category G (standard) or R (rush)")
    private String deliveryMethodCategory;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * The unique identifier for a delivery method
     * (Required)
     * 
     */
    @JsonProperty("deliveryMethodId")
    public Integer getDeliveryMethodId() {
        return deliveryMethodId;
    }

    /**
     * The unique identifier for a delivery method
     * (Required)
     * 
     */
    @JsonProperty("deliveryMethodId")
    public void setDeliveryMethodId(Integer deliveryMethodId) {
        this.deliveryMethodId = deliveryMethodId;
    }

    /**
     * The TO school profile the delivery method is associated with
     * 
     */
    @JsonProperty("toScprofilId")
    public Integer getToScprofilId() {
        return toScprofilId;
    }

    /**
     * The TO school profile the delivery method is associated with
     * 
     */
    @JsonProperty("toScprofilId")
    public void setToScprofilId(Integer toScprofilId) {
        this.toScprofilId = toScprofilId;
    }

    /**
     * todo
     * (Required)
     * 
     */
    @JsonProperty("fee")
    public Double getFee() {
        return fee;
    }

    /**
     * todo
     * (Required)
     * 
     */
    @JsonProperty("fee")
    public void setFee(Double fee) {
        this.fee = fee;
    }

    /**
     * todo
     * (Required)
     * 
     */
    @JsonProperty("displayWithFee")
    public String getDisplayWithFee() {
        return displayWithFee;
    }

    /**
     * todo
     * (Required)
     * 
     */
    @JsonProperty("displayWithFee")
    public void setDisplayWithFee(String displayWithFee) {
        this.displayWithFee = displayWithFee;
    }

    /**
     * todo
     * 
     */
    @JsonProperty("helpText")
    public String getHelpText() {
        return helpText;
    }

    /**
     * todo
     * 
     */
    @JsonProperty("helpText")
    public void setHelpText(String helpText) {
        this.helpText = helpText;
    }

    /**
     * todo
     * (Required)
     * 
     */
    @JsonProperty("feePathType")
    public String getFeePathType() {
        return feePathType;
    }

    /**
     * todo
     * (Required)
     * 
     */
    @JsonProperty("feePathType")
    public void setFeePathType(String feePathType) {
        this.feePathType = feePathType;
    }

    /**
     * todo
     * 
     */
    @JsonProperty("xmitCodeId")
    public Integer getXmitCodeId() {
        return xmitCodeId;
    }

    /**
     * todo
     * 
     */
    @JsonProperty("xmitCodeId")
    public void setXmitCodeId(Integer xmitCodeId) {
        this.xmitCodeId = xmitCodeId;
    }

    /**
     * todo
     * 
     */
    @JsonProperty("display")
    public String getDisplay() {
        return display;
    }

    /**
     * todo
     * 
     */
    @JsonProperty("display")
    public void setDisplay(String display) {
        this.display = display;
    }

    /**
     * todo
     * 
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * todo
     * 
     */
    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * todo
     * 
     */
    @JsonProperty("printVendorFee")
    public Double getPrintVendorFee() {
        return printVendorFee;
    }

    /**
     * todo
     * 
     */
    @JsonProperty("printVendorFee")
    public void setPrintVendorFee(Double printVendorFee) {
        this.printVendorFee = printVendorFee;
    }

    /**
     * todo
     * 
     */
    @JsonProperty("handleFee")
    public Double getHandleFee() {
        return handleFee;
    }

    /**
     * todo
     * 
     */
    @JsonProperty("handleFee")
    public void setHandleFee(Double handleFee) {
        this.handleFee = handleFee;
    }

    /**
     * todo
     * 
     */
    @JsonProperty("isPrint")
    public String getIsPrint() {
        return isPrint;
    }

    /**
     * todo
     * 
     */
    @JsonProperty("isPrint")
    public void setIsPrint(String isPrint) {
        this.isPrint = isPrint;
    }

    /**
     * todo
     * 
     */
    @JsonProperty("emailHelpText")
    public String getEmailHelpText() {
        return emailHelpText;
    }

    /**
     * todo
     * 
     */
    @JsonProperty("emailHelpText")
    public void setEmailHelpText(String emailHelpText) {
        this.emailHelpText = emailHelpText;
    }

    @JsonProperty("deliveryMethodType")
    public String getDeliveryMethodType() {
        return deliveryMethodType;
    }

    @JsonProperty("deliveryMethodType")
    public void setDeliveryMethodType(String deliveryMethodType) {
        this.deliveryMethodType = deliveryMethodType;
    }

    /**
     * todo
     * 
     */
    @JsonProperty("requestorFee")
    public Double getRequestorFee() {
        return requestorFee;
    }

    /**
     * todo
     * 
     */
    @JsonProperty("requestorFee")
    public void setRequestorFee(Double requestorFee) {
        this.requestorFee = requestorFee;
    }

    /**
     * The delivery method category G (standard) or R (rush)
     * 
     */
    @JsonProperty("deliveryMethodCategory")
    public String getDeliveryMethodCategory() {
        return deliveryMethodCategory;
    }

    /**
     * The delivery method category G (standard) or R (rush)
     * 
     */
    @JsonProperty("deliveryMethodCategory")
    public void setDeliveryMethodCategory(String deliveryMethodCategory) {
        this.deliveryMethodCategory = deliveryMethodCategory;
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
        return new ToStringBuilder(this).append("deliveryMethodId", deliveryMethodId).append("toScprofilId", toScprofilId).append("fee", fee).append("displayWithFee", displayWithFee).append("helpText", helpText).append("feePathType", feePathType).append("xmitCodeId", xmitCodeId).append("display", display).append("status", status).append("printVendorFee", printVendorFee).append("handleFee", handleFee).append("isPrint", isPrint).append("emailHelpText", emailHelpText).append("deliveryMethodType", deliveryMethodType).append("requestorFee", requestorFee).append("deliveryMethodCategory", deliveryMethodCategory).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(deliveryMethodId).append(helpText).append(feePathType).append(fee).append(display).append(emailHelpText).append(isPrint).append(deliveryMethodType).append(handleFee).append(displayWithFee).append(printVendorFee).append(toScprofilId).append(xmitCodeId).append(deliveryMethodCategory).append(requestorFee).append(additionalProperties).append(status).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DeliveryMethod) == false) {
            return false;
        }
        DeliveryMethod rhs = ((DeliveryMethod) other);
        return new EqualsBuilder().append(deliveryMethodId, rhs.deliveryMethodId).append(helpText, rhs.helpText).append(feePathType, rhs.feePathType).append(fee, rhs.fee).append(display, rhs.display).append(emailHelpText, rhs.emailHelpText).append(isPrint, rhs.isPrint).append(deliveryMethodType, rhs.deliveryMethodType).append(handleFee, rhs.handleFee).append(displayWithFee, rhs.displayWithFee).append(printVendorFee, rhs.printVendorFee).append(toScprofilId, rhs.toScprofilId).append(xmitCodeId, rhs.xmitCodeId).append(deliveryMethodCategory, rhs.deliveryMethodCategory).append(requestorFee, rhs.requestorFee).append(additionalProperties, rhs.additionalProperties).append(status, rhs.status).isEquals();
    }

}
