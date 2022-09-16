
package com.nsc.tsui.model.mvn.generated;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * Not needed for UI views in ordering process
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "scOrderStatusId",
    "scprofilToken",
    "code",
    "requestorDesc",
    "schoolDesc",
    "hstRequestorDesc",
    "needEmail",
    "sortOrder",
    "status",
    "xmitCode",
    "emailText",
    "multipleStatusEmail",
    "displayText",
    "schoolActionRequired",
    "toScprofilId",
    "type",
    "holdNumber"
})
public class ScOrderStatus {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("scOrderStatusId")
    private Integer scOrderStatusId;
    @JsonProperty("scprofilToken")
    private Integer scprofilToken;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("code")
    private String code;
    @JsonProperty("requestorDesc")
    private String requestorDesc;
    @JsonProperty("schoolDesc")
    private String schoolDesc;
    @JsonProperty("hstRequestorDesc")
    private String hstRequestorDesc;
    @JsonProperty("needEmail")
    private String needEmail;
    @JsonProperty("sortOrder")
    private Double sortOrder;
    @JsonProperty("status")
    private String status;
    @JsonProperty("xmitCode")
    private String xmitCode;
    @JsonProperty("emailText")
    private String emailText;
    @JsonProperty("multipleStatusEmail")
    private String multipleStatusEmail;
    @JsonProperty("displayText")
    private String displayText;
    @JsonProperty("schoolActionRequired")
    private String schoolActionRequired;
    @JsonProperty("toScprofilId")
    private Integer toScprofilId;
    @JsonProperty("type")
    private String type;
    @JsonProperty("holdNumber")
    private Integer holdNumber;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("scOrderStatusId")
    public Integer getScOrderStatusId() {
        return scOrderStatusId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("scOrderStatusId")
    public void setScOrderStatusId(Integer scOrderStatusId) {
        this.scOrderStatusId = scOrderStatusId;
    }

    @JsonProperty("scprofilToken")
    public Integer getScprofilToken() {
        return scprofilToken;
    }

    @JsonProperty("scprofilToken")
    public void setScprofilToken(Integer scprofilToken) {
        this.scprofilToken = scprofilToken;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("requestorDesc")
    public String getRequestorDesc() {
        return requestorDesc;
    }

    @JsonProperty("requestorDesc")
    public void setRequestorDesc(String requestorDesc) {
        this.requestorDesc = requestorDesc;
    }

    @JsonProperty("schoolDesc")
    public String getSchoolDesc() {
        return schoolDesc;
    }

    @JsonProperty("schoolDesc")
    public void setSchoolDesc(String schoolDesc) {
        this.schoolDesc = schoolDesc;
    }

    @JsonProperty("hstRequestorDesc")
    public String getHstRequestorDesc() {
        return hstRequestorDesc;
    }

    @JsonProperty("hstRequestorDesc")
    public void setHstRequestorDesc(String hstRequestorDesc) {
        this.hstRequestorDesc = hstRequestorDesc;
    }

    @JsonProperty("needEmail")
    public String getNeedEmail() {
        return needEmail;
    }

    @JsonProperty("needEmail")
    public void setNeedEmail(String needEmail) {
        this.needEmail = needEmail;
    }

    @JsonProperty("sortOrder")
    public Double getSortOrder() {
        return sortOrder;
    }

    @JsonProperty("sortOrder")
    public void setSortOrder(Double sortOrder) {
        this.sortOrder = sortOrder;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("xmitCode")
    public String getXmitCode() {
        return xmitCode;
    }

    @JsonProperty("xmitCode")
    public void setXmitCode(String xmitCode) {
        this.xmitCode = xmitCode;
    }

    @JsonProperty("emailText")
    public String getEmailText() {
        return emailText;
    }

    @JsonProperty("emailText")
    public void setEmailText(String emailText) {
        this.emailText = emailText;
    }

    @JsonProperty("multipleStatusEmail")
    public String getMultipleStatusEmail() {
        return multipleStatusEmail;
    }

    @JsonProperty("multipleStatusEmail")
    public void setMultipleStatusEmail(String multipleStatusEmail) {
        this.multipleStatusEmail = multipleStatusEmail;
    }

    @JsonProperty("displayText")
    public String getDisplayText() {
        return displayText;
    }

    @JsonProperty("displayText")
    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }

    @JsonProperty("schoolActionRequired")
    public String getSchoolActionRequired() {
        return schoolActionRequired;
    }

    @JsonProperty("schoolActionRequired")
    public void setSchoolActionRequired(String schoolActionRequired) {
        this.schoolActionRequired = schoolActionRequired;
    }

    @JsonProperty("toScprofilId")
    public Integer getToScprofilId() {
        return toScprofilId;
    }

    @JsonProperty("toScprofilId")
    public void setToScprofilId(Integer toScprofilId) {
        this.toScprofilId = toScprofilId;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("holdNumber")
    public Integer getHoldNumber() {
        return holdNumber;
    }

    @JsonProperty("holdNumber")
    public void setHoldNumber(Integer holdNumber) {
        this.holdNumber = holdNumber;
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
        return new ToStringBuilder(this).append("scOrderStatusId", scOrderStatusId).append("scprofilToken", scprofilToken).append("code", code).append("requestorDesc", requestorDesc).append("schoolDesc", schoolDesc).append("hstRequestorDesc", hstRequestorDesc).append("needEmail", needEmail).append("sortOrder", sortOrder).append("status", status).append("xmitCode", xmitCode).append("emailText", emailText).append("multipleStatusEmail", multipleStatusEmail).append("displayText", displayText).append("schoolActionRequired", schoolActionRequired).append("toScprofilId", toScprofilId).append("type", type).append("holdNumber", holdNumber).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(displayText).append(code).append(holdNumber).append(emailText).append(schoolActionRequired).append(type).append(multipleStatusEmail).append(xmitCode).append(scprofilToken).append(needEmail).append(toScprofilId).append(hstRequestorDesc).append(scOrderStatusId).append(sortOrder).append(schoolDesc).append(additionalProperties).append(requestorDesc).append(status).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ScOrderStatus) == false) {
            return false;
        }
        ScOrderStatus rhs = ((ScOrderStatus) other);
        return new EqualsBuilder().append(displayText, rhs.displayText).append(code, rhs.code).append(holdNumber, rhs.holdNumber).append(emailText, rhs.emailText).append(schoolActionRequired, rhs.schoolActionRequired).append(type, rhs.type).append(multipleStatusEmail, rhs.multipleStatusEmail).append(xmitCode, rhs.xmitCode).append(scprofilToken, rhs.scprofilToken).append(needEmail, rhs.needEmail).append(toScprofilId, rhs.toScprofilId).append(hstRequestorDesc, rhs.hstRequestorDesc).append(scOrderStatusId, rhs.scOrderStatusId).append(sortOrder, rhs.sortOrder).append(schoolDesc, rhs.schoolDesc).append(additionalProperties, rhs.additionalProperties).append(requestorDesc, rhs.requestorDesc).append(status, rhs.status).isEquals();
    }

}
