package user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.anapiqueras.api.domain.repository.iUserRepository;
import com.anapiqueras.api.persistence.model.RoleEntity;
import com.anapiqueras.api.persistence.model.UserEntity;

@ExtendWith(MockitoExtension.class)
public class UserRepostitoryTest {

    @Mock
    private iUserRepository userRepository;

    @Test
    public void checkFindOneByUsername() {
        // Arrange
        String username = "username";
        RoleEntity rol = new RoleEntity("ADMIN");
        Optional<UserEntity> userExpected = Optional.of(new UserEntity("username", "password", rol));
        // Act
        when(userRepository.findOneByUsername(anyString())).thenReturn(userExpected);
        Optional<UserEntity> userActual = userRepository.findOneByUsername(username);
        // Assert
        assertEquals(userExpected, userActual);
    }

    @Test
    public void checkFindOneByUsername_UserNotFound() {
        // Arrange
        String username = "usernameNotexist";
        // Configurando el comportamiento del repositorio mock para devolver un Optional vacío cuando se busque por el nombre de usuario
        when(userRepository.findOneByUsername(anyString())).thenReturn(Optional.empty());
        // Act
        Optional<UserEntity> user = userRepository.findOneByUsername(username);
        // Assert
        assertFalse(user.isPresent());
    }



}
