package com.patrick.savingsApp.resource;

import com.patrick.savingsApp.model.Transaction;
import com.patrick.savingsApp.serviceImpl.TransactionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping( "/transaction")

public class TransactionResource {

    private final TransactionImpl transactionService;

    @Autowired
    public TransactionResource(TransactionImpl transactionService) {
        this.transactionService = transactionService;
    }


    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransaction() {
        List<Transaction> transaction = transactionService.findAllTransaction();
        HashMap<String, List<Transaction>> parasayoto = new HashMap<>();

        parasayoto.put("data", transaction);
        System.out.println(transaction.size());
        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }
}
