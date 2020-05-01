package com.props7.psfxexchangeservice.provider;

public interface ExchangeProvider<T> {
    T provide(final String original, final String target);
}
