package com.company.jwt;

import com.company.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;

import java.security.Key;
import java.util.Date;

public class JwtUtil {
    @Value("${app.jwt.exp}")
    private long EXPIRE_DURATION;
    @Value("${app.jwt.secret}")
    private String SECRET_KEY;


    public String generateAccessToken(Authentication authentication ) {
        User userPrincipal = (User) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(String.format("%s,%s", userPrincipal.getUsername(), userPrincipal.getAuthorities()))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_KEY));
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parserBuilder().setSigningKey(key()).build()
                .parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key()).build().parse(token);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}

