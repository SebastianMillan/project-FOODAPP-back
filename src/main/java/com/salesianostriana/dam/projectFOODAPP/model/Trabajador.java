package com.salesianostriana.dam.projectFOODAPP.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SuperBuilder
public class Trabajador extends  Usuario{
    private LocalDate fechaNacimiento;
    private TipoTrabajador tipoTrabajador;
}
