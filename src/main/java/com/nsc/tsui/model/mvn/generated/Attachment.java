
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
    "fileIdentifier",
    "contentType",
    "originalFileName"
})
public class Attachment {

    /**
     * The unique identifier of file attached
     * 
     */
    @JsonProperty("fileIdentifier")
    @JsonPropertyDescription("The unique identifier of file attached")
    private String fileIdentifier;
    /**
     * The mime type of the attachment file
     * 
     */
    @JsonProperty("contentType")
    @JsonPropertyDescription("The mime type of the attachment file")
    private String contentType;
    /**
     * The name of the original file attached
     * 
     */
    @JsonProperty("originalFileName")
    @JsonPropertyDescription("The name of the original file attached")
    private String originalFileName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * The unique identifier of file attached
     * 
     */
    @JsonProperty("fileIdentifier")
    public String getFileIdentifier() {
        return fileIdentifier;
    }

    /**
     * The unique identifier of file attached
     * 
     */
    @JsonProperty("fileIdentifier")
    public void setFileIdentifier(String fileIdentifier) {
        this.fileIdentifier = fileIdentifier;
    }

    /**
     * The mime type of the attachment file
     * 
     */
    @JsonProperty("contentType")
    public String getContentType() {
        return contentType;
    }

    /**
     * The mime type of the attachment file
     * 
     */
    @JsonProperty("contentType")
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    /**
     * The name of the original file attached
     * 
     */
    @JsonProperty("originalFileName")
    public String getOriginalFileName() {
        return originalFileName;
    }

    /**
     * The name of the original file attached
     * 
     */
    @JsonProperty("originalFileName")
    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
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
        return new ToStringBuilder(this).append("fileIdentifier", fileIdentifier).append("contentType", contentType).append("originalFileName", originalFileName).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(originalFileName).append(additionalProperties).append(contentType).append(fileIdentifier).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Attachment) == false) {
            return false;
        }
        Attachment rhs = ((Attachment) other);
        return new EqualsBuilder().append(originalFileName, rhs.originalFileName).append(additionalProperties, rhs.additionalProperties).append(contentType, rhs.contentType).append(fileIdentifier, rhs.fileIdentifier).isEquals();
    }

}
