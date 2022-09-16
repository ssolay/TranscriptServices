
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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * GetSystemConfigResponse
 * <p>
 * The JSON object returned by system-config API 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "state",
    "state-category",
    "country",
    "country-category",
    "mobileCarrier",
    "sendToType",
    "cctype"
})
public class ResponseGetSystemConfig {

    @JsonProperty("state")
    private List<State> state = new ArrayList<State>();
    @JsonProperty("state-category")
    private List<State> stateCategory = new ArrayList<State>();
    @JsonProperty("country")
    private List<State> country = new ArrayList<State>();
    @JsonProperty("country-category")
    private List<State> countryCategory = new ArrayList<State>();
    @JsonProperty("mobileCarrier")
    private List<MobileCarrier> mobileCarrier = new ArrayList<MobileCarrier>();
    @JsonProperty("sendToType")
    private List<MobileCarrier> sendToType = new ArrayList<MobileCarrier>();
    @JsonProperty("cctype")
    private List<MobileCarrier> cctype = new ArrayList<MobileCarrier>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("state")
    public List<State> getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(List<State> state) {
        this.state = state;
    }

    @JsonProperty("state-category")
    public List<State> getStateCategory() {
        return stateCategory;
    }

    @JsonProperty("state-category")
    public void setStateCategory(List<State> stateCategory) {
        this.stateCategory = stateCategory;
    }

    @JsonProperty("country")
    public List<State> getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(List<State> country) {
        this.country = country;
    }

    @JsonProperty("country-category")
    public List<State> getCountryCategory() {
        return countryCategory;
    }

    @JsonProperty("country-category")
    public void setCountryCategory(List<State> countryCategory) {
        this.countryCategory = countryCategory;
    }

    @JsonProperty("mobileCarrier")
    public List<MobileCarrier> getMobileCarrier() {
        return mobileCarrier;
    }

    @JsonProperty("mobileCarrier")
    public void setMobileCarrier(List<MobileCarrier> mobileCarrier) {
        this.mobileCarrier = mobileCarrier;
    }

    @JsonProperty("sendToType")
    public List<MobileCarrier> getSendToType() {
        return sendToType;
    }

    @JsonProperty("sendToType")
    public void setSendToType(List<MobileCarrier> sendToType) {
        this.sendToType = sendToType;
    }

    @JsonProperty("cctype")
    public List<MobileCarrier> getCctype() {
        return cctype;
    }

    @JsonProperty("cctype")
    public void setCctype(List<MobileCarrier> cctype) {
        this.cctype = cctype;
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
        return new ToStringBuilder(this).append("state", state).append("stateCategory", stateCategory).append("country", country).append("countryCategory", countryCategory).append("mobileCarrier", mobileCarrier).append("sendToType", sendToType).append("cctype", cctype).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(country).append(countryCategory).append(mobileCarrier).append(cctype).append(sendToType).append(stateCategory).append(state).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ResponseGetSystemConfig) == false) {
            return false;
        }
        ResponseGetSystemConfig rhs = ((ResponseGetSystemConfig) other);
        return new EqualsBuilder().append(country, rhs.country).append(countryCategory, rhs.countryCategory).append(mobileCarrier, rhs.mobileCarrier).append(cctype, rhs.cctype).append(sendToType, rhs.sendToType).append(stateCategory, rhs.stateCategory).append(state, rhs.state).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
