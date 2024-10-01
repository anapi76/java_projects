package com.anapiqueras.api.repository;

import java.util.List;

import com.anapiqueras.api.dto.TypeProductDTO;
import com.anapiqueras.api.exceptions.TypeProductNotFoundException;

public interface iTypeProductRepository{

    public List<TypeProductDTO> findAll();

    public TypeProductDTO findTypeProductById(int id) throws TypeProductNotFoundException;

    public TypeProductDTO createTypeProduct(TypeProductDTO typeProduct);

    public TypeProductDTO updateTypeProduct(TypeProductDTO typeProductFound);

    public void deleteTypeProductById(int id) throws TypeProductNotFoundException;

}
