package com.anapiqueras.api.service;

import java.util.List;

import com.anapiqueras.api.dto.TypeProductDTO;
//import com.anapiqueras.api.exceptions.TypeProductCantBeNullException;
import com.anapiqueras.api.exceptions.TypeProductNotFoundException;

public interface iTypeProductService {

    public List<TypeProductDTO> findAll();

    public TypeProductDTO findTypeProductById(int id) throws TypeProductNotFoundException ;
    
    /* public TypeProductDTO createTypeProduct(TypeProductDTO typeProductDto) throws TypeProductCantBeNullException;

    public TypeProductDTO updateTypeProduct(int id,TypeProductDTO typeProductDto) throws TypeProductNotFoundException;

    public void deleteTypeProductById(int id) throws TypeProductNotFoundException; */

}
