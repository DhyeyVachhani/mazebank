package com.mazebank.mazebank.controller;

import com.mazebank.mazebank.entity.Account;
import com.mazebank.mazebank.exception.BadReqestException;
import com.mazebank.mazebank.service.AccountService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class AccountController {

    @Autowired
    AccountService accountService;

    private final Logger logger = LogManager.getLogger(getClass());

    @PostMapping("/account")
    public ResponseEntity<Account> createAccount(@RequestBody  Account account){
        try{
        return ResponseEntity.ok(accountService.createAccount(account));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/account")
    public ResponseEntity<String> deleteAccount(@RequestBody Account account){
        try{
        return ResponseEntity.ok(accountService.deleteAccount(account));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/account/deposit")
    public ResponseEntity<String> depositAccount(@RequestBody Account account){
        try{
            return ResponseEntity.ok(accountService.depositBalance(account));
        } catch(BadReqestException e){
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        }

    @PutMapping("/account/withdraw")
    public ResponseEntity<String> withdrawAccount(@RequestBody Account account){
        try{
            return ResponseEntity.ok(accountService.withdrawBalance(account));
        }catch(BadReqestException e ){
            logger.error((e.getMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }catch(Exception e){
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}