package com.microservice.product.microserviceproduct.mapper;

import org.springframework.stereotype.Component;

import com.microservice.product.microserviceproduct.dto.ProductDTO;
import com.microservice.product.microserviceproduct.dto.ProductDTOController;
import com.microservice.product.microserviceproduct.dto.TypeProductDTO;

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
