package com.nsc.tsui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ForwardController {


    public String forward() {
        return "forward:/";
    }

    @RequestMapping("/{path:[^\\.]+}")
    public String forwardWithPath() {
        return "forward:/";
    }
}
