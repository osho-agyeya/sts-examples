package com.repository;

import java.util.List;

import com.model.Account;
import com.repository.exceptions.AccountRepositoryException;

public interface AccountRepository {

    // crud

    public List<Account> fetchAllAccounts() throws AccountRepositoryException;

    public Account fetchAccountById(int id) throws AccountRepositoryException;

    public void saveAccount(final Account newAccount) throws AccountRepositoryException;

    public void updateAccount() throws AccountRepositoryException;

    public void removeAccount(int id) throws AccountRepositoryException;

}
