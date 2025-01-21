package com.product.producer_ms.controller;

import com.library.model.core.ProductModel;
import com.product.producer_ms.model.ErrorMessage;
import com.product.producer_ms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/Products")
public class ProductController {

    @Autowired
    ProductService productService;
    @PostMapping()
    public ResponseEntity<Object> createProduct(@RequestBody ProductModel product)  {
        String ProductID= null;
        try {
            ProductID = productService.createProducet(product);
        } catch (Exception e) {
           e.printStackTrace();
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorMessage(new Date(),e.getMessage(),"/products"));
        }
        return new ResponseEntity<>("successfully stored "+product, HttpStatus.CREATED);
    }
}
