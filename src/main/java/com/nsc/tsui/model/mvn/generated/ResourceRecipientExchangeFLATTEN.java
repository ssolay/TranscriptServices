
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
 * TOScprofileDetail
 * <p>
 * An object for an recipient organization that contains detail inforamtion about exchange network
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "exchangeNetworkType",
    "exchangeChanel",
    "subNetwork",
    "recipientDepartments"
})
public class ResourceRecipientExchangeFLATTEN {

    /**
     * One of the value (ETX, SPEEDE, OBOR). Set in recpipient.exchangeNetworkType
     * 
     */
    @JsonProperty("exchangeNetworkType")
    @JsonPropertyDescription("One of the value (ETX, SPEEDE, OBOR). Set in recpipient.exchangeNetworkType")
    private String exchangeNetworkType;
    @JsonProperty("exchangeChanel")
    private ExchangeChanel exchangeChanel;
    @JsonProperty("subNetwork")
    private ExchangeChanel subNetwork;
    /**
     * For ETX schools without sub network types
     * 
     */
    @JsonProperty("recipientDepartments")
    @JsonPropertyDescription("For ETX schools without sub network types")
    private List<ExchangeChanel> recipientDepartments = new ArrayList<ExchangeChanel>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * One of the value (ETX, SPEEDE, OBOR). Set in recpipient.exchangeNetworkType
     * 
     */
    @JsonProperty("exchangeNetworkType")
    public String getExchangeNetworkType() {
        return exchangeNetworkType;
    }

    /**
     * One of the value (ETX, SPEEDE, OBOR). Set in recpipient.exchangeNetworkType
     * 
     */
    @JsonProperty("exchangeNetworkType")
    public void setExchangeNetworkType(String exchangeNetworkType) {
        this.exchangeNetworkType = exchangeNetworkType;
    }

    @JsonProperty("exchangeChanel")
    public ExchangeChanel getExchangeChanel() {
        return exchangeChanel;
    }

    @JsonProperty("exchangeChanel")
    public void setExchangeChanel(ExchangeChanel exchangeChanel) {
        this.exchangeChanel = exchangeChanel;
    }

    @JsonProperty("subNetwork")
    public ExchangeChanel getSubNetwork() {
        return subNetwork;
    }

    @JsonProperty("subNetwork")
    public void setSubNetwork(ExchangeChanel subNetwork) {
        this.subNetwork = subNetwork;
    }

    /**
     * For ETX schools without sub network types
     * 
     */
    @JsonProperty("recipientDepartments")
    public List<ExchangeChanel> getRecipientDepartments() {
        return recipientDepartments;
    }

    /**
     * For ETX schools without sub network types
     * 
     */
    @JsonProperty("recipientDepartments")
    public void setRecipientDepartments(List<ExchangeChanel> recipientDepartments) {
        this.recipientDepartments = recipientDepartments;
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
        return new ToStringBuilder(this).append("exchangeNetworkType", exchangeNetworkType).append("exchangeChanel", exchangeChanel).append("subNetwork", subNetwork).append("recipientDepartments", recipientDepartments).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(recipientDepartments).append(exchangeChanel).append(additionalProperties).append(exchangeNetworkType).append(subNetwork).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ResourceRecipientExchangeFLATTEN) == false) {
            return false;
        }
        ResourceRecipientExchangeFLATTEN rhs = ((ResourceRecipientExchangeFLATTEN) other);
        return new EqualsBuilder().append(recipientDepartments, rhs.recipientDepartments).append(exchangeChanel, rhs.exchangeChanel).append(additionalProperties, rhs.additionalProperties).append(exchangeNetworkType, rhs.exchangeNetworkType).append(subNetwork, rhs.subNetwork).isEquals();
    }

}
