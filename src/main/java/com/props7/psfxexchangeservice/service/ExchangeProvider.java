package com.props7.psfxexchangeservice.service;

public interface ExchangeProvider<T> {
    T provide(final String original, final String target);
}
