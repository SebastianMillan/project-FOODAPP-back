package com.salesianostriana.dam.projectFOODAPP.controllerTest.controller;


import com.salesianostriana.dam.projectFOODAPP.usuario.model.RolUsuario;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Usuario;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.List;
import java.util.Set;

@TestConfiguration

class SecurityTestConfig {

    @Bean("customUserDetailsService")
    @Primary
    public UserDetailsService userDetailsService(){
        Usuario admin = Usuario.builder()
                .username("admin")
                .password("1234")
                .roles(Set.of(RolUsuario.ADMIN))
                .build();
        return new InMemoryUserDetailsManager(List.of(admin));
    }
}

