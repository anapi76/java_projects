package com.microservice.product.microserviceproduct.repository;

import java.util.List;

import com.microservice.product.microserviceproduct.dto.ProductDTO;
import com.microservice.product.microserviceproduct.exceptions.ProductNotFoundException;

public interface iProductRepository{

    public List<ProductDTO> findAll();

    public ProductDTO findProductById(int id) throws ProductNotFoundException;

    public ProductDTO createProduct(ProductDTO product);

    public ProductDTO updateProduct(ProductDTO productFound);

    public void deleteProductById(int id) throws ProductNotFoundException;

}
