package com.deliveryAgent.deliveryAgent.controller;

import com.deliveryAgent.deliveryAgent.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/update")
public class ProduceController {
    @Autowired
    DeliveryService deliveryService;

    @PostMapping("/location")
    public ResponseEntity<Map<String,String>> updateLocation()
    {
        for(int i=1;i<20000;i++)
        {
        String location="{ "+Math.round(Math.random()*100)+" , "+Math.round(Math.random()*100)+" }";
        deliveryService.publishLocationUpdate(location);
        }
        return new ResponseEntity<>(Map.of("message","published"), HttpStatus.OK);
    }

}
