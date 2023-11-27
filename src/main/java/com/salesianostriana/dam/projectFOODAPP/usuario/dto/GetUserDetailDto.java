package com.salesianostriana.dam.projectFOODAPP.usuario.dto;

import com.salesianostriana.dam.projectFOODAPP.usuario.model.Usuario;

import java.util.Set;
import java.util.stream.Collectors;

public record GetUserDetailDto(String id, String username, String nombre, String email, String telefono, String avatar, Set<String> roles) {

    public static GetUserDetailDto of(Usuario u){
        return new GetUserDetailDto(
                u.getId().toString(),
                u.getUsername(),
                u.getNombre(),
                u.getEmail(),
                u.getTelefono(),
                u.getAvatar(),
                u.getRoles().stream()
                        .map(Enum::name)
                        .collect(Collectors.toSet())

        );
    }
}
