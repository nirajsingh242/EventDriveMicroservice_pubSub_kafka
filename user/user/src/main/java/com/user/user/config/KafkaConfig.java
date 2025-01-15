package com.user.user.config;



import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import static com.user.user.config.TopicConstants.GROUP_ID;
import static com.user.user.config.TopicConstants.LOCATION_UPDATE_TOPIC;


@Configuration
public class KafkaConfig {

    @KafkaListener(topics = LOCATION_UPDATE_TOPIC,groupId = GROUP_ID)
    public void consumeLocation(String value)
    {
        System.out.println(value);
    }


}
