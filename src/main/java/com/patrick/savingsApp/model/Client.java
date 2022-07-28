package com.patrick.savingsApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Getter
@Setter

@Table(name = "client")
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "client_first_name")
    private String client_firstname;

    @Column(name = "client_last_name")
    private String client_lastname;

    @OneToOne
    @JoinColumn(name = "card")
    private Card card;

    @Column(name = "account_number")
    private Integer account_number;




}


