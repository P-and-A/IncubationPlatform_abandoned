package com.incubationplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by GMUK on 2018/10/17 0017.
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @GetMapping("/test")
    public String test(Model model){
        return "/test.html";
    }
}
