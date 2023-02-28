package com.andreis.cards.controller;

import com.andreis.cards.config.CardServiceProperties;
import com.andreis.cards.model.Card;
import com.andreis.cards.model.Customer;
import com.andreis.cards.model.Properties;
import com.andreis.cards.repositoy.CardRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cards")
@AllArgsConstructor
public class CardController {

    private final CardRepository cardRepository;
    private final CardServiceProperties cardServiceProperties;


    @PostMapping("/myCards")
    public List<Card> getCardDetails(@RequestBody Customer customer){
        return cardRepository.findByCustomerId(customer.getCustomerId());
    }

    @GetMapping("/properties")
    public String getPropertyDetails() throws JsonProcessingException {
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = Properties.builder()
                .msg(cardServiceProperties.getMsg())
                .buildVersion(cardServiceProperties.getBuildVersion())
                .mailDetails(cardServiceProperties.getMailDetails())
                .activeBranches(cardServiceProperties.getActiveBranches())
                .build();

        return objectWriter.writeValueAsString(properties);
    }
}
