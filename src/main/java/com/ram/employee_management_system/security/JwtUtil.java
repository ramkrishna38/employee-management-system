package com.ram.employee_management_system.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import java.util.Date;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "ramkrishna123456789";

    public String generateToken(String username){

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();

    }
    public String extractUsername(String token) {

        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();

    }

    public boolean validateToken(String token,
                                 org.springframework.security.core.userdetails.UserDetails userDetails) {

        String username = extractUsername(token);

        return username.equals(userDetails.getUsername());

    }


}