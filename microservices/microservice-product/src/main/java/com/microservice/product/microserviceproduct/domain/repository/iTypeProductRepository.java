package com.microservice.product.microserviceproduct.domain.repository;

import java.util.List;

import com.microservice.product.microserviceproduct.dto.TypeProductDTO;
import com.microservice.product.microserviceproduct.exceptions.TypeProductNotFoundException;

public interface iTypeProductRepository{

    public List<TypeProductDTO> findAll();

    public TypeProductDTO findTypeProductById(int id) throws TypeProductNotFoundException;

    public TypeProductDTO createTypeProduct(TypeProductDTO typeProduct);

    public TypeProductDTO updateTypeProduct(TypeProductDTO typeProductFound);

    public void deleteTypeProductById(int id) throws TypeProductNotFoundException;

}
