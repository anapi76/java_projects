package com.microservice.product.microserviceproduct.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.microservice.product.microserviceproduct.dto.ProductDTO;
import com.microservice.product.microserviceproduct.exceptions.ProductNotFoundException;
import com.microservice.product.microserviceproduct.mapper.DTOMapperProduct;
import com.microservice.product.microserviceproduct.mapper.ProductMapperDTO;
import com.microservice.product.microserviceproduct.repository.DAO.iProductDAO;
import com.microservice.product.microserviceproduct.entity.ProductEntity;


@Repository
public class ProductRepositoryImpl implements iProductRepository {

    public iProductDAO productDao;
    private DTOMapperProduct dtoMapperProduct;
    private ProductMapperDTO productMapperDTO;

    public ProductRepositoryImpl(iProductDAO productDao,DTOMapperProduct dtoMapperProduct, ProductMapperDTO productMapperDTO) {
        this.productDao = productDao;
        this.dtoMapperProduct=dtoMapperProduct;
        this.productMapperDTO=productMapperDTO;
    }

    @Override
    public List<ProductDTO> findAll() {
        List<ProductEntity> products = productDao.findAll();
        return products.stream().map(p->productMapperDTO.mapToProductDto(p)).collect(Collectors.toList());
    }

    @Override
    public ProductDTO findProductById(int id) throws ProductNotFoundException {
        ProductEntity productFound = productDao.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found for id: " + id));
        return productMapperDTO.mapToProductDto(productFound);
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDto) {
        ProductEntity product = dtoMapperProduct.mapToProduct(productDto);
        product = productDao.save(product);
        ProductDTO savedProductDto = productMapperDTO.mapToProductDto(product);
        return savedProductDto;
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDto) {
        ProductEntity product = dtoMapperProduct.mapToProduct(productDto);
        product= productDao.save(product);
        ProductDTO savedProductDto = productMapperDTO.mapToProductDto(product);
        return savedProductDto;
    }

    @Override
    public void deleteProductById(int id) throws ProductNotFoundException {
        if(findProductById(id)==null){
            new ProductNotFoundException("Product not found for id: " + id);
        }
        productDao.deleteById(id);
    }

}
