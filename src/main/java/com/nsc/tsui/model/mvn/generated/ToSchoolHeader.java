
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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "logoBase64",
    "contentType",
    "bgColor",
    "headerStyle",
    "subHeaderStyle",
    "imgWidth",
    "imgHeight",
    "alternateText"
})
public class ToSchoolHeader {

    @JsonProperty("logoBase64")
    private String logoBase64;
    @JsonProperty("contentType")
    private String contentType;
    @JsonProperty("bgColor")
    private String bgColor;
    @JsonProperty("headerStyle")
    private String headerStyle;
    @JsonProperty("subHeaderStyle")
    private String subHeaderStyle;
    @JsonProperty("imgWidth")
    private String imgWidth;
    @JsonProperty("imgHeight")
    private String imgHeight;
    @JsonProperty("alternateText")
    private String alternateText;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("logoBase64")
    public String getLogoBase64() {
        return logoBase64;
    }

    @JsonProperty("logoBase64")
    public void setLogoBase64(String logoBase64) {
        this.logoBase64 = logoBase64;
    }

    @JsonProperty("contentType")
    public String getContentType() {
        return contentType;
    }

    @JsonProperty("contentType")
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @JsonProperty("bgColor")
    public String getBgColor() {
        return bgColor;
    }

    @JsonProperty("bgColor")
    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    @JsonProperty("headerStyle")
    public String getHeaderStyle() {
        return headerStyle;
    }

    @JsonProperty("headerStyle")
    public void setHeaderStyle(String headerStyle) {
        this.headerStyle = headerStyle;
    }

    @JsonProperty("subHeaderStyle")
    public String getSubHeaderStyle() {
        return subHeaderStyle;
    }

    @JsonProperty("subHeaderStyle")
    public void setSubHeaderStyle(String subHeaderStyle) {
        this.subHeaderStyle = subHeaderStyle;
    }

    @JsonProperty("imgWidth")
    public String getImgWidth() {
        return imgWidth;
    }

    @JsonProperty("imgWidth")
    public void setImgWidth(String imgWidth) {
        this.imgWidth = imgWidth;
    }

    @JsonProperty("imgHeight")
    public String getImgHeight() {
        return imgHeight;
    }

    @JsonProperty("imgHeight")
    public void setImgHeight(String imgHeight) {
        this.imgHeight = imgHeight;
    }

    @JsonProperty("alternateText")
    public String getAlternateText() {
        return alternateText;
    }

    @JsonProperty("alternateText")
    public void setAlternateText(String alternateText) {
        this.alternateText = alternateText;
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
        return new ToStringBuilder(this).append("logoBase64", logoBase64).append("contentType", contentType).append("bgColor", bgColor).append("headerStyle", headerStyle).append("subHeaderStyle", subHeaderStyle).append("imgWidth", imgWidth).append("imgHeight", imgHeight).append("alternateText", alternateText).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(imgWidth).append(bgColor).append(alternateText).append(imgHeight).append(logoBase64).append(additionalProperties).append(contentType).append(subHeaderStyle).append(headerStyle).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ToSchoolHeader) == false) {
            return false;
        }
        ToSchoolHeader rhs = ((ToSchoolHeader) other);
        return new EqualsBuilder().append(imgWidth, rhs.imgWidth).append(bgColor, rhs.bgColor).append(alternateText, rhs.alternateText).append(imgHeight, rhs.imgHeight).append(logoBase64, rhs.logoBase64).append(additionalProperties, rhs.additionalProperties).append(contentType, rhs.contentType).append(subHeaderStyle, rhs.subHeaderStyle).append(headerStyle, rhs.headerStyle).isEquals();
    }

}
