package com.beamuae.availablehotels.controllers;

import com.beamuae.availablehotels.dtos.requests.AvailableHotelsRequest;
import com.beamuae.availablehotels.dtos.responses.AvailableHotelsResponse;
import com.beamuae.availablehotels.usecases.implementation.CallingProvidersUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AvailableHotelsController {

    @Autowired
    private CallingProvidersUseCase useCase;

    @RequestMapping(method = RequestMethod.POST, value = "/availableHotels")
    @ResponseBody
    AvailableHotelsResponse lookForHotels(@RequestBody AvailableHotelsRequest request) {
        return useCase.execute(request);
    }
}