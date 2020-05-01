package com.props7.psfxexchangeservice.controller;

import com.props7.psfxexchangeservice.model.ExchangeCurrency;
import com.props7.psfxexchangeservice.service.ExchangeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exchange")
public class ExchangeController {

    private final ExchangeService exchangeService;

    public ExchangeController(final ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @GetMapping("/findCurrency")
    public ExchangeCurrency findCurrency(@RequestParam String original,
                                         @RequestParam String target) {
        return exchangeService.exchange(original, target);
    }
}
