package com.salesianostriana.dam.projectFOODAPP.categoria.dto;

import com.salesianostriana.dam.projectFOODAPP.categoria.model.Categoria;

public record GetDtoCategoria(

        String nombre,

        int cantProductos
) {

    public static GetDtoCategoria of(Categoria categoria, int cantProductos) {

        return new GetDtoCategoria(
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