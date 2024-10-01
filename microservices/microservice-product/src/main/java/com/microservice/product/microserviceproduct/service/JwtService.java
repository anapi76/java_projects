package com.microservice.product.microserviceproduct.service;

import java.util.Date;
import java.util.stream.Collectors;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

@Component
public class JwtService {

    private final int EXPIRATION_TIME = 1800000;

    @Value("${jwt.key}")
    private String privateKey;

    @Value("${jwt.issuer}")
    private String issuer;

    public String generateToken(Authentication authentication) {
        Algorithm algorithm = Algorithm.HMAC256(this.privateKey);
        String username = authentication.getPrincipal().toString();
        String authorities = authentication.getAuthorities().stream().map(g -> g.getAuthority().toString())
                .collect(Collectors.joining(","));
        return createToken(username, authorities, algorithm);
    }

    public String createToken(String username, String authorities, Algorithm algorithm) {
        String jwtToken = JWT.create()
                .withIssuer(this.issuer)
                .withSubject(username)
                .withClaim("authorities", authorities)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .withNotBefore(new Date(System.currentTimeMillis()))
                .sign(algorithm);
        return jwtToken;
    }

    public DecodedJWT validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(this.privateKey);

            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(this.issuer)
                    .build();
            DecodedJWT decodedJWT = verifier.verify(token);
            return decodedJWT;
        } catch (JWTVerificationException exception) {
            throw new JWTVerificationException("Invalid token, not authorized");
        }
    }

    public String extractUserName(DecodedJWT decodedJWT) {
        return decodedJWT.getSubject().toString();
    }

    public Claim geSpecificClaim(DecodedJWT decodedJWT, String claimName) {
        return decodedJWT.getClaim(claimName);
    }

    public Map<String, Claim> returnAllClaims(DecodedJWT decodedJWT) {
        return decodedJWT.getClaims();
    }
}
