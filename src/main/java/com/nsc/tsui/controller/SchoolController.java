package com.nsc.tsui.controller;

import com.codahale.metrics.annotation.Metered;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.nsc.tsui.model.School;
import com.nsc.tsui.model.Views;
import com.nsc.tsui.model.generated.SchoolProfile;
import com.nsc.tsui.service.TSUIRequestBuilder;
import com.nsc.tsui.service.TSUIService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SchoolController {

    public static final Logger logger = LoggerFactory.getLogger(SchoolController.class);

    public static final String SCHOOL_PROFILE_BY_FICE_CODE_ENDPOINT = "/ficecode";
    public static final String SCHOOL_PROFILE_BY_ID_ENDPOINT = "/toscprofilid";

    @Autowired
    TSUIRequestBuilder tsuiRequestBuilder;

    @Autowired
    TSUIService tsuiService;

    @Value("${nsc.find.school.endpoint}")
    private String schoolEndpoint;

    @Value("${nsc.to.school.endpoint}")
    private String schoolProfileEndpoint;

    ObjectMapper objectMapper = new ObjectMapper();

    @Metered(name = "school-metered")
    @Timed(name = "school-timed")
//    @Cacheable("all-schools")
    @GetMapping(value = "/school", produces = MediaType.APPLICATION_JSON)
    public @ResponseBody String findSchoolByName() throws IOException {
        String responseBody = tsuiService.callWebService(tsuiRequestBuilder.buildGet(schoolEndpoint));
        logger.debug("school raw response | {}", responseBody);
        return objectMapper.writerWithView(Views.WebApp.class)
                .writeValueAsString(objectMapper.readValue(responseBody,
                                new TypeReference<List<School>>(){}));
    }

    @Metered(name = "school-by-name-metered")
    @Timed(name = "school-by-name-timed")
    @GetMapping(value = "/school/{name}", produces = MediaType.APPLICATION_JSON)
    public @ResponseBody String findSchoolByName(@PathVariable("name") String name) throws IOException {
        List<School> schools =
                objectMapper.readValue(tsuiService.callWebService(tsuiRequestBuilder.buildGet(schoolEndpoint)),
                        new TypeReference<List<School>>(){});
        List<School> foundSchools = Lists.newArrayList();
        for(School school : schools){
            if(school.getName().toLowerCase().contains(name.toLowerCase())){
                foundSchools.add(school);
            }
        }
        return objectMapper.writerWithView(Views.WebApp.class).writeValueAsString(foundSchools);
    }

    @Metered(name = "school-by-ficecode-metered")
    @Timed(name = "school-by-ficecode-timed")
    @GetMapping(value = "/school/ficecode/{ficecode}", produces = MediaType.APPLICATION_JSON)
    public @ResponseBody String schoolProfileByFiceCode(@PathVariable("ficecode") String ficecode,
                                                        HttpServletResponse httpServletResponse) throws IOException {
        String response = tsuiService.callWebService(tsuiRequestBuilder.buildGet(schoolProfileEndpoint +
                                SCHOOL_PROFILE_BY_FICE_CODE_ENDPOINT +
                                "/" + ficecode));
        if(!Strings.isNullOrEmpty(response)) {
            SchoolProfile schoolProfile =
                    objectMapper.readValue(response, SchoolProfile.class);
            return objectMapper.writerWithView(Views.WebApp.class).writeValueAsString(schoolProfile);
        } else {
            httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
            return "";
        }
    }

    @Metered(name = "school-by-toscprofileid-id-metered")
    @Timed(name = "school-by-toscprofileid-id-timed")
    @GetMapping(value = "/school/toscprofileid/{toscprofilid}", produces = MediaType.APPLICATION_JSON)
    public @ResponseBody String schoolProfileBySchoolProfileIdd(@PathVariable("toscprofilid") String toscprofilid,
                                                                HttpServletResponse httpServletResponse) throws IOException {
        String response = tsuiService.callWebService(tsuiRequestBuilder.buildGet(schoolProfileEndpoint +
                        SCHOOL_PROFILE_BY_ID_ENDPOINT +
                        "/" + toscprofilid));
        logger.debug("toscprofilid response | {} ", response);
        if(!Strings.isNullOrEmpty(response)) {
            SchoolProfile schoolProfile =
                    objectMapper.readValue(response,
                            SchoolProfile.class);
            return objectMapper.writerWithView(Views.WebApp.class).writeValueAsString(schoolProfile);
        } else {
            httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
            return "";
        }
    }
}
