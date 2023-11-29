package com.salesianostriana.dam.projectFOODAPP.usuario.dto;

import com.salesianostriana.dam.projectFOODAPP.usuario.model.Trabajador;

import java.time.LocalDate;

public record TrabajadorLoggedDto(
        String id,
        String nombre,

        String email,

        String telefono,

        String username,

        String puesto,

        String rol,

        LocalDate fechaNacimiento

) {
    public static TrabajadorLoggedDto of (Trabajador trabajador){
        return  new TrabajadorLoggedDto(
                trabajador.getId().toString(),
                trabajador.getNombre(),
                trabajador.getEmail(),
                trabajador.getTelefono(),
                trabajador.getUsername(),
                trabajador.getTipoTrabajador().toString(),
                trabajador.getRoles().toString(),
                trabajador.getFechaNacimiento()
        );
    }
}
