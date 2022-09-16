
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
 * Not needed in UI. This is for Generic API conf. 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "toScprofilDynmicIntgrtnId",
    "toScprofilId",
    "integrationProvider",
    "rootUrl",
    "status"
})
public class ToScprofilDynmicIntgrtn {

    @JsonProperty("toScprofilDynmicIntgrtnId")
    private Integer toScprofilDynmicIntgrtnId;
    @JsonProperty("toScprofilId")
    private Integer toScprofilId;
    @JsonProperty("integrationProvider")
    private String integrationProvider;
    @JsonProperty("rootUrl")
    private String rootUrl;
    @JsonProperty("status")
    private String status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("toScprofilDynmicIntgrtnId")
    public Integer getToScprofilDynmicIntgrtnId() {
        return toScprofilDynmicIntgrtnId;
    }

    @JsonProperty("toScprofilDynmicIntgrtnId")
    public void setToScprofilDynmicIntgrtnId(Integer toScprofilDynmicIntgrtnId) {
        this.toScprofilDynmicIntgrtnId = toScprofilDynmicIntgrtnId;
    }

    @JsonProperty("toScprofilId")
    public Integer getToScprofilId() {
        return toScprofilId;
    }

    @JsonProperty("toScprofilId")
    public void setToScprofilId(Integer toScprofilId) {
        this.toScprofilId = toScprofilId;
    }

    @JsonProperty("integrationProvider")
    public String getIntegrationProvider() {
        return integrationProvider;
    }

    @JsonProperty("integrationProvider")
    public void setIntegrationProvider(String integrationProvider) {
        this.integrationProvider = integrationProvider;
    }

    @JsonProperty("rootUrl")
    public String getRootUrl() {
        return rootUrl;
    }

    @JsonProperty("rootUrl")
    public void setRootUrl(String rootUrl) {
        this.rootUrl = rootUrl;
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
        return new ToStringBuilder(this).append("toScprofilDynmicIntgrtnId", toScprofilDynmicIntgrtnId).append("toScprofilId", toScprofilId).append("integrationProvider", integrationProvider).append("rootUrl", rootUrl).append("status", status).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(toScprofilId).append(integrationProvider).append(additionalProperties).append(toScprofilDynmicIntgrtnId).append(rootUrl).append(status).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ToScprofilDynmicIntgrtn) == false) {
            return false;
        }
        ToScprofilDynmicIntgrtn rhs = ((ToScprofilDynmicIntgrtn) other);
        return new EqualsBuilder().append(toScprofilId, rhs.toScprofilId).append(integrationProvider, rhs.integrationProvider).append(additionalProperties, rhs.additionalProperties).append(toScprofilDynmicIntgrtnId, rhs.toScprofilDynmicIntgrtnId).append(rootUrl, rhs.rootUrl).append(status, rhs.status).isEquals();
    }

}
