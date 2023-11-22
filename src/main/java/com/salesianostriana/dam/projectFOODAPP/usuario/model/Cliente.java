package com.salesianostriana.dam.projectFOODAPP.usuario.model;

import com.salesianostriana.dam.projectFOODAPP.pedido.model.Pedido;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.util.List;

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

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Pedido> pedidos;

}
