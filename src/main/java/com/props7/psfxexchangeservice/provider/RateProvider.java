package com.props7.psfxexchangeservice.provider;

public interface RateProvider<T> {
    T provide(final String original, final String target);
}
