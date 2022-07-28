package com.patrick.savingsApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter

@Table(name = "transaction")
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column (name = "transaction_id")
    private Integer transaction_id;

    @Column(name = "account_number")
    private Integer account_number;

    @Column(name = "transaction_date")
    private Date transaction_date;

    @OneToOne
    @JoinColumn(name = "transaction_type_ID")
    private Transaction transaction_typeID;


}
