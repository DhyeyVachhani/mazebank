package com.mazebank.mazebank.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private long transactionId;

    @Column(name="source_account_id")
    private long sourceAccountId;

    @Column(name="destination_account_id")
    private long destAccountId;

    @Column(name="amount")
    private long amount;

    @Column(name="source_account_type")
    private String sourceAccountType;

    @Column(name="target_account_type")
    private String targetAccountType;

    @Column(name="transaction_date")
    private Date transactionDate;
}