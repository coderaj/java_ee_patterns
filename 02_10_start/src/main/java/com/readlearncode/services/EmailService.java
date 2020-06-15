package com.readlearncode.services;

import com.readlearncode.Customer;

import javax.enterprise.event.Observes;

public class EmailService {
    public void sendWelcomeEmail(@Observes Customer customer){
        // Send welcome email to customers
        System.out.println("Welcome email sent!");
    }
}
