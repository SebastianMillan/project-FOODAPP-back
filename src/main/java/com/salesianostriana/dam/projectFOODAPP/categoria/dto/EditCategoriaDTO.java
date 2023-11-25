package com.salesianostriana.dam.projectFOODAPP.categoria.dto;

import jakarta.validation.constraints.NotEmpty;

public record EditCategoriaDTO (
        @NotEmpty(message = "{productDto.description.notEmpty}")
        String nombre
){
}
