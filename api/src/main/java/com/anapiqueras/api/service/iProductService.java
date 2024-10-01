package com.anapiqueras.api.service;

import java.util.List;

import com.anapiqueras.api.dto.ProductDTO;
import com.anapiqueras.api.exceptions.ProductCantBeNullException;
import com.anapiqueras.api.exceptions.ProductNotFoundException;
import com.anapiqueras.api.exceptions.TypeProductNotFoundException;

public interface iProductService {

    public List<ProductDTO> findAll();

    public ProductDTO findProductById(int id) throws ProductNotFoundException ;
    
    public ProductDTO createProduct(ProductDTO product) throws ProductCantBeNullException, TypeProductNotFoundException;

    public ProductDTO updateProduct(int id,ProductDTO product) throws ProductNotFoundException, TypeProductNotFoundException;

    public void deleteProductById(int id) throws ProductNotFoundException;

}
