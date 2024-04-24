package com.microservice.product.microserviceproduct.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservice.product.microserviceproduct.domain.repository.iTypeProductRepository;
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

/*     @Override
    public TypeProductDTO createTypeProduct(TypeProductDTO typeProductDto) throws TypeProductCantBeNullException {
        if (typeProductDto == null) {
            throw new TypeProductCantBeNullException("TypeProduct can't be null");
        }
        if (!validateTypeProduct(typeProductDto)) {
            return null;
        }
        TypeProductDTO createdTypeProduct = typeProductRepository.createTypeProduct(typeProductDto);

        return createdTypeProduct;
    }

    @Override
    public TypeProductDTO updateTypeProduct(int id, TypeProductDTO typeProductDto) throws TypeProductNotFoundException {
        TypeProductDTO typeProductFound = typeProductRepository.findTypeProductById(id);
        typeProductFound.setIdTypeProduct(id);
        if (typeProductDto.getName() != null) {
            typeProductFound.setName(typeProductDto.getName());
        }
        TypeProductDTO updatedTypeProduct = typeProductRepository.updateTypeProduct(typeProductFound);
        return updatedTypeProduct;
    }

    @Override
    public void deleteTypeProductById(int id) throws TypeProductNotFoundException {
        TypeProductDTO typeProductFound=findTypeProductById(id);
        typeProductRepository.deleteTypeProductById(id);
    }

    public Boolean validateTypeProduct(TypeProductDTO typeProductDto) {
        return (typeProductDto.getName() != null && !typeProductDto.getName().isEmpty());
    }
 */

}
