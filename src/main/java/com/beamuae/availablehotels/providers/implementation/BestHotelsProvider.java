package com.beamuae.availablehotels.providers.implementation;

import com.beamuae.availablehotels.converters.requestconverters.BestHotelsRequestConverter;
import com.beamuae.availablehotels.converters.responseconverters.BestHotelsResponseConverter;
import com.beamuae.availablehotels.dtos.requests.AvailableHotelsRequest;
import com.beamuae.availablehotels.dtos.requests.BestHotelsRequest;
import com.beamuae.availablehotels.dtos.responses.BestHotelsResponse;
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
public class BestHotelsProvider implements HotelOffersProvider {

    private final static String SERVICE_URL = "http://localhost:8000";
    private final static String SERVICE_PATH = "/BestHotels";

    private BestHotelsRequestConverter requestConverter;
    private OffersGateway offersGateway;
    private BestHotelsResponseConverter responseConverter;

    @Autowired
    public BestHotelsProvider(BestHotelsRequestConverter requestConverter,
                              OffersGateway offersGateway,
                              BestHotelsResponseConverter responseConverter) {
        this.requestConverter = requestConverter;
        this.offersGateway = offersGateway;
        this.responseConverter = responseConverter;
    }

    @Override
    public List<HotelDetails> provideOffers(AvailableHotelsRequest request) {
        BestHotelsRequest bestHotelsRequest = requestConverter.convert(request);
        String requestString = new Gson().toJson(bestHotelsRequest);
        String responseString = offersGateway.getOffers(SERVICE_URL, SERVICE_PATH, requestString);
        BestHotelsResponse[] bestHotelsResponses = new Gson().fromJson(responseString, BestHotelsResponse[].class);
        return stream(bestHotelsResponses)
                .map(resp -> responseConverter.convert(resp))
                .collect(toList());
    }

}
