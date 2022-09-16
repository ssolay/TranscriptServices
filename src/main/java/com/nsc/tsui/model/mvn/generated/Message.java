
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
    "titleCode",
    "titleDescription",
    "message"
})
public class Message {

    @JsonProperty("titleCode")
    private String titleCode;
    @JsonProperty("titleDescription")
    private String titleDescription;
    @JsonProperty("message")
    private String message;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("titleCode")
    public String getTitleCode() {
        return titleCode;
    }

    @JsonProperty("titleCode")
    public void setTitleCode(String titleCode) {
        this.titleCode = titleCode;
    }

    @JsonProperty("titleDescription")
    public String getTitleDescription() {
        return titleDescription;
    }

    @JsonProperty("titleDescription")
    public void setTitleDescription(String titleDescription) {
        this.titleDescription = titleDescription;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
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
        return new ToStringBuilder(this).append("titleCode", titleCode).append("titleDescription", titleDescription).append("message", message).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(additionalProperties).append(message).append(titleCode).append(titleDescription).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Message) == false) {
            return false;
        }
        Message rhs = ((Message) other);
        return new EqualsBuilder().append(additionalProperties, rhs.additionalProperties).append(message, rhs.message).append(titleCode, rhs.titleCode).append(titleDescription, rhs.titleDescription).isEquals();
    }

}
