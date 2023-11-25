package com.salesianostriana.dam.projectFOODAPP.usuario.exception;

public class EmptyClienteListException extends RuntimeException{
    public EmptyClienteListException(){
        super("No clients were found");
    }

}
