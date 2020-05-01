package com.props7.psfxexchangeservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exchange")
public class ExchangeController {

    @GetMapping("/findCurrency")
    public ExchangeCurrency findCurrency(@RequestParam String original,
                                         @RequestParam String target) {
        return new ExchangeCurrency(original, target, 1, 1);
    }
}
