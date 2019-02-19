package com.beamuae.availablehotels.providers.implementation;

import com.beamuae.availablehotels.converters.requestconverters.CrazyHotelsRequestConverter;
import com.beamuae.availablehotels.converters.responseconverters.CrazyHotelsResponseConverter;
import com.beamuae.availablehotels.dtos.requests.AvailableHotelsRequest;
import com.beamuae.availablehotels.dtos.requests.CrazyHotelsRequest;
import com.beamuae.availablehotels.dtos.responses.CrazyHotelsResponse;
import com.beamuae.availablehotels.dtos.responses.HotelDetails;
import com.beamuae.availablehotels.gateway.OffersGateway;
import com.beamuae.availablehotels.providers.HotelOffersProvider;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

@Component
public class CrazyHotelsProvider implements HotelOffersProvider {

    private final static String SERVICE_URL = "http://localhost:8000";
    private final static String SERVICE_PATH = "/CrazyHotels";

    private CrazyHotelsRequestConverter requestConverter;
    private OffersGateway offersGateway;
    private CrazyHotelsResponseConverter responseConverter;

    @Autowired
    public CrazyHotelsProvider(CrazyHotelsRequestConverter requestConverter,
                               OffersGateway offersGateway,
                               CrazyHotelsResponseConverter responseConverter) {
        this.requestConverter = requestConverter;
        this.offersGateway = offersGateway;
        this.responseConverter = responseConverter;
    }

    @Override
    public List<HotelDetails> provideOffers(AvailableHotelsRequest request) {
        CrazyHotelsRequest crazyHotelsRequest = requestConverter.convert(request);
        String requestString = new Gson().toJson(crazyHotelsRequest);
        String responseString = offersGateway.getOffers(SERVICE_URL, SERVICE_PATH, requestString);
        CrazyHotelsResponse[] crazyHotelsResponses = new Gson().fromJson(responseString, CrazyHotelsResponse[].class);
        return stream(crazyHotelsResponses)
                .map(resp -> responseConverter.convert(resp))
                .collect(toList());
    }

}
