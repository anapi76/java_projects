package com.anapiqueras.api.domain.service;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.anapiqueras.api.controller.dto.LoginRequest;
import com.anapiqueras.api.controller.dto.AuthResponse;
import com.anapiqueras.api.domain.repository.iUserRepository;
import com.anapiqueras.api.persistence.model.UserEntity;
import com.anapiqueras.api.util.JwtUtils;

import java.util.*;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private iUserRepository userRepository;
    private JwtUtils jwtUtils;
    private PasswordEncoder passwordEncoder;

    public UserDetailServiceImpl(iUserRepository userRepository, JwtUtils jwtUtils, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtUtils = jwtUtils;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findOneByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username " + username + "not found."));
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("ROLE_".concat(userEntity.getRole().getName())));
        return new User(userEntity.getUsername(), userEntity.getPassword(), userEntity.isEnabled(),
                userEntity.isAccountNoExpired(), userEntity.isCredentialNoExpired(), userEntity.isAccountNoLocked(),
                authorityList);
    }

    public AuthResponse loginUser(LoginRequest loginRequest) {
        String username = loginRequest.username();
        String password = loginRequest.password();
        Authentication authentication = this.authenticate(username, password);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String accesToken = jwtUtils.createToken(authentication);
        AuthResponse authResponse = new AuthResponse(username, "User logged succesfully", accesToken,
                true);
        return authResponse;
    }

    public Authentication authenticate(String username, String password) {
        UserDetails userDetails = this.loadUserByUsername((username));
        if (userDetails == null) {
            throw new UsernameNotFoundException("Invalid username");
        }
        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("Invalid password");
        }
        return new UsernamePasswordAuthenticationToken(username, userDetails.getPassword(),
                userDetails.getAuthorities());
    }

}
