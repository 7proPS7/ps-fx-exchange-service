package com.props7.psfxexchangeservice.provider;

import javafx.util.Pair;
import org.springframework.stereotype.Service;

import javax.money.Monetary;
import javax.money.MonetaryAmount;
import java.util.Random;

@Service
public class MoneyRateProviderImpl implements RateProvider<Pair<MonetaryAmount, MonetaryAmount>> {
    @Override
    public Pair<MonetaryAmount, MonetaryAmount> provide(final String originalCurrency, final String targetCurrency) {
        return new Pair<>(
                prepareMonetaryAmountForCurrency(originalCurrency),
                prepareMonetaryAmountForCurrency(targetCurrency)
        );
    }

    private MonetaryAmount prepareMonetaryAmountForCurrency(final String currency) {
        return Monetary
                .getDefaultAmountFactory()
                .setNumber(getRandomAmountForCurrency())
                .setCurrency(currency)
                .create();
    }

    private long getRandomAmountForCurrency() {
        return new Random().nextInt(4000);
    }
}
