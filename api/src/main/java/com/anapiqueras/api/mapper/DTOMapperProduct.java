package com.anapiqueras.api.mapper;

import org.springframework.stereotype.Component;

import com.anapiqueras.api.dto.ProductDTO;
import com.anapiqueras.api.entity.ProductEntity;
import com.anapiqueras.api.entity.TypeProductEntity;

@Component
public class DTOMapperProduct {

    private DTOMapperTypeProduct dtoMapperTypeProduct=new DTOMapperTypeProduct();

    public ProductEntity mapToProduct(ProductDTO productDto) {
       TypeProductEntity typeProduct=dtoMapperTypeProduct.mapToTypeProduct(productDto.getTypeProductDto());
        ProductEntity product = new ProductEntity(
                productDto.getName(),
                productDto.getDescription(),
                productDto.getPrice(),
                productDto.getStock(),
                typeProduct);
        product.setIdProduct(productDto.getIdProduct());
        return product;
    }
}
