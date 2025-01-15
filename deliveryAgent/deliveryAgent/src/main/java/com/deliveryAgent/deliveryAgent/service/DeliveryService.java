package com.deliveryAgent.deliveryAgent.service;

import com.deliveryAgent.deliveryAgent.kafkaConfig.TopicConstants;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class DeliveryService {

    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;

    //Logger logger= (Logger) LoggerFactory.getLogger(DeliveryService.class);

    public boolean publishLocationUpdate(String location)
    {
        kafkaTemplate.send(TopicConstants.LOCATION_UPDATE_TOPIC,location);
       System.out.println(("location published to topic :"+TopicConstants.LOCATION_UPDATE_TOPIC+" location :"+location));
        return true;

    }

}
