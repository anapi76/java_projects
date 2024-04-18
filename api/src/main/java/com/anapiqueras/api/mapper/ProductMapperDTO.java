package com.anapiqueras.api.mapper;

import org.springframework.stereotype.Component;

import com.anapiqueras.api.dto.ProductDTO;
import com.anapiqueras.api.dto.TypeProductDTO;
import com.anapiqueras.api.persistence.model.ProductEntity;

@Component
public class ProductMapperDTO {

    private TypeProductMapperDTO typeProductMapperDTO = new TypeProductMapperDTO();

    public ProductDTO mapToProductDto(ProductEntity product) {
        TypeProductDTO typeProduct = typeProductMapperDTO.mapToTypeProductDto(product.getTypeProduct());
        ProductDTO productDto = new ProductDTO(
                product.getIdProduct(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStock(),
                typeProduct);
        return productDto;
    }
}
