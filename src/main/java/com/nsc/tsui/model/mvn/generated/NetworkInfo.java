
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
    "toScprofilNetworkInfoId",
    "exchangeNetworkTypeCode",
    "toScprofilId",
    "supportedFileTypes",
    "priorityLevel",
    "ficeCode",
    "networkCode",
    "status"
})
public class NetworkInfo {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("toScprofilNetworkInfoId")
    private Integer toScprofilNetworkInfoId;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("exchangeNetworkTypeCode")
    private String exchangeNetworkTypeCode;
    @JsonProperty("toScprofilId")
    private Integer toScprofilId;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("supportedFileTypes")
    private String supportedFileTypes;
    @JsonProperty("priorityLevel")
    private Integer priorityLevel;
    @JsonProperty("ficeCode")
    private String ficeCode;
    @JsonProperty("networkCode")
    private String networkCode;
    @JsonProperty("status")
    private String status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("toScprofilNetworkInfoId")
    public Integer getToScprofilNetworkInfoId() {
        return toScprofilNetworkInfoId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("toScprofilNetworkInfoId")
    public void setToScprofilNetworkInfoId(Integer toScprofilNetworkInfoId) {
        this.toScprofilNetworkInfoId = toScprofilNetworkInfoId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("exchangeNetworkTypeCode")
    public String getExchangeNetworkTypeCode() {
        return exchangeNetworkTypeCode;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("exchangeNetworkTypeCode")
    public void setExchangeNetworkTypeCode(String exchangeNetworkTypeCode) {
        this.exchangeNetworkTypeCode = exchangeNetworkTypeCode;
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
    @JsonProperty("supportedFileTypes")
    public String getSupportedFileTypes() {
        return supportedFileTypes;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("supportedFileTypes")
    public void setSupportedFileTypes(String supportedFileTypes) {
        this.supportedFileTypes = supportedFileTypes;
    }

    @JsonProperty("priorityLevel")
    public Integer getPriorityLevel() {
        return priorityLevel;
    }

    @JsonProperty("priorityLevel")
    public void setPriorityLevel(Integer priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    @JsonProperty("ficeCode")
    public String getFiceCode() {
        return ficeCode;
    }

    @JsonProperty("ficeCode")
    public void setFiceCode(String ficeCode) {
        this.ficeCode = ficeCode;
    }

    @JsonProperty("networkCode")
    public String getNetworkCode() {
        return networkCode;
    }

    @JsonProperty("networkCode")
    public void setNetworkCode(String networkCode) {
        this.networkCode = networkCode;
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
        return new ToStringBuilder(this).append("toScprofilNetworkInfoId", toScprofilNetworkInfoId).append("exchangeNetworkTypeCode", exchangeNetworkTypeCode).append("toScprofilId", toScprofilId).append("supportedFileTypes", supportedFileTypes).append("priorityLevel", priorityLevel).append("ficeCode", ficeCode).append("networkCode", networkCode).append("status", status).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(exchangeNetworkTypeCode).append(toScprofilId).append(supportedFileTypes).append(priorityLevel).append(ficeCode).append(networkCode).append(additionalProperties).append(toScprofilNetworkInfoId).append(status).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof NetworkInfo) == false) {
            return false;
        }
        NetworkInfo rhs = ((NetworkInfo) other);
        return new EqualsBuilder().append(exchangeNetworkTypeCode, rhs.exchangeNetworkTypeCode).append(toScprofilId, rhs.toScprofilId).append(supportedFileTypes, rhs.supportedFileTypes).append(priorityLevel, rhs.priorityLevel).append(ficeCode, rhs.ficeCode).append(networkCode, rhs.networkCode).append(additionalProperties, rhs.additionalProperties).append(toScprofilNetworkInfoId, rhs.toScprofilNetworkInfoId).append(status, rhs.status).isEquals();
    }

}
