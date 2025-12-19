package com.insane.security;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtService {
	
	 private final String SECRET = "my-super-secret-key-my-super-secret-key";

	    public String generateToken(String username) {

	        return Jwts.builder()
	            .setSubject(username)
	            .setIssuedAt(new Date())
	            .setExpiration(new Date(System.currentTimeMillis() + 15 * 60 * 1000))
	            .signWith(Keys.hmacShaKeyFor(SECRET.getBytes()), SignatureAlgorithm.HS256)
	            .compact();
	    }

	    public String extractUsername(String token) {
	        return Jwts.parserBuilder()
	            .setSigningKey(SECRET.getBytes())
	            .build()
	            .parseClaimsJws(token)
	            .getBody()
	            .getSubject();
	    }

}
