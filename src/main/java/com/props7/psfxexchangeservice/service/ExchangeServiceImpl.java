package com.props7.psfxexchangeservice.service;

import com.props7.psfxexchangeservice.model.ExchangeCurrency;
import javafx.util.Pair;
import org.springframework.stereotype.Service;

import javax.money.MonetaryAmount;
import java.math.BigDecimal;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    private final ExchangeCurrencyProviderImpl exchangeProvider;

    public ExchangeServiceImpl(final ExchangeCurrencyProviderImpl exchangeProvider) {
        this.exchangeProvider = exchangeProvider;
    }

    @Override
    public ExchangeCurrency exchange(String original, String target) {
        //TODO call to some service or db to pick more data with currency details

        Pair<MonetaryAmount, MonetaryAmount> provide = exchangeProvider.provide(original, target);

        return new ExchangeCurrency(
                provide.getKey().getCurrency().getCurrencyCode(),
                new BigDecimal(provide.getKey().getNumber().longValueExact()),
                provide.getValue().getCurrency().getCurrencyCode(),
                new BigDecimal(provide.getValue().getNumber().longValueExact())
        );
    }
}
