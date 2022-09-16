
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
    "quantityId",
    "toScprofilId",
    "quantity",
    "fee",
    "displayWithFee",
    "feePathType",
    "status"
})
public class Quantity {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("quantityId")
    private Integer quantityId;
    @JsonProperty("toScprofilId")
    private Integer toScprofilId;
    @JsonProperty("quantity")
    private Double quantity;
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
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("quantityId")
    public Integer getQuantityId() {
        return quantityId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("quantityId")
    public void setQuantityId(Integer quantityId) {
        this.quantityId = quantityId;
    }

    @JsonProperty("toScprofilId")
    public Integer getToScprofilId() {
        return toScprofilId;
    }

    @JsonProperty("toScprofilId")
    public void setToScprofilId(Integer toScprofilId) {
        this.toScprofilId = toScprofilId;
    }

    @JsonProperty("quantity")
    public Double getQuantity() {
        return quantity;
    }

    @JsonProperty("quantity")
    public void setQuantity(Double quantity) {
        this.quantity = quantity;
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
        return new ToStringBuilder(this).append("quantityId", quantityId).append("toScprofilId", toScprofilId).append("quantity", quantity).append("fee", fee).append("displayWithFee", displayWithFee).append("feePathType", feePathType).append("status", status).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(toScprofilId).append(quantity).append(feePathType).append(quantityId).append(fee).append(additionalProperties).append(displayWithFee).append(status).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Quantity) == false) {
            return false;
        }
        Quantity rhs = ((Quantity) other);
        return new EqualsBuilder().append(toScprofilId, rhs.toScprofilId).append(quantity, rhs.quantity).append(feePathType, rhs.feePathType).append(quantityId, rhs.quantityId).append(fee, rhs.fee).append(additionalProperties, rhs.additionalProperties).append(displayWithFee, rhs.displayWithFee).append(status, rhs.status).isEquals();
    }

}
