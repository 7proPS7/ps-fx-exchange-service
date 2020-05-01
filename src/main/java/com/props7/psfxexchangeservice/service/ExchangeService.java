package com.props7.psfxexchangeservice.service;

import com.props7.psfxexchangeservice.model.ExchangeCurrency;

public interface ExchangeService {
    ExchangeCurrency exchange(String original, String target);
}
