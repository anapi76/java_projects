package com.microservice.user.microserviceuser.security;

import java.io.IOException;

import java.util.Collection;
import org.springframework.http.HttpHeaders;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder; 
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.microservice.user.microserviceuser.service.JwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Se ejecuta el filtro antes de cada petición para validar el token
public class JwtTokenValidator extends OncePerRequestFilter {

    private JwtService jwtService;

    public JwtTokenValidator(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain)
            throws ServletException, IOException {
        String jwtToken = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (jwtToken != null) {
            jwtToken = jwtToken.substring(7);

            DecodedJWT decodedJWT=jwtService.validateToken(jwtToken);
            String username=jwtService.extractUserName(decodedJWT);
            String stringAuthorities=jwtService.geSpecificClaim(decodedJWT, "authorities").asString();
    
            Collection<?extends GrantedAuthority> authorities=AuthorityUtils.commaSeparatedStringToAuthorityList(stringAuthorities);

            SecurityContext context= SecurityContextHolder.getContext();
            Authentication authentication= new UsernamePasswordAuthenticationToken(username,null,authorities);
            System.out.println(authentication);
            context.setAuthentication(authentication);
            
            SecurityContextHolder.setContext(context);
        }
        filterChain.doFilter(request, response);
    }
 
}
