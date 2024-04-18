package typeProduct;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.anapiqueras.api.dto.TypeProductDTO;
import com.anapiqueras.api.exceptions.TypeProductNotFoundException;
import com.anapiqueras.api.mapper.DTOMapperProduct;
import com.anapiqueras.api.mapper.TypeProductMapperDTO;
import com.anapiqueras.api.persistence.DAO.iTypeProductDAO;
import com.anapiqueras.api.persistence.impl.TypeProductRepositoryImpl;
import com.anapiqueras.api.persistence.model.TypeProductEntity;

public class TypeProductRepositoryTest {

    @Mock
    private iTypeProductDAO typeProductDao;

    @Mock
    private DTOMapperProduct dtoMapperProduct;

    @Mock
    private TypeProductMapperDTO typeProductMapperDTO;

    @InjectMocks
    private TypeProductRepositoryImpl typeProductRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void checkFindAll() {
        // Arrange
        TypeProductEntity typeProduct1= new TypeProductEntity("FOOD");
        TypeProductEntity typeProduct2= new TypeProductEntity("ELECTRONIC");
        List<TypeProductEntity> typeProductListExpected = List.of(typeProduct1, typeProduct2);
        // Act
        when(typeProductDao.findAll()).thenReturn(typeProductListExpected);
        List<TypeProductDTO> typeProductListActual = typeProductRepository.findAll();
        // Assert
        assertEquals(2, typeProductListActual.size());
    }

    @Test
    public void checkThereAreAnyTypeProducts() {
        // Arrange
        List<TypeProductEntity> typeProductListExpected = List.of();
        // Act
        when(typeProductDao.findAll()).thenReturn(typeProductListExpected);
        List<TypeProductDTO> typeProductListActual = typeProductRepository.findAll();
        // Assert
        assertTrue(typeProductListActual.isEmpty());
    }

    @Test
    public void checkFindTypeProductById() throws TypeProductNotFoundException {
        // Arrange
        int idProduct = 1;
        TypeProductEntity typeProduct= new TypeProductEntity("FOOD");
        TypeProductDTO typeProductDto= new TypeProductDTO(1,"FOOD");
        // Act
        when(typeProductDao.findById(anyInt())).thenReturn(Optional.of(typeProduct));
        when(typeProductMapperDTO.mapToTypeProductDto(any(TypeProductEntity.class))).thenReturn(typeProductDto);
        TypeProductDTO typeProductActual = typeProductRepository.findTypeProductById(1);
        // Assert
        assertEquals(idProduct, typeProductActual.getIdTypeProduct());
        assertEquals(typeProduct.getName(), typeProductActual.getName());
    }

 @Test
    public void checkNotFoundTypeProductById() throws TypeProductNotFoundException {
        // Arrange
        int idTypeProduct = 1;
        // Act
        when(typeProductDao.findById(idTypeProduct)).thenThrow(IllegalArgumentException.class);
        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            typeProductRepository.findTypeProductById(idTypeProduct);
        });
    }
}
