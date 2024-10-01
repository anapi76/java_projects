package product;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.anapiqueras.api.entity.ProductEntity;
import com.anapiqueras.api.entity.TypeProductEntity;

public class ProductTest {
    TypeProductEntity typeProduct= new TypeProductEntity("FOOD");
    ProductEntity product = new ProductEntity("Macarrones", "Pasta con huevo", 1.39, 100,typeProduct);

    @Test
    public void checkNewProduct() {
        // Arrange
        int idExpected = 1;
        // Act
        product.setIdProduct(idExpected);
        int idActual = product.getIdProduct();
        // Assert
        assertEquals(idExpected, idActual);
    }

    @Test
    public void checkGetIdProduct() {
        // Arrange
        int idExpected = 1;
        // Act
        product.setIdProduct(idExpected);
        int idActual = product.getIdProduct();
        // Assert
        assertEquals(idExpected, idActual);
    }

  @Test
    public void checkSetIdProduct() {
        // Arrange
        int idExpected = 2;
        // Act
        product.setIdProduct(2);
        // Assert
        assertEquals(idExpected, product.getIdProduct());
    } 

    @Test
    public void checkGetName() {
        // Arrange
        String nameExpected = "Macarrones";
        // Act
        String nameActual = product.getName();
        // Assert
        assertEquals(nameExpected, nameActual);
    }

    @Test
    public void checkSetName() {
        // Arrange
        String nameExpected = "Spaguettis";
        // Act
        product.setName("Spaguettis");
        // Assert
        assertEquals(nameExpected, product.getName());
    }

    @Test
    public void checkGetDescription() {
        // Arrange
        String descriptionExpected = "Pasta con huevo";
        // Act
        String descriptionActual = product.getDescription();
        // Assert
        assertEquals(descriptionExpected, descriptionActual);
    }

    @Test
    public void checkSetDescription() {
        // Arrange
        String descriptionExpected = "Pasta fresca";
        // Act
        product.setDescription("Pasta fresca");
        // Assert
        assertEquals(descriptionExpected, product.getDescription());
    }

    @Test
    public void checkGetPrice() {
        // Arrange
        Double priceExpected = 1.39;
        // Act
        Double priceActual = product.getPrice();
        // Assert
        assertEquals(priceExpected, priceActual);
    }

    @Test
    public void checkSetPrice() {
        // Arrange
        Double priceExpected = 1.59;    
        // Act
        product.setPrice(1.59);
        // Assert
        assertEquals(priceExpected, product.getPrice());
    }

    @Test
    public void checkGetStock() {
        // Arrange
        Integer stockExpected = 100;
        // Act
        Integer stockActual = product.getStock();
        // Assert
        assertEquals(stockExpected, stockActual);
    }

    @Test
    public void checkSetStock() {
        // Arrange
        Integer stockExpected = 150;    
        // Act
        product.setStock(150);
        // Assert
        assertEquals(stockExpected, product.getStock());
    }

    @Test
    public void checkGetType() {
        // Arrange

        // Act
        TypeProductEntity typeActual = product.getTypeProduct();
        // Assert
        assertEquals(typeProduct, typeActual);
    }

    @Test
    public void checkSetType() {
        // Arrange

        // Act
        product.setTypeProduct(typeProduct);
        // Assert
        assertEquals(typeProduct, product.getTypeProduct());
    }
}
