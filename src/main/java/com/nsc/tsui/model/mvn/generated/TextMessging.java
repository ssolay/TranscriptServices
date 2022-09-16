
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
    "carrierCode",
    "mobilePhoneNumber",
    "sendTxtMsg"
})
public class TextMessging {

    @JsonProperty("carrierCode")
    private String carrierCode;
    @JsonProperty("mobilePhoneNumber")
    private String mobilePhoneNumber;
    @JsonProperty("sendTxtMsg")
    private String sendTxtMsg;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("carrierCode")
    public String getCarrierCode() {
        return carrierCode;
    }

    @JsonProperty("carrierCode")
    public void setCarrierCode(String carrierCode) {
        this.carrierCode = carrierCode;
    }

    @JsonProperty("mobilePhoneNumber")
    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    @JsonProperty("mobilePhoneNumber")
    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    @JsonProperty("sendTxtMsg")
    public String getSendTxtMsg() {
        return sendTxtMsg;
    }

    @JsonProperty("sendTxtMsg")
    public void setSendTxtMsg(String sendTxtMsg) {
        this.sendTxtMsg = sendTxtMsg;
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
        return new ToStringBuilder(this).append("carrierCode", carrierCode).append("mobilePhoneNumber", mobilePhoneNumber).append("sendTxtMsg", sendTxtMsg).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(mobilePhoneNumber).append(additionalProperties).append(carrierCode).append(sendTxtMsg).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TextMessging) == false) {
            return false;
        }
        TextMessging rhs = ((TextMessging) other);
        return new EqualsBuilder().append(mobilePhoneNumber, rhs.mobilePhoneNumber).append(additionalProperties, rhs.additionalProperties).append(carrierCode, rhs.carrierCode).append(sendTxtMsg, rhs.sendTxtMsg).isEquals();
    }

}
