package com.codetechies.creditcardapply.controller;

import com.codetechies.creditcardapply.dto.CreditCardRequest;
import com.codetechies.creditcardapply.service.CreditCardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CreditCardController {
    private CreditCardService creditCardService;

    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @PostMapping("applyCreditCard")
    public ResponseEntity<String> applyCreditCard(@RequestBody CreditCardRequest creditCardRequest){

        if(null == creditCardRequest){
            return  ResponseEntity.badRequest().body("Please provide applicant details");
        }else{
           var response = creditCardService.applyCreditCard(creditCardRequest);
           return ResponseEntity.ok().body(response);
        }
    }
}
