package com.nsc.tsui.model.generated.recipients;

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
        "deliveryMethodId",
        "quantityId",
        "toOrderId",
        "sendToType",
        "organization",
        "processingOption",
        "street1",
        "city",
        "state",
        "country",
        "zip",
        "toRecipientCategory",
        "isAckgInvalidAddress"
})
public class PostRecipientsRequest {

    @JsonProperty("deliveryMethodId")
    public Integer deliveryMethodId;
    @JsonProperty("quantityId")
    public Integer quantityId;
    @JsonProperty("toOrderId")
    public Integer toOrderId;
    @JsonProperty("sendToType")
    public String sendToType;
    @JsonProperty("organization")
    public String organization;
    @JsonProperty("processingOption")
    public String processingOption;
    @JsonProperty("street1")
    public String street1;
    @JsonProperty("city")
    public String city;
    @JsonProperty("state")
    public String state;
    @JsonProperty("country")
    public String country;
    @JsonProperty("zip")
    public String zip;
    @JsonProperty("toRecipientCategory")
    public String toRecipientCategory;
    @JsonProperty("isAckgInvalidAddress")
    public String isAckgInvalidAddress;
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
