package com.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.beans.CustomerController;
import com.beans.Hello;
import com.config.AppConfig;

public class SpringAnnotationApp {

    public static void main(final String[] args) {

        // load the context
        System.out.println("SpringAnnotationApp.main()");

        AppConfig config = new AppConfig();

        // ApplicationContext context = new
        // AnnotationConfigApplicationContext(AppConfig.class); // context
        // is
        // creating
        // container

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // this line above is creating the container


        context.getEnvironment().setActiveProfiles("test"); // switch between
                                                            // profiles
        context.register(AppConfig.class);
        context.refresh();


        Hello hello = (Hello) context.getBean("hello");

        System.out.println("Type of hello: " + hello.getClass().getName()); // if
                                                                            // you
                                                                            // enable
                                                                            // aop,
                                                                            // then
                                                                            // proxy,
                                                                            // otherwise
                                                                            // hello.impl
        System.out.println("sayHello: " + hello.sayHello());

        CustomerController controller1 = context.getBean(CustomerController.class);
        controller1.printName();


        // CustomerController controller2 =
        // context.getBean(CustomerController.class);
        // controller2.printName();
        //
        // CustomerController controller3 =
        // context.getBean(CustomerController.class);
        // controller3.printName();


        context.close();


    }

}
