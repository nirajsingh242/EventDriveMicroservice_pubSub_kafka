package com.appsdeveloperblog.ws.mockservice.actuators;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Endpoint(id = "custom")
@Component
public class CustomActuatorEndpoint {

//    @ReadOperation
//    @RequestMapping("/custom")
//    public String customEndpoint() {
//        return "This is a custom actuator endpoint!";
//    }

    @ReadOperation
    @RequestMapping("/custom-with-param")
    public String customEndpointWithParam(@RequestParam String name) {
        return "Hello, " + name + "! This is a custom actuator endpoint with query parameters.";
    }
}
