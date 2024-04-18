package com.anapiqueras.api.domain.repository;

import java.util.List;

import com.anapiqueras.api.dto.ProductDTO;
import com.anapiqueras.api.exceptions.ProductNotFoundException;

public interface iProductRepository{

    public List<ProductDTO> findAll();

    public ProductDTO findProductById(int id) throws ProductNotFoundException;

    public ProductDTO createProduct(ProductDTO product);

    public ProductDTO updateProduct(ProductDTO productFound);

    public void deleteProductById(int id) throws ProductNotFoundException;

}
