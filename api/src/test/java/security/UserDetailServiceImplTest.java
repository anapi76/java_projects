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

import com.anapiqueras.api.controller.dto.AuthResponse;
import com.anapiqueras.api.controller.dto.LoginRequest;
import com.anapiqueras.api.domain.repository.iUserRepository;
import com.anapiqueras.api.domain.service.UserDetailServiceImpl;
import com.anapiqueras.api.persistence.model.RoleEntity;
import com.anapiqueras.api.persistence.model.UserEntity;
import com.anapiqueras.api.util.JwtUtils;
import org.springframework.security.core.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    UserEntity user = new UserEntity("username", "password", rol);

    @Test
    public void checkLoadUserByUsername() {
        // Arrange
        RoleEntity rol = new RoleEntity("rol");
        UserEntity user = new UserEntity("username", "password", rol);
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        User userExpected = new User("username", "password", authorityList);
        // Act
        when(userRepository.findOneByUsername(anyString())).thenReturn(Optional.of(user));
        UserDetails userActual = userDetailService.loadUserByUsername("username");
        // Asserts
        assertEquals(userExpected.getUsername(), userActual.getUsername());
        assertEquals(userExpected.getPassword(), userActual.getPassword());
    }

    @Test
    public void checkNotFoundUsername() {
        // Arrange

        // Act
        when(userRepository.findOneByUsername(anyString())).thenReturn(Optional.empty());
        // Asserts
        assertThrows(UsernameNotFoundException.class, () -> userDetailService.loadUserByUsername("username"));
    }

    @Test
    public void checkLoginUser() {
        // Arrange
        LoginRequest loginRequest = new LoginRequest(username, password);
        String accessToken = "token";
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        User userExpected = new User(username, password, authorityList);
        // Act
        when(userRepository.findOneByUsername(anyString())).thenReturn(Optional.of(user));
        when(passwordEncoder.matches(password, userExpected.getPassword())).thenReturn(true);
        Authentication authentication=userDetailService.authenticate(username, password);
        when(jwtUtils.createToken(authentication)).thenReturn(accessToken);
        AuthResponse authResponse = userDetailService.loginUser(loginRequest);
        // Asserts
        assertEquals(username, authResponse.username());
        assertEquals(accessToken, authResponse.jwt());
    }

    @Test
    void authenticateValidCredentials() {
        // Arrange
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        User userExpected = new User(username, password, authorityList);
        // Act
        when(userRepository.findOneByUsername(anyString())).thenReturn(Optional.of(user));
        when(passwordEncoder.matches(password, userExpected.getPassword())).thenReturn(true);
        Authentication authentication = userDetailService.authenticate(username, password);
        // Assert
        assertTrue(authentication instanceof UsernamePasswordAuthenticationToken);
        assertEquals(username, authentication.getName());
        assertEquals(password, authentication.getCredentials());
        assertTrue(authentication.isAuthenticated());
    }

    @Test
    public void authenticateInValidCredentials() {
        // Arrange
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        User userExpected = new User(username, "passwordd", authorityList);
        // Act
        when(userRepository.findOneByUsername(anyString())).thenReturn(Optional.of(user));
        when(!passwordEncoder.matches(password, userExpected.getPassword())).thenReturn(true);
        // Assert
        assertThrows(BadCredentialsException.class, () -> {
            userDetailService.authenticate(username, password);
        });

    }

    @Test
    public void authenticateUsernameNotFound() {
        // Arrange

        // Act
        when(userRepository.findOneByUsername(anyString())).thenReturn(Optional.empty());
        // Assert
        assertThrows(UsernameNotFoundException.class, () -> {
            userDetailService.authenticate(username, password);
        });

    }

}
