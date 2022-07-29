package com.patrick.savingsApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter

@Table(name = "card")
public class Card implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "card_number")
    private int cartNumber;

}
