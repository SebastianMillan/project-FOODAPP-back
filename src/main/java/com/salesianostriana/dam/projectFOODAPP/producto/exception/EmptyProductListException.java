package com.salesianostriana.dam.projectFOODAPP.producto.exception;

import jakarta.persistence.EntityNotFoundException;

public class EmptyProductListException extends RuntimeException {
    public EmptyProductListException(){
        super("No product were found");
    }
}
