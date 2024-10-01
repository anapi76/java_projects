package user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import com.anapiqueras.api_users.controller.UserController;
import com.anapiqueras.api_users.controller.dto.UserDTOController;
import com.anapiqueras.api_users.repository.iUserRepository;
import com.anapiqueras.api_users.service.iUserService;
import com.anapiqueras.api_users.dto.RoleDTO;
import com.anapiqueras.api_users.dto.UserDTO;
import com.anapiqueras.api_users.exceptions.RoleNotFoundException;
import com.anapiqueras.api_users.exceptions.UserCantBeNullException;
import com.anapiqueras.api_users.exceptions.UserNotFoundException;
import com.anapiqueras.api_users.mapper.ControllerMapperDTO;


public class UserControllerTest {

    @Mock
    private iUserRepository userRepository;

    @Mock
    private iUserService userService;

    @Mock
    public ControllerMapperDTO controllerMapperDto;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void checkIfThereAreUsers() {
        // Arrange
        RoleDTO role1 = new RoleDTO("ADMIN");
        RoleDTO role2 = new RoleDTO("USER");
        UserDTO user1 = new UserDTO(1,"ana", "$2a$12$JKcqjWdwb5ZyrRpbCO4s7uE0E64fnD/6bWOyrD60Q3BGUF2JyAmvC", "aaa@gmail.com", role1);
        UserDTO user2 = new UserDTO(2,"hugo", "$2a$12$JKcqjWdwb5ZyrRpbCO4s7uE0E64fnD/6bWOyrD60Q3BGUF2JyAmvC","bbb@gmail.com",
                role2);
        List<UserDTO> userList = List.of(user1, user2);
        // Act
        when(userRepository.findAll()).thenReturn(userList);
        HttpStatusCode code = userController.findAll().getStatusCode();
        // Assert
        assertEquals(HttpStatus.OK, code);
    }

