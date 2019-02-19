package com.beamuae.availablehotels.converters.responseconverters;

import com.beamuae.availablehotels.converters.Converter;
import com.beamuae.availablehotels.dtos.responses.CrazyHotelsResponse;
import com.beamuae.availablehotels.dtos.responses.HotelDetails;
import org.springframework.stereotype.Component;

@Component
public class CrazyHotelsResponseConverter implements Converter<CrazyHotelsResponse, HotelDetails> {

    public static final String CRAZY_HOTELS = "CrazyHotels";

    @Override
    public HotelDetails convert(CrazyHotelsResponse crazyHotelsResponse) {
        HotelDetails details = new HotelDetails();
        details.setProvider(CRAZY_HOTELS);
        details.setHotelName(crazyHotelsResponse.getHotelName());
        details.setFare(calculateFare(crazyHotelsResponse));
        details.setAmenities(crazyHotelsResponse.getAmenities());
        details.setRate(rate(crazyHotelsResponse));
        return details;
    }

    private int rate(CrazyHotelsResponse crazyHotelsResponse) {
        return crazyHotelsResponse.getRate().trim().length();
    }

    private double calculateFare(CrazyHotelsResponse crazyHotelsResponse) {
        return crazyHotelsResponse.getPrice() - crazyHotelsResponse.getDiscount();
    }
}
