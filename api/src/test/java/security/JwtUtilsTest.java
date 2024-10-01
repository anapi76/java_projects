package security;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.anapiqueras.api.util.JwtUtils;


public class JwtUtilsTest {
    
    @Mock
    private Authentication authentication;

    @InjectMocks
    JwtUtils jwtUtils;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

  /*  @Test
    public void testCreateToken() {
        // Arrange
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        when(authentication.getPrincipal()).thenReturn("username");
        //when(authentication.getAuthorities()).thenReturn(authorityList);

        // Act
        String token = jwtUtils.createToken(authentication);

        // Assert
        assertNotNull(token);
    }*/

}

