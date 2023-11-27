package com.salesianostriana.dam.projectFOODAPP.pedido.dto;

import com.salesianostriana.dam.projectFOODAPP.pedido.model.LineaPedido;

public record GetLineaPedidoEnPedidoDto(String producto, int cantidad) {

    public static GetLineaPedidoEnPedidoDto of(LineaPedido ln){
        return new GetLineaPedidoEnPedidoDto(
                ln.getProducto().getNombre(),
                ln.getCantidad()
        );
    }
}
