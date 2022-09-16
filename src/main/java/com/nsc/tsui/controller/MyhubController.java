package com.nsc.tsui.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/myhub")
public class MyhubController {

    Logger logger = LoggerFactory.getLogger(MyhubController.class);

    @RequestMapping(value = "/redirect", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE, produces = MediaType.ALL_VALUE)
    public String redirect(HttpEntity<String> httpEntity, HttpServletResponse httpServletResponse){
        logger.debug("post body | {}", httpEntity.getBody());
        return "redirect:/";
    }

}
