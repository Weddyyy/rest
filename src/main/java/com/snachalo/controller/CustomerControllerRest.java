package com.snachalo.controller;

import com.snachalo.model.Customer;
import com.snachalo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by weddy on 24.01.17.
 * Customer controller
 */
@RestController
@RequestMapping(value = "/api/customer", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CustomerControllerRest {

    @Autowired
    private CustomerService service;

    /**
     * Get all customers from database.
     * Example URI : /api/customer
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus( HttpStatus.OK )
    public List<Customer> getAll()
    {
        return service.getAll();
    }

    /**
     * Get customer by index.
     * Example URI : /api/customer/4
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus( HttpStatus.OK )
    public Customer getById(@PathVariable("id") String id)
    {
        return service.findById(id);
    }

    /**
     * Add new customer in database.
     * Example URI : /api/customer
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus( HttpStatus.CREATED )
    public Customer add(Customer customer)
    {
        return service.add(customer);
    }

    /**
     * Rewrite customer
     * Search by index
     * Example URI : /api/customer/4
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus( HttpStatus.OK )
    public Customer reSave(@PathVariable("id") String id,Customer customer)
    {
        return service.update(id,customer);
    }

    /**
     * Update customer fields
     * Example URI : /api/customer/4
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    @ResponseStatus( HttpStatus.OK )
    public Customer update(@PathVariable("id") String id,Customer customer)
    {
        return service.update(id,customer);
    }

    /**
     * Delete customer
     * Example URI : /api/customer/4
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") String id)
    {
        service.delete(id);
    }
}
