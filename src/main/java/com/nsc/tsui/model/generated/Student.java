
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
    "middleName",
    "lastName",
    "dateOfBirth",
    "studentId",
    "ssn",
    "schlFirstName",
    "schlMiddleName",
    "schlLastName",
    "currEnrolled",
    "attendBeginYear",
    "attendEndYear",
    "zeroFeePrgmCurrEnroll",
    "street1",
    "street2",
    "zip",
    "city",
    "state",
    "country",
    "email",
    "phone",
    "toScCampusId",
    "attendSchoolInfo",
    "degreeInfo",
    "textMessging",
    "verifiedStudentId",
    "allowSchoolUpdate"
})
public class Student {

    @JsonProperty("firstName")
    public String firstName;
    @JsonProperty("middleName")
    public String middleName;
    @JsonProperty("lastName")
    public String lastName;
    @JsonProperty("dateOfBirth")
    public String dateOfBirth;
    @JsonProperty("studentId")
    public String studentId;
    @JsonProperty("ssn")
    public String ssn;
    @JsonProperty("schlFirstName")
    public String schlFirstName;
    @JsonProperty("schlMiddleName")
    public String schlMiddleName;
    @JsonProperty("schlLastName")
    public String schlLastName;
    @JsonProperty("currEnrolled")
    public String currEnrolled;
    @JsonProperty("attendBeginYear")
    public String attendBeginYear;
    @JsonProperty("attendEndYear")
    public String attendEndYear;
    @JsonProperty("zeroFeePrgmCurrEnroll")
    public String zeroFeePrgmCurrEnroll;
    @JsonProperty("street1")
    public String street1;
    @JsonProperty("street2")
    public String street2;
    @JsonProperty("zip")
    public String zip;
    @JsonProperty("city")
    public String city;
    @JsonProperty("state")
    public String state;
    @JsonProperty("country")
    public String country;
    @JsonProperty("email")
    public String email;
    @JsonProperty("phone")
    public String phone;
    @JsonProperty("toScCampusId")
    public String toScCampusId;
    @JsonProperty("attendSchoolInfo")
    public List<AttendSchoolInfo> attendSchoolInfo = null;
    @JsonProperty("degreeInfo")
    public List<DegreeInfo> degreeInfo = null;
    @JsonProperty("textMessging")
    public TextMessging textMessging;
    @JsonProperty("verifiedStudentId")
    public String verifiedStudentId;
    @JsonProperty("allowSchoolUpdate")
    public String allowSchoolUpdate;
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
