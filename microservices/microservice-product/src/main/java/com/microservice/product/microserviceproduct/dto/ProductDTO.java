package com.microservice.product.microserviceproduct.dto;

public class ProductDTO {

    private int idProduct;
    private String name;
    private String description;
    private Double price;
    private Integer stock;
    private TypeProductDTO typeProductDto;

    public ProductDTO() {

    }

    public ProductDTO(int idProduct, String name, String description, Double price, Integer stock, TypeProductDTO typeProductDto) {
        this.idProduct=idProduct;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.typeProductDto = typeProductDto;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public TypeProductDTO getTypeProductDto() {
        return typeProductDto;
    }

    public void setTypeProductDto(TypeProductDTO typeProductDto) {
        this.typeProductDto = typeProductDto;
    }

}
