package com.snachalo.service;

import com.snachalo.model.Customer;
import com.snachalo.model.Email;
import com.snachalo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by weddy on 24.01.17.
 */
@Service
public class EmailService {

    @Autowired
    CustomerRepository customerRepository;

    /**
     * Get all customer email from database
     * @param customerId Customer id
     * @return All emails
     */
    public List<Email> getAll(String customerId)
    {
        Customer customer = customerRepository.findOne(customerId);
        if(customer==null)
            return null;
        return customer.getEmailList();
    }


    /**
     * Get customer email from database
     * If not found - return null
     * @param customerId Customer id
     * @param index Search index
     * @return Email
     */
    public Email getEmail(String customerId,int index)
    {
        Customer customer = customerRepository.findOne(customerId);
        if(customer==null || customer.getEmailList().size() <= index)
            return null;
        return customer.getEmailList().get(index);
    }

    /**
     * Add email to customer.
     * If not found customer - return null
     * @param customerId Customer id
     * @param email New email
     * @return New customer
     */
    public Customer add(String customerId, Email email)
    {
        Customer customer = customerRepository.findOne(customerId);
        if(customer==null)
            return null;
        customer.getEmailList().add(email);
        return customerRepository.save(customer);
    }

    /**
     * Remove email from customer
     * If not found customer  - return null
     * @param customerId Customer id
     * @param index Email index
     * @return New customer
     */
    public Customer remove(String customerId,int index)
    {
        Customer customer = customerRepository.findOne(customerId);
        if(customer==null)
            return null;
        customer.getEmailList().remove(index);
        return customerRepository.save(customer);
    }
}
