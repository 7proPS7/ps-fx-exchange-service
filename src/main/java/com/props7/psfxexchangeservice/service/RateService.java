package com.props7.psfxexchangeservice.service;

import com.props7.psfxexchangeservice.model.MoneyRate;

public interface RateService {
    MoneyRate findRates(String original, String target);

    MoneyRate findRate(String origin);
}
