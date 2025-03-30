package com.base.login;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.base.application.service.AuthService;
import com.base.domain.User;

class AuthServiceTest {

    private final AuthService authService = new AuthService();

    @Test
    void testLoginSuccess() {
        User user = new User();
        user.setUsername("user");
        user.setPassword("password");

        String token = authService.login(user);
        assertNotNull(token);
    }

    @Test
    void testLoginFailure() {
        User user = new User();
        user.setUsername("user");
        user.setPassword("wrongpassword");

        assertThrows(RuntimeException.class, () -> authService.login(user));
    }
}
