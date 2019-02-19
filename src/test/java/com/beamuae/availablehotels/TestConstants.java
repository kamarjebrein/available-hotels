package com.beamuae.availablehotels;

import com.beamuae.availablehotels.converters.requestconverters.BestHotelsRequestConverter;
import com.beamuae.availablehotels.converters.requestconverters.CrazyHotelsRequestConverter;
import com.beamuae.availablehotels.converters.responseconverters.BestHotelsResponseConverter;
import com.beamuae.availablehotels.converters.responseconverters.CrazyHotelsResponseConverter;

import java.time.LocalDate;

public interface TestConstants {

    LocalDate FEB_19_2019 = LocalDate.of(2019, 2, 19);
    LocalDate FEB_25_2019 = LocalDate.of(2019, 2, 25);
    String FEB_19_2019_ISO_LOCAL_DATE = "2019-02-19";
    String FEB_25_2019_ISO_LOCAL_DATE = "2019-02-25";
    String FEB_19_2019_ISO_INSTANT = "2019-02-19T00:00:00Z";
    String FEB_25_2019_ISO_INSTANT = "2019-02-25T00:00:00Z";
    String CITY_IATA = "AUH";
    String HOTEL_NAME = "HotelName";
    String[] AMENITIES = {"Room Service", "Minibar", "Fitness Center", "House Keeping", "Spa", "Sauna"};
    String RATE_2_STARS = "**";

    BestHotelsRequestConverter BEST_HOTELS_REQUEST_CONVERTER = new BestHotelsRequestConverter();
    CrazyHotelsRequestConverter CRAZY_HOTELS_REQUEST_CONVERTER = new CrazyHotelsRequestConverter();
    BestHotelsResponseConverter BEST_HOTELS_RESPONSE_CONVERTER = new BestHotelsResponseConverter();
    CrazyHotelsResponseConverter CRAZY_HOTELS_RESPONSE_CONVERTER = new CrazyHotelsResponseConverter();

}
