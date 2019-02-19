package com.beamuae.availablehotels.converters.responseconverters;

import com.beamuae.availablehotels.dtos.responses.BestHotelsResponse;
import com.beamuae.availablehotels.dtos.responses.HotelDetails;
import org.junit.Test;

import static com.beamuae.availablehotels.TestConstants.*;
import static com.beamuae.availablehotels.converters.responseconverters.BestHotelsResponseConverter.BEST_HOTELS;
import static org.junit.Assert.assertEquals;

public class BestHotelsResponseConverterTest {

    @Test
    public void convertBestHotelsResponseToHotelDetails() {
        BestHotelsResponse bestHotelsResponse = new BestHotelsResponse();
        bestHotelsResponse.setHotel(HOTEL_NAME);
        bestHotelsResponse.setHotelRate(4);
        bestHotelsResponse.setHotelFare(85);
        bestHotelsResponse.setRoomAmenities(AMENITIES);

        HotelDetails hotelDetails = BEST_HOTELS_RESPONSE_CONVERTER.convert(bestHotelsResponse);
        assertEquals(BEST_HOTELS, hotelDetails.getProvider());
        assertEquals(HOTEL_NAME, hotelDetails.getHotelName());
        assertEquals(4, hotelDetails.getRate());
        assertEquals((long) 85, (long) hotelDetails.getFare());
        assertAmenities(hotelDetails.getAmenities());
    }

    private void assertAmenities(String[] amenities) {
        for (int i = 0; i < amenities.length; i++) {
            assertEquals(AMENITIES[i], amenities[i]);
        }
    }
}