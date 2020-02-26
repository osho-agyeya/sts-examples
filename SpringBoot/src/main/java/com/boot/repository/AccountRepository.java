package com.boot.repository;

import java.util.List;

import com.boot.model.Account;


public interface AccountRepository {

    List<Account> fetchAll();

}