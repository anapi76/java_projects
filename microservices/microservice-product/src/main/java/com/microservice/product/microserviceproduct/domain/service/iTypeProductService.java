package com.microservice.product.microserviceproduct.domain.service;

import java.util.List;

import com.microservice.product.microserviceproduct.dto.TypeProductDTO;
import com.microservice.product.microserviceproduct.exceptions.TypeProductNotFoundException;

public interface iTypeProductService {

    public List<TypeProductDTO> findAll();

    public TypeProductDTO findTypeProductById(int id) throws TypeProductNotFoundException ;
    
    /* public TypeProductDTO createTypeProduct(TypeProductDTO typeProductDto) throws TypeProductCantBeNullException;

    public TypeProductDTO updateTypeProduct(int id,TypeProductDTO typeProductDto) throws TypeProductNotFoundException;

    public void deleteTypeProductById(int id) throws TypeProductNotFoundException; */

}
