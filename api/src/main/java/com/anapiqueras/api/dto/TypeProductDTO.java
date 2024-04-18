package com.anapiqueras.api.dto;

//import java.util.List;

public class TypeProductDTO {

    private int idTypeProduct;
    private String name;
    //private List<ProductDTO> productsDTO;

    public TypeProductDTO() {
    }

    public TypeProductDTO(int idTypeProduct) {
        this.idTypeProduct = idTypeProduct;
    }

    public TypeProductDTO(int idTypeProduct, String name) {
        this.idTypeProduct = idTypeProduct;
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