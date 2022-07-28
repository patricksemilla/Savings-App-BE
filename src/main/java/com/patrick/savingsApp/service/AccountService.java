package com.patrick.savingsApp.service;

import com.patrick.savingsApp.model.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {

    boolean save(Account account);
    Account findById(long id);
    Account deleteById(long id);
    List<Account> data();

    List<Account> findAllAccounts();
}
