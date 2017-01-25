package com.snachalo.model;

import com.snachalo.model.enums.PhoneType;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by weddy on 24.01.17.
 */
@NoArgsConstructor
public @Data class Phone {

    String phoneNumber;
    String phoneLabel;
    PhoneType phoneType;
}
