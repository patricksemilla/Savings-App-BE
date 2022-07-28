package com.patrick.savingsApp.Repo;

import com.patrick.savingsApp.model.account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface accountRepo extends JpaRepository<account, Long> {


    void deleteAccountByid(Long id);

    account findaccountByid(Long id);
}
