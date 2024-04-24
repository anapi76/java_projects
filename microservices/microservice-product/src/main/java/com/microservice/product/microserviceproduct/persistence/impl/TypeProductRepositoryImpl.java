package com.microservice.product.microserviceproduct.persistence.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.microservice.product.microserviceproduct.domain.repository.iTypeProductRepository;
import com.microservice.product.microserviceproduct.dto.TypeProductDTO;
import com.microservice.product.microserviceproduct.exceptions.TypeProductNotFoundException;
import com.microservice.product.microserviceproduct.mapper.DTOMapperTypeProduct;
import com.microservice.product.microserviceproduct.mapper.TypeProductMapperDTO;
import com.microservice.product.microserviceproduct.persistence.DAO.iTypeProductDAO;
import com.microservice.product.microserviceproduct.persistence.entity.TypeProductEntity;


@Repository
public class TypeProductRepositoryImpl implements iTypeProductRepository {

    public iTypeProductDAO typeProductDao;
    private DTOMapperTypeProduct dtoMapperTypeProduct;
    private TypeProductMapperDTO typeProductMapperDTO;

    public TypeProductRepositoryImpl(iTypeProductDAO typeProductDao,DTOMapperTypeProduct dtoMapperTypeProduct, TypeProductMapperDTO typeProductMapperDTO) {
        this.typeProductDao = typeProductDao;
        this.dtoMapperTypeProduct=dtoMapperTypeProduct;
        this.typeProductMapperDTO=typeProductMapperDTO;
    }

    @Override
    public List<TypeProductDTO> findAll() {
        List<TypeProductEntity> typeProducts = typeProductDao.findAll();
        return typeProducts.stream().map(p->typeProductMapperDTO.mapToTypeProductDto(p)).collect(Collectors.toList());
    }

    @Override
    public TypeProductDTO findTypeProductById(int id) throws TypeProductNotFoundException {
        TypeProductEntity typeProductFound = typeProductDao.findById(id)
                .orElseThrow(() -> new TypeProductNotFoundException("TypeProduct not found for id: " + id));
        return typeProductMapperDTO.mapToTypeProductDto(typeProductFound);
    }

    @Override
    public TypeProductDTO createTypeProduct(TypeProductDTO typeProductDto) {
        TypeProductEntity typeProduct = dtoMapperTypeProduct.mapToTypeProduct(typeProductDto);
        typeProduct = typeProductDao.save(typeProduct);
        TypeProductDTO savedTypeProductDto = typeProductMapperDTO.mapToTypeProductDto(typeProduct);
        return savedTypeProductDto;
    }

    @Override
    public TypeProductDTO updateTypeProduct(TypeProductDTO typeProductDto) {
        TypeProductEntity typeProduct = dtoMapperTypeProduct.mapToTypeProduct(typeProductDto);
        typeProduct= typeProductDao.save(typeProduct);
        TypeProductDTO savedTypeProductDto = typeProductMapperDTO.mapToTypeProductDto(typeProduct);
        return savedTypeProductDto;
    }

    @Override
    public void deleteTypeProductById(int id) {
        typeProductDao.deleteById(id);
    }

}
