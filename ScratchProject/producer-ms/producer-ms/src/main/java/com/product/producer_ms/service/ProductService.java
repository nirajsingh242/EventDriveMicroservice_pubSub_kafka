package com.product.producer_ms.service;

import com.product.producer_ms.model.ProductModel;

import java.util.concurrent.ExecutionException;

public interface ProductService {
    String createProducet(ProductModel productModel) throws Exception;
}
