package com.salesianostriana.dam.projectFOODAPP.usuario.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUserRequest {

    private String username;
    private String password;
    private String verifyPassword;
    private String avatar;
    private String fullName;
    private int edad;

}