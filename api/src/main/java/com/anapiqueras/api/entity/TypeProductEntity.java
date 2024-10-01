package com.anapiqueras.api.persistence.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="type_product")
public class TypeProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_type_product")
    private int idTypeProduct;
    
    @Column(nullable=false)
    private String name;
    
    @OneToMany(mappedBy = "typeProduct")
    private List<ProductEntity>products;

    public TypeProductEntity() {
    
    }

    public TypeProductEntity(String name) {
        this.name = name;
    }

    public int getIdTypeProduct() {
        return idTypeProduct;
    }

    public void setIdTypeProduct(int idTypeProduct) {
        this.idTypeProduct = idTypeProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
