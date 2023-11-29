package com.salesianostriana.dam.projectFOODAPP.pedido.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.salesianostriana.dam.projectFOODAPP.pedido.model.Pedido;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public record GetPedidoDto(
        String id,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime fecha,
        String cliente,
        String estadoPedido,
        double importe
) {

    public static GetPedidoDto of (Pedido p){

        return new GetPedidoDto(
                p.getId().toString(),
                p.getFecha(),
                p.getCliente(),
                p.getEstadoPedido().toString(),
                p.getLineasPedido().stream().mapToDouble(a -> a.getPrecioUnitario() * a.getCantidad()).sum()
        );
    }
}
