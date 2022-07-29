package com.patrick.savingsApp.resource;

import com.patrick.savingsApp.Response;
import com.patrick.savingsApp.model.Card;
import com.patrick.savingsApp.model.Client;
import com.patrick.savingsApp.serviceImpl.CardServiceImpl;
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
@CrossOrigin
@RequestMapping( "/card")

public class CardResource {

        private final CardServiceImpl cardService;

        @Autowired
        public CardResource(CardServiceImpl cardService) {
            this.cardService = cardService;
        }

    @PostMapping("/save")
    public ResponseEntity<Response> saveCard(@RequestBody Card card){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("card", cardService.save(card)))
                        .message("card Created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
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
