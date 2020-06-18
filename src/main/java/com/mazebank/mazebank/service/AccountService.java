package com.mazebank.mazebank.service;

import com.mazebank.mazebank.entity.Account;
import com.mazebank.mazebank.exception.BadReqestException;
import com.mazebank.mazebank.repository.AccountRepository;
import com.mazebank.mazebank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    CustomerRepository customerRepository;

    public Account createAccount(Account account){
        if(!customerRepository.findById(account.getCustomerId()).isPresent()){
            throw new BadReqestException("No such customer with customer Id : "+account.getCustomerId());
        }
        account.setCrDate(new Date());
        account.setAccountUpdate(new Date());
        return accountRepository.save(account);
    }

    public String deleteAccount(Account account){
        account.setAccountStatus("D");
        accountRepository.save(account);
        return "deleted successfully";
    }

    public String depositBalance(Account account) {
        Account existingAccount = accountRepository.findById(account.getAccountId()).orElseThrow( ()-> new BadReqestException("account not found with customerId : " + account.getAccountId()));
        account.setCrDate(existingAccount.getCrDate());
        account.setAccountId(existingAccount.getAccountId());
        account.setCustomerId(existingAccount.getCustomerId());
        account.setAccountStatus(existingAccount.getAccountStatus());
        account.setAccountType(existingAccount.getAccountType());
        accountRepository.save(account);
        return "Amount deposited successfully";
    }

    public String withdrawBalance(Account account) {
        Account existingAccount = accountRepository.findById(account.getAccountId()).orElseThrow( ()-> new BadReqestException("account not found with customerId : " + account.getAccountId()));
        if(existingAccount.getBalance()<account.getBalance()){
            throw new BadReqestException("“Withdraw not allowed, please choose smaller amount");
        }else{
            existingAccount.setBalance(existingAccount.getBalance()-account.getBalance());
            accountRepository.save(existingAccount);
            return "Amount withdrawn successfully";
        }
    }

    public Account getAccount(long id) {

        Optional<Account> account = accountRepository.findById(id);
        return account.orElse(null);
    }

    public void updateAccount(Account account) {
        accountRepository.save(account);
    }
}