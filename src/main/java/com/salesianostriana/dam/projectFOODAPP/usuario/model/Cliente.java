package com.salesianostriana.dam.projectFOODAPP.usuario.model;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@SuperBuilder
@NoArgsConstructor
public class Cliente extends Usuario {

    private int pin;
    private String direccion;
    private String codPostal;
    private String poblacion;
    private String provincia;
    private int puntos;

}
