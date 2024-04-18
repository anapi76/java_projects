package com.anapiqueras.api.persistence.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.anapiqueras.api.domain.repository.iTypeProductRepository;
import com.anapiqueras.api.dto.TypeProductDTO;
import com.anapiqueras.api.exceptions.TypeProductNotFoundException;
import com.anapiqueras.api.mapper.DTOMapperTypeProduct;
import com.anapiqueras.api.mapper.TypeProductMapperDTO;
import com.anapiqueras.api.persistence.DAO.iTypeProductDAO;
import com.anapiqueras.api.persistence.model.TypeProductEntity;

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
