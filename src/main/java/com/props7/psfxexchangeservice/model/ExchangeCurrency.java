package com.props7.psfxexchangeservice.model;

import java.math.BigDecimal;

public class ExchangeCurrency {
    private final String orinal;
    private final BigDecimal originalAmount;
    private final String target;
    private final BigDecimal targetAmount;

    public ExchangeCurrency(String orinal, BigDecimal originalAmount, String target, BigDecimal targetAmount) {
        this.orinal = orinal;
        this.originalAmount = originalAmount;
        this.target = target;
        this.targetAmount = targetAmount;
    }

    public String getOrinal() {
        return orinal;
    }

    public BigDecimal getOriginalAmount() {
        return originalAmount;
    }

    public String getTarget() {
        return target;
    }

    public BigDecimal getTargetAmount() {
        return targetAmount;
    }
}
