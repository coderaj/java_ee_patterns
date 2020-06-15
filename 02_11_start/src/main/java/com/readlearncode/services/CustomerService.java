package com.readlearncode.services;

import com.readlearncode.Customer;
import com.readlearncode.CustomerEvent;

import javax.annotation.Priority;
import javax.enterprise.event.Observes;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class CustomerService {

    public void createCustomer(@Observes @Priority(10)
                                @CustomerEvent(CustomerEvent.Type.ADD)
                                Customer customer) {
        // add new customer
    }

    public void deleteCustomer(@Observes
                               @CustomerEvent(CustomerEvent.Type.REMOVE)
                               Customer customer){
        // delete customer
    }

}