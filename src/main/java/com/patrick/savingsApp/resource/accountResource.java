package com.patrick.savingsApp.resource;

import com.patrick.savingsApp.model.account;
import com.patrick.savingsApp.service.accountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/account")
public class accountResource {
    private final accountService AccountService;

    public accountResource(accountService accountService) {
        AccountService = accountService;
    }
    @GetMapping
    public ResponseEntity<List<account>>getAllaccount() {
    List<account> Account = AccountService.findAllaccount();
    return new ResponseEntity<>(Account, HttpStatus.OK);
    }
}
