package com.snachalo.service;

import com.snachalo.model.Customer;
import com.snachalo.model.Phone;
import com.snachalo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by weddy on 24.01.17.
 */
@Service
public class PhoneService {

    @Autowired
    CustomerRepository customerRepository;

    /**
     * Get all customer phones from database.
     * If not found customer - return null.
     * @param customerId Customer id
     * @return All phones
     */
    public List<Phone> getAll(String customerId)
    {
        Customer customer = customerRepository.findOne(customerId);
        if(customer==null)
            return null;
        return customer.getPhoneList();
    }

    /**
     * Get phone from customer.
     * If not found customer - return null.
     * @param customerId Customer id
     * @param index Phone index
     * @return phone
     */
    public Phone getPhone(String customerId, int index)
    {
        Customer customer = customerRepository.findOne(customerId);
        if(customer==null || customer.getPhoneList().size() <= index)
            return null;
        return customer.getPhoneList().get(index);
    }

    /**
     * Add phone to customer.
     * If not found customer - return null.
     * @param customerId Customer id
     * @param phone New phone
     * @return New Customer
     */
    public Customer add(String customerId, Phone phone)
    {
        Customer customer = customerRepository.findOne(customerId);
        if(customer==null)
            return null;
        customer.getPhoneList().add(phone);
        return customerRepository.save(customer);
    }

    /**
     * Remove phone from customer.
     * If not found customer - return null.
     * @param customerId Customer id
     * @param index Phone index
     * @return New customer
     */
    public Customer remove(String customerId,int index)
    {
        Customer customer = customerRepository.findOne(customerId);
        if(customer==null)
            return null;
        customer.getPhoneList().remove(index);
        return customerRepository.save(customer);
    }
}
