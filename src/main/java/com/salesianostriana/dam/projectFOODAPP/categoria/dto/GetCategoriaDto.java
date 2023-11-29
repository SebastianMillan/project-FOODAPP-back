package com.salesianostriana.dam.projectFOODAPP.categoria.dto;

import com.salesianostriana.dam.projectFOODAPP.categoria.model.Categoria;
import jakarta.validation.constraints.NotEmpty;

public record GetCategoriaDto(

        String id,
        @NotEmpty(message = "GetCategoriaDto.nombre.notEmpty}")
        String nombre
) {

    public static GetCategoriaDto of (Categoria c){

        return new GetCategoriaDto(
                c.getId().toString(),
                c.getNombre()
        );
    }
}
