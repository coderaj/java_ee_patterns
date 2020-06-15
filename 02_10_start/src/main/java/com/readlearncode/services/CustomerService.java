package com.readlearncode.services;

import com.readlearncode.Customer;

import javax.enterprise.event.Observes;

public class CustomerService {
    public void createCustomer(@Observes Customer customer){
        // add new customer
        System.out.println("Added new customer");
    }
}
