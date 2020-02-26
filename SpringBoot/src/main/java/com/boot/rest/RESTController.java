package com.boot.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class RESTController {


    @RequestMapping(value = "/foo", method = RequestMethod.GET)
    public String foo() { // this should be a get
        return "hello foo";
    }

    // @RequestMapping("/bar")
    @GetMapping("/bar")
    public String bar() {
        return "hello bar";
    }

}

