
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
    "attendSchool",
    "attendSchlBeg",
    "attendSchlEnd"
})
public class AttendSchoolInfo {

    @JsonProperty("attendSchool")
    private String attendSchool;
    @JsonProperty("attendSchlBeg")
    private String attendSchlBeg;
    @JsonProperty("attendSchlEnd")
    private String attendSchlEnd;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("attendSchool")
    public String getAttendSchool() {
        return attendSchool;
    }

    @JsonProperty("attendSchool")
    public void setAttendSchool(String attendSchool) {
        this.attendSchool = attendSchool;
    }

    @JsonProperty("attendSchlBeg")
    public String getAttendSchlBeg() {
        return attendSchlBeg;
    }

    @JsonProperty("attendSchlBeg")
    public void setAttendSchlBeg(String attendSchlBeg) {
        this.attendSchlBeg = attendSchlBeg;
    }

    @JsonProperty("attendSchlEnd")
    public String getAttendSchlEnd() {
        return attendSchlEnd;
    }

    @JsonProperty("attendSchlEnd")
    public void setAttendSchlEnd(String attendSchlEnd) {
        this.attendSchlEnd = attendSchlEnd;
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
        return new ToStringBuilder(this).append("attendSchool", attendSchool).append("attendSchlBeg", attendSchlBeg).append("attendSchlEnd", attendSchlEnd).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(attendSchool).append(attendSchlEnd).append(attendSchlBeg).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AttendSchoolInfo) == false) {
            return false;
        }
        AttendSchoolInfo rhs = ((AttendSchoolInfo) other);
        return new EqualsBuilder().append(attendSchool, rhs.attendSchool).append(attendSchlEnd, rhs.attendSchlEnd).append(attendSchlBeg, rhs.attendSchlBeg).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
