package com.salesianostriana.dam.projectFOODAPP.usuario.model;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SuperBuilder
public class Trabajador extends Usuario {
    private LocalDate fechaNacimiento;
    private TipoTrabajador tipoTrabajador;
}
