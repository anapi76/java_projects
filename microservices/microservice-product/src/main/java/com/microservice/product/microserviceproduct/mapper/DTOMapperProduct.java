package com.microservice.product.microserviceproduct.mapper;

import org.springframework.stereotype.Component;

import com.microservice.product.microserviceproduct.dto.ProductDTO;
import com.microservice.product.microserviceproduct.entity.ProductEntity;
import com.microservice.product.microserviceproduct.entity.TypeProductEntity;



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
