package com.props7.psfxexchangeservice.service;

import com.props7.psfxexchangeservice.model.MoneyRate;

import java.math.BigDecimal;

public interface RateService {
    MoneyRate findRates(String original, String target);

    MoneyRate findRate(String original);

    void add(String original, BigDecimal originalAmount, String target, BigDecimal targetAmount);
}
