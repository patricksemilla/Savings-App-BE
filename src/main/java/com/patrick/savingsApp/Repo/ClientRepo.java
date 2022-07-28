package com.patrick.savingsApp.Repo;

import com.patrick.savingsApp.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client, Long> {

}
