package mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.anapiqueras.api.dto.ProductDTO;
import com.anapiqueras.api.dto.TypeProductDTO;
import com.anapiqueras.api.mapper.DTOMapperProduct;
import com.anapiqueras.api.persistence.model.ProductEntity;

public class DTOMapperProductTest {

    private DTOMapperProduct dtoMapperProduct = new DTOMapperProduct();

    @Test
    public void checkMapToProduct() {
        // Arrange
        TypeProductDTO typeProduct= new TypeProductDTO(1,"FOOD");
        ProductDTO productDto = new ProductDTO(1, "Macarrones", "Pasta con huevo", 1.39, 100, typeProduct);
        int idExpected = productDto.getIdProduct();
        String nameExpected = productDto.getName();
        String descriptionExpected = productDto.getDescription();
        Double priceExpected = productDto.getPrice();
        Integer stockExpected = productDto.getStock();
        String typeExpected = typeProduct.getName();
        // Act
        ProductEntity product = dtoMapperProduct.mapToProduct(productDto);
        int idActual = product.getIdProduct();
        String nameActual = product.getName();
        String descriptionActual = product.getDescription();
        Double priceActual = product.getPrice();
        Integer stockActual = product.getStock();
        String typeActual = product.getTypeProduct().getName();
        // Assert
        assertEquals(idExpected, idActual);
        assertEquals(nameExpected, nameActual);
        assertEquals(descriptionExpected, descriptionActual);
        assertEquals(priceExpected, priceActual);
        assertEquals(stockExpected, stockActual);
        assertEquals(typeExpected, typeActual);
    }
}
