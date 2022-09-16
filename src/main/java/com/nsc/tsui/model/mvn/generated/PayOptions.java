
package com.nsc.tsui.model.mvn.generated;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "deliveryMethods",
    "quantities",
    "transcriptTypes"
})
public class PayOptions {

    @JsonProperty("deliveryMethods")
    @JsonDeserialize(as = LinkedHashSet.class)
    private Set<DeliveryMethod> deliveryMethods = new LinkedHashSet<DeliveryMethod>();
    @JsonProperty("quantities")
    @JsonDeserialize(as = LinkedHashSet.class)
    private Set<Quantity> quantities = new LinkedHashSet<Quantity>();
    @JsonProperty("transcriptTypes")
    @JsonDeserialize(as = LinkedHashSet.class)
    private Set<TranscriptType> transcriptTypes = new LinkedHashSet<TranscriptType>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("deliveryMethods")
    public Set<DeliveryMethod> getDeliveryMethods() {
        return deliveryMethods;
    }

    @JsonProperty("deliveryMethods")
    public void setDeliveryMethods(Set<DeliveryMethod> deliveryMethods) {
        this.deliveryMethods = deliveryMethods;
    }

    @JsonProperty("quantities")
    public Set<Quantity> getQuantities() {
        return quantities;
    }

    @JsonProperty("quantities")
    public void setQuantities(Set<Quantity> quantities) {
        this.quantities = quantities;
    }

    @JsonProperty("transcriptTypes")
    public Set<TranscriptType> getTranscriptTypes() {
        return transcriptTypes;
    }

    @JsonProperty("transcriptTypes")
    public void setTranscriptTypes(Set<TranscriptType> transcriptTypes) {
        this.transcriptTypes = transcriptTypes;
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
        return new ToStringBuilder(this).append("deliveryMethods", deliveryMethods).append("quantities", quantities).append("transcriptTypes", transcriptTypes).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(quantities).append(additionalProperties).append(deliveryMethods).append(transcriptTypes).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PayOptions) == false) {
            return false;
        }
        PayOptions rhs = ((PayOptions) other);
        return new EqualsBuilder().append(quantities, rhs.quantities).append(additionalProperties, rhs.additionalProperties).append(deliveryMethods, rhs.deliveryMethods).append(transcriptTypes, rhs.transcriptTypes).isEquals();
    }

}
