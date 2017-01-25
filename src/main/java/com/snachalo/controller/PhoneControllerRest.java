package com.snachalo.controller;

import com.snachalo.model.Phone;
import com.snachalo.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by weddy on 24.01.17.
 * Phone controller
 */
@RestController
@RequestMapping(value = "/api/customer/{id}/phone", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PhoneControllerRest {

    @Autowired
    PhoneService phoneService;

    /**
     * Get all customer phones.
     * Example URI : /api/customer/1/phone
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus( HttpStatus.OK )
    public List<Phone> getAll(@PathVariable("id") String id)
    {
        return phoneService.getAll(id);
    }

    /**
     * Get customer phone by index.
     * Example URI : /api/customer/1/phone?index=3
     */
    @RequestMapping(method = RequestMethod.GET, params = "index")
    @ResponseStatus( HttpStatus.OK )
    public Phone getPhone(@PathVariable("id") String id, @RequestParam(value="index") int index)
    {
        return phoneService.getPhone(id,index);
    }

    /**
     * Add phone to customer.
     * Example URI : /api/customer/1/phone
     * Body - JSON type.
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus( HttpStatus.CREATED )
    public List<Phone> addPhone(@PathVariable("id") String id,@RequestBody Phone phone)
    {
        return phoneService.add(id,phone).getPhoneList();
    }

    /**
     * Delete phone from customer.
     * Example URI : /api/customer/1/phone?index=3
     */
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus( HttpStatus.OK )
    public List<Phone> deletePhone(@PathVariable("id") String id, @RequestParam(value="index") int index)
    {
        return phoneService.remove(id,index).getPhoneList();
    }
}
