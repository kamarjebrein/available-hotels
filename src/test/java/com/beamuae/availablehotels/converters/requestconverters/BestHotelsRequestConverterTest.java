package com.beamuae.availablehotels.converters.requestconverters;

import com.beamuae.availablehotels.dtos.requests.AvailableHotelsRequest;
import com.beamuae.availablehotels.dtos.requests.BestHotelsRequest;
import org.junit.Test;

import static com.beamuae.availablehotels.TestConstants.*;
import static org.junit.Assert.assertEquals;

public class BestHotelsRequestConverterTest {

    @Test
    public void convertAvailableHotelsRequestToBestHotelsRequest() {
        AvailableHotelsRequest availableHotelsRequest = new AvailableHotelsRequest();
        availableHotelsRequest.setCity(CITY_IATA);
        availableHotelsRequest.setFromDate(FEB_19_2019);
        availableHotelsRequest.setToDate(FEB_25_2019);
        availableHotelsRequest.setNumberOfAdults(3);

        BestHotelsRequest bestHotelsRequest = BEST_HOTELS_REQUEST_CONVERTER.convert(availableHotelsRequest);
        assertEquals(CITY_IATA, bestHotelsRequest.getCity());
        assertEquals(FEB_19_2019_ISO_LOCAL_DATE, bestHotelsRequest.getFromDate());
        assertEquals(FEB_25_2019_ISO_LOCAL_DATE, bestHotelsRequest.getToDate());
        assertEquals(3, bestHotelsRequest.getNumberOfAdults());
    }
}