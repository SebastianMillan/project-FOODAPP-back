package com.salesianostriana.dam.projectFOODAPP.pedido.dto;

import com.salesianostriana.dam.projectFOODAPP.pedido.model.Pedido;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Cliente;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public record GetDetallePedidoDto(

        String id,

        String direccion,

        String telefono,

        String estadoPedido,

        String horaLlegada,

        List<GetLineaPedidoEnDetalle> lineasPedido,

        double total
) {
/*
    public static GetDetallePedidoDto of (Pedido p){

        return new GetDetallePedidoDto(
                p.getId().toString(),
                //p.getCliente(),
                //p.getCliente(),
                null,
                null,
                p.getEstadoPedido().toString(),
                p.getFecha().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")),
                p.getLineasPedido().stream().map(GetLineaPedidoEnDetalle::of).toList(),
                p.getLineasPedido().stream().mapToDouble(x -> x.getPrecioUnitario() * x.getCantidad()).sum()

        );
    }
    */
}
