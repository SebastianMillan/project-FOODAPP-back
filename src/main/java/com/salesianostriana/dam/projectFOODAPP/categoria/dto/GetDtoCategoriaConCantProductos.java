package com.salesianostriana.dam.projectFOODAPP.categoria.dto;

import com.salesianostriana.dam.projectFOODAPP.categoria.model.Categoria;

public record GetDtoCategoriaConCantProductos(

        String id,

        String nombre,

        int cantProductos
) {

    public static GetDtoCategoriaConCantProductos of(Categoria categoria, int cantProductos) {

        return new GetDtoCategoriaConCantProductos(
                categoria.getId().toString(),
                categoria.getNombre(),
                cantProductos
        );
    }
}