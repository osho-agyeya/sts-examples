package com.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.Account;
import com.repository.AccountRepositoryImpl;

@Controller
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountRepositoryImpl repository;// to be injected


    @RequestMapping("/toUpdateAccountJSP")
    public ModelAndView handleAboutRequest(@RequestParam("id") final int id) {

        System.out.println("The id that has been chosen is=" + id);

        return new ModelAndView("updateAccount", "idForUpdate", id);
    }

    @RequestMapping("/list")
    public ModelAndView list() {

        System.out.println("AccountController.list()");

        List<Account> accounts = this.repository.fetchAll();

        return new ModelAndView("listAccounts", "allAccounts", accounts);


    }

    @RequestMapping("/update")
    public void updateAccountById(@RequestParam("name") final String name, @RequestParam("balance") final double balance,
        @RequestParam("id") final int id, final HttpSession session) {

        System.out.println("AccountController.updateAccount()");

        this.repository.updateAccount(new Account(id, name, balance));

        list();

    }


}
