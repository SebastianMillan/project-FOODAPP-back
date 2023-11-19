package com.salesianostriana.dam.projectFOODAPP.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Producto {
    @GeneratedValue @Id
    private Long id;

    private String nombre;
    private String imagen;
    private String descripcion;
    private double precio;
    private double precioOferta;
    private String[] tags;

    @ManyToOne
    private Categoria categoria;
}
