package com.props7.psfxexchangeservice.controller;

import com.google.common.collect.ImmutableList;
import com.props7.psfxexchangeservice.model.MoneyRate;
import com.props7.psfxexchangeservice.service.RateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/rates")
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
    public MoneyRate findRates(@RequestParam String original, @RequestParam String target) {
        return rateService.findRates(original, target);
    }

    @GetMapping("/findAll")
    public List<MoneyRate> all() {
        return ImmutableList.of(
                new MoneyRate("USD", BigDecimal.ONE, "PLN", BigDecimal.ONE),
                new MoneyRate("USD", BigDecimal.ONE, "GBP", BigDecimal.ONE));
    }

    @PostMapping("/add")
    public ResponseEntity<Object> newRate(@RequestParam String original, @RequestParam BigDecimal originalAmount,
                                          @RequestParam String target, @RequestParam BigDecimal targetAmount) {
        //TODO data validation process
        rateService.add(original, originalAmount, target, targetAmount);
        //TODO throw exception if some problem appeared
        return ResponseEntity.ok("Rates created successfully!");
    }
}
