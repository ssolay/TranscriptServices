
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
    "firstName",
    "lastName",
    "middleName",
    "dateOfBirth",
    "formerFirstName",
    "formerLastName",
    "street",
    "city",
    "state",
    "zipCode",
    "country",
    "email",
    "phone",
    "studentSchools"
})
public class UserProfile {

    @JsonProperty("firstName")
    public String firstName;
    @JsonProperty("lastName")
    public String lastName;
    @JsonProperty("middleName")
    public String middleName;
    @JsonProperty("dateOfBirth")
    public String dateOfBirth;
    @JsonProperty("formerFirstName")
    public String formerFirstName;
    @JsonProperty("formerLastName")
    public String formerLastName;
    @JsonProperty("street")
    public String street;
    @JsonProperty("city")
    public String city;
    @JsonProperty("state")
    public String state;
    @JsonProperty("zipCode")
    public String zipCode;
    @JsonProperty("country")
    public String country;
    @JsonProperty("email")
    public String email;
    @JsonProperty("phone")
    public String phone;
    @JsonProperty("studentSchools")
    public List<StudentSchool> studentSchools = null;
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
