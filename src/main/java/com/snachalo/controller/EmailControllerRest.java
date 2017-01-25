package com.snachalo.controller;

import com.snachalo.model.Email;
import com.snachalo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by weddy on 24.01.17.
 * Email controller
 */
@RestController
@RequestMapping(value = "/api/customer/{id}/email", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class EmailControllerRest {

    @Autowired
    private EmailService emailService;

    /**
     * Get all customer emails.
     * Example URI : /api/customer/1/email
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus( HttpStatus.OK )
    public List<Email> getAll(@PathVariable("id") String id)
    {
        return emailService.getAll(id);
    }

    /**
     * Get customer email by index.
     * Example URI : /api/customer/1/email?index=3
     */
    @RequestMapping(method = RequestMethod.GET, params = "index")
    @ResponseStatus( HttpStatus.OK )
    public Email getEmail(@PathVariable("id") String id, @RequestParam(value="index") int index)
    {
        return emailService.getEmail(id,index);
    }

    /**
     * Add email to customer.
     * Example URI : /api/customer/1/email
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus( HttpStatus.CREATED )
    public List<Email> addEmail(@PathVariable("id") String id,@RequestBody Email email)
    {
        return emailService.add(id,email).getEmailList();
    }

    /**
     * Delete email from customer.
     * Example URI : /api/customer/1/email?index=3
     */
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus( HttpStatus.OK )
    public List<Email> deleteEmail(@PathVariable("id") String id, @RequestParam(value="index") int index)
    {
        return emailService.remove(id,index).getEmailList();
    }
}
