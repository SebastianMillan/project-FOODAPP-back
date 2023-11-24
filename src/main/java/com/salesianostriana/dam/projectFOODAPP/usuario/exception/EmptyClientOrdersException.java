package com.salesianostriana.dam.projectFOODAPP.usuario.exception;

public class EmptyClientOrdersException extends RuntimeException{
    public EmptyClientOrdersException(){
        super("No orders were found");
    }
}
