
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
 * PostStudentCheckResponse
 * <p>
 * The student information returned after looking up student at school via Ellucian or Generic APIs
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "verifiedStudentId",
    "restrictions",
    "ungradedTerms",
    "programs"
})
public class ResponsePostStudentCheck {

    /**
     * The student ID verified by school
     * 
     */
    @JsonProperty("verifiedStudentId")
    @JsonPropertyDescription("The student ID verified by school")
    private String verifiedStudentId;
    /**
     * Transcript-related restrictions that prevent students from placing an order.  Return all active holds/restrictions with a brief description
     * 
     */
    @JsonProperty("restrictions")
    @JsonPropertyDescription("Transcript-related restrictions that prevent students from placing an order.  Return all active holds/restrictions with a brief description")
    private List<Restriction> restrictions = new ArrayList<Restriction>();
    /**
     * Academic terms for the in-progress, ungraded courses for the student from SIS to display to student to select a specific term
     * 
     */
    @JsonProperty("ungradedTerms")
    @JsonPropertyDescription("Academic terms for the in-progress, ungraded courses for the student from SIS to display to student to select a specific term")
    private List<Restriction> ungradedTerms = new ArrayList<Restriction>();
    /**
     * In-progress or active student programs of study for the student from SIS to display to student to select for transcript ordering
     * 
     */
    @JsonProperty("programs")
    @JsonPropertyDescription("In-progress or active student programs of study for the student from SIS to display to student to select for transcript ordering")
    private List<Restriction> programs = new ArrayList<Restriction>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * The student ID verified by school
     * 
     */
    @JsonProperty("verifiedStudentId")
    public String getVerifiedStudentId() {
        return verifiedStudentId;
    }

    /**
     * The student ID verified by school
     * 
     */
    @JsonProperty("verifiedStudentId")
    public void setVerifiedStudentId(String verifiedStudentId) {
        this.verifiedStudentId = verifiedStudentId;
    }

    /**
     * Transcript-related restrictions that prevent students from placing an order.  Return all active holds/restrictions with a brief description
     * 
     */
    @JsonProperty("restrictions")
    public List<Restriction> getRestrictions() {
        return restrictions;
    }

    /**
     * Transcript-related restrictions that prevent students from placing an order.  Return all active holds/restrictions with a brief description
     * 
     */
    @JsonProperty("restrictions")
    public void setRestrictions(List<Restriction> restrictions) {
        this.restrictions = restrictions;
    }

    /**
     * Academic terms for the in-progress, ungraded courses for the student from SIS to display to student to select a specific term
     * 
     */
    @JsonProperty("ungradedTerms")
    public List<Restriction> getUngradedTerms() {
        return ungradedTerms;
    }

    /**
     * Academic terms for the in-progress, ungraded courses for the student from SIS to display to student to select a specific term
     * 
     */
    @JsonProperty("ungradedTerms")
    public void setUngradedTerms(List<Restriction> ungradedTerms) {
        this.ungradedTerms = ungradedTerms;
    }

    /**
     * In-progress or active student programs of study for the student from SIS to display to student to select for transcript ordering
     * 
     */
    @JsonProperty("programs")
    public List<Restriction> getPrograms() {
        return programs;
    }

    /**
     * In-progress or active student programs of study for the student from SIS to display to student to select for transcript ordering
     * 
     */
    @JsonProperty("programs")
    public void setPrograms(List<Restriction> programs) {
        this.programs = programs;
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
        return new ToStringBuilder(this).append("verifiedStudentId", verifiedStudentId).append("restrictions", restrictions).append("ungradedTerms", ungradedTerms).append("programs", programs).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(restrictions).append(programs).append(additionalProperties).append(verifiedStudentId).append(ungradedTerms).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ResponsePostStudentCheck) == false) {
            return false;
        }
        ResponsePostStudentCheck rhs = ((ResponsePostStudentCheck) other);
        return new EqualsBuilder().append(restrictions, rhs.restrictions).append(programs, rhs.programs).append(additionalProperties, rhs.additionalProperties).append(verifiedStudentId, rhs.verifiedStudentId).append(ungradedTerms, rhs.ungradedTerms).isEquals();
    }

}
