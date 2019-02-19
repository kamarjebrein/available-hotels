package com.beamuae.availablehotels.gateway;

import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public interface OffersGateway {

    String getOffers(String serviceUrl, String servicePath, String requestString);

    default URI uri(String serviceUrl, String servicePath) {
        return UriComponentsBuilder
                .fromUriString(serviceUrl)
                .path(servicePath)
                .build().toUri();
    }

}
