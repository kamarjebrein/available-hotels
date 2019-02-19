package com.beamuae.availablehotels.converters.requestconverters;

import com.beamuae.availablehotels.dtos.requests.AvailableHotelsRequest;
import com.beamuae.availablehotels.dtos.requests.CrazyHotelsRequest;
import org.junit.Test;

import static com.beamuae.availablehotels.TestConstants.*;
import static org.junit.Assert.assertEquals;

public class CrazyHotelsRequestConverterTest {

    @Test
    public void convertAvailableHotelsRequestToBestHotelsRequest() {
        AvailableHotelsRequest availableHotelsRequest = new AvailableHotelsRequest();
        availableHotelsRequest.setCity(CITY_IATA);
        availableHotelsRequest.setFromDate(FEB_19_2019);
        availableHotelsRequest.setToDate(FEB_25_2019);
        availableHotelsRequest.setNumberOfAdults(3);

        CrazyHotelsRequest crazyHotelsRequest = CRAZY_HOTELS_REQUEST_CONVERTER.convert(availableHotelsRequest);
        assertEquals(CITY_IATA, crazyHotelsRequest.getCity());
        assertEquals(FEB_19_2019_ISO_INSTANT, crazyHotelsRequest.getFrom());
        assertEquals(FEB_25_2019_ISO_INSTANT, crazyHotelsRequest.getTo());
        assertEquals(3, crazyHotelsRequest.getAdultsCount());
    }
}