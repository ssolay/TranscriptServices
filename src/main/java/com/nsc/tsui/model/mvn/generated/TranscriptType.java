
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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "xcriptTypeId",
    "toScprofilId",
    "fee",
    "displayWithFee",
    "feePathType",
    "status",
    "xmitCodeId",
    "display"
})
public class TranscriptType {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("xcriptTypeId")
    private Integer xcriptTypeId;
    @JsonProperty("toScprofilId")
    private Integer toScprofilId;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("fee")
    private Double fee;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("displayWithFee")
    private String displayWithFee;
    @JsonProperty("feePathType")
    private String feePathType;
    @JsonProperty("status")
    private String status;
    @JsonProperty("xmitCodeId")
    private Integer xmitCodeId;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("display")
    private String display;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("xcriptTypeId")
    public Integer getXcriptTypeId() {
        return xcriptTypeId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("xcriptTypeId")
    public void setXcriptTypeId(Integer xcriptTypeId) {
        this.xcriptTypeId = xcriptTypeId;
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
     * 
     * (Required)
     * 
     */
    @JsonProperty("fee")
    public Double getFee() {
        return fee;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("fee")
    public void setFee(Double fee) {
        this.fee = fee;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("displayWithFee")
    public String getDisplayWithFee() {
        return displayWithFee;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("displayWithFee")
    public void setDisplayWithFee(String displayWithFee) {
        this.displayWithFee = displayWithFee;
    }

    @JsonProperty("feePathType")
    public String getFeePathType() {
        return feePathType;
    }

    @JsonProperty("feePathType")
    public void setFeePathType(String feePathType) {
        this.feePathType = feePathType;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("xmitCodeId")
    public Integer getXmitCodeId() {
        return xmitCodeId;
    }

    @JsonProperty("xmitCodeId")
    public void setXmitCodeId(Integer xmitCodeId) {
        this.xmitCodeId = xmitCodeId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("display")
    public String getDisplay() {
        return display;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("display")
    public void setDisplay(String display) {
        this.display = display;
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
        return new ToStringBuilder(this).append("xcriptTypeId", xcriptTypeId).append("toScprofilId", toScprofilId).append("fee", fee).append("displayWithFee", displayWithFee).append("feePathType", feePathType).append("status", status).append("xmitCodeId", xmitCodeId).append("display", display).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(toScprofilId).append(feePathType).append(xmitCodeId).append(fee).append(display).append(additionalProperties).append(xcriptTypeId).append(displayWithFee).append(status).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TranscriptType) == false) {
            return false;
        }
        TranscriptType rhs = ((TranscriptType) other);
        return new EqualsBuilder().append(toScprofilId, rhs.toScprofilId).append(feePathType, rhs.feePathType).append(xmitCodeId, rhs.xmitCodeId).append(fee, rhs.fee).append(display, rhs.display).append(additionalProperties, rhs.additionalProperties).append(xcriptTypeId, rhs.xcriptTypeId).append(displayWithFee, rhs.displayWithFee).append(status, rhs.status).isEquals();
    }

}
