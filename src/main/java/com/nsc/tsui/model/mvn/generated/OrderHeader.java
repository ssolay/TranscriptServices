
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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "toScprofilId",
    "referMethod",
    "userIp",
    "feePathType",
    "feePathTypeAnswer",
    "feePathDesc",
    "archiveStudent"
})
public class OrderHeader {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("toScprofilId")
    private Integer toScprofilId;
    /**
     * Use the value from UserProfile which was returned from /auth/authorize api
     * 
     */
    @JsonProperty("referMethod")
    @JsonPropertyDescription("Use the value from UserProfile which was returned from /auth/authorize api")
    private String referMethod;
    @JsonProperty("userIp")
    private String userIp;
    /**
     * If there is a fee path type question, this value is determine in UI based on the answer to the questions
     * 
     */
    @JsonProperty("feePathType")
    @JsonPropertyDescription("If there is a fee path type question, this value is determine in UI based on the answer to the questions")
    private String feePathType;
    /**
     * If there is a fee path type question, this value is determine in UI based on the answer to the questions
     * 
     */
    @JsonProperty("feePathTypeAnswer")
    @JsonPropertyDescription("If there is a fee path type question, this value is determine in UI based on the answer to the questions")
    private String feePathTypeAnswer;
    @JsonProperty("feePathDesc")
    private String feePathDesc;
    @JsonProperty("archiveStudent")
    private String archiveStudent;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("toScprofilId")
    public Integer getToScprofilId() {
        return toScprofilId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("toScprofilId")
    public void setToScprofilId(Integer toScprofilId) {
        this.toScprofilId = toScprofilId;
    }

    /**
     * Use the value from UserProfile which was returned from /auth/authorize api
     * 
     */
    @JsonProperty("referMethod")
    public String getReferMethod() {
        return referMethod;
    }

    /**
     * Use the value from UserProfile which was returned from /auth/authorize api
     * 
     */
    @JsonProperty("referMethod")
    public void setReferMethod(String referMethod) {
        this.referMethod = referMethod;
    }

    @JsonProperty("userIp")
    public String getUserIp() {
        return userIp;
    }

    @JsonProperty("userIp")
    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    /**
     * If there is a fee path type question, this value is determine in UI based on the answer to the questions
     * 
     */
    @JsonProperty("feePathType")
    public String getFeePathType() {
        return feePathType;
    }

    /**
     * If there is a fee path type question, this value is determine in UI based on the answer to the questions
     * 
     */
    @JsonProperty("feePathType")
    public void setFeePathType(String feePathType) {
        this.feePathType = feePathType;
    }

    /**
     * If there is a fee path type question, this value is determine in UI based on the answer to the questions
     * 
     */
    @JsonProperty("feePathTypeAnswer")
    public String getFeePathTypeAnswer() {
        return feePathTypeAnswer;
    }

    /**
     * If there is a fee path type question, this value is determine in UI based on the answer to the questions
     * 
     */
    @JsonProperty("feePathTypeAnswer")
    public void setFeePathTypeAnswer(String feePathTypeAnswer) {
        this.feePathTypeAnswer = feePathTypeAnswer;
    }

    @JsonProperty("feePathDesc")
    public String getFeePathDesc() {
        return feePathDesc;
    }

    @JsonProperty("feePathDesc")
    public void setFeePathDesc(String feePathDesc) {
        this.feePathDesc = feePathDesc;
    }

    @JsonProperty("archiveStudent")
    public String getArchiveStudent() {
        return archiveStudent;
    }

    @JsonProperty("archiveStudent")
    public void setArchiveStudent(String archiveStudent) {
        this.archiveStudent = archiveStudent;
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
        return new ToStringBuilder(this).append("toScprofilId", toScprofilId).append("referMethod", referMethod).append("userIp", userIp).append("feePathType", feePathType).append("feePathTypeAnswer", feePathTypeAnswer).append("feePathDesc", feePathDesc).append("archiveStudent", archiveStudent).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(feePathTypeAnswer).append(toScprofilId).append(feePathType).append(feePathDesc).append(userIp).append(additionalProperties).append(referMethod).append(archiveStudent).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof OrderHeader) == false) {
            return false;
        }
        OrderHeader rhs = ((OrderHeader) other);
        return new EqualsBuilder().append(feePathTypeAnswer, rhs.feePathTypeAnswer).append(toScprofilId, rhs.toScprofilId).append(feePathType, rhs.feePathType).append(feePathDesc, rhs.feePathDesc).append(userIp, rhs.userIp).append(additionalProperties, rhs.additionalProperties).append(referMethod, rhs.referMethod).append(archiveStudent, rhs.archiveStudent).isEquals();
    }

}
