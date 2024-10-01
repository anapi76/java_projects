package security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.anapiqueras.api_users.controller.dto.AuthResponse;
import com.anapiqueras.api_users.controller.dto.LoginRequest;
import com.anapiqueras.api_users.repository.iUserRepository;
import com.anapiqueras.api_users.service.UserDetailServiceImpl;
import com.anapiqueras.api_users.dto.RoleDTO;
import com.anapiqueras.api_users.dto.UserDTO;
import com.anapiqueras.api_users.exceptions.UserNotFoundException;
import com.anapiqueras.api_users.entity.RoleEntity;
import com.anapiqueras.api_users.entity.UserEntity;
import com.anapiqueras.api_users.util.JwtUtils;

import org.springframework.security.core.*;

import java.util.ArrayList;
import java.util.List;

public class UserDetailServiceImplTest {

    @Mock
    private iUserRepository userRepository;

    @Mock
    private JwtUtils jwtUtils;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    UserDetailServiceImpl userDetailService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    String password = "password";
    String username = "username";
    RoleEntity rol = new RoleEntity("rol");
    UserEntity user = new UserEntity("username", "password","email@gmail.com" ,rol);

    @Test
    public void checkLoadUserByUsername() throws UserNotFoundException {
        // Arrange
        RoleDTO rol = new RoleDTO(1,"rol");
        UserDTO user = new UserDTO(1,"username", "password","email@gmail.com", rol);
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        User userExpected = new User("username", "password", authorityList);
        // Act
        when(userRepository.findUserByUsername(anyString())).thenReturn(user);
        UserDetails userActual = userDetailService.loadUserByUsername("username");
        // Asserts
        assertEquals(userExpected.getUsername(), userActual.getUsername());
        assertEquals(userExpected.getPassword(), userActual.getPassword());
    }

    @Test
    public void checkNotFoundUsername() throws UserNotFoundException {
        // Arrange

        // Act
        when(userRepository.findUserByUsername(anyString())).thenThrow(UsernameNotFoundException.class);
        // Asserts
        assertThrows(UsernameNotFoundException.class, () -> userDetailService.loadUserByUsername("username"));
    }

    @Test
    public void checkLoginUser() throws UserNotFoundException {
        // Arrange
        RoleDTO rol = new RoleDTO(1,"rol");
        UserDTO user = new UserDTO(1,"username", "password","email@gmail.com", rol);
        LoginRequest loginRequest = new LoginRequest(username, password);
        String accessToken = "token";
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        User userExpected = new User(username, password, authorityList);
        // Act
        when(userRepository.findUserByUsername(anyString())).thenReturn(user);
        when(passwordEncoder.matches(password, userExpected.getPassword())).thenReturn(true);
        Authentication authentication = userDetailService.authenticate(username, password);
        when(jwtUtils.createToken(authentication)).thenReturn(accessToken);
        AuthResponse authResponse = userDetailService.loginUser(loginRequest);
        // Asserts
        assertEquals(username, authResponse.username());
        assertEquals(accessToken, authResponse.jwt());
    }

    @Test
    void authenticateValidCredentials() throws UserNotFoundException {
        // Arrange
        RoleDTO rol = new RoleDTO(1,"rol");
        UserDTO user = new UserDTO(1,"username", "password","email@gmail.com", rol);
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        User userExpected = new User(username, password, authorityList);
        // Act
        when(userRepository.findUserByUsername(anyString())).thenReturn(user);
        when(passwordEncoder.matches(password, userExpected.getPassword())).thenReturn(true);
        Authentication authentication = userDetailService.authenticate(username, password);
        // Assert
        assertTrue(authentication instanceof UsernamePasswordAuthenticationToken);
        assertEquals(username, authentication.getName());
        assertEquals(password, authentication.getCredentials());
        assertTrue(authentication.isAuthenticated());
    }

    @Test
    public void authenticateInValidCredentials() throws UserNotFoundException {
        // Arrange
        RoleDTO rol = new RoleDTO(1,"rol");
        UserDTO user = new UserDTO(1,"username", "password","email@gmail.com", rol);
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        User userExpected = new User(username, "passwordd", authorityList);
        // Act
        when(userRepository.findUserByUsername(anyString())).thenReturn(user);
        when(!passwordEncoder.matches(password, userExpected.getPassword())).thenReturn(true);
        // Assert
        assertThrows(BadCredentialsException.class, () -> {
            userDetailService.authenticate(username, password);
        });
    }

    @Test
    public void authenticateUsernameNotFound() throws UserNotFoundException {
        // Arrange

        // Act
        when(userRepository.findUserByUsername(anyString())).thenThrow(UsernameNotFoundException.class);
        // Assert
        assertThrows(UsernameNotFoundException.class, () -> {
            userDetailService.authenticate(username, password);
        });

    }

}
