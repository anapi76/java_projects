package com.microservice.product.microserviceproduct.service;

import java.util.List;

import com.microservice.product.microserviceproduct.dto.ProductDTO;
import com.microservice.product.microserviceproduct.exceptions.ProductCantBeNullException;
import com.microservice.product.microserviceproduct.exceptions.ProductNotFoundException;
import com.microservice.product.microserviceproduct.exceptions.TypeProductNotFoundException;

public interface iProductService {

    public List<ProductDTO> findAll();

    public ProductDTO findProductById(int id) throws ProductNotFoundException ;
    
    public ProductDTO createProduct(ProductDTO product) throws ProductCantBeNullException, TypeProductNotFoundException;

    public ProductDTO updateProduct(int id,ProductDTO product) throws ProductNotFoundException, TypeProductNotFoundException;

    public void deleteProductById(int id) throws ProductNotFoundException;

}
