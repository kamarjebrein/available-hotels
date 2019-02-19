package com.beamuae.availablehotels.converters.requestconverters;

import com.beamuae.availablehotels.converters.Converter;
import com.beamuae.availablehotels.dtos.requests.AvailableHotelsRequest;
import com.beamuae.availablehotels.dtos.requests.BestHotelsRequest;
import org.springframework.stereotype.Component;

import static com.beamuae.availablehotels.utilities.DateTimeFormatUtils.dateIsoLocalDate;

@Component
public class BestHotelsRequestConverter implements Converter<AvailableHotelsRequest, BestHotelsRequest> {
    @Override
    public BestHotelsRequest convert(AvailableHotelsRequest request) {
        BestHotelsRequest bestHotelsRequest = new BestHotelsRequest();
        bestHotelsRequest.setCity(request.getCity());
        bestHotelsRequest.setFromDate(dateIsoLocalDate(request.getFromDate()));
        bestHotelsRequest.setToDate(dateIsoLocalDate(request.getToDate()));
        bestHotelsRequest.setNumberOfAdults(request.getNumberOfAdults());
        return bestHotelsRequest;
    }
}
