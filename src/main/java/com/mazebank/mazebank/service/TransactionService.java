package com.mazebank.mazebank.service;

import com.mazebank.mazebank.entity.Transaction;
import com.mazebank.mazebank.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction createTransaction(Transaction transaction){
        transaction.setTransactionDate(new Date());
        return transactionRepository.save(transaction);
    }
}
