package com.microservice.product.microserviceproduct.mapper;

import org.springframework.stereotype.Component;

import com.microservice.product.microserviceproduct.dto.ProductDTO;
import com.microservice.product.microserviceproduct.dto.TypeProductDTO;
import com.microservice.product.microserviceproduct.entity.ProductEntity;

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
