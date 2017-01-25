package com.snachalo.controller;

import com.snachalo.model.Address;
import com.snachalo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by weddy on 24.01.17.
 * Address controller
 */
@RestController
@RequestMapping(value = "/api/customer/{id}/address", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AddressControllerRest {

    @Autowired
    private AddressService addressService;

    /**
     * Get all customer addresses.
     * Example URI : /api/customer/1/address
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus( HttpStatus.OK )
    public List<Address> getAll(@PathVariable("id") String id)
    {
        return addressService.getAll(id);
    }

    /**
     * Get customer address by index.
     * Example URI : /api/customer/1/address?index=3
     */
    @RequestMapping(method = RequestMethod.GET, params = "index")
    @ResponseStatus( HttpStatus.OK )
    public Address getAddress(@PathVariable("id") String id, @RequestParam(value="index") int index)
    {
        return addressService.get(id,index);
    }

    /**
     * Add address to customer.
     * Example URI : /api/customer/1/address
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus( HttpStatus.CREATED )
    public List<Address> addAddress(@PathVariable("id") String id,@RequestBody Address address)
    {
        return addressService.add(id,address).getAddressList();
    }

    /**
     * Delete address from customer.
     * Example URI : /api/customer/1/address
     */
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus( HttpStatus.OK )
    public List<Address> deleteAddress(@PathVariable("id") String id, @RequestParam(value="index") int index)
    {
        return addressService.remove(id,index).getAddressList();
    }
}
