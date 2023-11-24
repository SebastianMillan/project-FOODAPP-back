package com.salesianostriana.dam.projectFOODAPP.usuario.dto;

import com.salesianostriana.dam.projectFOODAPP.usuario.model.Trabajador;

import java.time.LocalDate;

public record AltaTrabajadorDto(
        String nombre,
        String email,
        String telefono,
        String username,
        String password,
        String puesto,
        LocalDate fechaNacimiento

) {

    public static AltaTrabajadorDto of (Trabajador trabajador){
        return new AltaTrabajadorDto(
                trabajador.getNombre(),
                trabajador.getEmail(),
                trabajador.getTelefono(),
                trabajador.getUsername(),
                trabajador.getPassword(),
                trabajador.getTipoTrabajador().toString(),
                trabajador.getFechaNacimiento()
        );
    }

}
