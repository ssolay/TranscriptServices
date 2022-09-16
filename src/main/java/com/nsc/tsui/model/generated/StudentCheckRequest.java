package com.nsc.tsui.model.generated;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "ficeCode",
        "firstName",
        "lastName",
        "schlLastName",
        "dateOfBirth",
        "studentId",
        "ssn"
})
@Builder
public class StudentCheckRequest {

    @JsonProperty("ficeCode")
    public String ficeCode;
    @JsonProperty("firstName")
    public String firstName;
    @JsonProperty("lastName")
    public String lastName;
    @JsonProperty("schlLastName")
    public String schlLastName;
    @JsonProperty("dateOfBirth")
    public String dateOfBirth;
    @JsonProperty("studentId")
    public String studentId;
    @JsonProperty("ssn")
    public String ssn;
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