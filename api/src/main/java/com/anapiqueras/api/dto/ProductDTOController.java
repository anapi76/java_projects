package com.anapiqueras.api.dto;

public class ProductDTOController {

    private int idProduct;
    private String name;
    private String description;
    private Double price;
    private Integer stock;
    private Integer type;

    public ProductDTOController() {

    }

    public ProductDTOController(int idProduct, String name, String description, Double price, Integer stock) {
        this.idProduct=idProduct;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
       
    }

    public ProductDTOController(int idProduct, String name, String description, Double price, Integer stock, Integer type) {
        this.idProduct=idProduct;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.type = type;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

}
