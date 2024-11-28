package com.slippery.musicapi.service.impl;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    private final Long EXPIRATIONTIME =8640000L;
    private final String secretString ="a72e05ed3f968479b926f8b261bd134c69c981a71f5d272e0cb5237f833addf122e3b236d918feaf38facf453e4325d80909b7b1107c9af46189eace24d7e3cc97cdb036b3c89bae5a9bfe28c86c377d7b67d892da090efb510e1a98ad393a921678634e02f21e49a119353f211ded9a181f20bf2f1f074fbbbd2196695633b8b88acaeb7027af518149da91c31ac00c86bfbc136649aed62c2dd1ec241e123fa6380933bdcdb0874cb51628c6a10d73cee8952992aa775b4160e4fecf3cffac718e93e51d276cf6413602793a1892bf45bc8ec123fced870c79711822642d7eaf927c736c2dcff3523d569bfab5a8ddbb7d6673213932b685b7e1d8ca79ac89";

    protected SecretKey generateSecretKey(){
        byte[] keyBytes = Base64.getDecoder().decode(secretString);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    public String generateJwtToken(String username){
        Map<String,Object> claims =new HashMap<>();

        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+EXPIRATIONTIME))
                .and()
                .signWith(generateSecretKey())
                .compact();
    }
    public String extractUsername(String token){
        return extractClaims(token, Claims::getSubject);
    }

    private <T> T extractClaims(String token, Function<Claims, T> claimsTFunction) {
        return claimsTFunction.apply(Jwts.parser().verifyWith(generateSecretKey()).build().parseSignedClaims(token).getPayload());

    }
    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(generateSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String userName = extractUsername(token);
        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaims(token, Claims::getExpiration);
    }
}
