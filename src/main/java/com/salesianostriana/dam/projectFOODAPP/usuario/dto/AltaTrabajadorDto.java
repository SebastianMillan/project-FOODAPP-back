package com.salesianostriana.dam.projectFOODAPP.usuario.dto;

import com.salesianostriana.dam.projectFOODAPP.usuario.model.Trabajador;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AltaTrabajadorDto(
        @NotEmpty
        String nombre,

        @Email
        String email,
        String telefono,

        @NotEmpty
        String username,
        String password,

        @NotEmpty
        String puesto,

        @NotNull
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
