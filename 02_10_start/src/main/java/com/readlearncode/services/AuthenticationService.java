package com.readlearncode.services;

import com.readlearncode.Customer;

import javax.enterprise.event.Observes;

public class AuthenticationService {
    public void createAuthCredentials(@Observes Customer customer){
        // Create auth credentials for the customer
        System.out.println("Created auth credentials for customer!");
    }
}
