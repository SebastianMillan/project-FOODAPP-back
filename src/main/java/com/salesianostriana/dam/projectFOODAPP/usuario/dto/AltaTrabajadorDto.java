package com.salesianostriana.dam.projectFOODAPP.usuario.dto;

import com.salesianostriana.dam.projectFOODAPP.usuario.model.Trabajador;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AltaTrabajadorDto(
        @NotEmpty(message = "{altaTrabajadorDto.name.notEmpty}")
        String nombre,

        @Email(message = "{altaTrabajdorDto.email.notValid}")
        String email,
        String telefono,

        @NotEmpty(message = "{altaTrabajadorDto.userName.NotEmpty}")
        String username,
        @NotEmpty(message = "{altaTrabajdorDto.password.notEmpty}")
        String password,

        @NotEmpty(message = "{altaTrabajadorDto.puesto.notEmpty}")
        String puesto,

        @NotNull(message = "{altaTrabajadorDto.fecha.notNull}")
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
