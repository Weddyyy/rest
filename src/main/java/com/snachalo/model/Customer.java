package com.snachalo.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weddy on 23.01.17.
 */
@Document
public @Data class Customer {

    @Id
    @Setter(AccessLevel.NONE)
    private String id;

    String title;
    String forename;
    String middleInitials;
    String Surname;

    List<Address> addressList;

    List<Email> emailList;

    List<Phone> phoneList;

    public Customer()
    {
        addressList = new ArrayList<>();
        emailList = new ArrayList<>();
        phoneList = new ArrayList<>();
    }
}
