package com.salesianostriana.dam.projectFOODAPP.usuario.service;

import com.salesianostriana.dam.projectFOODAPP.usuario.model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private Map<String, Usuario> roles = new HashMap<>();

    @Override
    public UserDetails loadUserByUsername(String username) {
        return roles.get(username);
    }

    private List<GrantedAuthority> getAuthority(String role) {
        return Collections.singletonList(new SimpleGrantedAuthority(role));
    }
}
