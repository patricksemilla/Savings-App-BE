package com.patrick.savingsApp.resource;

import com.patrick.savingsApp.Response;
import com.patrick.savingsApp.model.Account;
import com.patrick.savingsApp.model.Client;
import com.patrick.savingsApp.serviceImpl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@CrossOrigin
@RequestMapping( "/account")
public class AccountResource {

    private final AccountServiceImpl accountService;

    @Autowired
    public AccountResource(AccountServiceImpl accountService) {
    this.accountService = accountService;
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveAccount(@RequestBody Account account){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("account", accountService.save(account)))
                        .message("Account Created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
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
