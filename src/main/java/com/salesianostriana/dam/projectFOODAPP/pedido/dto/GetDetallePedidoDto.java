package com.salesianostriana.dam.projectFOODAPP.pedido.dto;

import com.salesianostriana.dam.projectFOODAPP.pedido.model.Pedido;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Cliente;

import java.time.LocalTime;
import java.util.List;

public record GetDetallePedidoDto(

        String id,

        String direccion,

        String telefono,

        String estadoPedido,

        LocalTime horaLlegada,

        List<GetLineaPedidoEnDetalle> lineasPedido,

        double total
) {

    public static GetDetallePedidoDto of (Pedido p, double total){

        return new GetDetallePedidoDto(
                p.getId().toString(),
                p.getCliente(),
                p.getCliente(),
                p.getEstadoPedido().toString(),
                p.getFecha().toLocalTime().plusMinutes(30),
                p.getLineasPedido().stream().map(GetLineaPedidoEnDetalle::of).toList(),
                total
        );
    }
}
