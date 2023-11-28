package com.salesianostriana.dam.projectFOODAPP.pedido.dto;

import com.salesianostriana.dam.projectFOODAPP.pedido.model.LineaPedido;

public record GetLineaPedidoEnDetalle (

        String nombreProducto,

        int cantidadProductos,

        double precioUnit,

        double subtotal

){

    public static GetLineaPedidoEnDetalle of (LineaPedido ln){

        return new GetLineaPedidoEnDetalle(
                ln.getProducto().getNombre(),
                ln.getCantidad(),
                ln.getPrecioUnitario(),
                ln.getCantidad() * ln.getPrecioUnitario()
        );
    }
}
