package com.snachalo.model;

import com.snachalo.model.enums.AddressType;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by weddy on 24.01.17.
 */
@NoArgsConstructor
public @Data class Address {

    String addr1;
    String addr2;
    String addressLabel;

    AddressType addressType;

    String city;
    String cityId;
    String country;
    String postCode;
}
