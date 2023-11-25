package com.salesianostriana.dam.projectFOODAPP.categoria.dto;

import com.salesianostriana.dam.projectFOODAPP.categoria.model.Categoria;

public record GetCategoriaDto(

        String nombre
) {

    public static GetCategoriaDto of (Categoria c){

        return new GetCategoriaDto(
                c.getNombre()
        );
    }
}
