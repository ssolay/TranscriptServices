
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
    "quantityId",
    "toScprofilId",
    "quantity",
    "fee",
    "displayWithFee",
    "feePathType",
    "status"
})
public class Quantity {

    @JsonProperty("quantityId")
    public Integer quantityId;
    @JsonProperty("toScprofilId")
    public Integer toScprofilId;
    @JsonProperty("quantity")
    public Double quantity;
    @JsonProperty("fee")
    public Double fee;
    @JsonProperty("displayWithFee")
    public String displayWithFee;
    @JsonProperty("feePathType")
    public String feePathType;
    @JsonProperty("status")
    public String status;
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
