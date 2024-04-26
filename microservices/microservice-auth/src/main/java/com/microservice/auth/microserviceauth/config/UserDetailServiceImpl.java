package com.microservice.auth.microserviceauth.config;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.microservice.auth.microserviceauth.dto.AuthUserDTO;
import com.microservice.auth.microserviceauth.exceptions.AuthUserNotFoundException;
import com.microservice.auth.microserviceauth.repository.iAuthUserRepository;

import java.util.*;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private iAuthUserRepository authUserRepository;
    private PasswordEncoder passwordEncoder;

    public UserDetailServiceImpl(iAuthUserRepository authUserRepository, PasswordEncoder passwordEncoder) {
        this.authUserRepository = authUserRepository;;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try{
            AuthUserDTO authUserDto = authUserRepository.findAuthUserByUsername(username);
            List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
            authorityList.add(new SimpleGrantedAuthority("ROLE_".concat(authUserDto.getRole().getName())));
            return new User(authUserDto.getUsername(), authUserDto.getPassword(), 
                    authorityList);
        }catch (AuthUserNotFoundException ex) {
            throw new UsernameNotFoundException("Username not found");
        }
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
