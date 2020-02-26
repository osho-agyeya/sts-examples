package com.boot.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.Account;

@RestController
@RequestMapping("/api/accounts")
public class AccountRESTController {

    private List<Account> accounts = new ArrayList<>();

    public AccountRESTController() {
        this.accounts.add(new Account(1, "Anil", 60000));
        this.accounts.add(new Account(2, "Ajay", 4500));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Account> fetchAll() {
        return this.accounts;
    }

    // /api/acocunts?id=2 // @RequestMapping
    // /api/accounts/2 //@PathVariable
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Account> fetchById(@PathVariable final int id) {

        Optional<Account> account = this.accounts.stream().filter(acc -> acc.getId() == id).findFirst();
        if (account.isPresent()) {
            return new ResponseEntity<Account>(account.get(), HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Void> save(@RequestBody final Account account) {

        if (account.getId() <= 0 || account.getBalance() < 0 || account.getName() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {
            this.accounts.add(account);
            return ResponseEntity.status(HttpStatus.OK).build();
        }


    }


}