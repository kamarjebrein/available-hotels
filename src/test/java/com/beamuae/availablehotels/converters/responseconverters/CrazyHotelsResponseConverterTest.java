package com.beamuae.availablehotels.converters.responseconverters;

import com.beamuae.availablehotels.dtos.responses.CrazyHotelsResponse;
import com.beamuae.availablehotels.dtos.responses.HotelDetails;
import org.junit.Test;

import static com.beamuae.availablehotels.TestConstants.*;
import static com.beamuae.availablehotels.converters.responseconverters.CrazyHotelsResponseConverter.CRAZY_HOTELS;
import static org.junit.Assert.assertEquals;

public class CrazyHotelsResponseConverterTest {

    @Test
    public void convertCrazyHotelsResponseToHotelDetails() {
        CrazyHotelsResponse crazyHotelsResponse = new CrazyHotelsResponse();
        crazyHotelsResponse.setHotelName(HOTEL_NAME);
        crazyHotelsResponse.setRate(RATE_2_STARS);
        crazyHotelsResponse.setPrice(27);
        crazyHotelsResponse.setDiscount(3.5);
        crazyHotelsResponse.setAmenities(AMENITIES);

        HotelDetails hotelDetails = CRAZY_HOTELS_RESPONSE_CONVERTER.convert(crazyHotelsResponse);
        assertEquals(CRAZY_HOTELS, hotelDetails.getProvider());
        assertEquals(HOTEL_NAME, hotelDetails.getHotelName());
        assertEquals(2, hotelDetails.getRate());
        assertEquals((long) 23.5, (long) hotelDetails.getFare());
        assertAmenities(hotelDetails.getAmenities());
    }

    private void assertAmenities(String[] amenities) {
        for (int i = 0; i < amenities.length; i++) {
            assertEquals(AMENITIES[i], amenities[i]);
        }
    }

}