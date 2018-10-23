package com.incubationplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by GMUK on 2018/10/20 0020.
 */
@Controller
@RequestMapping("/visitor")
public class LoginController {
    @RequestMapping("/login")
    public String toLogin(Model model){
        return "visitor/login.html";
    }

    @RequestMapping("/loginError")
    public String toLoginError(Model model){
        return "visitor/loginError.html";
    }
}
