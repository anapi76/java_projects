package com.microservice.product.microserviceproduct.mapper;

import org.springframework.stereotype.Component;

import com.microservice.product.microserviceproduct.dto.TypeProductDTO;
import com.microservice.product.microserviceproduct.entity.TypeProductEntity;

@Component
public class TypeProductMapperDTO {

    public TypeProductDTO mapToTypeProductDto(TypeProductEntity typeProduct) {
        TypeProductDTO typeProductDto = new TypeProductDTO(
                typeProduct.getIdTypeProduct(),
                typeProduct.getName());
        return typeProductDto;
    }
}
