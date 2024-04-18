package mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.anapiqueras.api.dto.ProductDTO;
import com.anapiqueras.api.mapper.ProductMapperDTO;
import com.anapiqueras.api.persistence.model.ProductEntity;
import com.anapiqueras.api.persistence.model.TypeProductEntity;

public class ProductMapperDTOTest {

    TypeProductEntity typeProduct= new TypeProductEntity("FOOD");
    private ProductMapperDTO productMapperDTO = new ProductMapperDTO();

    @Test
    public void checkMapToProductDTO() {
        // Arrange
        ProductEntity product = new ProductEntity("Macarrones", "Pasta con huevo", 1.39, 100, typeProduct);
        int idExpected = product.getIdProduct();
        String nameExpected = product.getName();
        String descriptionExpected = product.getDescription();
        Double priceExpected = product.getPrice();
        Integer stockExpected = product.getStock();
        // Act
        ProductDTO productDto = productMapperDTO.mapToProductDto(product);
        int idActual = productDto.getIdProduct();
        String nameActual = productDto.getName();
        String descriptionActual = productDto.getDescription();
        Double priceActual = productDto.getPrice();
        Integer stockActual = productDto.getStock();
        // Assert
        assertEquals(idExpected, idActual);
        assertEquals(nameExpected, nameActual);
        assertEquals(descriptionExpected, descriptionActual);
        assertEquals(priceExpected, priceActual);
        assertEquals(stockExpected, stockActual);
        assertEquals(typeProduct.getName(), productDto.getTypeProductDto().getName());
    }
}
