package com.beamuae.availablehotels.gateway;

public class OffersGatewayMock implements OffersGateway {

    private String responseString;

    public OffersGatewayMock(String responseString) {
        this.responseString = responseString;
    }

    @Override
    public String getOffers(String serviceUrl, String servicePath, String requestString) {
        return responseString;
    }
}