
package com.nsc.tsui.model.generated;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "scpfNotesId",
    "toScprofilId",
    "notesType",
    "notes",
    "status"
})
public class ToSchoolNote {

    @JsonProperty("scpfNotesId")
    public Integer scpfNotesId;
    @JsonProperty("toScprofilId")
    public Integer toScprofilId;
    @JsonProperty("notesType")
    public String notesType;
    @JsonProperty("notes")
    public String notes;
    @JsonProperty("status")
    public String status;
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
