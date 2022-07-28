package com.patrick.savingsApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter

@Table(name = "transaction_type")
public class Transaction_type implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @OneToOne
    @JoinColumn(name = "transaction_type_ID")
    private Transaction transaction_typeID;

}
