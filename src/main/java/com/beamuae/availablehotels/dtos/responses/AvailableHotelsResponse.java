package com.beamuae.availablehotels.dtos.responses;

import java.util.List;

public class AvailableHotelsResponse {

    private List<HotelDetails> hotelsDetails;

    public List<HotelDetails> getHotelsDetails() {
        return hotelsDetails;
    }

    public void setHotelsDetails(List<HotelDetails> hotelsDetails) {
        this.hotelsDetails = hotelsDetails;
    }
}
