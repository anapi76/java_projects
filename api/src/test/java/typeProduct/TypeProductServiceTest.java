package typeProduct;

import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.never;
//import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.anapiqueras.api.repository.iTypeProductRepository;
import com.anapiqueras.api.service.TypeProductServiceImpl;
import com.anapiqueras.api.dto.*;
//import com.anapiqueras.api.exceptions.TypeProductCantBeNullException;
import com.anapiqueras.api.exceptions.TypeProductNotFoundException;

public class TypeProductServiceTest {

    @Mock
    private iTypeProductRepository typeProductRepository;

    @InjectMocks
    private TypeProductServiceImpl typeProductService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void checkFindAll() {
        // Arrangeç
        TypeProductDTO typeProduct1= new TypeProductDTO(1,"FOOD");
        TypeProductDTO typeProduct2= new TypeProductDTO(1,"ELECTRONIC");
        List<TypeProductDTO> typeProductListExpected = List.of(typeProduct1, typeProduct2);
        // Act
        when(typeProductRepository.findAll()).thenReturn(typeProductListExpected);
        List<TypeProductDTO> typeProductListActual = typeProductService.findAll();
        // Assert
        assertEquals(typeProductListExpected, typeProductListActual);
    }

   @Test
    public void checkThereAreAnyTypeProducts() {
        // Arrange
        List<TypeProductDTO> typeProductListExpected = List.of();
        // Act
        when(typeProductRepository.findAll()).thenReturn(typeProductListExpected);
        List<TypeProductDTO> typeProductListActual = typeProductService.findAll();
        // Assert
        assertTrue(typeProductListActual.isEmpty());
    }
  
    @Test
    public void checkFindTypeProductById() throws TypeProductNotFoundException {
        int idTypeProduct = 1;
        TypeProductDTO typeProduct= new TypeProductDTO(1,"FOOD");
        // Act
        when(typeProductRepository.findTypeProductById(idTypeProduct)).thenReturn(typeProduct);
        TypeProductDTO typeProductActual = typeProductService.findTypeProductById(idTypeProduct);
        // Assert
        assertEquals(idTypeProduct, typeProductActual.getIdTypeProduct());
        assertEquals(typeProduct.getName(), typeProductActual.getName());
    }

    @Test
    public void checkNotFoundTypeProductById() throws TypeProductNotFoundException {
        // Arrange
        int idTypeProduct = 999;
        // Act
        when(typeProductRepository.findTypeProductById(idTypeProduct)).thenReturn(null);
        TypeProductDTO typeProductActual = typeProductService.findTypeProductById(idTypeProduct);
        // Assert
        assertNull(typeProductActual);
    }

 /*    @Test
    public void checkCreateProductWithValidDto() throws TypeProductCantBeNullException {
        // Arrange
        TypeProductDTO typeProduct= new TypeProductDTO(1,"FOOD");
        // Act
        when(typeProductRepository.createTypeProduct(typeProduct)).thenReturn(typeProduct);
        TypeProductDTO typeProductCreated = typeProductService.createTypeProduct(typeProduct);
        // Assert
        assertEquals(typeProduct, typeProductCreated);
    }

    @Test
    public void checkCreateTypeProductWithNullDto() throws TypeProductCantBeNullException {
        // Arrange
        TypeProductDTO typeProductExpected = null;
        // Act

        // Assert
        assertThrows(TypeProductCantBeNullException.class, () -> {
            typeProductService.createTypeProduct(typeProductExpected);
        });
    }

  @Test
    public void checkCreateTypeProductWithInvalidDto() throws TypeProductCantBeNullException {
        // Arrange
        TypeProductDTO typeProduct= new TypeProductDTO(1,"FOOD");
        // Act
        when(typeProductRepository.createTypeProduct(typeProduct)).thenReturn(null);
        TypeProductDTO typeProductCreated = typeProductService.createTypeProduct(typeProduct);
        // Assert
        assertNull(typeProductCreated);
    }

  @Test
    public void checkUpdateTypeProductWithValidId() throws TypeProductNotFoundException {
        // Arrange
        int idTypeProduct = 1;
        TypeProductDTO typeProduct= new TypeProductDTO(1,"FOOD");
        // Act
        when(typeProductRepository.findTypeProductById(idTypeProduct)).thenReturn(typeProduct);
        when(typeProductRepository.updateTypeProduct(any(TypeProductDTO.class))).thenReturn(typeProduct);
        TypeProductDTO typeProductUpdated = typeProductService.updateTypeProduct(idTypeProduct,typeProduct);
        // Assert
        //verify(productRepository, times(1)).updateProduct(any(ProductDTO.class));

        assertEquals(typeProduct.getIdTypeProduct(), typeProductUpdated.getIdTypeProduct());
        assertEquals(typeProduct.getName(), typeProductUpdated.getName());
    }

      @Test
    public void checkNotUpdateTypeProductNotFoundProduct() throws TypeProductNotFoundException {
        // Arrange
        int idTypeProduct = 999;
        TypeProductDTO typeProduct= new TypeProductDTO(1,"FOOD");
        // Act
        when(typeProductRepository.findTypeProductById(idTypeProduct))
                .thenThrow(new TypeProductNotFoundException("TypeProduct not found for id: " + idTypeProduct));
        // Assert
        assertThrows(TypeProductNotFoundException.class, () -> {
            typeProductService.updateTypeProduct(idTypeProduct,typeProduct);
        });
        verify(typeProductRepository, never()).updateTypeProduct(any(TypeProductDTO.class));
    }

   @Test
    public void checkDeleteTypeProductById() throws TypeProductNotFoundException {
        // Arrange
        int idTypeProduct = 1;
        TypeProductDTO typeProduct= new TypeProductDTO(1,"FOOD");
        // Act
        when(typeProductRepository.findTypeProductById(idTypeProduct)).thenReturn(typeProduct);
        doNothing().when(typeProductRepository).deleteTypeProductById(idTypeProduct);
        typeProductService.deleteTypeProductById(idTypeProduct);
        // Assert
        verify(typeProductRepository).deleteTypeProductById(idTypeProduct);
    }

   @Test
    public void checkNotDeleteTypeProductById() throws TypeProductNotFoundException {
        // Arrange
        int idTypeProduct = 999;
        // Act
        when(typeProductRepository.findTypeProductById(idTypeProduct))
        .thenThrow(new TypeProductNotFoundException("TypeProduct not found for id: " + idTypeProduct));
        // Assert
        assertThrows(TypeProductNotFoundException.class, () -> {
            typeProductService.deleteTypeProductById(idTypeProduct);
        });
        verify(typeProductRepository, never()).deleteTypeProductById(idTypeProduct);
    }

     @Test
    public void checkValidateTypeProduct() {
         // Arrange
         TypeProductDTO typeProduct= new TypeProductDTO(1,"FOOD");
         // Act
         Boolean result = typeProductService.validateTypeProduct(typeProduct);
         // Assert
         assertTrue(result);
    } */
 
}
