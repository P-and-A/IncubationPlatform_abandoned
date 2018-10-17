package com.incubationplatform.controller;

import com.incubationplatform.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private TestService testService;

    @GetMapping("/test")
    public String test(Model model){
        model.addAttribute("testData",testService.testService());
        return "test.html";
    }
}
