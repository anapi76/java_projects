package product;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import com.anapiqueras.api.controller.ProductController;
import com.anapiqueras.api.controller.dto.ProductDTOController;
import com.anapiqueras.api.domain.service.iProductService;
import com.anapiqueras.api.dto.ProductDTO;
import com.anapiqueras.api.dto.TypeProductDTO;
import com.anapiqueras.api.exceptions.ProductCantBeNullException;
import com.anapiqueras.api.exceptions.ProductNotFoundException;
import com.anapiqueras.api.exceptions.TypeProductNotFoundException;
import com.anapiqueras.api.mapper.ControllerMapperDTO;

public class ProductControllerTest {
    @Mock
    private iProductService productService;
    @Mock
    private ControllerMapperDTO controllerMapperDto;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    TypeProductDTO typeProduct= new TypeProductDTO(1,"FOOD");
  

    @Test
    public void checkIfThereAreProducts() {
        // Arrange
        ProductDTO product1 = new ProductDTO(1, "Macarrones", "Pasta con huevo", 1.39, 100, typeProduct);
        ProductDTO product2 = new ProductDTO(2, "Tallarines", "Pasta con huevo", 1.39, 100, typeProduct);
        List<ProductDTO> productList = List.of(product1, product2);
        // Act
        when(productService.findAll()).thenReturn(productList);
        HttpStatusCode code = productController.findAll().getStatusCode();
        // Assert
        assertEquals(HttpStatus.OK, code);
    }

    @Test
    public void checkIfThereAreAnyProducts() {
        // Arrange
        List<ProductDTO> productList = List.of();
        // Act
        when(productService.findAll()).thenReturn(productList);
        ResponseEntity<List<ProductDTO>> response = productController.findAll();
        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().isEmpty());
    }

    @Test
    public void checkIfProductExist() throws ProductNotFoundException {
        // Arrange
        int idProduct = 1;
        ProductDTO product1 = new ProductDTO(1, "Macarrones", "Pasta con huevo", 1.39, 100, typeProduct);
        // Act
        when(productService.findProductById(idProduct)).thenReturn(product1);
        HttpStatusCode code = productController.findProductById(idProduct).getStatusCode();
        // Assert
        assertEquals(HttpStatus.OK, code);
    }

    @Test
    public void checkIfProductNotExist() throws ProductNotFoundException {
        // Arrange
        int idProduct = 999;
        // Act
        when(productService.findProductById(idProduct)).thenThrow(ProductNotFoundException.class);
        HttpStatusCode result = productController.findProductById(idProduct).getStatusCode();
        // Assert
        assertEquals(HttpStatus.NOT_FOUND, result);
    }

    @Test
    public void checkCreateProduct() throws ProductCantBeNullException, TypeProductNotFoundException {
        // Arrange
        ProductDTO product1 = new ProductDTO(1, "Macarrones", "Pasta con huevo", 1.39, 100, typeProduct);
        ProductDTOController product3=new ProductDTOController(1, "Macarrones", "Pasta con huevo", 1.39, 100, 1);
        // Act
        when(controllerMapperDto.mapToProductDto(product3)).thenReturn(product1);
        when(productService.createProduct(product1)).thenReturn(product1);
        HttpStatusCode result = productController.createProduct(product3).getStatusCode();
        // Assert
        assertEquals(HttpStatus.CREATED, result);
    }

    @Test
    public void checkNotCreateProductIfIsNotValid() throws ProductCantBeNullException, TypeProductNotFoundException {
        // Arrange
        int idProduct = 1;
        ProductDTO product = new ProductDTO(idProduct, null, "Smartphone Samsung", 300.00, null, null);
        ProductDTOController productDtoController = new ProductDTOController(idProduct, null, "Smartphone Samsung", 300.00, null, null);
        // Act
        when(controllerMapperDto.mapToProductDto(productDtoController)).thenReturn(product);
        when(productService.createProduct(product)).thenThrow(ProductCantBeNullException.class);
        HttpStatusCode result = productController.createProduct(productDtoController).getStatusCode();
        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, result);
    }

    @Test
    public void checkProductIsNull() {
        // Arrange

        // Act
        HttpStatusCode result = productController.createProduct(null).getStatusCode();
        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, result);
    }

    @Test
    public void checkUpdateProduct() throws ProductNotFoundException, TypeProductNotFoundException {
        // Arrange
        int idProduct = 1;
        ProductDTOController productDtoController = new ProductDTOController(idProduct, null, "Espirales", null, null, null);
        ProductDTO product = new ProductDTO(idProduct, null, "Espirales", null, null, null);
        ProductDTO productModified= new ProductDTO(1, "Espirales", "Pasta con huevo", 1.39, 100, typeProduct);
        // Act
        when(controllerMapperDto.mapToProductDto(productDtoController)).thenReturn(product);
        when(productService.updateProduct(idProduct, product)).thenReturn(productModified);
        HttpStatusCode result = productController.updateProduct(idProduct, productDtoController).getStatusCode();
        // Assert
        assertEquals(HttpStatus.CREATED, result);
    }

    @Test
    public void checkNotUpdateProduct() throws ProductNotFoundException, TypeProductNotFoundException {
        // Arrange
        int idProduct = 999;
        ProductDTOController productDtoController = new ProductDTOController(idProduct, null, "Espirales", null, null, null);
        ProductDTO product = new ProductDTO(idProduct, null, "Smartphone Xiomi", null, 0, null);
        // Act
        when(controllerMapperDto.mapToProductDto(productDtoController)).thenReturn(product);
        when(productService.updateProduct(idProduct, product)).thenThrow(ProductNotFoundException.class);
        HttpStatusCode result = productController.updateProduct(idProduct, productDtoController).getStatusCode();
        // Assert
        assertEquals(HttpStatus.NOT_FOUND, result);
    }

    @Test
    public void checkDeleteProduct() throws ProductNotFoundException {
        // Arrange
        int idProduct = 2;
        // Act
        doNothing().when(productService).deleteProductById(idProduct);
        HttpStatusCode result = productController.deleteProductById(idProduct).getStatusCode();
        // Assert
        assertEquals(HttpStatus.OK, result);
    }

    @Test
    public void checkNotDeleteProduct() throws ProductNotFoundException {
        // Arrange
        int idProduct = 999;
        // Act
        doThrow(ProductNotFoundException.class).when(productService).deleteProductById(idProduct);
        HttpStatusCode result = productController.deleteProductById(idProduct).getStatusCode();
        // Assert
        assertEquals(HttpStatus.NOT_FOUND, result);
    }

}
