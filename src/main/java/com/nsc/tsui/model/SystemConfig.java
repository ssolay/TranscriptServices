package com.nsc.tsui.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class SystemConfig {

//    @JsonView({Views.Nsc.class, Views.WebApp.class})
//    private String configName;

    @JsonView({Views.Nsc.class, Views.WebApp.class})
    private List<Option> states;

    @JsonView({Views.Nsc.class, Views.WebApp.class})
    private List<Option> countries;

    @JsonView({Views.Nsc.class, Views.WebApp.class})
    private List<Option> mobileCarriers;

    @JsonView({Views.Nsc.class, Views.WebApp.class})
    private List<Option> sendToTypes;

    @JsonCreator
    public SystemConfig(@JsonProperty("state") List<Option> states,
                        @JsonProperty("country") List<Option> countries,
                        @JsonProperty("mobileCarrier") List<Option> mobileCarriers,
                        @JsonProperty("sendToType") List<Option> sendToTypes){
        this.states = states;
        this.countries = countries;
        this.mobileCarriers = mobileCarriers;
        this.sendToTypes = sendToTypes;
    }
}
