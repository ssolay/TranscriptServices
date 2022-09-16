package com.nsc.tsui.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SystemMessage {
    @JsonView({Views.Nsc.class, Views.WebApp.class})
    private Integer titleCode;

    @JsonView({Views.Nsc.class, Views.WebApp.class})
    private String titleDescription;

    @JsonView({Views.Nsc.class, Views.WebApp.class})
    private String message;

    @JsonCreator
    public SystemMessage(@JsonProperty("titleCode") Integer titleCode,
                         @JsonProperty("titleDescription") String titleDescription,
                         @JsonProperty("message") String message){
        this.titleCode = titleCode;
        this.titleDescription = titleDescription;
        this.message = message;
    }
}
