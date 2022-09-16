
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
    "campusName",
    "state",
    "toScCampusId",
    "toScprofilId",
    "status"
})
public class ScCampu {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("campusName")
    private String campusName;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("state")
    private String state;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("toScCampusId")
    private Integer toScCampusId;
    @JsonProperty("toScprofilId")
    private Integer toScprofilId;
    @JsonProperty("status")
    private String status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("campusName")
    public String getCampusName() {
        return campusName;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("campusName")
    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("state")
    public String getState() {
        return state;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("toScCampusId")
    public Integer getToScCampusId() {
        return toScCampusId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("toScCampusId")
    public void setToScCampusId(Integer toScCampusId) {
        this.toScCampusId = toScCampusId;
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
        return new ToStringBuilder(this).append("campusName", campusName).append("state", state).append("toScCampusId", toScCampusId).append("toScprofilId", toScprofilId).append("status", status).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(toScprofilId).append(campusName).append(state).append(additionalProperties).append(toScCampusId).append(status).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ScCampu) == false) {
            return false;
        }
        ScCampu rhs = ((ScCampu) other);
        return new EqualsBuilder().append(toScprofilId, rhs.toScprofilId).append(campusName, rhs.campusName).append(state, rhs.state).append(additionalProperties, rhs.additionalProperties).append(toScCampusId, rhs.toScCampusId).append(status, rhs.status).isEquals();
    }

}
