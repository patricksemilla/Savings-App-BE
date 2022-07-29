package com.patrick.savingsApp.resource;

import com.patrick.savingsApp.Response;
import com.patrick.savingsApp.model.Client;
import com.patrick.savingsApp.model.Transaction;
import com.patrick.savingsApp.serviceImpl.TransactionImpl;
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
@RequestMapping( "/transaction")

public class TransactionResource {

    private final TransactionImpl transactionService;

    @Autowired
    public TransactionResource(TransactionImpl transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveTransaction(@RequestBody Transaction transaction){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("transaction", transactionService.save(transaction)))
                        .message("Transaction Created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
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
