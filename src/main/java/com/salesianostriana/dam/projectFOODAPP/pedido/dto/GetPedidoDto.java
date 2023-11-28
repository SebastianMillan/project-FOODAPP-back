package com.salesianostriana.dam.projectFOODAPP.pedido.dto;

import com.salesianostriana.dam.projectFOODAPP.pedido.model.Pedido;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public record GetPedidoDto(
        String id,
        String fecha,
        String cliente,
        String estadoPedido,
        List<GetLineaPedidoEnPedidoDto> ln,
        double importe
) {

    public static GetPedidoDto of (Pedido p){

        return new GetPedidoDto(
                p.getId().toString(),
                p.getFecha().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")),
                p.getCliente(),
                p.getEstadoPedido().toString(),
                p.getLineasPedido()
                        .stream()
                        .map(GetLineaPedidoEnPedidoDto::of)
                        .toList(),
                p.getLineasPedido().stream().mapToDouble(a -> a.getPrecioUnitario() * a.getCantidad()).sum()
        );
    }
}
