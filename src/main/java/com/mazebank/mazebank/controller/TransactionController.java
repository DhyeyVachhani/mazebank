package com.mazebank.mazebank.controller;

import com.mazebank.mazebank.entity.Transaction;
import com.mazebank.mazebank.exception.BadReqestException;
import com.mazebank.mazebank.service.TransactionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    private final Logger logger = LogManager.getLogger(getClass());

    @PostMapping("/transaction")
    public ResponseEntity<String> amountTransfer(@RequestBody Transaction transaction){
        try{
            return ResponseEntity.ok(transactionService.createTransaction(transaction));
        }catch(BadReqestException e ){
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}