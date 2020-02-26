package com.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping("/about")
    public String handleAboutRequest() {
        System.out.println("HomeController.handleAboutRequest()");
        return "about";
    }

    @RequestMapping("/generate")
    public ModelAndView generateRandomNumber(@RequestParam("min") final int min, @RequestParam("max") final int max,
        final HttpSession session) {
        Random random = new Random();
        int result = random.nextInt((max - min) + 1) - min;

        Map<String, Integer> data = new HashMap<String, Integer>();
        data.put("min", min);
        data.put("max", max);
        data.put("result", result);


        List<Integer> numbers = (List<Integer>) session.getAttribute("numbers");
        if (numbers == null) {
            numbers = new ArrayList<>();
        }
        numbers.add(result);
        session.setAttribute("numbers", numbers);

        return new ModelAndView("random", data); // go to jsp

    }

}
