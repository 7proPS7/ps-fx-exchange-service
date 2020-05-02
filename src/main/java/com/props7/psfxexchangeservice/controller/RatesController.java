package com.props7.psfxexchangeservice.controller;

import com.props7.psfxexchangeservice.model.MoneyRate;
import com.props7.psfxexchangeservice.service.RateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rate")
public class RatesController {

    private final RateService rateService;

    public RatesController(final RateService rateService) {
        this.rateService = rateService;
    }

    @GetMapping("/findRate")
    public MoneyRate findRate(@RequestParam String original) {
        return rateService.findRate(original);
    }

    @GetMapping("/findRates")
    public MoneyRate findRates(@RequestParam String original,
                               @RequestParam String target) {
        return rateService.findRates(original, target);
    }
}
