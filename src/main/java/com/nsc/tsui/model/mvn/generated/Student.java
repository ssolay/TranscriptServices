
package com.nsc.tsui.model.mvn.generated;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "userName",
    "firstName",
    "middleName",
    "lastName",
    "dateOfBirth",
    "ssn",
    "street1",
    "street2",
    "city",
    "state",
    "zip",
    "country",
    "phone",
    "email",
    "schlFirstName",
    "schlMiddleName",
    "schlLastName",
    "studentId",
    "verifiedStudentId",
    "currEnrolled",
    "zeroFeePrgmCurrEnroll",
    "attendBeginYear",
    "attendEndYear",
    "toScCampusId",
    "attendSchoolInfo",
    "degreeInfo",
    "textMessging",
    "updateSchoolRec",
    "firstXcript"
})
public class Student {

    /**
     * The login Id for authenticated user
     * 
     */
    @JsonProperty("userName")
    @JsonPropertyDescription("The login Id for authenticated user")
    private String userName;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("middleName")
    private String middleName;
    @JsonProperty("lastName")
    private String lastName;
    /**
     * birth_date in YYYY-MM-DD format
     * 
     */
    @JsonProperty("dateOfBirth")
    @JsonPropertyDescription("birth_date in YYYY-MM-DD format")
    private String dateOfBirth;
    @JsonProperty("ssn")
    private String ssn;
    @JsonProperty("street1")
    private String street1;
    @JsonProperty("street2")
    private String street2;
    @JsonProperty("city")
    private String city;
    @JsonProperty("state")
    private String state;
    @JsonProperty("zip")
    private String zip;
    @JsonProperty("country")
    private String country;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("email")
    private String email;
    @JsonProperty("schlFirstName")
    private String schlFirstName;
    @JsonProperty("schlMiddleName")
    private String schlMiddleName;
    @JsonProperty("schlLastName")
    private String schlLastName;
    @JsonProperty("studentId")
    private String studentId;
    /**
     * The student ID validated by school via Ellucian APIs and Generic APIs
     * 
     */
    @JsonProperty("verifiedStudentId")
    @JsonPropertyDescription("The student ID validated by school via Ellucian APIs and Generic APIs")
    private String verifiedStudentId;
    @JsonProperty("currEnrolled")
    private String currEnrolled;
    /**
     * Associated with the school setting for zero fee program. Out of scope for March
     * 
     */
    @JsonProperty("zeroFeePrgmCurrEnroll")
    @JsonPropertyDescription("Associated with the school setting for zero fee program. Out of scope for March")
    private String zeroFeePrgmCurrEnroll;
    @JsonProperty("attendBeginYear")
    private String attendBeginYear;
    @JsonProperty("attendEndYear")
    private String attendEndYear;
    @JsonProperty("toScCampusId")
    private Integer toScCampusId;
    /**
     * Corresponding to the attendSchoolLabels from school profile. 
     * 
     */
    @JsonProperty("attendSchoolInfo")
    @JsonPropertyDescription("Corresponding to the attendSchoolLabels from school profile. ")
    private List<AttendSchoolInfo> attendSchoolInfo = new ArrayList<AttendSchoolInfo>();
    /**
     * Collect up to 4 degrees if school asks for degree
     * 
     */
    @JsonProperty("degreeInfo")
    @JsonPropertyDescription("Collect up to 4 degrees if school asks for degree")
    private List<DegreeInfo> degreeInfo = new ArrayList<DegreeInfo>();
    @JsonProperty("textMessging")
    private TextMessging textMessging;
    @JsonProperty("updateSchoolRec")
    private String updateSchoolRec;
    /**
     * Need to check whether it is needed for ordering process
     * 
     */
    @JsonProperty("firstXcript")
    @JsonPropertyDescription("Need to check whether it is needed for ordering process")
    private String firstXcript;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * The login Id for authenticated user
     * 
     */
    @JsonProperty("userName")
    public String getUserName() {
        return userName;
    }

    /**
     * The login Id for authenticated user
     * 
     */
    @JsonProperty("userName")
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("middleName")
    public String getMiddleName() {
        return middleName;
    }

