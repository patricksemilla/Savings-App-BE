package com.patrick.savingsApp.resource;

import com.patrick.savingsApp.model.Card;
import com.patrick.savingsApp.serviceImpl.CardServiceImpl;
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
@RequestMapping( "/card")

public class CardResource {

        private final CardServiceImpl cardService;

        @Autowired
        public CardResource(CardServiceImpl cardService) {
            this.cardService = cardService;
        }


        @GetMapping
        public ResponseEntity<List<Card>> getAllCards(){
            List<Card> card = cardService.findAllCards();
            HashMap<String, List<Card>> parasayoto = new HashMap<>();

            parasayoto.put("data", card);
            System.out.println(card.size());
            return new ResponseEntity<>(card, HttpStatus.OK);
        }
}
