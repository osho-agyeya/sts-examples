package com.boot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.model.Account;
import com.boot.repository.AccountRepository;

@Controller
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountRepository repository;

    @RequestMapping("/list")
    public String list(final Model model) {

        List<Account> accounts = this.repository.fetchAll();
        model.addAttribute("allAccounts", accounts);
        return "listAccounts";

    }

}
