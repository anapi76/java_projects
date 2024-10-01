package com.microservice.product.microserviceproduct.controller;

import java.util.List;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.microservice.product.microserviceproduct.service.iProductService;
import com.microservice.product.microserviceproduct.dto.ProductDTO;
import com.microservice.product.microserviceproduct.dto.ProductDTOController;
import com.microservice.product.microserviceproduct.exceptions.ProductCantBeNullException;
import com.microservice.product.microserviceproduct.exceptions.ProductNotFoundException;
import com.microservice.product.microserviceproduct.exceptions.TypeProductNotFoundException;
import com.microservice.product.microserviceproduct.mapper.ControllerMapperDTO;


@RestController
@RequestMapping("/product")
public class ProductController {

    public iProductService productService;
    public ControllerMapperDTO controllerMapperDto;

    public ProductController(iProductService productService, ControllerMapperDTO controllerMapperDto) {
        this.productService = productService;
        this.controllerMapperDto = controllerMapperDto;
    }

    @GetMapping("")
    public ResponseEntity<List<ProductDTO>> findAll() {
        List<ProductDTO> products = productService.findAll();
            return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findProductById(@PathVariable int id) {
        try {
            ProductDTO product = productService.findProductById(id);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (ProductNotFoundException pne) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTOController productController) {
        try {
            ProductDTO productDto = controllerMapperDto.mapToProductDto(productController);
            ProductDTO createdProduct = productService.createProduct(productDto);
            if (createdProduct == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
        } catch (ProductCantBeNullException p) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (TypeProductNotFoundException t) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable int id,
            @RequestBody ProductDTOController productController) {
        try {
            ProductDTO productDto = controllerMapperDto.mapToProductDto(productController);
            ProductDTO productUpdated = productService.updateProduct(id, productDto);
            return new ResponseEntity<>(productUpdated, HttpStatus.CREATED);
        } catch (ProductNotFoundException pne) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (TypeProductNotFoundException t) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable int id) {
        try {
            productService.deleteProductById(id);
            return new ResponseEntity<>("Product deleted:" + id, HttpStatus.OK);
        } catch (ProductNotFoundException pne) {
            return new ResponseEntity<>("Product not found for id: " + id, HttpStatus.NOT_FOUND);
        }
    }
}
