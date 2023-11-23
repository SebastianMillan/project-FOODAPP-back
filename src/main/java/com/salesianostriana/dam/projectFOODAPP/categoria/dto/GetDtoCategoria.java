package com.salesianostriana.dam.projectFOODAPP.categoria.dto;

import com.salesianostriana.dam.projectFOODAPP.categoria.model.Categoria;

public record GetDtoCategoria(
        String nombre
) {

    public static GetDtoCategoria of (Categoria categoria){

        return new GetDtoCategoria(
                categoria.getNombre()
        );
    }
}
