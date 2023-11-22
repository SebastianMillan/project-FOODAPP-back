package com.salesianostriana.dam.projectFOODAPP.pedido.exception;
public class EmptyHistorialException extends RuntimeException{

    public EmptyHistorialException(){
        super("La lista de pedidos esta vacía");
    }
}
