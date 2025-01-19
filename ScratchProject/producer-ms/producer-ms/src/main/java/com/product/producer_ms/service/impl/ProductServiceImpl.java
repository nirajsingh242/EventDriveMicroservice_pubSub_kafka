package com.product.producer_ms.service.impl;

import com.product.producer_ms.model.ProductModel;
import com.product.producer_ms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static com.product.producer_ms.config.TopicConstants.LOCATION_UPDATE_TOPIC;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    KafkaTemplate<String,ProductModel> kafkaTemplate;

    @Override
    public String createProducet(ProductModel productModel) throws Exception {
        String productId=UUID.randomUUID().toString();
        //Asynchrounous way
//        CompletableFuture<SendResult<String, ProductModel>> future = kafkaTemplate.send(LOCATION_UPDATE_TOPIC, productId, productModel);
//        future.whenComplete((result,exception)->{
//            if(exception!=null)
//            {
//                System.out.println("****** Failed to send message "+exception.getMessage());
//            }else{
//                System.out.println("****** Message sent successfully: "+result.getRecordMetadata());
//            }
//        });
//        System.out.println("****** Product created successfully: ");

        //synchronous way
        System.out.println("****** Before send method called: ");
        SendResult<String, ProductModel> result = kafkaTemplate.send(LOCATION_UPDATE_TOPIC, productId, productModel).get();
        System.out.println("****** Partition: "+result.getRecordMetadata().partition());
        System.out.println("****** Topic: "+result.getRecordMetadata().topic());
        System.out.println("****** Offset: "+result.getRecordMetadata().offset());
        System.out.println("****** Returning product Id: ");

        return productId;
    }
}
