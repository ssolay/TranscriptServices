
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
 * PostOrderRequest
 * <p>
 * The JSON object for posting to /order API
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "student",
    "orderHeader"
})
public class RequestPostOrder {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("student")
    private Student student;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("orderHeader")
    private OrderHeader orderHeader;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("student")
    public Student getStudent() {
        return student;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("student")
    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("orderHeader")
    public OrderHeader getOrderHeader() {
        return orderHeader;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("orderHeader")
    public void setOrderHeader(OrderHeader orderHeader) {
        this.orderHeader = orderHeader;
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
        return new ToStringBuilder(this).append("student", student).append("orderHeader", orderHeader).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(orderHeader).append(additionalProperties).append(student).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RequestPostOrder) == false) {
            return false;
        }
        RequestPostOrder rhs = ((RequestPostOrder) other);
        return new EqualsBuilder().append(orderHeader, rhs.orderHeader).append(additionalProperties, rhs.additionalProperties).append(student, rhs.student).isEquals();
    }

}
