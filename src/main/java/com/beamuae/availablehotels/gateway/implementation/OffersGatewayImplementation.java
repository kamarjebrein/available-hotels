package com.beamuae.availablehotels.gateway.implementation;

import com.beamuae.availablehotels.gateway.OffersGateway;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OffersGatewayImplementation implements OffersGateway {
    @Override
    public String getOffers(String serviceUrl, String servicePath, String requestString) {
        HttpEntity<String> httpRequest = new HttpEntity<>(requestString);
        return new RestTemplate().postForObject(uri(serviceUrl, servicePath), httpRequest, String.class);
    }
}
