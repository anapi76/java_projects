package com.anapiqueras.api.mapper;

import org.springframework.stereotype.Component;

import com.anapiqueras.api.controller.dto.ProductDTOController;
import com.anapiqueras.api.dto.ProductDTO;
import com.anapiqueras.api.dto.TypeProductDTO;

@Component
public class ControllerMapperDTO {

    public ProductDTO mapToProductDto(ProductDTOController product) {
        TypeProductDTO typeProduct= new TypeProductDTO();
        if(product.getType()!=null){
           typeProduct = new TypeProductDTO(product.getType());
        }
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
