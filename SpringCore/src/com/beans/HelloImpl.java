package com.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// singleton bean means lifetime of bean is lifetime of container


@Component("hello") // default id="helloImpl"
public class HelloImpl implements Hello {

    @Autowired
    private CustomerController controller;

    public HelloImpl() {
        // TODO Auto-generated constructor stub
        System.out.println("HelloImpl.HelloImpl()" + this.controller);// here
                                                                      // we get
                                                                      // null
                                                                      // in
                                                                      // output
                                                                      // because
                                                                      // injection
                                                                      // happens
                                                                      // after
                                                                      // postconstruct
                                                                      // has
                                                                      // been
                                                                      // called
    }

    @PostConstruct
    public void init() {
        System.out.println("HelloImpl.init()" + this.controller);

        // here we should post things that need to be initialized after
        // injections
    }

    @PreDestroy
    public void dispose() {
        System.out.println("HelloImpl.dispose()");
        // we can write cleanup code
    }
    // this is like the finalize method, which runs when the garbage
    // collector starts, this will happend when the heap runs out of memory


    @Value("spring core")
    private String message;


    public String getMessage() {
        return this.message;
    }


    public void setMessage(final String message) {
        this.message = message;
    }

    @Override
    public String sayHello() {
        return "Hello" + this.message;
    }


}
