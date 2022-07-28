package com.patrick.savingsApp.Repo;

import com.patrick.savingsApp.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepo extends JpaRepository<Card, Long> {

}