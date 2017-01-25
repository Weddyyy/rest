package com.snachalo.service;

import com.snachalo.model.Address;
import com.snachalo.model.Customer;
import com.snachalo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by weddy on 24.01.17.
 */
@Service
public class AddressService {

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Get all Addresses from database
     * If don't find customer - return null
     * @param customerId Customer id
     * @return
     */
    public List<Address> getAll(String customerId)
    {
        Customer customer = customerRepository.findOne(customerId);
        if(customer==null)
            return null;
        return customer.getAddressList();
    }

    /**
     * Add address to customer
     * If don't find customer - return null
     * @param customerId Customer id
     * @param address Address
     * @return
     */
    public Customer add(String customerId, Address address)
    {
        Customer customer = customerRepository.findOne(customerId);
        if(customer==null)
            return null;
        customer.getAddressList().add(address);
        return customerRepository.save(customer);
    }

    /**
     * Get Address from customer by index (first index = 0)
     * If don't find address or customer - return null
     * @param customerId Customer id
     * @param index index in list
     * @return
     */
    public Address get(String customerId, int index)
    {
        Customer customer = customerRepository.findOne(customerId);
        if(customer==null || customer.getAddressList().size() <= index)
            return null;
        return customer.getAddressList().get(index);
    }

    /**
     * Remove address from customer by index ( first index = 0 )
     * If don't find customer - return null
     * @param customerId
     * @param index
     * @return
     */
    public Customer remove(String customerId,int index)
    {
        Customer customer = customerRepository.findOne(customerId);
        if(customer==null)
            return null;
        customer.getAddressList().remove(index);
        return customerRepository.save(customer);
    }
}
