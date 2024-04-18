package com.anapiqueras.api.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anapiqueras.api.domain.repository.iProductRepository;
import com.anapiqueras.api.domain.repository.iTypeProductRepository;
import com.anapiqueras.api.dto.ProductDTO;
import com.anapiqueras.api.dto.TypeProductDTO;
import com.anapiqueras.api.exceptions.ProductCantBeNullException;
import com.anapiqueras.api.exceptions.ProductNotFoundException;
import com.anapiqueras.api.exceptions.TypeProductNotFoundException;

@Service
public class ProductServiceImpl implements iProductService {

    public iProductRepository productRepository;
    public iTypeProductRepository typeProductRepository;

    public ProductServiceImpl(iProductRepository productRepository, iTypeProductRepository typeProductRepository) {
        this.productRepository = productRepository;
        this.typeProductRepository = typeProductRepository;
    }

    @Override
    public List<ProductDTO> findAll() {
        List<ProductDTO> products = productRepository.findAll();
        return products;
    }

    @Override
    public ProductDTO findProductById(int id) throws ProductNotFoundException {
        ProductDTO productFound = productRepository.findProductById(id);
        return productFound;
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDto)throws TypeProductNotFoundException, ProductCantBeNullException {
        if (productDto == null) {
            throw new ProductCantBeNullException("Product can't be null");
        }
        if (!validateProduct(productDto)) {
            return null;
        }
        TypeProductDTO typeProduct = typeProductRepository.findTypeProductById(productDto.getTypeProductDto().getIdTypeProduct());
        productDto.setTypeProductDto(typeProduct);
        ProductDTO createdProduct = productRepository.createProduct(productDto);

        return createdProduct;
    }

    @Override
    public ProductDTO updateProduct(int id, ProductDTO productDto) throws ProductNotFoundException, TypeProductNotFoundException {
        ProductDTO productFound = productRepository.findProductById(id);
        productFound.setIdProduct(id);
        if (productDto.getName() != null) {
            productFound.setName(productDto.getName());
        }
        if (productDto.getDescription() != null) {
            productFound.setDescription(productDto.getDescription());
        }
        if (productDto.getPrice() != null) {
            productFound.setPrice(productDto.getPrice());
        }
        if (productDto.getStock() != null) {
            productFound.setStock(productDto.getStock());
        }
        if (productDto.getTypeProductDto() != null) {
            TypeProductDTO typeProduct = typeProductRepository.findTypeProductById(productDto.getTypeProductDto().getIdTypeProduct());
            productFound.setTypeProductDto(typeProduct);
        }
        ProductDTO updatedProduct = productRepository.updateProduct(productFound);
        return updatedProduct;
    }

    @Override
    public void deleteProductById(int id) throws ProductNotFoundException {
        productRepository.deleteProductById(id);
    }

    public Boolean validateProduct(ProductDTO productDto) {
        return (productDto.getName() != null && !productDto.getName().isEmpty() && productDto.getDescription() != null
                && !productDto.getDescription().isEmpty() && productDto.getPrice() != null && productDto.getPrice() > 0
                && productDto.getStock() != null && productDto.getStock() > 0
                && productDto.getTypeProductDto() != null);
    }
}
