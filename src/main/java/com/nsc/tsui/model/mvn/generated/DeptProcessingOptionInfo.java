
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
 * Not needed in UI. The logic is performed in exchange API
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "toScprofilDeptProcessingOptionInfoId",
    "ficeCode",
    "deptProcessingOption",
    "toScprofilId",
    "status"
})
public class DeptProcessingOptionInfo {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("toScprofilDeptProcessingOptionInfoId")
    private Integer toScprofilDeptProcessingOptionInfoId;
    @JsonProperty("ficeCode")
    private String ficeCode;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("deptProcessingOption")
    private String deptProcessingOption;
    @JsonProperty("toScprofilId")
    private Integer toScprofilId;
    @JsonProperty("status")
    private String status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("toScprofilDeptProcessingOptionInfoId")
    public Integer getToScprofilDeptProcessingOptionInfoId() {
        return toScprofilDeptProcessingOptionInfoId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("toScprofilDeptProcessingOptionInfoId")
    public void setToScprofilDeptProcessingOptionInfoId(Integer toScprofilDeptProcessingOptionInfoId) {
        this.toScprofilDeptProcessingOptionInfoId = toScprofilDeptProcessingOptionInfoId;
    }

    @JsonProperty("ficeCode")
    public String getFiceCode() {
        return ficeCode;
    }

    @JsonProperty("ficeCode")
    public void setFiceCode(String ficeCode) {
        this.ficeCode = ficeCode;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("deptProcessingOption")
    public String getDeptProcessingOption() {
        return deptProcessingOption;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("deptProcessingOption")
    public void setDeptProcessingOption(String deptProcessingOption) {
        this.deptProcessingOption = deptProcessingOption;
    }

    @JsonProperty("toScprofilId")
    public Integer getToScprofilId() {
        return toScprofilId;
    }

    @JsonProperty("toScprofilId")
    public void setToScprofilId(Integer toScprofilId) {
        this.toScprofilId = toScprofilId;
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
        return new ToStringBuilder(this).append("toScprofilDeptProcessingOptionInfoId", toScprofilDeptProcessingOptionInfoId).append("ficeCode", ficeCode).append("deptProcessingOption", deptProcessingOption).append("toScprofilId", toScprofilId).append("status", status).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(toScprofilId).append(toScprofilDeptProcessingOptionInfoId).append(ficeCode).append(additionalProperties).append(deptProcessingOption).append(status).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DeptProcessingOptionInfo) == false) {
            return false;
        }
        DeptProcessingOptionInfo rhs = ((DeptProcessingOptionInfo) other);
        return new EqualsBuilder().append(toScprofilId, rhs.toScprofilId).append(toScprofilDeptProcessingOptionInfoId, rhs.toScprofilDeptProcessingOptionInfoId).append(ficeCode, rhs.ficeCode).append(additionalProperties, rhs.additionalProperties).append(deptProcessingOption, rhs.deptProcessingOption).append(status, rhs.status).isEquals();
    }

}
