package com.snachalo.model;

import com.snachalo.model.enums.EmailType;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by weddy on 24.01.17.
 */
@NoArgsConstructor
public @Data class Email {
    String email;
    String emailLabel;
    EmailType emailType;
}
