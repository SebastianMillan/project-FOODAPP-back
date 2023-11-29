package com.salesianostriana.dam.projectFOODAPP.pedido.exception;

import jakarta.persistence.EntityNotFoundException;

public class PedidoNotFoundException extends EntityNotFoundException {
    public PedidoNotFoundException() {
        super("El pedido que estás intentando buscar no existe.");
    }
}
