package com.salesianostriana.dam.projectFOODAPP.usuario.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

public record EditLoggedUserDto(

        @NotEmpty(message = "{loggedUser.name.notEmpty}")
        String nombre,
        @Email(message = "{loggedUser.email}")
        String email,
        String telefono,
        @URL(message = "{loggedUser.url}")
        String avatar,
        String direccion,
        String codPostal,
        String poblacion
) {}
