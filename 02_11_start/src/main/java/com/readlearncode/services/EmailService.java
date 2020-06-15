package com.readlearncode.services;

import com.readlearncode.Customer;

import javax.annotation.Priority;
import javax.enterprise.event.Observes;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class EmailService {

    public void sendWelcomeEmail(@Observes @Priority(30) Customer customer) {
        // send welcome email
    }

}