package com.salesianostriana.dam.projectFOODAPP.usuario.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UserResponse {

    protected String id;
    protected String username, avatar, fullName;
    protected Set<String> roles;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    protected LocalDateTime createdAt;
    protected int edad;


    public static UserResponse fromUser(Usuario user) {

        return UserResponse.builder()
                .id(user.getId().toString())
                .username(user.getUsername())
                .avatar(user.getAvatar())
                .fullName(user.getNombre())
                .roles(user.getRoles().stream()
                        .map(Enum::name)
                        .collect(Collectors.toSet()))
                .createdAt(user.getCreatedAt())
                .edad(user.getEdad())
                .build();
    }

}
