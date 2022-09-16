package com.nsc.tsui.controller;

import com.codahale.metrics.annotation.Metered;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsc.tsui.model.School;
import com.nsc.tsui.model.SystemMessage;
import com.nsc.tsui.model.Views;
import com.nsc.tsui.model.generated.system.SystemConfig;
import com.nsc.tsui.service.TSUIRequestBuilder;
import com.nsc.tsui.service.TSUIService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SystemController {

    public static final Logger logger = LoggerFactory.getLogger(SystemController.class);

    @Autowired
    TSUIRequestBuilder tsuiRequestBuilder;

    @Autowired
    TSUIService tsuiService;

    @Value("${nsc.system.config.endpoint}")
    private String configEndpoint;

    @Value("${nsc.system.message.endpoint}")
    private String messageEndponit;

    ObjectMapper objectMapper = new ObjectMapper();

    private static final String STATES_CONFIG_KEY = "states";

    @Metered(name = "system-config-metered")
    @Timed(name = "system-config-timed")
    //@Cacheable("system-config")
    @GetMapping(value = "/system/config", produces = MediaType.APPLICATION_JSON)
    public @ResponseBody String systemConfig() throws IOException {
        String responseBody = tsuiService.callWebService(tsuiRequestBuilder.buildGet(configEndpoint));
        SystemConfig systemConfigs = objectMapper.readValue(responseBody,
                SystemConfig.class);
        return objectMapper.writerWithView(Views.WebApp.class)
                .writeValueAsString(systemConfigs);
    }

    @Metered(name = "system-config-states-metered")
    @Timed(name = "system-config-states-timed")
    //@Cacheable("system-config-states")
    @GetMapping(value = "/system/config/states", produces = MediaType.APPLICATION_JSON)
    public @ResponseBody String systemConfigStates(HttpServletResponse httpServletResponse) throws Exception {
        String responseBody = tsuiService.callWebService(tsuiRequestBuilder.buildGet(configEndpoint));
        SystemConfig systemConfigs = objectMapper.readValue(responseBody,
                SystemConfig.class);
        return objectMapper.writerWithView(Views.WebApp.class)
                .writeValueAsString(systemConfigs.state);
    }

    @Metered(name = "system-config-countries-metered")
    @Timed(name = "system-config-countris-timed")
//    @Cacheable("system-config-countries")
    @GetMapping(value = "/system/config/countries", produces = MediaType.APPLICATION_JSON)
    public @ResponseBody String systemConfigCountries(HttpServletResponse httpServletResponse) throws Exception {
        String responseBody = tsuiService.callWebService(tsuiRequestBuilder.buildGet(configEndpoint));
        SystemConfig systemConfigs = objectMapper.readValue(responseBody,
                SystemConfig.class);
        return objectMapper.writerWithView(Views.WebApp.class)
                .writeValueAsString(systemConfigs.country);
    }

    @Metered(name = "system-config-mobile-carriers-metered")
    @Timed(name = "system-config-mobile-carriers-timed")
//    @Cacheable("system-config-mobile-carriers")
    @GetMapping(value = "/system/config/mobile-carriers", produces = MediaType.APPLICATION_JSON)
    public @ResponseBody String systemConfigMobileCarriers(HttpServletResponse httpServletResponse) throws Exception {
        String responseBody = tsuiService.callWebService(tsuiRequestBuilder.buildGet(configEndpoint));
        SystemConfig systemConfigs = objectMapper.readValue(responseBody,
                SystemConfig.class);
        return objectMapper.writerWithView(Views.WebApp.class)
                .writeValueAsString(systemConfigs.mobileCarrier);
    }

    @Metered(name = "system-config-send-to-types-metered")
    @Timed(name = "system-config-send-to-types-timed")
    //@Cacheable("system-config-send-to-types")
    @GetMapping(value = "/system/config/send-to-types", produces = MediaType.APPLICATION_JSON)
    public @ResponseBody String systemConfigSendToTypes(HttpServletResponse httpServletResponse) throws Exception {
        String responseBody = tsuiService.callWebService(tsuiRequestBuilder.buildGet(configEndpoint));
        SystemConfig systemConfigs = objectMapper.readValue(responseBody,
                SystemConfig.class);
        return objectMapper.writerWithView(Views.WebApp.class)
                .writeValueAsString(systemConfigs.sendToType);
    }

    @Metered(name = "system-message-metered")
    @Timed(name = "system-message-timed")
    //@Cacheable("system-message")
    @GetMapping(value = "/system/message", produces = MediaType.APPLICATION_JSON)
    public @ResponseBody String systemMessage() throws IOException {
        List<SystemMessage> systemMessages =
                objectMapper.readValue(tsuiService.callWebService(tsuiRequestBuilder.buildGet(messageEndponit)),
                        new TypeReference<List<SystemMessage>>(){});
        return objectMapper.writerWithView(Views.WebApp.class).writeValueAsString(systemMessages);
    }
}
