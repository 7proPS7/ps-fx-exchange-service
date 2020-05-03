package com.props7.psfxexchangeservice.service;

import com.props7.psfxexchangeservice.model.MoneyRate;
import com.props7.psfxexchangeservice.provider.MoneyRateProviderImpl;
import javafx.util.Pair;
import org.springframework.stereotype.Service;

import javax.money.MonetaryAmount;
import java.math.BigDecimal;

@Service
public class MoneyRateServiceImpl implements RateService {

    private final MoneyRateProviderImpl moneyRateProvider;

    public MoneyRateServiceImpl(final MoneyRateProviderImpl moneyRateProvider) {
        this.moneyRateProvider = moneyRateProvider;
    }

    @Override
    public MoneyRate findRates(String original, String target) {
        //TODO call to some service or db to pick more data with currency details

        Pair<MonetaryAmount, MonetaryAmount> provide = moneyRateProvider.provide(original, target);

        return new MoneyRate(
                provide.getKey().getCurrency().getCurrencyCode(),
                new BigDecimal(provide.getKey().getNumber().longValueExact()),
                provide.getValue().getCurrency().getCurrencyCode(),
                new BigDecimal(provide.getValue().getNumber().longValueExact())
        );
    }

    @Override
    public MoneyRate findRate(String origin) {
        return new MoneyRate(origin, new BigDecimal("123"));
    }

    @Override
    public void add(String original, BigDecimal originalAmount, String target, BigDecimal targetAmount) {

    }
}
