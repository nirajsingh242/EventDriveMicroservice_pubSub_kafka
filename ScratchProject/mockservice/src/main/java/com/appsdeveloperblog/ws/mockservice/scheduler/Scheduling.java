package com.appsdeveloperblog.ws.mockservice.scheduler;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class Scheduling {

    @Scheduled(fixedDelay = 1000)
    public void fixedDlay()
    {
        System.out.println("Fixed Delay task "+System.currentTimeMillis()/1000);
    }

    @Scheduled(fixedRate = 1000)
    @Async
    public void fixedrate()
    {
        System.out.println("Fixed Rate task "+System.currentTimeMillis()/1000);
    }

}
