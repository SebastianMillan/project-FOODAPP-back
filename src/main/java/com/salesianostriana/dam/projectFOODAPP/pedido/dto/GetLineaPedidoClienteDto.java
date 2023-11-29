package com.salesianostriana.dam.projectFOODAPP.pedido.dto;

import com.salesianostriana.dam.projectFOODAPP.pedido.model.LineaPedido;

public record GetLineaPedidoClienteDto(

        String idPedido,
        String producto,
        double precioUnitario,
        int cantidad,
        double subtotal

) {
    public static GetLineaPedidoClienteDto of (LineaPedido lp){
        return new GetLineaPedidoClienteDto(
                lp.getPedido().getId().toString(),
                lp.getProducto().getNombre(),
                lp.getPrecioUnitario(),
                lp.getCantidad(),
                lp.getPrecioUnitario() * lp.getCantidad()
        );
    }
}
