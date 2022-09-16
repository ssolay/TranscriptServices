
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
    "deptId",
    "deptName",
    "ftpAccountName",
    "fileFormat"
})
public class ExchangeChanel {

    /**
     * Unique internal identifier
     * 
     */
    @JsonProperty("deptId")
    @JsonPropertyDescription("Unique internal identifier")
    private Integer deptId;
    @JsonProperty("deptName")
    private String deptName;
    /**
     * FTP account name
     * 
     */
    @JsonProperty("ftpAccountName")
    @JsonPropertyDescription("FTP account name")
    private String ftpAccountName;
    /**
     * Matched transcript file format (PDF, XML, EDI)
     * 
     */
    @JsonProperty("fileFormat")
    @JsonPropertyDescription("Matched transcript file format (PDF, XML, EDI)")
    private String fileFormat;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Unique internal identifier
     * 
     */
    @JsonProperty("deptId")
    public Integer getDeptId() {
        return deptId;
    }

    /**
     * Unique internal identifier
     * 
     */
    @JsonProperty("deptId")
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    @JsonProperty("deptName")
    public String getDeptName() {
        return deptName;
    }

    @JsonProperty("deptName")
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /**
     * FTP account name
     * 
     */
    @JsonProperty("ftpAccountName")
    public String getFtpAccountName() {
        return ftpAccountName;
    }

    /**
     * FTP account name
     * 
     */
    @JsonProperty("ftpAccountName")
    public void setFtpAccountName(String ftpAccountName) {
        this.ftpAccountName = ftpAccountName;
    }

    /**
     * Matched transcript file format (PDF, XML, EDI)
     * 
     */
    @JsonProperty("fileFormat")
    public String getFileFormat() {
        return fileFormat;
    }

    /**
     * Matched transcript file format (PDF, XML, EDI)
     * 
     */
    @JsonProperty("fileFormat")
    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
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
        return new ToStringBuilder(this).append("deptId", deptId).append("deptName", deptName).append("ftpAccountName", ftpAccountName).append("fileFormat", fileFormat).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(deptId).append(deptName).append(ftpAccountName).append(additionalProperties).append(fileFormat).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ExchangeChanel) == false) {
            return false;
        }
        ExchangeChanel rhs = ((ExchangeChanel) other);
        return new EqualsBuilder().append(deptId, rhs.deptId).append(deptName, rhs.deptName).append(ftpAccountName, rhs.ftpAccountName).append(additionalProperties, rhs.additionalProperties).append(fileFormat, rhs.fileFormat).isEquals();
    }

}
