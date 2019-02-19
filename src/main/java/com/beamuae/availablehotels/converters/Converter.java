package com.beamuae.availablehotels.converters;

public interface Converter<A, B> {
    B convert(A a);
}
