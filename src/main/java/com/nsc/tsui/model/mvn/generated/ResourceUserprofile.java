
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


/**
 * UserProfile
 * <p>
 * A profile information of an authenticated user
 * 
 */
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
    "studentSchools",
    "required"
})
public class ResourceUserprofile {

    /**
     * The first name
     * 
     */
    @JsonProperty("firstName")
    @JsonPropertyDescription("The first name")
    private String firstName;
    /**
     * The last name
     * 
     */
    @JsonProperty("lastName")
    @JsonPropertyDescription("The last name")
    private String lastName;
    /**
     * The middle name
     * 
     */
    @JsonProperty("middleName")
    @JsonPropertyDescription("The middle name")
    private String middleName;
    /**
     * The date of birth YYYY-MM-DD
     * 
     */
    @JsonProperty("dateOfBirth")
    @JsonPropertyDescription("The date of birth YYYY-MM-DD")
    private String dateOfBirth;
    /**
     * The former first name if there is one
     * 
     */
    @JsonProperty("formerFirstName")
    @JsonPropertyDescription("The former first name if there is one")
    private String formerFirstName;
    /**
     * The former last name if there is one
     * 
     */
    @JsonProperty("formerLastName")
    @JsonPropertyDescription("The former last name if there is one")
    private String formerLastName;
    /**
     * The street address
     * 
     */
    @JsonProperty("street")
    @JsonPropertyDescription("The street address")
    private String street;
    /**
     * The city
     * 
     */
    @JsonProperty("city")
    @JsonPropertyDescription("The city")
    private String city;
    /**
     * The two character state code
     * 
     */
    @JsonProperty("state")
    @JsonPropertyDescription("The two character state code")
    private String state;
    /**
     * the zip code
     * 
     */
    @JsonProperty("zipCode")
    @JsonPropertyDescription("the zip code")
    private String zipCode;
    /**
     * The two character country code
     * 
     */
    @JsonProperty("country")
    @JsonPropertyDescription("The two character country code")
    private String country;
    /**
     * The eamil address
     * 
     */
    @JsonProperty("email")
    @JsonPropertyDescription("The eamil address")
    private String email;
    /**
     * The phone number
     * 
     */
    @JsonProperty("phone")
    @JsonPropertyDescription("The phone number")
    private String phone;
    @JsonProperty("studentSchools")
    private List<ResourceToscprofileSimple> studentSchools = new ArrayList<ResourceToscprofileSimple>();
    @JsonProperty("required")
    private Object required;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * The first name
     * 
     */
    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    /**
     * The first name
     * 
     */
    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * The last name
     * 
     */
    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    /**
     * The last name
     * 
     */
    @JsonProperty("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * The middle name
     * 
     */
    @JsonProperty("middleName")
    public String getMiddleName() {
        return middleName;
    }

    /**
     * The middle name
     * 
     */
    @JsonProperty("middleName")
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * The date of birth YYYY-MM-DD
     * 
     */
    @JsonProperty("dateOfBirth")
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * The date of birth YYYY-MM-DD
     * 
     */
    @JsonProperty("dateOfBirth")
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * The former first name if there is one
     * 
     */
    @JsonProperty("formerFirstName")
    public String getFormerFirstName() {
        return formerFirstName;
    }

    /**
     * The former first name if there is one
     * 
     */
    @JsonProperty("formerFirstName")
    public void setFormerFirstName(String formerFirstName) {
        this.formerFirstName = formerFirstName;
    }

    /**
     * The former last name if there is one
     * 
     */
    @JsonProperty("formerLastName")
    public String getFormerLastName() {
        return formerLastName;
    }

    /**
     * The former last name if there is one
     * 
     */
    @JsonProperty("formerLastName")
    public void setFormerLastName(String formerLastName) {
        this.formerLastName = formerLastName;
    }

    /**
     * The street address
     * 
     */
    @JsonProperty("street")
    public String getStreet() {
        return street;
    }

    /**
     * The street address
     * 
     */
    @JsonProperty("street")
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * The city
     * 
     */
    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    /**
     * The city
     * 
     */
    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * The two character state code
     * 
     */
    @JsonProperty("state")
    public String getState() {
        return state;
    }

    /**
     * The two character state code
     * 
     */
    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    /**
     * the zip code
     * 
     */
    @JsonProperty("zipCode")
    public String getZipCode() {
        return zipCode;
    }

    /**
     * the zip code
     * 
     */
    @JsonProperty("zipCode")
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * The two character country code
     * 
     */
    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    /**
     * The two character country code
     * 
     */
    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * The eamil address
     * 
     */
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    /**
     * The eamil address
     * 
     */
    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * The phone number
     * 
     */
    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    /**
     * The phone number
     * 
     */
    @JsonProperty("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JsonProperty("studentSchools")
    public List<ResourceToscprofileSimple> getStudentSchools() {
        return studentSchools;
    }

    @JsonProperty("studentSchools")
    public void setStudentSchools(List<ResourceToscprofileSimple> studentSchools) {
        this.studentSchools = studentSchools;
    }

    @JsonProperty("required")
    public Object getRequired() {
        return required;
    }

    @JsonProperty("required")
    public void setRequired(Object required) {
        this.required = required;
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
        return new ToStringBuilder(this).append("firstName", firstName).append("lastName", lastName).append("middleName", middleName).append("dateOfBirth", dateOfBirth).append("formerFirstName", formerFirstName).append("formerLastName", formerLastName).append("street", street).append("city", city).append("state", state).append("zipCode", zipCode).append("country", country).append("email", email).append("phone", phone).append("studentSchools", studentSchools).append("required", required).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(lastName).append(zipCode).append(country).append(formerLastName).append(city).append(dateOfBirth).append(required).append(firstName).append(formerFirstName).append(phone).append(street).append(studentSchools).append(middleName).append(state).append(additionalProperties).append(email).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ResourceUserprofile) == false) {
            return false;
        }
        ResourceUserprofile rhs = ((ResourceUserprofile) other);
        return new EqualsBuilder().append(lastName, rhs.lastName).append(zipCode, rhs.zipCode).append(country, rhs.country).append(formerLastName, rhs.formerLastName).append(city, rhs.city).append(dateOfBirth, rhs.dateOfBirth).append(required, rhs.required).append(firstName, rhs.firstName).append(formerFirstName, rhs.formerFirstName).append(phone, rhs.phone).append(street, rhs.street).append(studentSchools, rhs.studentSchools).append(middleName, rhs.middleName).append(state, rhs.state).append(additionalProperties, rhs.additionalProperties).append(email, rhs.email).isEquals();
    }

}
