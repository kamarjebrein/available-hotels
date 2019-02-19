package com.beamuae.availablehotels.usecases;

public interface UseCase<I, O> {

    O execute(I input);

}
