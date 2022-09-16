
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
    "logoBase64",
    "contentType",
    "bgColor",
    "headerStyle",
    "subHeaderStyle",
    "imgWidth",
    "imgHeight",
    "alternateText"
})
public class ToSchoolHeader {

    @JsonProperty("logoBase64")
    public String logoBase64;
    @JsonProperty("contentType")
    public String contentType;
    @JsonProperty("bgColor")
    public String bgColor;
    @JsonProperty("headerStyle")
    public String headerStyle;
    @JsonProperty("subHeaderStyle")
    public String subHeaderStyle;
    @JsonProperty("imgWidth")
    public String imgWidth;
    @JsonProperty("imgHeight")
    public String imgHeight;
    @JsonProperty("alternateText")
    public String alternateText;
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
