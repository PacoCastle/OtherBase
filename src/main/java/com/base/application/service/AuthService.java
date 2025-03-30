package com.base.application.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.base.domain.User;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class AuthService {
    //private final PasswordEncoder passwordEncoder;
    private final SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256); // Secure key generation

    //public AuthService(PasswordEncoder passwordEncoder) {
        //this.passwordEncoder = passwordEncoder;
    //}

    public String login(User user) {
        // Validate user credentials (mocked for simplicity)
        if ("user".equals(user.getUsername()) && "password".equals(user.getPassword())) {
            return Jwts.builder()
                       .setSubject(user.getUsername())
                       .setIssuedAt(new Date())
                       .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                       .signWith(secretKey) // Use the secure key
                       .compact();
        }
        throw new RuntimeException("Invalid credentials");
    }
}
