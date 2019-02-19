package com.beamuae.availablehotels.usecases.implementation;

import com.beamuae.availablehotels.dtos.requests.AvailableHotelsRequest;
import com.beamuae.availablehotels.dtos.responses.AvailableHotelsResponse;
import com.beamuae.availablehotels.dtos.responses.HotelDetails;
import com.beamuae.availablehotels.providers.HotelOffersProvider;
import com.beamuae.availablehotels.usecases.UseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class CallingProvidersUseCase implements UseCase<AvailableHotelsRequest, AvailableHotelsResponse> {

    @Autowired
    private List<HotelOffersProvider> providers;

    @Override
    public AvailableHotelsResponse execute(AvailableHotelsRequest request) {
        List<HotelDetails> detailsList =
                providers.stream()
                        .map(provider -> provider.provideOffers(request))
                        .flatMap(List::stream)
                        .sorted((hd1, hd2) -> hd2.getRate() - hd1.getRate())
                        .collect(toList());

        AvailableHotelsResponse response = new AvailableHotelsResponse();
        response.setHotelsDetails(detailsList);
        return response;
    }
}
