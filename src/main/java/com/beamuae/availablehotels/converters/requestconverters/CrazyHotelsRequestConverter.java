package com.beamuae.availablehotels.converters.requestconverters;

import com.beamuae.availablehotels.converters.Converter;
import com.beamuae.availablehotels.dtos.requests.AvailableHotelsRequest;
import com.beamuae.availablehotels.dtos.requests.CrazyHotelsRequest;
import org.springframework.stereotype.Component;

import static com.beamuae.availablehotels.utilities.DateTimeFormatUtils.dateIsoInstant;

@Component
public class CrazyHotelsRequestConverter implements Converter<AvailableHotelsRequest, CrazyHotelsRequest> {
    @Override
    public CrazyHotelsRequest convert(AvailableHotelsRequest request) {
        CrazyHotelsRequest crazyHotelsRequest = new CrazyHotelsRequest();
        crazyHotelsRequest.setCity(request.getCity());
        crazyHotelsRequest.setFrom(dateIsoInstant(request.getFromDate()));
        crazyHotelsRequest.setTo(dateIsoInstant(request.getToDate()));
        crazyHotelsRequest.setAdultsCount(request.getNumberOfAdults());
        return crazyHotelsRequest;
    }
}
