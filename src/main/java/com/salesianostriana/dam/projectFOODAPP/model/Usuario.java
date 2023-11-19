package com.salesianostriana.dam.projectFOODAPP.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@MappedSuperclass
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements Serializable {
    @GeneratedValue @Id
    private Long id;

    private String username;
    private String password;
    private String nombre;
    private String email;
    private String telefono;
}
