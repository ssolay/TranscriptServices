
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
    "code",
    "codeDescription"
})
public class Restriction {

    /**
     * The code
     * (Required)
     * 
     */
    @JsonProperty("code")
    @JsonPropertyDescription("The code")
    private String code;
    /**
     * The description of the code
     * (Required)
     * 
     */
    @JsonProperty("codeDescription")
    @JsonPropertyDescription("The description of the code")
    private String codeDescription;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * The code
     * (Required)
     * 
     */
    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    /**
     * The code
     * (Required)
     * 
     */
    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * The description of the code
     * (Required)
     * 
     */
    @JsonProperty("codeDescription")
    public String getCodeDescription() {
        return codeDescription;
    }

    /**
     * The description of the code
     * (Required)
     * 
     */
    @JsonProperty("codeDescription")
    public void setCodeDescription(String codeDescription) {
        this.codeDescription = codeDescription;
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
        return new ToStringBuilder(this).append("code", code).append("codeDescription", codeDescription).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(code).append(additionalProperties).append(codeDescription).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Restriction) == false) {
            return false;
        }
        Restriction rhs = ((Restriction) other);
        return new EqualsBuilder().append(code, rhs.code).append(additionalProperties, rhs.additionalProperties).append(codeDescription, rhs.codeDescription).isEquals();
    }

}
