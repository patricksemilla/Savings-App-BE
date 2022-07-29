package com.patrick.savingsApp.service;

import com.patrick.savingsApp.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TransactionService {
    Transaction save(Transaction transaction);

    Transaction findById(long id);

    Transaction deleteById(long id);

    List<Transaction> data();

}
