package com.nsc.tsui.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Option {

    @JsonView({Views.Nsc.class, Views.WebApp.class})
    private String code;

    @JsonView({Views.Nsc.class, Views.WebApp.class})
    private String codeDescription;

    @JsonCreator
    public Option(@JsonProperty("code") String code,
                  @JsonProperty("codeDescription") String codeDescription){
        this.code = code;
        this.codeDescription = codeDescription;
    }
}
