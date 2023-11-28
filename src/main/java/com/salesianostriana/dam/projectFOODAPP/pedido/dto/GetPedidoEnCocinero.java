package com.salesianostriana.dam.projectFOODAPP.pedido.dto;

import com.salesianostriana.dam.projectFOODAPP.pedido.model.Pedido;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

public record GetPedidoEnCocinero(String id, String fecha, String estadoPedido, List<GetLineaPedidoEnPedidoDto> lineasPedido) {

    public static GetPedidoEnCocinero of(Pedido p){
        return new GetPedidoEnCocinero(
                p.getId().toString(),
                p.getFecha().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")),
                p.getEstadoPedido().name(),
                p.getLineasPedido().stream()
                        .map(GetLineaPedidoEnPedidoDto::of)
                        .toList()
        );
    }
}
