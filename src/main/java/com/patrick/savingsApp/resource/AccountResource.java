package com.patrick.savingsApp.resource;

import com.patrick.savingsApp.model.Account;
import com.patrick.savingsApp.serviceImpl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping( "/account")
public class AccountResource {

    private final AccountServiceImpl accountService;

    @Autowired
    public AccountResource(AccountServiceImpl accountService) {
    this.accountService = accountService;
    }


    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts(){
        List<Account> account = accountService.findAllAccounts();
        HashMap<String, List<Account>> parasayoto = new HashMap<>();

        for(Account accounts: account){
            System.out.println(accounts.getAccount_balance());
        }

        parasayoto.put("data", account);
        System.out.println(account.size());
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

}
