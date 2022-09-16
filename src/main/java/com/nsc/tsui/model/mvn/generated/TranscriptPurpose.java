
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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "xcriptPurposeId",
    "toScprofilId",
    "status",
    "xmitCodeId",
    "display"
})
public class TranscriptPurpose {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("xcriptPurposeId")
    private Integer xcriptPurposeId;
    @JsonProperty("toScprofilId")
    private Integer toScprofilId;
    @JsonProperty("status")
    private String status;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("xmitCodeId")
    private Integer xmitCodeId;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("display")
    private String display;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("xcriptPurposeId")
    public Integer getXcriptPurposeId() {
        return xcriptPurposeId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("xcriptPurposeId")
    public void setXcriptPurposeId(Integer xcriptPurposeId) {
        this.xcriptPurposeId = xcriptPurposeId;
    }

    @JsonProperty("toScprofilId")
    public Integer getToScprofilId() {
        return toScprofilId;
    }

    @JsonProperty("toScprofilId")
    public void setToScprofilId(Integer toScprofilId) {
        this.toScprofilId = toScprofilId;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("xmitCodeId")
    public Integer getXmitCodeId() {
        return xmitCodeId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("xmitCodeId")
    public void setXmitCodeId(Integer xmitCodeId) {
        this.xmitCodeId = xmitCodeId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("display")
    public String getDisplay() {
        return display;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("display")
    public void setDisplay(String display) {
        this.display = display;
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
        return new ToStringBuilder(this).append("xcriptPurposeId", xcriptPurposeId).append("toScprofilId", toScprofilId).append("status", status).append("xmitCodeId", xmitCodeId).append("display", display).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(toScprofilId).append(xmitCodeId).append(display).append(additionalProperties).append(xcriptPurposeId).append(status).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TranscriptPurpose) == false) {
            return false;
        }
        TranscriptPurpose rhs = ((TranscriptPurpose) other);
        return new EqualsBuilder().append(toScprofilId, rhs.toScprofilId).append(xmitCodeId, rhs.xmitCodeId).append(display, rhs.display).append(additionalProperties, rhs.additionalProperties).append(xcriptPurposeId, rhs.xcriptPurposeId).append(status, rhs.status).isEquals();
    }

}
