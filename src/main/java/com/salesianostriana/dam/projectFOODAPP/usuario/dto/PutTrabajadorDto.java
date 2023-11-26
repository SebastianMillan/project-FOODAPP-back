package com.salesianostriana.dam.projectFOODAPP.usuario.dto;

import com.salesianostriana.dam.projectFOODAPP.usuario.model.TipoTrabajador;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Trabajador;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PutTrabajadorDto(
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
    public static Trabajador from (PutTrabajadorDto t){
        return Trabajador.builder()
                .nombre(t.nombre)
                .email(t.email)
                .telefono(t.telefono)
                .username(t.username)
                .password(t.password)
                .tipoTrabajador(TipoTrabajador.valueOf(t.puesto))
                .fechaNacimiento(t.fechaNacimiento)
                .build();


    }
}
