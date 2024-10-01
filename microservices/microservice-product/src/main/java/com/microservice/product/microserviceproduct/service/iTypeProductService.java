package com.microservice.product.microserviceproduct.service;

import java.util.List;

import com.microservice.product.microserviceproduct.dto.TypeProductDTO;
import com.microservice.product.microserviceproduct.exceptions.TypeProductNotFoundException;

public interface iTypeProductService {

    public List<TypeProductDTO> findAll();

    public TypeProductDTO findTypeProductById(int id) throws TypeProductNotFoundException ;

}
