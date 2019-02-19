package com.beamuae.availablehotels.providers;

import com.beamuae.availablehotels.dtos.requests.AvailableHotelsRequest;
import com.beamuae.availablehotels.dtos.responses.HotelDetails;

import java.util.List;

public interface HotelOffersProvider {

    List<HotelDetails> provideOffers(AvailableHotelsRequest request);

}
