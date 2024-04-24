package com.microservice.product.microserviceproduct.mapper;

import org.springframework.stereotype.Component;

import com.microservice.product.microserviceproduct.dto.TypeProductDTO;
import com.microservice.product.microserviceproduct.persistence.entity.TypeProductEntity;

@Component
public class DTOMapperTypeProduct {

    public TypeProductEntity mapToTypeProduct(TypeProductDTO typeProductDto) {
        TypeProductEntity typeProduct = new TypeProductEntity(
                typeProductDto.getName());
        typeProduct.setIdTypeProduct(typeProductDto.getIdTypeProduct());
        return typeProduct;
    }
}
