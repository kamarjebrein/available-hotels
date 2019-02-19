package com.beamuae.availablehotels.converters.responseconverters;

import com.beamuae.availablehotels.converters.Converter;
import com.beamuae.availablehotels.dtos.responses.BestHotelsResponse;
import com.beamuae.availablehotels.dtos.responses.HotelDetails;
import org.springframework.stereotype.Component;

@Component
public class BestHotelsResponseConverter implements Converter<BestHotelsResponse, HotelDetails> {

    public static final String BEST_HOTELS = "BestHotels";

    @Override
    public HotelDetails convert(BestHotelsResponse bestHotelsResponse) {
        HotelDetails details = new HotelDetails();
        details.setProvider(BEST_HOTELS);
        details.setHotelName(bestHotelsResponse.getHotel());
        details.setFare(bestHotelsResponse.getHotelFare());
        details.setAmenities(bestHotelsResponse.getRoomAmenities());
        details.setRate(bestHotelsResponse.getHotelRate());
        return details;
    }
}
