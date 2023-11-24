package com.salesianostriana.dam.projectFOODAPP.usuario.exception;

public class TrabajadoresListEmptyException extends RuntimeException{

    public TrabajadoresListEmptyException(){
        super( "Lista de trabajadores esta vacia");
    }
}
