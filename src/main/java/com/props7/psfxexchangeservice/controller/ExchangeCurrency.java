package com.props7.psfxexchangeservice.controller;

public class ExchangeCurrency {
    private final String original;
    private final String target;
    private final double originalAmount;
    private final double targetAmount;

    public ExchangeCurrency(String original, String target, double originalAmount, double targetAmount) {
        this.original = original;
        this.target = target;
        this.originalAmount = originalAmount;
        this.targetAmount = targetAmount;
    }

    public String getOriginal() {
        return original;
    }

    public String getTarget() {
        return target;
    }

    public double getOriginalAmount() {
        return originalAmount;
    }

    public double getTargetAmount() {
        return targetAmount;
    }
}
