package com.mazebank.mazebank.service;

import com.mazebank.mazebank.config.JwtTokenUtil;
import com.mazebank.mazebank.entity.Account;
import com.mazebank.mazebank.entity.Transaction;
import com.mazebank.mazebank.exception.BadReqestException;
import com.mazebank.mazebank.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountService accountService;

    @Transactional
    public String createTransaction(Transaction transaction){

        Account sourceAccount = accountService.getAccount(transaction.getSourceAccountId());
        Account destAccount = accountService.getAccount(transaction.getSourceAccountId());

        if(sourceAccount==null){
            throw new BadReqestException("Source account not found with account Id "+transaction.getSourceAccountId());
        }
        else if(destAccount==null){
            throw new BadReqestException("Destination account not found with account Id "+transaction.getSourceAccountId());
        }
        else if(sourceAccount.getBalance()<transaction.getAmount()) {
            throw new BadReqestException("Transfer not allowed, please choose smaller amount");
        }
        else {
            transaction.setTransactionDate(new Date());
            sourceAccount.setBalance(sourceAccount.getBalance() - transaction.getAmount());
            destAccount.setBalance(destAccount.getBalance() + transaction.getAmount());
            accountService.updateAccount(sourceAccount);
            accountService.updateAccount(destAccount);
            transactionRepository.save(transaction);
            return "Amount transfer completed successfully";
        }
    }
}