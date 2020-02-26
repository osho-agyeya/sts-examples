package com.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype") // this causes output to always have constructor call
                    // output
public class CustomerController {

    private CustomerService service;

    @Autowired
    public CustomerController(final CustomerService service) {
        System.out.println("CustomerController.CustomerController()");
        this.service = service; // this becomes a constructor injection
    }

    public void printName() {

        System.out.println("Full Name:" + this.service.getFullName());

    }

}
