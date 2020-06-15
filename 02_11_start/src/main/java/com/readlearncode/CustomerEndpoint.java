package com.readlearncode;


import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@Stateless
@Path("/customers")
public class CustomerEndpoint {

    @Inject
    @CustomerEvent(CustomerEvent.Type.ADD)
    private Event<Customer> customerAddEvent;

    @Inject
    @CustomerEvent(CustomerEvent.Type.REMOVE)
    private Event<Customer> customerRemoveEvent;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void newCustomer(Customer customer) {
        customerAddEvent.fire(customer);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteCustomer(Customer customer){
        customerRemoveEvent.fire(customer);
    }
}