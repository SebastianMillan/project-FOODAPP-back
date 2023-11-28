package com.salesianostriana.dam.projectFOODAPP.pedido.dto;

public record GetPedidoRepartidorDTO (

        String idCliente,

        String nombreCliente,

        String fecha,

        String estadoPedido,

        String direccion,

        String telefono,

        double importe
){

}
