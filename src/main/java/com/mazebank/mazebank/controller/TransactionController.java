package com.mazebank.mazebank.controller;

import com.mazebank.mazebank.entity.Transaction;
import com.mazebank.mazebank.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/transaction")
    public EntityResponse<String> amountTransfer(@ResponseBody Transaction transaction, String token){

    }
}
