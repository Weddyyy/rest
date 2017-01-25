package com.snachalo.service;

import com.snachalo.model.Customer;
import com.snachalo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by weddy on 24.01.17.
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Get all customers from database.
     * @return
     */
    public List<Customer> getAll()
    {
        return customerRepository.findAll();
    }

    /**
     * Find customer from database
     * If not found customer - return null
     * @param id Customer id
     * @return
     */
    public Customer findById(String id)
    {
        return customerRepository.findOne(id);
    }

    /**
     * Add customer to database.
     * @param customer Customer
     * @return
     */
    public Customer add(Customer customer)
    {
        return customerRepository.save(customer);
    }

    /**
     * Delete customer from database
     * @param id id customer
     */
    public void delete(String id)
    {
        customerRepository.delete(id);
    }

    /**
     * Rewrite customer in database
     * @param id Customer id
     * @param customer Customer data
     * @return new customer
     */
    public Customer update(String id,Customer customer)
    {
        Customer dbCustomer = customerRepository.findOne(id);
        if(dbCustomer==null)
            return null;

        dbCustomer.setAddressList(customer.getAddressList());
        dbCustomer.setForename(customer.getForename());
        dbCustomer.setPhoneList(customer.getPhoneList());
        dbCustomer.setEmailList(customer.getEmailList());
        dbCustomer.setMiddleInitials(customer.getMiddleInitials());
        dbCustomer.setSurname(customer.getSurname());

        return customerRepository.save(dbCustomer);
    }

    /**
     * Update customer in database
     * @param id Customer id
     * @param customer new fields.
     * @return new customer
     */
    public Customer patch(String id,Customer customer)
    {
        Customer customerOld = customerRepository.findOne(id);
        if(customerOld==null)
            return null;

        if(customer.getForename()!=null)
            customerOld.setForename(customer.getForename());

        if(customer.getMiddleInitials()!=null)
            customerOld.setMiddleInitials(customer.getMiddleInitials());

        if(customer.getSurname()!=null)
            customerOld.setSurname(customer.getSurname());

        if(customer.getTitle()!=null)
            customerOld.setTitle(customer.getTitle());

        if(customer.getAddressList()!=null)
            customerOld.setAddressList(customer.getAddressList());

        if(customer.getPhoneList()!=null)
            customerOld.setPhoneList(customer.getPhoneList());

        if(customer.getEmailList()!=null)
            customerOld.setEmailList(customer.getEmailList());

        return customerRepository.save(customerOld);
    }
}
