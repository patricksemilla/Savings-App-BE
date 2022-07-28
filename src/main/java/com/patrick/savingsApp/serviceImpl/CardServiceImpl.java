package com.patrick.savingsApp.serviceImpl;

import com.patrick.savingsApp.Repo.CardRepo;
import com.patrick.savingsApp.model.Card;
import com.patrick.savingsApp.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class CardServiceImpl implements CardService {

    private final CardRepo repo;

    @Autowired
    public CardServiceImpl(CardRepo repo) {

        this.repo = repo;
    }

    @Override
    public boolean save(Card card) {

        try {
            repo.save(card);
        }catch (Exception e){
            // exception not save
        }
        return false;
    }

    @Override
    public Card findById(long id) {
        Optional<Card> cardOptional = repo.findById(id);

        return cardOptional.orElse(null);
    }

    @Override
    public Card deleteById(long id) {
        Card card = findById(id);

        if(card == null) return null;

        repo.deleteById(id);

        return card;
    }

    @Override
    public List<Card> data() {
        return repo.findAll();
    }

    public List<Card> findAllCards() {
        return repo.findAll();
    }
}
