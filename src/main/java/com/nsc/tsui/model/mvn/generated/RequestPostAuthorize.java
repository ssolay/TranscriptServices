
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
 * PostAuthorizeRequest
 * <p>
 * The JSON object for posting to /rest/authorize API
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "accessCode",
    "authorizationId",
    "authTimestamp"
})
public class RequestPostAuthorize {

    /**
     * A hash value that authorize the request from MyHub
     * (Required)
     * 
     */
    @JsonProperty("accessCode")
    @JsonPropertyDescription("A hash value that authorize the request from MyHub")
    private String accessCode;
    /**
     * A unique system assigned ID for the authorized session
     * (Required)
     * 
     */
    @JsonProperty("authorizationId")
    @JsonPropertyDescription("A unique system assigned ID for the authorized session")
    private Double authorizationId;
    /**
     * The timestamp in milliseconds that is used to check expiration. 
     * (Required)
     * 
     */
    @JsonProperty("authTimestamp")
    @JsonPropertyDescription("The timestamp in milliseconds that is used to check expiration. ")
    private Double authTimestamp;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * A hash value that authorize the request from MyHub
     * (Required)
     * 
     */
    @JsonProperty("accessCode")
    public String getAccessCode() {
        return accessCode;
    }

    /**
     * A hash value that authorize the request from MyHub
     * (Required)
     * 
     */
    @JsonProperty("accessCode")
    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }

    /**
     * A unique system assigned ID for the authorized session
     * (Required)
     * 
     */
    @JsonProperty("authorizationId")
    public Double getAuthorizationId() {
        return authorizationId;
    }

    /**
     * A unique system assigned ID for the authorized session
     * (Required)
     * 
     */
    @JsonProperty("authorizationId")
    public void setAuthorizationId(Double authorizationId) {
        this.authorizationId = authorizationId;
    }

    /**
     * The timestamp in milliseconds that is used to check expiration. 
     * (Required)
     * 
     */
    @JsonProperty("authTimestamp")
    public Double getAuthTimestamp() {
        return authTimestamp;
    }

    /**
     * The timestamp in milliseconds that is used to check expiration. 
     * (Required)
     * 
     */
    @JsonProperty("authTimestamp")
    public void setAuthTimestamp(Double authTimestamp) {
        this.authTimestamp = authTimestamp;
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
        return new ToStringBuilder(this).append("accessCode", accessCode).append("authorizationId", authorizationId).append("authTimestamp", authTimestamp).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(additionalProperties).append(authTimestamp).append(accessCode).append(authorizationId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RequestPostAuthorize) == false) {
            return false;
        }
        RequestPostAuthorize rhs = ((RequestPostAuthorize) other);
        return new EqualsBuilder().append(additionalProperties, rhs.additionalProperties).append(authTimestamp, rhs.authTimestamp).append(accessCode, rhs.accessCode).append(authorizationId, rhs.authorizationId).isEquals();
    }

}
