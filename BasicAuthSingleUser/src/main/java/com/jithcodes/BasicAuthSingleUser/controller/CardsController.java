package com.jithcodes.BasicAuthSingleUser.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {

    @GetMapping("/myCards")
    public String getCardDetails() {
        return "Here is the card details";
    }
}