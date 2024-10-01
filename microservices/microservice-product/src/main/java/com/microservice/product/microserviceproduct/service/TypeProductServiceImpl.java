package com.microservice.product.microserviceproduct.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservice.product.microserviceproduct.repository.iTypeProductRepository;
import com.microservice.product.microserviceproduct.dto.TypeProductDTO;
import com.microservice.product.microserviceproduct.exceptions.TypeProductNotFoundException;

@Service
public class TypeProductServiceImpl implements iTypeProductService {

    public iTypeProductRepository typeProductRepository;

    public TypeProductServiceImpl(iTypeProductRepository typeProductRepository) {
        this.typeProductRepository = typeProductRepository;
    }

    @Override
    public List<TypeProductDTO> findAll() {
        List<TypeProductDTO> typeProducts = typeProductRepository.findAll();
        return typeProducts;
    }

    @Override
    public TypeProductDTO findTypeProductById(int id) throws TypeProductNotFoundException {
        TypeProductDTO typeProductFound = typeProductRepository.findTypeProductById(id);
        return typeProductFound;
    }

}
