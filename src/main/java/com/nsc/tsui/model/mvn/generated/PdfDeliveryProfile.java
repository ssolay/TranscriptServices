
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
 * Not needed for UI. Will be determined in Post recipient API
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "pdfDeliveryProfileId",
    "toScprofilId",
    "addDynamicWatermark",
    "pdfDeliveryFee",
    "offerDigitalRightsOption",
    "hasCertificate",
    "maxNumberViews",
    "addWatermark",
    "visibleDigitalSignature",
    "digitalSignatureFee",
    "rightsManagementFee",
    "electronicDeliveryFeePaidBy",
    "defaultProfile",
    "xcriptTypeId",
    "xmitCodeId",
    "status"
})
public class PdfDeliveryProfile {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("pdfDeliveryProfileId")
    private Integer pdfDeliveryProfileId;
    @JsonProperty("toScprofilId")
    private Integer toScprofilId;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("addDynamicWatermark")
    private String addDynamicWatermark;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("pdfDeliveryFee")
    private Double pdfDeliveryFee;
    @JsonProperty("offerDigitalRightsOption")
    private String offerDigitalRightsOption;
    @JsonProperty("hasCertificate")
    private String hasCertificate;
    @JsonProperty("maxNumberViews")
    private Integer maxNumberViews;
    @JsonProperty("addWatermark")
    private String addWatermark;
    @JsonProperty("visibleDigitalSignature")
    private String visibleDigitalSignature;
    @JsonProperty("digitalSignatureFee")
    private Double digitalSignatureFee;
    @JsonProperty("rightsManagementFee")
    private Double rightsManagementFee;
    @JsonProperty("electronicDeliveryFeePaidBy")
    private String electronicDeliveryFeePaidBy;
    @JsonProperty("defaultProfile")
    private String defaultProfile;
    @JsonProperty("xcriptTypeId")
    private Integer xcriptTypeId;
    @JsonProperty("xmitCodeId")
    private Integer xmitCodeId;
    @JsonProperty("status")
    private String status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("pdfDeliveryProfileId")
    public Integer getPdfDeliveryProfileId() {
        return pdfDeliveryProfileId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("pdfDeliveryProfileId")
    public void setPdfDeliveryProfileId(Integer pdfDeliveryProfileId) {
        this.pdfDeliveryProfileId = pdfDeliveryProfileId;
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
    @JsonProperty("addDynamicWatermark")
    public String getAddDynamicWatermark() {
        return addDynamicWatermark;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("addDynamicWatermark")
    public void setAddDynamicWatermark(String addDynamicWatermark) {
        this.addDynamicWatermark = addDynamicWatermark;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("pdfDeliveryFee")
    public Double getPdfDeliveryFee() {
        return pdfDeliveryFee;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("pdfDeliveryFee")
    public void setPdfDeliveryFee(Double pdfDeliveryFee) {
        this.pdfDeliveryFee = pdfDeliveryFee;
    }

    @JsonProperty("offerDigitalRightsOption")
    public String getOfferDigitalRightsOption() {
        return offerDigitalRightsOption;
    }

    @JsonProperty("offerDigitalRightsOption")
    public void setOfferDigitalRightsOption(String offerDigitalRightsOption) {
        this.offerDigitalRightsOption = offerDigitalRightsOption;
    }

    @JsonProperty("hasCertificate")
    public String getHasCertificate() {
        return hasCertificate;
    }

    @JsonProperty("hasCertificate")
    public void setHasCertificate(String hasCertificate) {
        this.hasCertificate = hasCertificate;
    }

    @JsonProperty("maxNumberViews")
    public Integer getMaxNumberViews() {
        return maxNumberViews;
    }

    @JsonProperty("maxNumberViews")
    public void setMaxNumberViews(Integer maxNumberViews) {
        this.maxNumberViews = maxNumberViews;
    }

    @JsonProperty("addWatermark")
    public String getAddWatermark() {
        return addWatermark;
    }

    @JsonProperty("addWatermark")
    public void setAddWatermark(String addWatermark) {
        this.addWatermark = addWatermark;
    }

    @JsonProperty("visibleDigitalSignature")
    public String getVisibleDigitalSignature() {
        return visibleDigitalSignature;
    }

    @JsonProperty("visibleDigitalSignature")
    public void setVisibleDigitalSignature(String visibleDigitalSignature) {
        this.visibleDigitalSignature = visibleDigitalSignature;
    }

    @JsonProperty("digitalSignatureFee")
    public Double getDigitalSignatureFee() {
        return digitalSignatureFee;
    }

    @JsonProperty("digitalSignatureFee")
    public void setDigitalSignatureFee(Double digitalSignatureFee) {
        this.digitalSignatureFee = digitalSignatureFee;
    }

    @JsonProperty("rightsManagementFee")
    public Double getRightsManagementFee() {
        return rightsManagementFee;
    }

    @JsonProperty("rightsManagementFee")
    public void setRightsManagementFee(Double rightsManagementFee) {
        this.rightsManagementFee = rightsManagementFee;
    }

    @JsonProperty("electronicDeliveryFeePaidBy")
    public String getElectronicDeliveryFeePaidBy() {
        return electronicDeliveryFeePaidBy;
    }

    @JsonProperty("electronicDeliveryFeePaidBy")
    public void setElectronicDeliveryFeePaidBy(String electronicDeliveryFeePaidBy) {
        this.electronicDeliveryFeePaidBy = electronicDeliveryFeePaidBy;
    }

    @JsonProperty("defaultProfile")
    public String getDefaultProfile() {
        return defaultProfile;
    }

    @JsonProperty("defaultProfile")
    public void setDefaultProfile(String defaultProfile) {
        this.defaultProfile = defaultProfile;
    }

    @JsonProperty("xcriptTypeId")
    public Integer getXcriptTypeId() {
        return xcriptTypeId;
    }

    @JsonProperty("xcriptTypeId")
    public void setXcriptTypeId(Integer xcriptTypeId) {
        this.xcriptTypeId = xcriptTypeId;
    }

    @JsonProperty("xmitCodeId")
    public Integer getXmitCodeId() {
        return xmitCodeId;
    }

    @JsonProperty("xmitCodeId")
    public void setXmitCodeId(Integer xmitCodeId) {
        this.xmitCodeId = xmitCodeId;
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
        return new ToStringBuilder(this).append("pdfDeliveryProfileId", pdfDeliveryProfileId).append("toScprofilId", toScprofilId).append("addDynamicWatermark", addDynamicWatermark).append("pdfDeliveryFee", pdfDeliveryFee).append("offerDigitalRightsOption", offerDigitalRightsOption).append("hasCertificate", hasCertificate).append("maxNumberViews", maxNumberViews).append("addWatermark", addWatermark).append("visibleDigitalSignature", visibleDigitalSignature).append("digitalSignatureFee", digitalSignatureFee).append("rightsManagementFee", rightsManagementFee).append("electronicDeliveryFeePaidBy", electronicDeliveryFeePaidBy).append("defaultProfile", defaultProfile).append("xcriptTypeId", xcriptTypeId).append("xmitCodeId", xmitCodeId).append("status", status).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(pdfDeliveryProfileId).append(digitalSignatureFee).append(hasCertificate).append(pdfDeliveryFee).append(defaultProfile).append(addWatermark).append(visibleDigitalSignature).append(toScprofilId).append(xmitCodeId).append(electronicDeliveryFeePaidBy).append(addDynamicWatermark).append(maxNumberViews).append(additionalProperties).append(xcriptTypeId).append(offerDigitalRightsOption).append(rightsManagementFee).append(status).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PdfDeliveryProfile) == false) {
            return false;
        }
        PdfDeliveryProfile rhs = ((PdfDeliveryProfile) other);
        return new EqualsBuilder().append(pdfDeliveryProfileId, rhs.pdfDeliveryProfileId).append(digitalSignatureFee, rhs.digitalSignatureFee).append(hasCertificate, rhs.hasCertificate).append(pdfDeliveryFee, rhs.pdfDeliveryFee).append(defaultProfile, rhs.defaultProfile).append(addWatermark, rhs.addWatermark).append(visibleDigitalSignature, rhs.visibleDigitalSignature).append(toScprofilId, rhs.toScprofilId).append(xmitCodeId, rhs.xmitCodeId).append(electronicDeliveryFeePaidBy, rhs.electronicDeliveryFeePaidBy).append(addDynamicWatermark, rhs.addDynamicWatermark).append(maxNumberViews, rhs.maxNumberViews).append(additionalProperties, rhs.additionalProperties).append(xcriptTypeId, rhs.xcriptTypeId).append(offerDigitalRightsOption, rhs.offerDigitalRightsOption).append(rightsManagementFee, rhs.rightsManagementFee).append(status, rhs.status).isEquals();
    }

}
