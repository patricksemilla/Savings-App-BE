package com.patrick.savingsApp.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;



@Entity
@NoArgsConstructor
@Table(name = "account")
@Getter
@Setter
@AllArgsConstructor
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client")
    private Client client;

    @Column(name = "account_balance")
    private Double account_balance;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "create_at")
    private Date created_at;



}

