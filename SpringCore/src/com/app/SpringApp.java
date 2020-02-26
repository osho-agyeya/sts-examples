package com.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beans.AccountOperations;
import com.beans.Hello;

public class SpringApp {

    public static void main(final String[] args) {
        // TODO Auto-generated method stub
        System.out.println("SpringApp.main()");


        // load the spring context(container)
        // ApplicationContext context = new
        // ClassPathXmlApplicationContext("context.xml");

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        context.getEnvironment().setActiveProfiles("dev");
        context.setConfigLocation("context.xml");
        context.refresh();

        // load a spring bean => By Type
        // Hello hello = context.getBean(Hello.class);
        // System.out.println("sayHello result:" + hello.sayHello());

        // load a spring bean => By Id(Name)
        Hello hello = (Hello) context.getBean("hello");
        System.out.println("sayHello result:" + hello.sayHello());

        hello = (Hello) context.getBean("welcome");
        System.out.println("sayHello result:" + hello.sayHello());


		/*
		 * AccountOperations operations = context.getBean(AccountOperations.class);
		 * operations.createAccount("Bablu", 3434500); operations.fetchAccounts();
		 */
        context.close();
    }

}
