package product;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.anapiqueras.api.dto.ProductDTO;
import com.anapiqueras.api.dto.TypeProductDTO;
import com.anapiqueras.api.exceptions.ProductNotFoundException;
import com.anapiqueras.api.mapper.DTOMapperProduct;
import com.anapiqueras.api.mapper.ProductMapperDTO;
import com.anapiqueras.api.persistence.DAO.iProductDAO;
import com.anapiqueras.api.persistence.impl.ProductRepositoryImpl;
import com.anapiqueras.api.persistence.model.ProductEntity;
import com.anapiqueras.api.persistence.model.TypeProductEntity;

public class ProductRepositoryTest {

    @Mock
    private iProductDAO productDao;

    @Mock
    private DTOMapperProduct dtoMapperProduct;

    @Mock
    private ProductMapperDTO productMapperDTO;

    @InjectMocks
    private ProductRepositoryImpl productRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void checkFindAll() {
        // Arrange
        TypeProductEntity typeProduct= new TypeProductEntity("FOOD");
        ProductEntity product1 = new ProductEntity("Macarrones", "Pasta con huevo", 1.39, 100, typeProduct);
        product1.setIdProduct(1);
        ProductEntity product2 = new ProductEntity("Tallarines", "Pasta con huevo", 1.39, 100, typeProduct);
        product2.setIdProduct(2);
        List<ProductEntity> productListExpected = List.of(product1, product2);
        // Act
        when(productDao.findAll()).thenReturn(productListExpected);
        List<ProductDTO> productListActual = productRepository.findAll();
        // Assert
        assertEquals(2, productListActual.size());
    }

    @Test
    public void checkThereAreAnyProducts() {
        // Arrange
        List<ProductEntity> productListExpected = List.of();
        // Act
        when(productDao.findAll()).thenReturn(productListExpected);
        List<ProductDTO> productListActual = productRepository.findAll();
        // Assert
        assertTrue(productListActual.isEmpty());
    }

    @Test
    public void checkFindProductById() throws ProductNotFoundException {
        // Arrange
        int idProduct = 1;
        TypeProductEntity typeProduct= new TypeProductEntity("FOOD");
        TypeProductDTO typeProductDto= new TypeProductDTO(1,"FOOD");
        ProductEntity productExpected = new ProductEntity("Macarrones", "Pasta con huevo", 1.39, 100, typeProduct);
        productExpected.setIdProduct(1);
        ProductDTO productDTO=new ProductDTO(idProduct,"Macarrones", "Pasta con huevo", 1.39, 100, typeProductDto);
        // Act
        when(productDao.findById(anyInt())).thenReturn(Optional.of(productExpected));
        when(productMapperDTO.mapToProductDto(any(ProductEntity.class))).thenReturn(productDTO);
        ProductDTO productActual = productRepository.findProductById(1);
        // Assert
        assertEquals(idProduct, productActual.getIdProduct());
        assertEquals(productExpected.getName(), productActual.getName());
        assertEquals(productExpected.getDescription(), productActual.getDescription());
        assertEquals(productExpected.getPrice(), productActual.getPrice());
        assertEquals(productExpected.getTypeProduct().getName(), productActual.getTypeProductDto().getName());
    }

    @Test
    public void checkNotFoundProductById() throws ProductNotFoundException {
        // Arrange
        int idProduct = 1;
        // Act
        when(productDao.findById(idProduct)).thenThrow(IllegalArgumentException.class);
        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            productRepository.findProductById(idProduct);
        });
    }

    @Test
    public void testCreateProduct() {
        // Arrange
        int idProduct = 1;
        TypeProductDTO typeProductDto= new TypeProductDTO(1,"FOOD");
        ProductDTO productDto = new ProductDTO(idProduct, "Spaguettis", "Pasta fresca", 1.39, 100, typeProductDto);
        TypeProductEntity typeProduct= new TypeProductEntity("FOOD");
        ProductEntity savedProduct = new ProductEntity("Spaguettis", "Pasta fresca", 1.39, 100, typeProduct);
        savedProduct.setIdProduct(idProduct);
        //Product productToSave=dtoMapperProduct.mapToProduct(productDto);
        when(productDao.save(any(ProductEntity.class))).thenReturn(savedProduct);
        when(dtoMapperProduct.mapToProduct(any(ProductDTO.class))).thenReturn(savedProduct);
        when(productMapperDTO.mapToProductDto(any(ProductEntity.class))).thenReturn(productDto);
        // Act
        ProductDTO result = productRepository.createProduct(productDto);
        // Assert
        assertEquals(savedProduct.getIdProduct(), result.getIdProduct());
        assertEquals(savedProduct.getName(), result.getName());
        assertEquals(savedProduct.getDescription(), result.getDescription());
        assertEquals(savedProduct.getPrice(), result.getPrice());
    }

    @Test
    public void testUpdateProduct() {
        // Arrange
        int idProduct = 1;
        TypeProductDTO typeProductDto= new TypeProductDTO(1,"FOOD");
        ProductDTO productDto = new ProductDTO(idProduct, "Spaguettis", "Pasta fresca", 1.39, 100, typeProductDto);
        TypeProductEntity typeProduct= new TypeProductEntity("FOOD");
        ProductEntity savedProduct = new ProductEntity("Spaguettis", "Pasta fresca", 1.39, 100, typeProduct);
        savedProduct.setIdProduct(idProduct);
        //Product productToSave=dtoMapperProduct.mapToProduct(productDto);
        when(productDao.save(any(ProductEntity.class))).thenReturn(savedProduct);
        when(dtoMapperProduct.mapToProduct(any(ProductDTO.class))).thenReturn(savedProduct);
        when(productMapperDTO.mapToProductDto(any(ProductEntity.class))).thenReturn(productDto);
        // Act
        ProductDTO result = productRepository.updateProduct(productDto);
        // Assert
        assertEquals(savedProduct.getIdProduct(), result.getIdProduct());
        assertEquals(savedProduct.getName(), result.getName());
        assertEquals(savedProduct.getDescription(), result.getDescription());
        assertEquals(savedProduct.getPrice(), result.getPrice());
    }

    @Test
    public void testDeleteProduct() throws ProductNotFoundException {
        // Arrange
        int idProduct = 1;
        TypeProductEntity typeProduct= new TypeProductEntity("FOOD");
        ProductEntity productExpected = new ProductEntity("Macarrones", "Pasta con huevo", 1.39, 100, typeProduct);
        // Act
        when(productDao.findById(anyInt())).thenReturn(Optional.of(productExpected));
        productRepository.deleteProductById(idProduct);
        // Assert
        verify(productDao).deleteById(idProduct);
    }    
}
