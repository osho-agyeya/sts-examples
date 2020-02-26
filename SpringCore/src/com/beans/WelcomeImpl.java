package com.beans;

import org.springframework.stereotype.Component;

@Component("welcome")
public class WelcomeImpl implements Hello {


    public String sayHello() {
        return "Welcome to Spring...";
    }

}
