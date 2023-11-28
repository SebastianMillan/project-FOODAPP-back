package com.salesianostriana.dam.projectFOODAPP.pedido.dto;

import com.salesianostriana.dam.projectFOODAPP.pedido.model.Pedido;

public record GetPedidoRepartidorDTO (

        String idCliente,

        String nombreCliente,

        String fecha,

        String estadoPedido,

        String direccion,

        String telefono,

        double importe
){

    public static GetPedidoRepartidorDTO of (Pedido p){
        return new GetPedidoRepartidorDTO(
                p.getCliente().toString(),
                null,
                p.getFecha().toString(),
                p.getEstadoPedido().toString(),
                null,
                null,
                p.getLineasPedido().stream().mapToDouble(x -> x.getPrecioUnitario() * x.getPrecioUnitario()).sum()
        );
    }
}
