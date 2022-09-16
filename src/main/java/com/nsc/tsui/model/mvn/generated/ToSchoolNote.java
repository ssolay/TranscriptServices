
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
 * We may only need a Welcome note for ordering process
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "scpfNotesId",
    "toScprofilId",
    "notesType",
    "notes",
    "status"
})
public class ToSchoolNote {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("scpfNotesId")
    private Integer scpfNotesId;
    @JsonProperty("toScprofilId")
    private Integer toScprofilId;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("notesType")
    private String notesType;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("notes")
    private String notes;
    @JsonProperty("status")
    private String status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("scpfNotesId")
    public Integer getScpfNotesId() {
        return scpfNotesId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("scpfNotesId")
    public void setScpfNotesId(Integer scpfNotesId) {
        this.scpfNotesId = scpfNotesId;
    }

    @JsonProperty("toScprofilId")
    public Integer getToScprofilId() {
        return toScprofilId;
    }

    @JsonProperty("toScprofilId")
    public void setToScprofilId(Integer toScprofilId) {
        this.toScprofilId = toScprofilId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("notesType")
    public String getNotesType() {
        return notesType;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("notesType")
    public void setNotesType(String notesType) {
        this.notesType = notesType;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("notes")
    public String getNotes() {
        return notes;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("notes")
    public void setNotes(String notes) {
        this.notes = notes;
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
        return new ToStringBuilder(this).append("scpfNotesId", scpfNotesId).append("toScprofilId", toScprofilId).append("notesType", notesType).append("notes", notes).append("status", status).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(toScprofilId).append(notes).append(notesType).append(scpfNotesId).append(additionalProperties).append(status).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ToSchoolNote) == false) {
            return false;
        }
        ToSchoolNote rhs = ((ToSchoolNote) other);
        return new EqualsBuilder().append(toScprofilId, rhs.toScprofilId).append(notes, rhs.notes).append(notesType, rhs.notesType).append(scpfNotesId, rhs.scpfNotesId).append(additionalProperties, rhs.additionalProperties).append(status, rhs.status).isEquals();
    }

}
