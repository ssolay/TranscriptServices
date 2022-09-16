
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
    "toOrderId",
    "toScprofilId",
    "chFlag",
    "referMethod",
    "reqIdentifierType",
    "requireReleaseFm",
    "preauthPaymentId",
    "paymentStatus",
    "scOrderStatusId",
    "orderStatus",
    "orderDate",
    "feePathType",
    "feePathDesc",
    "preauthFee",
    "totalFee",
    "totalFeePaid",
    "createdTimestamp",
    "paperlessConsentFormAllowed",
    "consentTypeUsed",
    "consentTypeAllowed",
    "archiveStudent"
})
public class OrderHeader {

    @JsonProperty("toOrderId")
    public Integer toOrderId;
    @JsonProperty("toScprofilId")
    public Integer toScprofilId;
    @JsonProperty("chFlag")
    public String chFlag;
    @JsonProperty("referMethod")
    public String referMethod;
    @JsonProperty("reqIdentifierType")
    public Integer reqIdentifierType;
    @JsonProperty("requireReleaseFm")
    public String requireReleaseFm;
    @JsonProperty("preauthPaymentId")
    public Integer preauthPaymentId;
    @JsonProperty("paymentStatus")
    public String paymentStatus;
    @JsonProperty("scOrderStatusId")
    public Integer scOrderStatusId;
    @JsonProperty("orderStatus")
    public String orderStatus;
    @JsonProperty("orderDate")
    public String orderDate;
    @JsonProperty("feePathType")
    public String feePathType;
    @JsonProperty("feePathDesc")
    public String feePathDesc;
    @JsonProperty("preauthFee")
    public Integer preauthFee;
    @JsonProperty("totalFee")
    public Integer totalFee;
    @JsonProperty("totalFeePaid")
    public Integer totalFeePaid;
    @JsonProperty("createdTimestamp")
    public String createdTimestamp;
    @JsonProperty("paperlessConsentFormAllowed")
    public String paperlessConsentFormAllowed;
    @JsonProperty("consentTypeUsed")
    public String consentTypeUsed;
    @JsonProperty("consentTypeAllowed")
    public String consentTypeAllowed;
    @JsonProperty("archiveStudent")
    public String archiveStudent;
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
