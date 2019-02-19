package com.beamuae.availablehotels.providers.implementation;

import com.beamuae.availablehotels.dtos.requests.AvailableHotelsRequest;
import com.beamuae.availablehotels.dtos.responses.HotelDetails;
import com.beamuae.availablehotels.gateway.OffersGatewayMock;
import org.junit.Before;
import org.junit.Test;

import org.apache.commons.io.IOUtils;

import java.util.List;

import static com.beamuae.availablehotels.TestConstants.*;
import static com.beamuae.availablehotels.converters.responseconverters.BestHotelsResponseConverter.BEST_HOTELS;
import static org.junit.Assert.assertEquals;

public class BestHotelsProviderTest {

    private BestHotelsProvider provider;

    @Before
    public void setUp() throws Exception {
        String responseString = IOUtils.toString(BestHotelsProviderTest.class.getResourceAsStream("BestHotelsResponseExample.json"), "UTF-8");
        OffersGatewayMock offersGatewayMock = new OffersGatewayMock(responseString);
        provider = new BestHotelsProvider(BEST_HOTELS_REQUEST_CONVERTER, offersGatewayMock, BEST_HOTELS_RESPONSE_CONVERTER);
    }

    @Test
    public void sendRequestReceiveResponseAndParse() {
        AvailableHotelsRequest availableHotelsRequest = new AvailableHotelsRequest();
        availableHotelsRequest.setCity(CITY_IATA);
        availableHotelsRequest.setFromDate(FEB_19_2019);
        availableHotelsRequest.setToDate(FEB_25_2019);
        availableHotelsRequest.setNumberOfAdults(3);

        List<HotelDetails> hotelsDetails = provider.provideOffers(availableHotelsRequest);
        assertEquals(1, hotelsDetails.size());
        HotelDetails details = hotelsDetails.get(0);
        assertEquals(BEST_HOTELS, details.getProvider());
        assertEquals(HOTEL_NAME, details.getHotelName());
        assertEquals((long) 65, (long) details.getFare());
        assertAmenities(details.getAmenities());
    }

    private void assertAmenities(String[] amenities) {
        for (int i = 0; i < amenities.length; i++) {
            assertEquals(AMENITIES[i], amenities[i]);
        }
    }
}