package com.codetechies.creditcardapply.service;

import com.codetechies.creditcardapply.dto.CreditCardRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class CreditCardService {

    @Value("${credit.rating.url:http://localhost:8002}")
    private String creditRatingUrl;
    private final RestTemplate restTemplate;

    public CreditCardService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String applyCreditCard(CreditCardRequest creditCardRequest) {
       var rating = restTemplate.getForObject(creditRatingUrl+"/getCreditRating/"
               +creditCardRequest.getSocialIdNumber(),Integer.class);
       log.info("*** Rating is : {}", rating);
        return rating >= 5? "Approved" : "Rejected";
    }
}
