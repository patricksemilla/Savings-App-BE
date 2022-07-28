package com.patrick.savingsApp.Repo;

import com.patrick.savingsApp.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TransactionRepo extends JpaRepository<Transaction,Long> {

    List<Transaction> findAll();

    void deleteById(long id);

    Optional<Transaction> findById(long id);
}
