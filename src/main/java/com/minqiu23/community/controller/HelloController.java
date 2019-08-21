package com.minqiu23.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Min-Qiu23 on 2019/8/21
 */

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(@RequestParam(name = "name") String name , Model model){

        // This is my first springboot project
        model.addAttribute("name", name);
        return "hello";
    }
}
