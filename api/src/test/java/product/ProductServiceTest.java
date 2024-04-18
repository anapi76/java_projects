package product;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.anapiqueras.api.domain.repository.iProductRepository;
import com.anapiqueras.api.domain.repository.iTypeProductRepository;
import com.anapiqueras.api.domain.service.ProductServiceImpl;
import com.anapiqueras.api.dto.*;
import com.anapiqueras.api.exceptions.ProductCantBeNullException;
import com.anapiqueras.api.exceptions.ProductNotFoundException;
import com.anapiqueras.api.exceptions.TypeProductNotFoundException;

public class ProductServiceTest {

    @Mock
    private iProductRepository productRepository;

    @Mock
    private iTypeProductRepository typeProductRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void checkFindAll() {
        // Arrangeç
        TypeProductDTO typeProduct= new TypeProductDTO(1,"FOOD");
        ProductDTO product1 = new ProductDTO(1, "Macarrones", "Pasta con huevo", 1.39, 100,typeProduct);
        ProductDTO product2 = new ProductDTO(2, "Tallarines", "Pasta con huevo", 1.39, 100,typeProduct);
        List<ProductDTO> productListExpected = List.of(product1, product2);
        // Act
        when(productRepository.findAll()).thenReturn(productListExpected);
        List<ProductDTO> productListActual = productService.findAll();
        // Assert
        assertEquals(productListExpected, productListActual);
    }

    @Test
    public void checkThereAreAnyProducts() {
        // Arrange
        List<ProductDTO> productListExpected = List.of();
        // Act
        when(productRepository.findAll()).thenReturn(productListExpected);
        List<ProductDTO> productListActual = productService.findAll();
        // Assert
        assertTrue(productListActual.isEmpty());
    }

    @Test
    public void checkFindProductById() throws ProductNotFoundException {
        int idProduct = 1;
        TypeProductDTO typeProduct= new TypeProductDTO(1,"FOOD");
        ProductDTO productExpected = new ProductDTO(idProduct, "Macarrones", "Pasta con huevo", 1.39, 100, typeProduct);
        // Act
        when(productRepository.findProductById(idProduct)).thenReturn(productExpected);
        ProductDTO productActual = productService.findProductById(1);
        // Assert
        assertEquals(idProduct, productActual.getIdProduct());
        assertEquals(productExpected.getName(), productActual.getName());
        assertEquals(productExpected.getDescription(), productActual.getDescription());
        assertEquals(productExpected.getPrice(), productActual.getPrice());
        assertEquals(productExpected.getTypeProductDto(), productActual.getTypeProductDto());
    }

    @Test
    public void checkNotFoundProductById() throws ProductNotFoundException {
        // Arrange
        int idProduct = 999;
        // Act
        when(productRepository.findProductById(idProduct)).thenReturn(null);
        ProductDTO productActual = productService.findProductById(idProduct);
        // Assert
        assertNull(productActual);
    }

    @Test
    public void checkCreateProductWithValidDto() throws ProductCantBeNullException, TypeProductNotFoundException {
        // Arrange
        int idProduct = 1;
        TypeProductDTO typeProduct= new TypeProductDTO(1,"FOOD");
        ProductDTO productExpected = new ProductDTO(idProduct, "Spaguettis", "Pasta fresca", 1.39, 100, typeProduct);
        // Act
        when(productRepository.createProduct(productExpected)).thenReturn(productExpected);
        ProductDTO productCreated = productService.createProduct(productExpected);
        // Assert
        assertEquals(productExpected, productCreated);
    }

    @Test
    public void checkCreateProductWithNullDto() throws ProductCantBeNullException {
        // Arrange
        ProductDTO productExpected = null;
        // Act

        // Assert
        assertThrows(ProductCantBeNullException.class, () -> {
            productService.createProduct(productExpected);
        });
    }

