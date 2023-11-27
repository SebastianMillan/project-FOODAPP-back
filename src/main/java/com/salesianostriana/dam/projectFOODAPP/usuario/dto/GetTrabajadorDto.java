package com.salesianostriana.dam.projectFOODAPP.usuario.dto;

import com.salesianostriana.dam.projectFOODAPP.usuario.model.TipoTrabajador;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Trabajador;

import java.time.LocalDate;
import java.util.Date;

public record GetTrabajadorDto(

        String id,
        String nombre,

        String email,

        String telefono,

        String username,

        String password,

        String puesto,

        LocalDate fechaNacimiento

) {

    public static GetTrabajadorDto of (Trabajador trabajador){
        return  new GetTrabajadorDto(
                trabajador.getId().toString(),
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
