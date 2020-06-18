package com.mazebank.mazebank.service;

import com.mazebank.mazebank.entity.Customer;
import com.mazebank.mazebank.entity.User;
import com.mazebank.mazebank.exception.BadReqestException;
import com.mazebank.mazebank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer) {
        customer.setCustomerUpdate(new Date());
        customer.setCustomerStatus("A");
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Customer customer) {

        Customer existingCustomer = customerRepository.findById(customer.getCustomerId()).orElseThrow(() -> new BadReqestException("customer not found with customerId : " + customer.getCustomerId()));
        customer.setCustomerSSN(existingCustomer.getCustomerSSN());
        customer.setCustomerUpdate(new Date());
        customer.setCustomerStatus(existingCustomer.getCustomerStatus());
        return customerRepository.save(customer);
    }

    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new BadReqestException("customer not found with customerId : " + id));
    }

    public String deleteCustomer(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new BadReqestException("customer not found with customerId : " + id));
        customer.setCustomerStatus("D");
        customerRepository.save(customer);
        return "Successfully deleted";
    }
}