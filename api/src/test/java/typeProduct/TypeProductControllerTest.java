package typeProduct;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import com.anapiqueras.api.controller.TypeProductController;
import com.anapiqueras.api.service.iTypeProductService;
import com.anapiqueras.api.dto.TypeProductDTO;
//import com.anapiqueras.api.exceptions.TypeProductCantBeNullException;
import com.anapiqueras.api.exceptions.TypeProductNotFoundException;

public class TypeProductControllerTest {
    @Mock
    private iTypeProductService typeProductService;

    @InjectMocks
    private TypeProductController typeProductController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    TypeProductDTO typeProduct= new TypeProductDTO(1,"FOOD");
  

    @Test
    public void checkIfThereAreTypeProducts() {
        // Arrange
        TypeProductDTO typeProduct1 = new TypeProductDTO(1,"FOOD");
        TypeProductDTO typeProduct2 = new TypeProductDTO(2, "ELECTRONIC");
        List<TypeProductDTO> typeProductList = List.of(typeProduct1, typeProduct2);
        // Act
        when(typeProductService.findAll()).thenReturn(typeProductList);
        HttpStatusCode code = typeProductController.findAll().getStatusCode();
        // Assert
        assertEquals(HttpStatus.OK, code);
    }

    @Test
    public void checkIfThereAreAnyTypeProducts() {
        // Arrange
        List<TypeProductDTO> typeProductList = List.of();
        // Act
        when(typeProductService.findAll()).thenReturn(typeProductList);
        ResponseEntity<List<TypeProductDTO>> response = typeProductController.findAll();
        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().isEmpty());
    }

    @Test
    public void checkIfTypeProductExist() throws TypeProductNotFoundException {
        // Arrange
        int idTypeProduct = 1;
        TypeProductDTO typeProduct = new TypeProductDTO(1, "FOOD");
        // Act
        when(typeProductService.findTypeProductById(idTypeProduct)).thenReturn(typeProduct);
        HttpStatusCode code = typeProductController.findTypeProductById(idTypeProduct).getStatusCode();
        // Assert
        assertEquals(HttpStatus.OK, code);
    }

    @Test
    public void checkIfTypeProductNotExist() throws TypeProductNotFoundException {
        // Arrange
        int idTypeProduct = 999;
        // Act
        when(typeProductService.findTypeProductById(idTypeProduct)).thenThrow(TypeProductNotFoundException.class);
        HttpStatusCode result = typeProductController.findTypeProductById(idTypeProduct).getStatusCode();
        // Assert
        assertEquals(HttpStatus.NOT_FOUND, result);
    }

   /*  @Test
    public void checkCreateTypeProduct() throws TypeProductCantBeNullException {
        // Arrange
        TypeProductDTO typeProduct = new TypeProductDTO(1,"FOOD");
        // Act
        when(typeProductService.createTypeProduct(typeProduct)).thenReturn(typeProduct);
        HttpStatusCode result = typeProductController.createTypeProduct(typeProduct).getStatusCode();
        // Assert
        assertEquals(HttpStatus.CREATED, result);
    }

    @Test
    public void checkNotCreateTypeProductIfIsNotValid() throws TypeProductCantBeNullException {
        // Arrange
        int idTypeProduct = 1;
        TypeProductDTO typeProduct = new TypeProductDTO(idTypeProduct, null);
        // Act
        when(typeProductService.createTypeProduct(typeProduct)).thenThrow(TypeProductCantBeNullException.class);
        HttpStatusCode result = typeProductController.createTypeProduct(typeProduct).getStatusCode();
        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, result);
    }

    @Test
    public void checkTypeProductIsNull() {
        // Arrange

        // Act
        HttpStatusCode result = typeProductController.createTypeProduct(null).getStatusCode();
        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, result);
    }

    @Test
    public void checkUpdateTypeProduct() throws TypeProductNotFoundException {
        // Arrange
        int idTypeProduct = 1;
        TypeProductDTO typeProductModified = new TypeProductDTO(idTypeProduct,"ELECTRONIC");
        // Act
        when(typeProductService.updateTypeProduct(idTypeProduct, typeProductModified)).thenReturn(typeProductModified);
        HttpStatusCode result = typeProductController.updateTypeProduct(idTypeProduct, typeProductModified).getStatusCode();
        // Assert
        assertEquals(HttpStatus.CREATED, result);
    }

    @Test
    public void checkNotUpdateProduct() throws TypeProductNotFoundException {
        // Arrange
        int idTypeProduct = 999;
        TypeProductDTO typeProductModified = new TypeProductDTO(1,"ELECTRONIC");
        // Act
        when(typeProductService.updateTypeProduct(idTypeProduct, typeProductModified)).thenThrow(TypeProductNotFoundException.class);
        HttpStatusCode result = typeProductController.updateTypeProduct(idTypeProduct, typeProductModified).getStatusCode();
        // Assert
        assertEquals(HttpStatus.NOT_FOUND, result);
    }

    @Test
    public void checkDeleteProduct() throws TypeProductNotFoundException {
        // Arrange
        int idTypeProduct = 2;
        // Act
        doNothing().when(typeProductService).deleteTypeProductById(idTypeProduct);
        HttpStatusCode result = typeProductController.deleteTypeProductById(idTypeProduct).getStatusCode();
        // Assert
        assertEquals(HttpStatus.OK, result);
    }

    @Test
    public void checkNotDeleteTypeProduct() throws TypeProductNotFoundException {
        // Arrange
        int idTypeProduct = 999;
        // Act
        doThrow(TypeProductNotFoundException.class).when(typeProductService).deleteTypeProductById(idTypeProduct);
        HttpStatusCode result = typeProductController.deleteTypeProductById(idTypeProduct).getStatusCode();
        // Assert
        assertEquals(HttpStatus.NOT_FOUND, result);
    } */

}
