package com.nsc.tsui.model.generated;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "payeezyToken",
        "ccAmount",
        "ccType",
        "ccExpiryMonth",
        "ccExpiryYear",
        "ccName",
        "billEmail",
        "billPhone",
        "billStreet1",
        "billStreet2",
        "billCity",
        "billState",
        "billCountry",
        "billZip"
})
public class PaymentInformationRequest {

    @JsonProperty("payeezyToken")
    public String payeezyToken;
    @JsonProperty("ccAmount")
    public String ccAmount;
    @JsonProperty("ccType")
    public String ccType;
    @JsonProperty("ccExpiryMonth")
    public String ccExpiryMonth;
    @JsonProperty("ccExpiryYear")
    public String ccExpiryYear;
    @JsonProperty("ccName")
    public String ccName;
    @JsonProperty("billEmail")
    public String billEmail;
    @JsonProperty("billPhone")
    public String billPhone;
    @JsonProperty("billStreet1")
    public String billStreet1;
    @JsonProperty("billStreet2")
    public String billStreet2;
    @JsonProperty("billCity")
    public String billCity;
    @JsonProperty("billState")
    public String billState;
    @JsonProperty("billCountry")
    public String billCountry;
    @JsonProperty("billZip")
    public String billZip;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}