package com.anapiqueras.api.mapper;

import org.springframework.stereotype.Component;

import com.anapiqueras.api.dto.TypeProductDTO;
import com.anapiqueras.api.entity.TypeProductEntity;

@Component
public class TypeProductMapperDTO {

    public TypeProductDTO mapToTypeProductDto(TypeProductEntity typeProduct) {
        TypeProductDTO typeProductDto = new TypeProductDTO(
                typeProduct.getIdTypeProduct(),
                typeProduct.getName());
        return typeProductDto;
    }
}
