package com.anapiqueras.api.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idProduct")
    private int idProduct;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private String description;

    @Column(nullable=false)
    private Double price;

    @Column(nullable=false)
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "type_product")
    private TypeProductEntity typeProduct;

    public ProductEntity() {
    
    }

    public ProductEntity(String name, String description, Double price, Integer stock, TypeProductEntity typeProduct) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock=stock;
        this.typeProduct = typeProduct;
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

    public TypeProductEntity getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(TypeProductEntity typeProduct) {
        this.typeProduct = typeProduct;
    }
}
