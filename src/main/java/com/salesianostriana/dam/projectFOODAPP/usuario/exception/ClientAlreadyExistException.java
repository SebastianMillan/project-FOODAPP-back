package com.salesianostriana.dam.projectFOODAPP.usuario.exception;

public class ClientAlreadyExistException extends RuntimeException{

    public ClientAlreadyExistException (String id){
        super("El cliente con el id: "+id+" ya existe.");
    }
}
