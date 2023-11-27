package com.salesianostriana.dam.projectFOODAPP.pedido.exception;

import jakarta.persistence.EntityNotFoundException;

public class PedidoNotFoundException extends EntityNotFoundException {
    public PedidoNotFoundException(){
        super("The pedido could not be found");
    }
    public PedidoNotFoundException(String id){
        super(String.format("The pedido with the id %s could not be found", id));
    }
}
