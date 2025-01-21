package com.product.producer_ms.service.impl;

import com.library.model.core.ProductModel;
import com.product.producer_ms.service.ProductService;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import java.util.UUID;

import static com.library.model.core.TopicConstants.PRODUCT_ORDER_MS;

@Service
public class    ProductServiceImpl implements ProductService {
    @Autowired
    KafkaTemplate<String, ProductModel> kafkaTemplate;

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
        ProducerRecord<String, ProductModel> record = new ProducerRecord<>(
                PRODUCT_ORDER_MS,
                productId,
                productModel);
        record.headers().add("messageId", UUID.randomUUID().toString().getBytes());//sending uniqu id in header for each message
        SendResult<String, ProductModel> result = kafkaTemplate.send(record).get();

        //SendResult<String, ProductModel> result = kafkaTemplate.send(PRODUCT_ORDER_MS, productId, productModel).get();
        System.out.println("****** Partition: "+result.getRecordMetadata().partition());
        System.out.println("****** Topic: "+result.getRecordMetadata().topic());
        System.out.println("****** Offset: "+result.getRecordMetadata().offset());
        System.out.println("****** Offset: "+result.getRecordMetadata().offset());
        System.out.println("****** Returning product Id: key"+productId);

        return productId;
    }
}
