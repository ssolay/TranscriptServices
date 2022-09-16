
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
 * TOScprofileSimple
 * <p>
 * A simple version of the TO School Profile object that is used to locate student's school
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "toScprofilId",
    "ficeCode",
    "schlName",
    "uiVersion"
})
public class ResourceToscprofileSimple {

    /**
     * The unique identifier for a school profile
     * (Required)
     * 
     */
    @JsonProperty("toScprofilId")
    @JsonPropertyDescription("The unique identifier for a school profile")
    private Integer toScprofilId;
    /**
     * The 8 digit school code (6 digit school code and 2 digit branch code)
     * (Required)
     * 
     */
    @JsonProperty("ficeCode")
    @JsonPropertyDescription("The 8 digit school code (6 digit school code and 2 digit branch code)")
    private String ficeCode;
    /**
     * The name of the school
     * (Required)
     * 
     */
    @JsonProperty("schlName")
    @JsonPropertyDescription("The name of the school")
    private String schlName;
    /**
     * The version of the UI application. Used to determine the ordering web interface for the school.
     * 
     */
    @JsonProperty("uiVersion")
    @JsonPropertyDescription("The version of the UI application. Used to determine the ordering web interface for the school.")
    private String uiVersion;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * The unique identifier for a school profile
     * (Required)
     * 
     */
    @JsonProperty("toScprofilId")
    public Integer getToScprofilId() {
        return toScprofilId;
    }

    /**
     * The unique identifier for a school profile
     * (Required)
     * 
     */
    @JsonProperty("toScprofilId")
    public void setToScprofilId(Integer toScprofilId) {
        this.toScprofilId = toScprofilId;
    }

    /**
     * The 8 digit school code (6 digit school code and 2 digit branch code)
     * (Required)
     * 
     */
    @JsonProperty("ficeCode")
    public String getFiceCode() {
        return ficeCode;
    }

    /**
     * The 8 digit school code (6 digit school code and 2 digit branch code)
     * (Required)
     * 
     */
    @JsonProperty("ficeCode")
    public void setFiceCode(String ficeCode) {
        this.ficeCode = ficeCode;
    }

    /**
     * The name of the school
     * (Required)
     * 
     */
    @JsonProperty("schlName")
    public String getSchlName() {
        return schlName;
    }

    /**
     * The name of the school
     * (Required)
     * 
     */
    @JsonProperty("schlName")
    public void setSchlName(String schlName) {
        this.schlName = schlName;
    }

    /**
     * The version of the UI application. Used to determine the ordering web interface for the school.
     * 
     */
    @JsonProperty("uiVersion")
    public String getUiVersion() {
        return uiVersion;
    }

    /**
     * The version of the UI application. Used to determine the ordering web interface for the school.
     * 
     */
    @JsonProperty("uiVersion")
    public void setUiVersion(String uiVersion) {
        this.uiVersion = uiVersion;
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
        return new ToStringBuilder(this).append("toScprofilId", toScprofilId).append("ficeCode", ficeCode).append("schlName", schlName).append("uiVersion", uiVersion).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(schlName).append(toScprofilId).append(uiVersion).append(additionalProperties).append(ficeCode).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ResourceToscprofileSimple) == false) {
            return false;
        }
        ResourceToscprofileSimple rhs = ((ResourceToscprofileSimple) other);
        return new EqualsBuilder().append(schlName, rhs.schlName).append(toScprofilId, rhs.toScprofilId).append(uiVersion, rhs.uiVersion).append(additionalProperties, rhs.additionalProperties).append(ficeCode, rhs.ficeCode).isEquals();
    }

}
