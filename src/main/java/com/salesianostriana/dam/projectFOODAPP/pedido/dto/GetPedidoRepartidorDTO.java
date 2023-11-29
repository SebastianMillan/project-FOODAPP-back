package com.salesianostriana.dam.projectFOODAPP.pedido.dto;

import ch.qos.logback.core.net.server.Client;
import com.salesianostriana.dam.projectFOODAPP.pedido.model.Pedido;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Cliente;

import java.time.format.DateTimeFormatter;

public record GetPedidoRepartidorDTO (

        String idPedido,

        String nombreCliente,

        String fecha,

        String estadoPedido,

        String direccion,

        String telefono,

        double importe
){
/*
    public static GetPedidoRepartidorDTO of (Pedido p){
        return new GetPedidoRepartidorDTO(
                p.getId().toString(),
                null,
                p.getFecha().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")),
                p.getEstadoPedido().toString(),
                null,
                null,
                p.getLineasPedido().stream().mapToDouble(x -> x.getPrecioUnitario() * x.getPrecioUnitario()).sum()
        );
    }

 */
}
