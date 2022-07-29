package com.patrick.savingsApp.serviceImpl;


import com.patrick.savingsApp.Repo.TransactionRepo;

import com.patrick.savingsApp.model.Transaction;
import com.patrick.savingsApp.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TransactionImpl implements TransactionService {
    private final TransactionRepo repo;

    @Autowired

    public TransactionImpl(TransactionRepo repo) {
        this.repo = repo;
    }

    @Override
    public Transaction save(Transaction transaction) {
        return repo.save(transaction);
    }

    @Override
    public Transaction findById(long id) {
        Optional<Transaction> TransactionOptional = repo.findById(id);

        return TransactionOptional.orElse(null);
    }

    @Override
    public Transaction deleteById(long id) {
        Transaction transaction = findById(id);

        if(transaction == null) return null;

        repo.deleteById(id);

        return transaction;
    }

    @Override
    public List<Transaction> data() {
        return repo.findAll();
    }

    public List<Transaction> findAllTransaction() {
        return repo.findAll();
    }
}
