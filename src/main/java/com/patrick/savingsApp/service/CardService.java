package com.patrick.savingsApp.service;

import com.patrick.savingsApp.model.Card;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CardService{
    Card save(Card card);
    Card findById(long id);
    Card deleteById(long id);
    List<Card> data();
}
