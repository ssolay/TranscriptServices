package com.nsc.tsui.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
public class School {

    @JsonView({Views.Nsc.class, Views.WebApp.class})
    private Integer scProfileId;
    @JsonView({Views.Nsc.class, Views.WebApp.class})
    private String ficeCode;
    @JsonView({Views.Nsc.class, Views.WebApp.class})
    private String name;
    @JsonView({Views.Nsc.class, Views.WebApp.class})
    private String uiVersion;

    @JsonCreator
    public School(@JsonProperty("toScprofilId") Integer scProfileId,
                  @JsonProperty("ficeCode") String ficeCode,
                  @JsonProperty("schlName") String name,
                  @JsonProperty("uiVersion") String uiVersion){
        this.scProfileId = scProfileId;
        this.ficeCode = ficeCode;
        this.name = name;
        this.uiVersion = uiVersion;
    }
}
