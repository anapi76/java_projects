package com.microservice.product.microserviceproduct.controller;

import java.util.List;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.microservice.product.microserviceproduct.service.iTypeProductService;
import com.microservice.product.microserviceproduct.dto.TypeProductDTO;
import com.microservice.product.microserviceproduct.exceptions.TypeProductNotFoundException;


@RestController
@RequestMapping("/typeProduct")
public class TypeProductController {

    public iTypeProductService typeProductService;

    public TypeProductController(iTypeProductService typeProductService) {
        this.typeProductService = typeProductService;
    }

    @GetMapping()
    public ResponseEntity<List<TypeProductDTO>> findAll() {
        List<TypeProductDTO> typeProducts = typeProductService.findAll();
        if (typeProducts.isEmpty()) {
            return new ResponseEntity<>(typeProducts, HttpStatus.OK);
        }
        return new ResponseEntity<>(typeProducts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeProductDTO> findTypeProductById(@PathVariable int id) {
        try {
            TypeProductDTO typeProduct = typeProductService.findTypeProductById(id);
            return new ResponseEntity<>(typeProduct, HttpStatus.OK);
        } catch (TypeProductNotFoundException pne) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
