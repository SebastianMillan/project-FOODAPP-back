package com.salesianostriana.dam.projectFOODAPP.pedido.exception;

import jakarta.persistence.EntityNotFoundException;

public class LineaPedidoNotFoundException extends EntityNotFoundException {

    public LineaPedidoNotFoundException() {
        super("La Linea de Pedido no existe");
    }

}
