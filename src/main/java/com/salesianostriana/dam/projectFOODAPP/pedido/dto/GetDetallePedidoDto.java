package com.salesianostriana.dam.projectFOODAPP.pedido.dto;

import com.salesianostriana.dam.projectFOODAPP.pedido.model.Pedido;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Cliente;

import java.time.LocalTime;

public record GetDetallePedidoDto(

        String id,

        String direccion,

        String telefono,

        String estadoPedido,

        LocalTime horaLlegada,

        String nombreProducto,

        int cantProductos,

        double precioUnitario,

        double subtotal,

        double total
) {

    public static GetDetallePedidoDto of (Pedido p){

        return new GetDetallePedidoDto(
                p.getId().toString(),
                c.getDireccion(),
                c.getTelefono(),
                p.getEstadoPedido().toString(),
                p.getFecha().toLocalTime().plusMinutes(30),
                p.getLineasPedido().stream().map(x -> x.getProducto().getNombre()).toString(),
                p.getLineasPedido().stream().mapToInt(x -> x.getCantidad()).sum(),
                p.getLineasPedido().stream().mapToDouble(x -> x.getPrecioUnitario()).sum(),
                p.getLineasPedido().stream().mapToDouble(ln -> ln.getPrecioUnitario() * ln.getCantidad()).sum(),
                total
        );
    }
}
