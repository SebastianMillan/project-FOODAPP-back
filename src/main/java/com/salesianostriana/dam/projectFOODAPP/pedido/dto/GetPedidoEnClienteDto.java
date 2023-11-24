package com.salesianostriana.dam.projectFOODAPP.pedido.dto;

import com.salesianostriana.dam.projectFOODAPP.pedido.model.Pedido;

public record GetPedidoEnClienteDto(String id, String fecha, String estadoPedido, double importeTotal) {
    public static GetPedidoEnClienteDto of(Pedido p){
        return new GetPedidoEnClienteDto(
                p.getId().toString(),
                p.getFecha().toString(),
                p.getEstadoPedido().name(),
                p.getLineasPedido().stream()
                        .mapToDouble(ln -> ln.getPrecioUnitario()*ln.getCantidad())
                        .sum()

        );

    }
}
