package com.salesianostriana.dam.projectFOODAPP.categoria.dto;

import com.salesianostriana.dam.projectFOODAPP.categoria.model.Categoria;

public record GetDtoCategoriaConCantProductos(

        String nombre,

        int cantProductos
) {

    public static GetDtoCategoriaConCantProductos of(Categoria categoria, int cantProductos) {

        return new GetDtoCategoriaConCantProductos(
                categoria.getNombre(),
                cantProductos
        );
    }
}
/*
public static GetAlumnoDto of (Alumno a) {
        return new GetAlumnoDto(a.getId(), a.getNombre() + " " + a.getApellidos(), 0,0 );
    }
 */