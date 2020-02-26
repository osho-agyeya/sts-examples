package com.boot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping
    // @ResponseBody //due to this the response becomes the string "welcome"
    public String welcome() {
        System.out.println("HomeController.welcome()");
        return "welcome";
    }

    // jsps are outdated: freemarkers, velocity, thymeleaf
    // jasper compiler is in web server

}
