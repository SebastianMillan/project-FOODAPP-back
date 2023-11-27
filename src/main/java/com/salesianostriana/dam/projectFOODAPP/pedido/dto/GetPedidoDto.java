package com.salesianostriana.dam.projectFOODAPP.pedido.dto;

import com.salesianostriana.dam.projectFOODAPP.pedido.model.Pedido;

import java.time.LocalDateTime;
import java.util.List;

public record GetPedidoDto(
        String id,
        LocalDateTime fecha,
        String cliente,
        String estadoPedido,
        List<GetLineaPedidoEnPedidoDto> ln
) {

    public static GetPedidoDto of (Pedido p){

        return new GetPedidoDto(
                p.getId().toString(),
                p.getFecha(),
                p.getCliente(),
                p.getEstadoPedido().toString(),
                p.getLineasPedido()
                        .stream()
                        .map(GetLineaPedidoEnPedidoDto::of)
                        .toList()
        );
    }
}