    @Test
    public void checkIfThereAreAnyUsers() {
        // Arrange
        List<UserDTO> userList = List.of();
        // Act
        when(userRepository.findAll()).thenReturn(userList);
        ResponseEntity<List<UserDTO>> response = userController.findAll();
        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().isEmpty());
    }

    @Test
    public void checkIfUserExist() throws UserNotFoundException {
        // Arrange
        int id = 1;
        RoleDTO role=new RoleDTO("ADMIN");
        UserDTO user = new UserDTO(id, "ana", "$2a$12$JKcqjWdwb5ZyrRpbCO4s7uE0E64fnD/6bWOyrD60Q3BGUF2JyAmvC", "aaa@gmail.com",role);
        // Act
        when(userService.findUserById(id)).thenReturn(user);
        HttpStatusCode code = userController.findUserById(id).getStatusCode();
        // Assert
        assertEquals(HttpStatus.OK, code);
    }

    @Test
    public void checkIfUserNotExist() throws UserNotFoundException {
        // Arrange
        int id = 999;
        // Act
        when(userService.findUserById(id)).thenThrow(UserNotFoundException.class);
        HttpStatusCode result = userController.findUserById(id).getStatusCode();
        // Assert
        assertEquals(HttpStatus.NOT_FOUND, result);
    }

    @Test
    public void checkCreateUSer() throws UserCantBeNullException, UserNotFoundException, RoleNotFoundException {
        // Arrange
        int id = 1;
        RoleDTO role=new RoleDTO(1,"ADMIN");
        UserDTO user = new UserDTO(id, "ana", "$2a$12$JKcqjWdwb5ZyrRpbCO4s7uE0E64fnD/6bWOyrD60Q3BGUF2JyAmvC", "aaa@gmail.com",role);
        UserDTOController userDtoController = new UserDTOController(id, "ana", "1234", "aaa@gmail.com",1);
        // Act
        when(controllerMapperDto.mapToUserDto(userDtoController)).thenReturn(user);
        when(userService.createUser(user)).thenReturn(user);
        HttpStatusCode result = userController.createUser(userDtoController).getStatusCode();
        // Assert
        assertEquals(HttpStatus.CREATED, result);
    }

    @Test
    public void checkNotCreateUsertIfIsNotValid() throws UserCantBeNullException, UserNotFoundException, RoleNotFoundException {
        // Arrange
        int id = 1;
        RoleDTO role=new RoleDTO(1,"ADMIN");
        UserDTO user = new UserDTO(id, null, "$2a$12$JKcqjWdwb5ZyrRpbCO4s7uE0E64fnD/6bWOyrD60Q3BGUF2JyAmvC", "aaa@gmail.com",role);
        UserDTOController userDtoController = new UserDTOController(id, null, "1234", "aaa@gmail.com",1);
        // Act
        when(controllerMapperDto.mapToUserDto(userDtoController)).thenReturn(user);
        when(userService.createUser(user)).thenThrow(UserCantBeNullException.class);
        HttpStatusCode result = userController.createUser(userDtoController).getStatusCode();
        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, result);
    }

    @Test
    public void checkUserIsNull() throws UserNotFoundException {
        // Arrange

        // Act
        HttpStatusCode result = userController.createUser(null).getStatusCode();
        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, result);
    }

    @Test
    public void checkUpdateUser() throws UserNotFoundException, RoleNotFoundException {
        // Arrange
        int id = 1;
        RoleDTO role=new RoleDTO(1,"ADMIN");
        UserDTO user = new UserDTO(id, "ana", "$2a$12$JKcqjWdwb5ZyrRpbCO4s7uE0E64fnD/6bWOyrD60Q3BGUF2JyAmvC", "aaa@gmail.com",role);
        UserDTOController userDtoController = new UserDTOController(id, "ana", "1234", "aaa@gmail.com",1);
        UserDTO userModified=new UserDTO(id, "anapi", "$2a$12$JKcqjWdwb5ZyrRpbCO4s7uE0E64fnD/6bWOyrD60Q3BGUF2JyAmvC", "aaa@gmail.com",role);
        // Act
        when(controllerMapperDto.mapToUserDto(userDtoController)).thenReturn(user);
        when(userService.updateUser(id, user)).thenReturn(userModified);
        HttpStatusCode result = userController.updateUser(id, userDtoController).getStatusCode();
        // Assert
        assertEquals(HttpStatus.CREATED, result);
    }

    @Test
    public void checkNotUpdateUser() throws UserNotFoundException, RoleNotFoundException {
        // Arrange
        int id = 999;
        RoleDTO role=new RoleDTO(1,"ADMIN");
        UserDTO user = new UserDTO(id, "ana", "$2a$12$JKcqjWdwb5ZyrRpbCO4s7uE0E64fnD/6bWOyrD60Q3BGUF2JyAmvC", "aaa@gmail.com",role);
        UserDTOController userDtoController = new UserDTOController(id, "ana", "1234", "aaa@gmail.com",1);
        // Act
        when(controllerMapperDto.mapToUserDto(userDtoController)).thenReturn(user);
        when(userService.updateUser(id, user)).thenThrow(UserNotFoundException.class);
        HttpStatusCode result = userController.updateUser(id, userDtoController).getStatusCode();
        // Assert
        assertEquals(HttpStatus.NOT_FOUND, result);
    }

     @Test
    public void checkDeleteUser() throws UserNotFoundException {
        // Arrange
        int id= 2;
        // Act
        doNothing().when(userService).deleteUserById(id);
        HttpStatusCode result = userController.deleteUserById(id).getStatusCode();
        // Assert
        assertEquals(HttpStatus.OK, result);
    }

    @Test
    public void checkNotDeleteProduct() throws UserNotFoundException {
        // Arrange
        int id = 999;
        // Act
        doThrow(UserNotFoundException.class).when(userService).deleteUserById(id);
        HttpStatusCode result = userController.deleteUserById(id).getStatusCode();
        // Assert
        assertEquals(HttpStatus.NOT_FOUND, result);
    }

}
