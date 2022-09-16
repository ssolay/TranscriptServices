
package com.nsc.tsui.model.generated.recipients;

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
    "userName",
    "firstName",
    "lastName",
    "street1",
    "city",
    "state",
    "zip",
    "country",
    "phone",
    "email",
    "studentId",
    "currEnrolled",
    "attendSchoolInfo",
    "degreeInfo",
    "updateSchoolRec"
})
public class Student {

    @JsonProperty("userName")
    public String userName;
    @JsonProperty("firstName")
    public String firstName;
    @JsonProperty("lastName")
    public String lastName;
    @JsonProperty("street1")
    public String street1;
    @JsonProperty("city")
    public String city;
    @JsonProperty("state")
    public String state;
    @JsonProperty("zip")
    public String zip;
    @JsonProperty("country")
    public String country;
    @JsonProperty("phone")
    public String phone;
    @JsonProperty("email")
    public String email;
    @JsonProperty("studentId")
    public String studentId;
    @JsonProperty("currEnrolled")
    public String currEnrolled;
    @JsonProperty("attendSchoolInfo")
    public List<Object> attendSchoolInfo = null;
    @JsonProperty("degreeInfo")
    public List<Object> degreeInfo = null;
    @JsonProperty("updateSchoolRec")
    public String updateSchoolRec;
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
