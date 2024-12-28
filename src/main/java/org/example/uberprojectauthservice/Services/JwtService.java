package org.example.uberprojectauthservice.Services;
import io.jsonwebtoken.Claims;
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
import java.util.function.Function;

@Service
public class JwtService implements CommandLineRunner {
    @Value("${jwt.expiry}")
    private int expiry;

    @Value("${jwt.secret}")
    private String secret;

    //This creates a brand new jwt token based on payload
    private String createToken(Map<String,Object> payload,String email){
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expiry*1000L);
        return Jwts.builder().
                claims(payload).
                issuedAt(new Date(System.currentTimeMillis())).
                expiration(expiryDate).
                subject(email).
                signWith(getSignKey()).
                compact();
    }

    public Key getSignKey() {
        return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    public Claims extractAllPayloads(String token) {
            return Jwts
                    .parser()
                    .setSigningKey(getSignKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllPayloads(token);
        return claimsResolver.apply(claims);
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private String extractEmail(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Boolean validateToken(String token,String email) {
        final String userEmail = extractEmail(token);
        return userEmail.equals(email) && !isTokenExpired(token);
    }

    private Object extractPayload(String token,String payload) {
        Claims claim=extractAllPayloads(token);
        return (String) claim.get(payload);
    }

    @Override
    public void run(String... args) throws Exception {
        Map<String,Object> mp=new HashMap<>();
        mp.put("username","admin");
        mp.put("password","admin");
        String result=createToken(mp,"rohith");
        System.out.println("Generated token is : "+result);
        System.out.println(extractPayload(result,"password"));
    }
}