    @JsonProperty("middleName")
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * birth_date in YYYY-MM-DD format
     * 
     */
    @JsonProperty("dateOfBirth")
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * birth_date in YYYY-MM-DD format
     * 
     */
    @JsonProperty("dateOfBirth")
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @JsonProperty("ssn")
    public String getSsn() {
        return ssn;
    }

    @JsonProperty("ssn")
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @JsonProperty("street1")
    public String getStreet1() {
        return street1;
    }

    @JsonProperty("street1")
    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    @JsonProperty("street2")
    public String getStreet2() {
        return street2;
    }

    @JsonProperty("street2")
    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("zip")
    public String getZip() {
        return zip;
    }

    @JsonProperty("zip")
    public void setZip(String zip) {
        this.zip = zip;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    @JsonProperty("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("schlFirstName")
    public String getSchlFirstName() {
        return schlFirstName;
    }

    @JsonProperty("schlFirstName")
    public void setSchlFirstName(String schlFirstName) {
        this.schlFirstName = schlFirstName;
    }

    @JsonProperty("schlMiddleName")
    public String getSchlMiddleName() {
        return schlMiddleName;
    }

    @JsonProperty("schlMiddleName")
    public void setSchlMiddleName(String schlMiddleName) {
        this.schlMiddleName = schlMiddleName;
    }

    @JsonProperty("schlLastName")
    public String getSchlLastName() {
        return schlLastName;
    }

    @JsonProperty("schlLastName")
    public void setSchlLastName(String schlLastName) {
        this.schlLastName = schlLastName;
    }

    @JsonProperty("studentId")
    public String getStudentId() {
        return studentId;
    }

    @JsonProperty("studentId")
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * The student ID validated by school via Ellucian APIs and Generic APIs
     * 
     */
    @JsonProperty("verifiedStudentId")
    public String getVerifiedStudentId() {
        return verifiedStudentId;
    }

    /**
     * The student ID validated by school via Ellucian APIs and Generic APIs
     * 
     */
    @JsonProperty("verifiedStudentId")
    public void setVerifiedStudentId(String verifiedStudentId) {
        this.verifiedStudentId = verifiedStudentId;
    }

    @JsonProperty("currEnrolled")
    public String getCurrEnrolled() {
        return currEnrolled;
    }

    @JsonProperty("currEnrolled")
    public void setCurrEnrolled(String currEnrolled) {
        this.currEnrolled = currEnrolled;
    }

    /**
     * Associated with the school setting for zero fee program. Out of scope for March
     * 
     */
    @JsonProperty("zeroFeePrgmCurrEnroll")
    public String getZeroFeePrgmCurrEnroll() {
        return zeroFeePrgmCurrEnroll;
    }

    /**
     * Associated with the school setting for zero fee program. Out of scope for March
     * 
     */
    @JsonProperty("zeroFeePrgmCurrEnroll")
    public void setZeroFeePrgmCurrEnroll(String zeroFeePrgmCurrEnroll) {
        this.zeroFeePrgmCurrEnroll = zeroFeePrgmCurrEnroll;
    }

    @JsonProperty("attendBeginYear")
    public String getAttendBeginYear() {
        return attendBeginYear;
    }

    @JsonProperty("attendBeginYear")
    public void setAttendBeginYear(String attendBeginYear) {
        this.attendBeginYear = attendBeginYear;
    }

    @JsonProperty("attendEndYear")
    public String getAttendEndYear() {
        return attendEndYear;
    }

    @JsonProperty("attendEndYear")
    public void setAttendEndYear(String attendEndYear) {
        this.attendEndYear = attendEndYear;
    }

    @JsonProperty("toScCampusId")
    public Integer getToScCampusId() {
        return toScCampusId;
    }

    @JsonProperty("toScCampusId")
    public void setToScCampusId(Integer toScCampusId) {
        this.toScCampusId = toScCampusId;
    }

    /**
     * Corresponding to the attendSchoolLabels from school profile. 
     * 
     */
    @JsonProperty("attendSchoolInfo")
    public List<AttendSchoolInfo> getAttendSchoolInfo() {
        return attendSchoolInfo;
    }

    /**
     * Corresponding to the attendSchoolLabels from school profile. 
     * 
     */
    @JsonProperty("attendSchoolInfo")
    public void setAttendSchoolInfo(List<AttendSchoolInfo> attendSchoolInfo) {
        this.attendSchoolInfo = attendSchoolInfo;
    }

    /**
     * Collect up to 4 degrees if school asks for degree
     * 
     */
    @JsonProperty("degreeInfo")
    public List<DegreeInfo> getDegreeInfo() {
        return degreeInfo;
    }

    /**
     * Collect up to 4 degrees if school asks for degree
     * 
     */
    @JsonProperty("degreeInfo")
    public void setDegreeInfo(List<DegreeInfo> degreeInfo) {
        this.degreeInfo = degreeInfo;
    }

    @JsonProperty("textMessging")
    public TextMessging getTextMessging() {
        return textMessging;
    }

    @JsonProperty("textMessging")
    public void setTextMessging(TextMessging textMessging) {
        this.textMessging = textMessging;
    }

    @JsonProperty("updateSchoolRec")
    public String getUpdateSchoolRec() {
        return updateSchoolRec;
    }

    @JsonProperty("updateSchoolRec")
    public void setUpdateSchoolRec(String updateSchoolRec) {
        this.updateSchoolRec = updateSchoolRec;
    }

    /**
     * Need to check whether it is needed for ordering process
     * 
     */
    @JsonProperty("firstXcript")
    public String getFirstXcript() {
        return firstXcript;
    }

    /**
     * Need to check whether it is needed for ordering process
     * 
     */
    @JsonProperty("firstXcript")
    public void setFirstXcript(String firstXcript) {
        this.firstXcript = firstXcript;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("userName", userName).append("firstName", firstName).append("middleName", middleName).append("lastName", lastName).append("dateOfBirth", dateOfBirth).append("ssn", ssn).append("street1", street1).append("street2", street2).append("city", city).append("state", state).append("zip", zip).append("country", country).append("phone", phone).append("email", email).append("schlFirstName", schlFirstName).append("schlMiddleName", schlMiddleName).append("schlLastName", schlLastName).append("studentId", studentId).append("verifiedStudentId", verifiedStudentId).append("currEnrolled", currEnrolled).append("zeroFeePrgmCurrEnroll", zeroFeePrgmCurrEnroll).append("attendBeginYear", attendBeginYear).append("attendEndYear", attendEndYear).append("toScCampusId", toScCampusId).append("attendSchoolInfo", attendSchoolInfo).append("degreeInfo", degreeInfo).append("textMessging", textMessging).append("updateSchoolRec", updateSchoolRec).append("firstXcript", firstXcript).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(lastName).append(country).append(degreeInfo).append(attendBeginYear).append(city).append(currEnrolled).append(ssn).append(studentId).append(verifiedStudentId).append(street1).append(textMessging).append(street2).append(state).append(attendSchoolInfo).append(email).append(toScCampusId).append(updateSchoolRec).append(zip).append(zeroFeePrgmCurrEnroll).append(dateOfBirth).append(userName).append(firstName).append(firstXcript).append(schlMiddleName).append(attendEndYear).append(phone).append(schlFirstName).append(schlLastName).append(middleName).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Student) == false) {
            return false;
        }
        Student rhs = ((Student) other);
        return new EqualsBuilder().append(lastName, rhs.lastName).append(country, rhs.country).append(degreeInfo, rhs.degreeInfo).append(attendBeginYear, rhs.attendBeginYear).append(city, rhs.city).append(currEnrolled, rhs.currEnrolled).append(ssn, rhs.ssn).append(studentId, rhs.studentId).append(verifiedStudentId, rhs.verifiedStudentId).append(street1, rhs.street1).append(textMessging, rhs.textMessging).append(street2, rhs.street2).append(state, rhs.state).append(attendSchoolInfo, rhs.attendSchoolInfo).append(email, rhs.email).append(toScCampusId, rhs.toScCampusId).append(updateSchoolRec, rhs.updateSchoolRec).append(zip, rhs.zip).append(zeroFeePrgmCurrEnroll, rhs.zeroFeePrgmCurrEnroll).append(dateOfBirth, rhs.dateOfBirth).append(userName, rhs.userName).append(firstName, rhs.firstName).append(firstXcript, rhs.firstXcript).append(schlMiddleName, rhs.schlMiddleName).append(attendEndYear, rhs.attendEndYear).append(phone, rhs.phone).append(schlFirstName, rhs.schlFirstName).append(schlLastName, rhs.schlLastName).append(middleName, rhs.middleName).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
