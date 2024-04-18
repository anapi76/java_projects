package security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.anapiqueras.api.controller.AuthenticationController;
import com.anapiqueras.api.controller.dto.LoginRequest;
import com.anapiqueras.api.controller.dto.AuthResponse;
import com.anapiqueras.api.domain.service.UserDetailServiceImpl;

public class AuthenticationControllerTest {

    @Mock
    private UserDetailServiceImpl userDetailService;

    @InjectMocks
    private AuthenticationController authenticationController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void checkIfUserLoginValid() {
        // Arrange
        LoginRequest authLoginRequest = new LoginRequest("ana", "1,2,3,4");
        AuthResponse authResponse = new AuthResponse("ana", "User logged successfully",
                "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJBVVRIMEpXVCIsInN1YiI6ImFuYSIsImF1dGhvcml0aWVzIjoiUk9MRV9BRE1JTiIsImlhdCI6MTcxMzQyNzc5NSwiZXhwIjoxNzEzNDI5NTk1LCJqdGkiOiJkOTBkZWRhMC0yZGVhLTQ1MzMtYTM1Yi1mNzI1MGExODM4NWYiLCJuYmYiOjE3MTM0Mjc3OTV9.nOqiEIDpiG8knH5dgUAexjS-B9ofAJEJgfLfF46th24",
                true);
        // Act
        when(userDetailService.loginUser(any(LoginRequest.class))).thenReturn(authResponse);
        ResponseEntity<AuthResponse> responseEntity = authenticationController.login(authLoginRequest);
        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals("ana", responseEntity.getBody().userName());
        assertEquals("User logged successfully", responseEntity.getBody().message());
        assertTrue(responseEntity.getBody().status());
    }

    @Test
    public void checkIfUserLoginInvalid() {
        // Arrange
        LoginRequest authLoginRequest = new LoginRequest("invalidUser", "invalidPassword");
        // Act
        when(userDetailService.loginUser(any(LoginRequest.class))).thenReturn(null);
        ResponseEntity<AuthResponse> responseEntity = authenticationController.login(authLoginRequest);
        // Assert
        assertEquals(HttpStatus.UNAUTHORIZED, responseEntity.getStatusCode());
        assertNull(responseEntity.getBody());
    }

}
