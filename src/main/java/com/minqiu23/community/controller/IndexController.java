package com.minqiu23.community.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by Min-Qiu23 on 2019/8/21
 */

@Controller
public class IndexController {

    @RequestMapping("/")
    public String hello(){
        return "index";
    }
}
