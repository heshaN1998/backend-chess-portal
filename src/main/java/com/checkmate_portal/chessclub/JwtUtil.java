package com.checkmate_portal.chessclub;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
    private final String SECRET="HACKING2018Heshan";
    private Key getKey(){
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }
    //Creating token Section
    public String generateToken(String userName){
        return Jwts.builder().setSubject(userName).setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + 1000*60*60)).signWith(getKey(), SignatureAlgorithm.ES256).compact();
    }
    //Extract userName
    public String extractUsername(String token){
        return Jwts.parser().setSigningKey(getKey()).build().parseClaimsJwt(token).getBody().getSubject();
    }
}
