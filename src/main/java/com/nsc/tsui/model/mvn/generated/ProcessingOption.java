
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
    "processingOptionId",
    "toScprofilId",
    "code",
    "status",
    "description"
})
public class ProcessingOption {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("processingOptionId")
    private Integer processingOptionId;
    @JsonProperty("toScprofilId")
    private Integer toScprofilId;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("code")
    private String code;
    @JsonProperty("status")
    private String status;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("description")
    private String description;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("processingOptionId")
    public Integer getProcessingOptionId() {
        return processingOptionId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("processingOptionId")
    public void setProcessingOptionId(Integer processingOptionId) {
        this.processingOptionId = processingOptionId;
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
    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
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
     * 
     * (Required)
     * 
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
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
        return new ToStringBuilder(this).append("processingOptionId", processingOptionId).append("toScprofilId", toScprofilId).append("code", code).append("status", status).append("description", description).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(toScprofilId).append(code).append(processingOptionId).append(description).append(additionalProperties).append(status).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ProcessingOption) == false) {
            return false;
        }
        ProcessingOption rhs = ((ProcessingOption) other);
        return new EqualsBuilder().append(toScprofilId, rhs.toScprofilId).append(code, rhs.code).append(processingOptionId, rhs.processingOptionId).append(description, rhs.description).append(additionalProperties, rhs.additionalProperties).append(status, rhs.status).isEquals();
    }

}
