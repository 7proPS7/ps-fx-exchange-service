package com.props7.psfxexchangeservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
public class MoneyRate {
    private final String orinal;
    private final BigDecimal originalAmount;
    private final String target;
    private final BigDecimal targetAmount;
}
