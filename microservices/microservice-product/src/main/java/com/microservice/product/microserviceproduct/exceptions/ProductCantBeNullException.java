package com.microservice.product.microserviceproduct.exceptions;

public class ProductCantBeNullException extends Exception {
    public ProductCantBeNullException(String message) {
        super(message);
    }
}
