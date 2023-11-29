package com.salesianostriana.dam.projectFOODAPP.pedido.dto;


import ch.qos.logback.core.net.server.Client;
import com.salesianostriana.dam.projectFOODAPP.pedido.model.Pedido;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Cliente;

import java.time.LocalTime;

public record GetPedidoDetallesDTO(

        String id,
        String direccion,

        String telefono,

        String estado,

        LocalTime horaLlegada,

        String nombreProducto,

        int cantidadProductos,

        double precioUnitario,

        double subtotal
) {

    public static GetPedidoDetallesDTO of (Pedido ped, Cliente cl){

        return new GetPedidoDetallesDTO(
                ped.getId().toString(),
                cl.getDireccion(),
                cl.getTelefono(),
                ped.getEstadoPedido().toString(),
                LocalTime.now().plusMinutes(20L),
                ped.getLineasPedido().stream().peek(lineaPedido -> lineaPedido.getProducto().getNombre()).toString(),
                ped.getLineasPedido().stream().mapToInt(cantPr -> cantPr.getCantidad()).sum(),
                ped.getLineasPedido().stream().mapToDouble(precioU -> precioU.getPrecioUnitario()).sum(),
                ped.getLineasPedido().stream().mapToDouble(subtotal -> subtotal.getPrecioUnitario() * subtotal.getCantidad()).sum()
        );
    }
}
