package com.patrick.savingsApp.service;

import com.patrick.savingsApp.Repo.accountRepo;
import com.patrick.savingsApp.model.account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class accountService {
    private final accountRepo AccountRepo;

    @Autowired
    public accountService(accountRepo accountRepo) {
        AccountRepo = accountRepo;
    }

    public account addAccount(account account){
        account.setaccount_number(Integer.valueOf(UUID.randomUUID().toString()));
        return AccountRepo.save(account);
        
    }

    public List<account> findAllaccount(){
        return AccountRepo.findAll();
    }

    public account updateaccount(account Account){
        return AccountRepo.save(Account);
    }

    public account findaccountByid(Long id){
        return AccountRepo.findaccountByid(id); //exception not found
    }
    public void deleteaccount(Long id){
        AccountRepo.deleteAccountByid(id);

    }
}
