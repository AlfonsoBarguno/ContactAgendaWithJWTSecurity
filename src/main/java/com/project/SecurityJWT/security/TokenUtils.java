package com.project.SecurityJWT.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class TokenUtils {

    private final static String ACCESS_TOKEN_SECRET = "$2a$10$p2P1S/zS4O08.GkUF1DA6Ofqr6kcLTAW.ixv0EfUh5V8/1WKoV6/.";

    private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 2_592_000L;



    public static String createToken(String name, String email){

        long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS*1000;
        Date expirationDate = new Date(System.currentTimeMillis()+expirationTime);

        Map<String, Object> extra = new HashMap<>();
        extra.put("nombre", name);

        String compact = Jwts.builder()
                .setSubject(email)
                .setExpiration(expirationDate)
                .addClaims(extra)
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
                .compact();

        return compact;
    }

    public static UsernamePasswordAuthenticationToken getAuthenticationToken(String token){

        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            String email = claims.getSubject();

            return new UsernamePasswordAuthenticationToken(email,null, Collections.emptyList());

        } catch (JwtException e) {

            return null;}







    }

    public static void main(String[] args) {
        System.out.println("Token: " + TokenUtils.createToken("Darwin", "darwin@gamil.com"));
    }


}
