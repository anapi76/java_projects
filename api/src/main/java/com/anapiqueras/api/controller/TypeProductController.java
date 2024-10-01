package com.anapiqueras.api.controller;

import java.util.List;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.anapiqueras.api.service.iTypeProductService;
import com.anapiqueras.api.dto.TypeProductDTO;
//import com.anapiqueras.api.exceptions.TypeProductCantBeNullException;
import com.anapiqueras.api.exceptions.TypeProductNotFoundException;

@RestController
@RequestMapping("/typeProduct")
public class TypeProductController {

    public iTypeProductService typeProductService;

    public TypeProductController(iTypeProductService typeProductService) {
        this.typeProductService = typeProductService;
    }

    @GetMapping("/")
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

   /*  @PostMapping("/create")
    public ResponseEntity<TypeProductDTO> createTypeProduct(@RequestBody TypeProductDTO typeProductDto) {
        try {
            TypeProductDTO createdTypeProduct = typeProductService.createTypeProduct(typeProductDto);
            if (createdTypeProduct == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(createdTypeProduct, HttpStatus.CREATED);
        } catch (TypeProductCantBeNullException p) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TypeProductDTO> updateTypeProduct(@PathVariable int id,
            @RequestBody TypeProductDTO typeProductDto) {
        try {
            TypeProductDTO typeProductUpdated = typeProductService.updateTypeProduct(id, typeProductDto);
            return new ResponseEntity<>(typeProductUpdated, HttpStatus.CREATED);
        } catch (TypeProductNotFoundException pne) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTypeProductById(@PathVariable int id) {
        try {
            typeProductService.deleteTypeProductById(id);
            return new ResponseEntity<>("TypeProduct deleted:" + id, HttpStatus.OK);
        } catch (TypeProductNotFoundException pne) {
            return new ResponseEntity<>("TypeProduct not found for id: " + id, HttpStatus.NOT_FOUND);
        }
    } */
}
