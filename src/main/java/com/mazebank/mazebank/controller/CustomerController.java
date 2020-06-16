package com.mazebank.mazebank.controller;

import com.mazebank.mazebank.entity.Customer;
import com.mazebank.mazebank.entity.Response;
import com.mazebank.mazebank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.createCustomer(customer));
    }

    @PutMapping("/customer")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.updateCustomer(customer));
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long id){
        return ResponseEntity.ok(customerService.getCustomer(id));
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<Response> deleteCustomer(@PathVariable("id") Long id){
        return ResponseEntity.ok(new Response("success",customerService.deleteCustomer(id)));
    }
}