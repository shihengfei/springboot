package com.qinmei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 模拟请求 Controller
 */
@Controller
public class PageController {

    @RequestMapping("/test")
    public String showPage(){
        return "show";
    }
}
