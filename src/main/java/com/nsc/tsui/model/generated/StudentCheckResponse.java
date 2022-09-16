
package com.nsc.tsui.model.generated;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "verifiedStudentId",
    "restrictions",
    "ungradedTerms",
    "programs"
})
public class StudentCheckResponse {

    @JsonProperty("verifiedStudentId")
    public String verifiedStudentId;
    @JsonProperty("restrictions")
    public List<Restriction> restrictions = null;
    @JsonProperty("ungradedTerms")
    public List<UngradedTerm> ungradedTerms = null;
    @JsonProperty("programs")
    public List<Program> programs = null;
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
