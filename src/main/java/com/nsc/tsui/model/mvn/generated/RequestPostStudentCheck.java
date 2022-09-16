
package com.nsc.tsui.model.mvn.generated;

import java.util.HashMap;
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


/**
 * PostStudentCheckRequest
 * <p>
 * The JSON object for posting to student/check API
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ficeCode",
    "toScprofilId",
    "firstName",
    "lastName",
    "formerFirstName",
    "formerLastName",
    "dateOfBirth",
    "studentId",
    "ssn"
})
public class RequestPostStudentCheck {

    /**
     * The 8 digit school code and branch code
     * (Required)
     * 
     */
    @JsonProperty("ficeCode")
    @JsonPropertyDescription("The 8 digit school code and branch code")
    private String ficeCode;
    /**
     * The school profile ID associated with the order
     * (Required)
     * 
     */
    @JsonProperty("toScprofilId")
    @JsonPropertyDescription("The school profile ID associated with the order")
    private Integer toScprofilId;
    /**
     * The first name from academic record
     * (Required)
     * 
     */
    @JsonProperty("firstName")
    @JsonPropertyDescription("The first name from academic record")
    private String firstName;
    /**
     * The last name from academic record
     * (Required)
     * 
     */
    @JsonProperty("lastName")
    @JsonPropertyDescription("The last name from academic record")
    private String lastName;
    /**
     * The former first name
     * 
     */
    @JsonProperty("formerFirstName")
    @JsonPropertyDescription("The former first name")
    private String formerFirstName;
    /**
     * The former last name
     * 
     */
    @JsonProperty("formerLastName")
    @JsonPropertyDescription("The former last name")
    private String formerLastName;
    /**
     * The date of birth YYYY-MM-DD
     * (Required)
     * 
     */
    @JsonProperty("dateOfBirth")
    @JsonPropertyDescription("The date of birth YYYY-MM-DD")
    private String dateOfBirth;
    /**
     * The school issued student ID
     * 
     */
    @JsonProperty("studentId")
    @JsonPropertyDescription("The school issued student ID")
    private String studentId;
    /**
     * The SSN
     * 
     */
    @JsonProperty("ssn")
    @JsonPropertyDescription("The SSN")
    private Double ssn;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * The 8 digit school code and branch code
     * (Required)
     * 
     */
    @JsonProperty("ficeCode")
    public String getFiceCode() {
        return ficeCode;
    }

    /**
     * The 8 digit school code and branch code
     * (Required)
     * 
     */
    @JsonProperty("ficeCode")
    public void setFiceCode(String ficeCode) {
        this.ficeCode = ficeCode;
    }

    /**
     * The school profile ID associated with the order
     * (Required)
     * 
     */
    @JsonProperty("toScprofilId")
    public Integer getToScprofilId() {
        return toScprofilId;
    }

    /**
     * The school profile ID associated with the order
     * (Required)
     * 
     */
    @JsonProperty("toScprofilId")
    public void setToScprofilId(Integer toScprofilId) {
        this.toScprofilId = toScprofilId;
    }

    /**
     * The first name from academic record
     * (Required)
     * 
     */
    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    /**
     * The first name from academic record
     * (Required)
     * 
     */
    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * The last name from academic record
     * (Required)
     * 
     */
    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    /**
     * The last name from academic record
     * (Required)
     * 
     */
    @JsonProperty("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * The former first name
     * 
     */
    @JsonProperty("formerFirstName")
    public String getFormerFirstName() {
        return formerFirstName;
    }

    /**
     * The former first name
     * 
     */
    @JsonProperty("formerFirstName")
    public void setFormerFirstName(String formerFirstName) {
        this.formerFirstName = formerFirstName;
    }

    /**
     * The former last name
     * 
     */
    @JsonProperty("formerLastName")
    public String getFormerLastName() {
        return formerLastName;
    }

    /**
     * The former last name
     * 
     */
    @JsonProperty("formerLastName")
    public void setFormerLastName(String formerLastName) {
        this.formerLastName = formerLastName;
    }

    /**
     * The date of birth YYYY-MM-DD
     * (Required)
     * 
     */
    @JsonProperty("dateOfBirth")
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * The date of birth YYYY-MM-DD
     * (Required)
     * 
     */
    @JsonProperty("dateOfBirth")
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * The school issued student ID
     * 
     */
    @JsonProperty("studentId")
    public String getStudentId() {
        return studentId;
    }

    /**
     * The school issued student ID
     * 
     */
    @JsonProperty("studentId")
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * The SSN
     * 
     */
    @JsonProperty("ssn")
    public Double getSsn() {
        return ssn;
    }

    /**
     * The SSN
     * 
     */
    @JsonProperty("ssn")
    public void setSsn(Double ssn) {
        this.ssn = ssn;
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
        return new ToStringBuilder(this).append("ficeCode", ficeCode).append("toScprofilId", toScprofilId).append("firstName", firstName).append("lastName", lastName).append("formerFirstName", formerFirstName).append("formerLastName", formerLastName).append("dateOfBirth", dateOfBirth).append("studentId", studentId).append("ssn", ssn).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(studentId).append(firstName).append(lastName).append(toScprofilId).append(formerFirstName).append(formerLastName).append(ficeCode).append(dateOfBirth).append(additionalProperties).append(ssn).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RequestPostStudentCheck) == false) {
            return false;
        }
        RequestPostStudentCheck rhs = ((RequestPostStudentCheck) other);
        return new EqualsBuilder().append(studentId, rhs.studentId).append(firstName, rhs.firstName).append(lastName, rhs.lastName).append(toScprofilId, rhs.toScprofilId).append(formerFirstName, rhs.formerFirstName).append(formerLastName, rhs.formerLastName).append(ficeCode, rhs.ficeCode).append(dateOfBirth, rhs.dateOfBirth).append(additionalProperties, rhs.additionalProperties).append(ssn, rhs.ssn).isEquals();
    }

}
