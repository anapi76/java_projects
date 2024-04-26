package security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import com.anapiqueras.api_users.config.SecurityConfig;
import com.anapiqueras.api_users.util.JwtUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = { SecurityConfig.class, JwtUtils.class })
@AutoConfigureMockMvc
@DirtiesContext
public class SecurityConfigTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UserDetailsService userDetailsService;

    @Mock
    private AuthenticationConfiguration authenticationConfiguration;

    @MockBean
    AuthenticationProvider authenticationProvider;

    @MockBean
    SecurityFilterChain securityFilterChain;

    @MockBean
    PasswordEncoder passwordEncoder;

    @MockBean
    AuthenticationManager authenticationManager;

    @Mock
    JwtUtils jwtUtils;

    @InjectMocks
    SecurityConfig securityConfig;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testAdminAccessToProductEndpoints() throws Exception {
        mockMvc.perform(get("/product/"))
                .andExpect(status().isOk());
        mockMvc.perform(get("/product/"))
                .andExpect(status().isOk());
    }

}
