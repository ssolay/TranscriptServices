
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


/**
 * GenericPostResponse
 * <p>
 * Generic response object for POST requests
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status",
    "message",
    "level"
})
public class DefinitionPostResponse {

    /**
     * The result status of the request, can be "success" or "fail" 
     * 
     */
    @JsonProperty("status")
    @JsonPropertyDescription("The result status of the request, can be \"success\" or \"fail\" ")
    private String status;
    /**
     * The response message. Can be displayed to user
     * 
     */
    @JsonProperty("message")
    @JsonPropertyDescription("The response message. Can be displayed to user")
    private String message;
    /**
     * The priority of the status. Values from low to high: info,warning,error,fatal
     * 
     */
    @JsonProperty("level")
    @JsonPropertyDescription("The priority of the status. Values from low to high: info,warning,error,fatal")
    private String level;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * The result status of the request, can be "success" or "fail" 
     * 
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * The result status of the request, can be "success" or "fail" 
     * 
     */
    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * The response message. Can be displayed to user
     * 
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * The response message. Can be displayed to user
     * 
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * The priority of the status. Values from low to high: info,warning,error,fatal
     * 
     */
    @JsonProperty("level")
    public String getLevel() {
        return level;
    }

    /**
     * The priority of the status. Values from low to high: info,warning,error,fatal
     * 
     */
    @JsonProperty("level")
    public void setLevel(String level) {
        this.level = level;
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
        return new ToStringBuilder(this).append("status", status).append("message", message).append("level", level).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(additionalProperties).append(message).append(level).append(status).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DefinitionPostResponse) == false) {
            return false;
        }
        DefinitionPostResponse rhs = ((DefinitionPostResponse) other);
        return new EqualsBuilder().append(additionalProperties, rhs.additionalProperties).append(message, rhs.message).append(level, rhs.level).append(status, rhs.status).isEquals();
    }

}
