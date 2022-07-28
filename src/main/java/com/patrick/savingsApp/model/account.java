package com.patrick.savingsApp.model;


import com.patrick.savingsApp.enumeration.Status;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;


@Entity
public class account implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)

    private Long id;
    private Integer client_id;
    private Double account_balance;
    private Integer account_number;
    private Status status;
    private Date created_at;

    public account(){}

    public account(Long id, Integer client_id, Double account_balance, Integer account_number, Status status, Date created_at) {
        this.id = id;
        this.client_id = client_id;
        this.account_balance = account_balance;
        this.account_number = account_number;
        this.status = status;
        this.created_at = created_at;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;

    }
    public Integer getclient_id(){
        return client_id;
    }

    public void setclient_Id(Integer client_id){
        this.client_id = client_id;

    }
    public Double getaccount_balance(){
        return account_balance;
    }

    public void setaccount_balance(Double account_balance){
        this.account_balance = account_balance;

    }
    public Integer getaccount_number(){
        return account_number;
    }

    public void setaccount_number(Integer account_number){
        this.account_number = account_number;

    }
    public Status getstatus(){
        return status;
    }

    public void setstatus(Status status){
        this.status = status;

    }

    public Date getCreated_at(){
        return created_at;
    }

    public void setdate(Date created_at){
        this.created_at = created_at;
    }
}
