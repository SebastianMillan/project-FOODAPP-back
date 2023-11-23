package com.salesianostriana.dam.projectFOODAPP.pedido.dto;
import com.salesianostriana.dam.projectFOODAPP.pedido.model.EstadoPedido;
import com.salesianostriana.dam.projectFOODAPP.pedido.model.Pedido;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Cliente;

import java.time.LocalDateTime;

public record GetHistorialDTO (

        String cliente,
        LocalDateTime fecha,

        double importeTotal,

        String estadoPedido
){

    public static GetHistorialDTO of (Pedido ped, double importeTotal){

        return new GetHistorialDTO(
                ped.getCliente(),
                ped.getFecha(),
                importeTotal,
                ped.getEstadoPedido().toString()
        );
    }

}
