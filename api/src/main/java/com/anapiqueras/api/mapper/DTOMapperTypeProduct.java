package com.anapiqueras.api.mapper;

import org.springframework.stereotype.Component;

import com.anapiqueras.api.dto.TypeProductDTO;
import com.anapiqueras.api.persistence.model.TypeProductEntity;

@Component
public class DTOMapperTypeProduct {

    public TypeProductEntity mapToTypeProduct(TypeProductDTO typeProductDto) {
        TypeProductEntity typeProduct = new TypeProductEntity(
                typeProductDto.getName());
        typeProduct.setIdTypeProduct(typeProductDto.getIdTypeProduct());
        return typeProduct;
    }
}
