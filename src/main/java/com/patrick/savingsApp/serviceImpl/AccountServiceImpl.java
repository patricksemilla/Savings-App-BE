package com.patrick.savingsApp.serviceImpl;

import com.patrick.savingsApp.Repo.AccountRepo;

import com.patrick.savingsApp.model.Account;
import com.patrick.savingsApp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private final AccountRepo repo;

    @Autowired
    public AccountServiceImpl(AccountRepo repo) {

        this.repo = repo;
    }

    @Override
    public boolean save(Account account) {
        return false;
    }

    @Override
    public Account findById(long id) {
        Optional<Account> AccountOptional = repo.findById(id);

        return AccountOptional.orElse(null);
    }

    @Override
    public Account deleteById(long id) {
        Account account = findById(id);

        if(account == null) return null;

        repo.deleteById(id);

        return account;
    }

    @Override
    public List<Account> data() {
        return repo.findAll();
    }

    @Override
    public List<Account> findAllAccounts() {
        return repo.findAll();
    }
}
