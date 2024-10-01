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
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.anapiqueras.api.controller.UserController;
import com.anapiqueras.api.repository.iUserRepository;
import com.anapiqueras.api.entity.RoleEntity;
import com.anapiqueras.api.entity.UserEntity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


public class UserControllerTest {

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
        RoleEntity role1 = new RoleEntity("ADMIN");
        RoleEntity role2 = new RoleEntity("USER");
        UserEntity user1 = new UserEntity("ana", "$2a$12$JKcqjWdwb5ZyrRpbCO4s7uE0E64fnD/6bWOyrD60Q3BGUF2JyAmvC", role1);
        UserEntity user2 = new UserEntity("hugo", "$2a$12$JKcqjWdwb5ZyrRpbCO4s7uE0E64fnD/6bWOyrD60Q3BGUF2JyAmvC",
                role2);
        List<UserEntity> userList = List.of(user1, user2);
        // Act
        when(userRepository.findAll()).thenReturn(userList);
        HttpStatusCode code = userController.findAll().getStatusCode();
        // Assert
        assertEquals(HttpStatus.OK, code);
    }

    @Test
    public void checkIfThereAreAnyUsers() {
        // Arrange
        List<UserEntity> userList = List.of();
        // Act
        when(userRepository.findAll()).thenReturn(userList);
        ResponseEntity<List<UserEntity>> response = userController.findAll();
        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().isEmpty());
    }

   /* @Test
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
    }*/
}
