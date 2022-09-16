
package com.nsc.tsui.model.mvn.generated;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
 * PostConsentSignatureRequest
 * <p>
 * The JSON object for posting to /consent-signature API
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "lines"
})
public class RequestPostConsentSignature {

    /**
     * a series of X and Y coordinates
     * 
     */
    @JsonProperty("lines")
    @JsonPropertyDescription("a series of X and Y coordinates")
    private List<List<Object>> lines = new ArrayList<List<Object>>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * a series of X and Y coordinates
     * 
     */
    @JsonProperty("lines")
    public List<List<Object>> getLines() {
        return lines;
    }

    /**
     * a series of X and Y coordinates
     * 
     */
    @JsonProperty("lines")
    public void setLines(List<List<Object>> lines) {
        this.lines = lines;
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
        return new ToStringBuilder(this).append("lines", lines).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(lines).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RequestPostConsentSignature) == false) {
            return false;
        }
        RequestPostConsentSignature rhs = ((RequestPostConsentSignature) other);
        return new EqualsBuilder().append(lines, rhs.lines).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