    @Test
    public void checkCreateProductWithInvalidDto() throws ProductCantBeNullException, TypeProductNotFoundException {
        // Arrange
        int idProduct = 1;
        TypeProductDTO typeProduct= new TypeProductDTO(1,"FOOD");
        ProductDTO productExpected = new ProductDTO(idProduct, null, "Pasta fresca", 1.39, 100, typeProduct);
        // Act
        when(productRepository.createProduct(productExpected)).thenReturn(null);
        ProductDTO productCreated = productService.createProduct(productExpected);
        // Assert
        assertNull(productCreated);
    }

    @Test
    public void checkUpdateProductWithValidId() throws ProductNotFoundException, TypeProductNotFoundException {
        // Arrange
        int idProduct = 1;
        TypeProductDTO typeProduct= new TypeProductDTO(1,"FOOD");
        ProductDTO productExpected = new ProductDTO(idProduct, "Spaguettis", "Pasta fresca", 1.39, 100, typeProduct);
        // Act
        when(productRepository.findProductById(idProduct)).thenReturn(productExpected);
        when(productRepository.updateProduct(any(ProductDTO.class))).thenReturn(productExpected);
        ProductDTO productUpdated = productService.updateProduct(idProduct, productExpected);
        // Assert
        //verify(productRepository, times(1)).updateProduct(any(ProductDTO.class));

        assertEquals(productExpected.getIdProduct(), productUpdated.getIdProduct());
        assertEquals(productExpected.getName(), productUpdated.getName());
        assertEquals(productExpected.getDescription(), productUpdated.getDescription());
        assertEquals(productExpected.getPrice(), productUpdated.getPrice());
        assertEquals(productExpected.getStock(), productUpdated.getStock());
        assertEquals(productExpected.getTypeProductDto(), productUpdated.getTypeProductDto());
    }

    @Test
    public void checkNotUpdateProductNotFoundProduct() throws ProductNotFoundException {
        // Arrange
        int idProduct = 999;
        TypeProductDTO typeProduct= new TypeProductDTO(1,"FOOD");
        ProductDTO productExpected = new ProductDTO(idProduct, "Spaguettis", "Pasta fresca", 1.39, 100, typeProduct);
        // Act
        when(productRepository.findProductById(idProduct))
                .thenThrow(new ProductNotFoundException("Product not found for id: " + idProduct));
        // Assert
        assertThrows(ProductNotFoundException.class, () -> {
            productService.updateProduct(idProduct, productExpected);
        });
        verify(productRepository, never()).updateProduct(any(ProductDTO.class));
    }

    @Test
    public void checkDeleteProductById() throws ProductNotFoundException {
        // Arrange
        int idProduct = 1;
        TypeProductDTO typeProduct= new TypeProductDTO(1,"FOOD");
        ProductDTO productExpected = new ProductDTO(idProduct, "Spaguettis", "Pasta fresca", 1.39, 100, typeProduct);
        // Act
        when(productRepository.findProductById(idProduct)).thenReturn(productExpected);
        doNothing().when(productRepository).deleteProductById(idProduct);
        productService.deleteProductById(idProduct);
        // Assert
        verify(productRepository).deleteProductById(idProduct);
    }

    @Test
    public void checkNotDeleteProductById() throws ProductNotFoundException {
        // Arrange
        int idProduct = 999;
        // Act
        when(productRepository.findProductById(idProduct))
        .thenThrow(new ProductNotFoundException("Product not found for id: " + idProduct));
        // Assert
        assertThrows(ProductNotFoundException.class, () -> {
            productService.deleteProductById(idProduct);
        });
        verify(productRepository, never()).deleteProductById(idProduct);
    }

    @Test
    public void checkValidateProduct() {
         // Arrange
         int idProduct = 1;
         TypeProductDTO typeProduct= new TypeProductDTO(1,"FOOD");
         ProductDTO productExpected = new ProductDTO(idProduct, "Spaguettis", "Pasta fresca", 1.39, 100,typeProduct);
         // Act
         Boolean result = productService.validateProduct(productExpected);
         // Assert
         assertTrue(result);
    }

}
