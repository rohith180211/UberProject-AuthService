package org.example.uberprojectauthservice.Services;


import org.springframework.beans.factory.annotation.Value;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService implements CommandLineRunner {
    @Value("${jwt.expiry}")
    private int expiry;

    @Value("${jwt.secret}")
    private String secret;

    //This creates a brand new jwt token based on payload
    private String createToken(Map<String,Object> payload,String username){
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expiry*1000L);
        return Jwts.builder().
                claims(payload).
                issuedAt(new Date(System.currentTimeMillis())).
                expiration(expiryDate).
                subject(username).
                signWith(getSignKey()).
                compact();
    }

    public Key getSignKey() {
        return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public void run(String... args) throws Exception {
        Map<String,Object> mp=new HashMap<>();
        mp.put("username","admin");
        mp.put("password","admin");
        String result=createToken(mp,"rohith");
        System.out.println("Generated token is : "+result);
    }
}
