package com.codetechies.creditcardapply.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CreditCardRequest {

    private  final String firstName;
    private  final String lastName;
    private  final String socialIdNumber;

}
