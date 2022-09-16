
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
    "deliveryMethodId",
    "toScprofilId",
    "fee",
    "displayWithFee",
    "helpText",
    "feePathType",
    "xmitCodeId",
    "display",
    "status",
    "printVendorFee",
    "handleFee",
    "isPrint"
})
public class DeliveryMethod {

    @JsonProperty("deliveryMethodId")
    public Integer deliveryMethodId;
    @JsonProperty("toScprofilId")
    public Integer toScprofilId;
    @JsonProperty("fee")
    public Double fee;
    @JsonProperty("displayWithFee")
    public String displayWithFee;
    @JsonProperty("helpText")
    public String helpText;
    @JsonProperty("feePathType")
    public String feePathType;
    @JsonProperty("xmitCodeId")
    public Integer xmitCodeId;
    @JsonProperty("display")
    public String display;
    @JsonProperty("status")
    public String status;
    @JsonProperty("printVendorFee")
    public Double printVendorFee;
    @JsonProperty("handleFee")
    public Double handleFee;
    @JsonProperty("isPrint")
    public String isPrint;
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
