
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
 * TOOrder
 * <p>
 * An order object including student info and order header
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "student",
    "orderHeader",
    "recipients",
    "payment"
})
public class ResourceOrder {

    @JsonProperty("student")
    private Student student;
    @JsonProperty("orderHeader")
    private OrderHeader_ orderHeader;
    @JsonProperty("recipients")
    private List<RequestPostRecipient> recipients = new ArrayList<RequestPostRecipient>();
    /**
     * PaymentDetail
     * <p>
     * An object including payment details
     * 
     */
    @JsonProperty("payment")
    @JsonPropertyDescription("An object including payment details")
    private RequestPostPayment payment;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("student")
    public Student getStudent() {
        return student;
    }

    @JsonProperty("student")
    public void setStudent(Student student) {
        this.student = student;
    }

    @JsonProperty("orderHeader")
    public OrderHeader_ getOrderHeader() {
        return orderHeader;
    }

    @JsonProperty("orderHeader")
    public void setOrderHeader(OrderHeader_ orderHeader) {
        this.orderHeader = orderHeader;
    }

    @JsonProperty("recipients")
    public List<RequestPostRecipient> getRecipients() {
        return recipients;
    }

    @JsonProperty("recipients")
    public void setRecipients(List<RequestPostRecipient> recipients) {
        this.recipients = recipients;
    }

    /**
     * PaymentDetail
     * <p>
     * An object including payment details
     * 
     */
    @JsonProperty("payment")
    public RequestPostPayment getPayment() {
        return payment;
    }

    /**
     * PaymentDetail
     * <p>
     * An object including payment details
     * 
     */
    @JsonProperty("payment")
    public void setPayment(RequestPostPayment payment) {
        this.payment = payment;
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
        return new ToStringBuilder(this).append("student", student).append("orderHeader", orderHeader).append("recipients", recipients).append("payment", payment).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(payment).append(orderHeader).append(additionalProperties).append(student).append(recipients).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ResourceOrder) == false) {
            return false;
        }
        ResourceOrder rhs = ((ResourceOrder) other);
        return new EqualsBuilder().append(payment, rhs.payment).append(orderHeader, rhs.orderHeader).append(additionalProperties, rhs.additionalProperties).append(student, rhs.student).append(recipients, rhs.recipients).isEquals();
    }

}
