package com.repository;

import java.util.List;

import com.model.Account;

public interface AccountRepository {

    List<Account> fetchAll();

}