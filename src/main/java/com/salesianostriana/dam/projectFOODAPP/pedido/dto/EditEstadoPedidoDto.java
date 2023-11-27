package com.salesianostriana.dam.projectFOODAPP.pedido.dto;

import jakarta.validation.constraints.NotBlank;

public record EditEstadoPedidoDto(
        @NotBlank(message = "{editEstadoPedido.estadoPedido.message}")
        String estadoPedido
) { }
