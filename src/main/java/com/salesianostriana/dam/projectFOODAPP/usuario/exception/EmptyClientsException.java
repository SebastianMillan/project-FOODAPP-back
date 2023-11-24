package com.salesianostriana.dam.projectFOODAPP.usuario.exception;

import jakarta.persistence.EntityNotFoundException;

public class EmptyClientsException extends EntityNotFoundException {

    public EmptyClientsException(){
        super("No hay clientes.");
    }
}
