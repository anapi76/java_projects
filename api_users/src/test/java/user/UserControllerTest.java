package user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.anapiqueras.api_users.controller.UserController;
import com.anapiqueras.api_users.domain.repository.iUserRepository;
import com.anapiqueras.api_users.dto.RoleDTO;
import com.anapiqueras.api_users.dto.UserDTO;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.MediaType;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Mock
    private iUserRepository userRepository;

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

  /*   @Test
    @WithMockUser(roles = "ADMIN")
    public void testUsersAthenticatedUser() throws Exception {
        mockMvc.perform(get("/users")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = "unAuthorized")
    public void testUsersUnAthenticatedUser() throws Exception {
        mockMvc.perform(get("/users")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden());;
    } */
}
