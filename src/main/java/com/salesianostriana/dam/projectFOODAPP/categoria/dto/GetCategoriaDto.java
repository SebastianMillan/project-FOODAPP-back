package com.salesianostriana.dam.projectFOODAPP.categoria.dto;

import com.salesianostriana.dam.projectFOODAPP.categoria.model.Categoria;
import jakarta.validation.constraints.NotEmpty;

public record GetCategoriaDto(

        @NotEmpty(message = "{productDto.description.notEmpty}")
        String nombre
) {

    public static GetCategoriaDto of (Categoria c){

        return new GetCategoriaDto(
                c.getNombre()
        );
    }
}
