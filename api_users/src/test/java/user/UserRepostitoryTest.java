package user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import com.anapiqueras.api_users.dto.RoleDTO;
import com.anapiqueras.api_users.dto.UserDTO;
import com.anapiqueras.api_users.exceptions.UserNotFoundException;
import com.anapiqueras.api_users.mapper.DTOMapperUser;
import com.anapiqueras.api_users.mapper.UserMapperDTO;
import com.anapiqueras.api_users.persistence.DAO.iUserDAO;
import com.anapiqueras.api_users.persistence.impl.UserRepositoryImpl;
import com.anapiqueras.api_users.persistence.model.RoleEntity;
import com.anapiqueras.api_users.persistence.model.UserEntity;

public class UserRepostitoryTest {

    @Mock
    private UserMapperDTO userMapperDTO;

    @Mock
    private DTOMapperUser dtoMapperUser;

    @Mock
    private iUserDAO userDao;

    @InjectMocks
    private UserRepositoryImpl userRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void checkIfThereAreUsers() {
        // Arrange
        RoleEntity role1 = new RoleEntity("ADMIN");
        RoleDTO role2 = new RoleDTO("USER");
        UserEntity user1 = new UserEntity("ana", "1234", "aaa@gmail.com", role1);
        List<UserEntity> userList = List.of(user1);
        // Act
        when(userDao.findAll()).thenReturn(userList);
        when(userMapperDTO.mapToUserDto(any(UserEntity.class)))
                .thenAnswer(invocation -> {
                    UserEntity userEntity = invocation.getArgument(0);
                    return new UserDTO(1, userEntity.getUsername(), userEntity.getPassword(), userEntity.getEmail(),
                            role2);
                });
        List<UserDTO> userListActual = userRepository.findAll();
        // Assert
        assertEquals(userList.size(), userListActual.size());
    }

    @Test
    public void checkIfThereAreNotUsers() {
        // Arrange
        List<UserEntity> userList = List.of();
        // Act
        when(userDao.findAll()).thenReturn(userList);
        // Act
        List<UserDTO> userListActual = userRepository.findAll();
        // Assert
        assertEquals(userList.size(), userListActual.size());
    }

    @Test
    public void checkFindOneByUsername() throws UserNotFoundException {
        // Arrange
        String username = "username";
        RoleDTO rol = new RoleDTO("ADMIN");
        RoleEntity rolEntity = new RoleEntity("ADMIN");
        UserDTO userExpected = new UserDTO(1, "username", "password", "email", rol);
        UserEntity userEntity = new UserEntity("username", "password", "email", rolEntity);
        // Act
        when(userDao.findOneByUsername(anyString())).thenReturn(Optional.of(userEntity));
        when(userMapperDTO.mapToUserDto(userEntity)).thenReturn(userExpected);
        UserDTO userActual = userRepository.findUserByUsername(username);
        // Assert
        assertEquals(userExpected.getUsername(), userActual.getUsername());
    }

    @Test
    public void checkFindOneByUsernameNotFound() throws UserNotFoundException {
        // Arrange

        // Act
        when(userDao.findOneByUsername(anyString())).thenReturn(Optional.empty());
        // Assert
        assertThrows(UserNotFoundException.class, () -> {
            userRepository.findUserByUsername("username");
        });
    }

    @Test
    public void testCreateUser() {
        // Arrange
        RoleDTO rol = new RoleDTO("ADMIN");
        UserDTO userDto = new UserDTO(1, "username", "password", "email", rol);
        RoleEntity rolEntity = new RoleEntity("ADMIN");
        UserEntity userEntity = new UserEntity("username", "password", "email", rolEntity);
        // Act
        when(dtoMapperUser.mapToUser(any(UserDTO.class))).thenReturn(userEntity);
        when(userDao.save(any(UserEntity.class))).thenReturn(userEntity);
        when(userMapperDTO.mapToUserDto(any(UserEntity.class))).thenReturn(userDto);
        UserDTO createdUser = userRepository.createUser(userDto);
        // Assert
        assertEquals(userDto, createdUser);
    }

    @Test
    public void testUpdateUser() {
        // Arrange
        RoleDTO rol = new RoleDTO("ADMIN");
        UserDTO userDto = new UserDTO(1, "username", "password", "email", rol);
        RoleEntity rolEntity = new RoleEntity("ADMIN");
        UserEntity userEntity = new UserEntity("username", "password", "email", rolEntity);
        // Act
        when(dtoMapperUser.mapToUser(any(UserDTO.class))).thenReturn(userEntity);
        when(userDao.save(any(UserEntity.class))).thenReturn(userEntity);
        when(userMapperDTO.mapToUserDto(any(UserEntity.class))).thenReturn(userDto);
        UserDTO updatedUser = userRepository.updateUser(userDto);
        // Assert
        assertEquals(userDto, updatedUser);
    }

    @Test
    public void testNotUpdateUser() {
        // Arrange
        RoleDTO rol = new RoleDTO("ADMIN");
        UserDTO userDto = new UserDTO(1, "username", "password", "email", rol);
        RoleEntity rolEntity = new RoleEntity("ADMIN");
        UserEntity userEntity = new UserEntity("username", "password", "email", rolEntity);;
         // Act
        when(dtoMapperUser.mapToUser(any(UserDTO.class))).thenReturn(userEntity);
        when(userDao.save(any(UserEntity.class))).thenReturn(null);
        UserDTO updatedUser = userRepository.updateUser(userDto);
        // Assert
        assertNull(updatedUser); 
    }
}
