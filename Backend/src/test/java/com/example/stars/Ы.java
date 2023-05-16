package com.example.stars;

import com.example.stars.config.SecurityConfig;
import com.example.stars.service.CustomUsersDetailsService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;


public class SecurityConfigTest {

    @Mock
    private CustomUsersDetailsService customUsersDetailsService;

    @InjectMocks
    private SecurityConfig securityConfig;

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testConfigureHttpSecurity() throws Exception {
        HttpSecurity httpSecurity = mock(HttpSecurity.class);
        securityConfig.configure(httpSecurity);
        // Добавьте проверки для вашего метода configure() здесь
    }

    @Test
    public void testGetPasswordEncoder() {
        PasswordEncoder passwordEncoder = securityConfig.getPasswordEncoder();
        // Добавьте проверки для вашего метода getPasswordEncoder() здесь
    }
}
