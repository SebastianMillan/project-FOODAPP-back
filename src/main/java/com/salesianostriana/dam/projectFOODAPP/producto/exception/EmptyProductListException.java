package com.salesianostriana.dam.projectFOODAPP.producto.exception;

import jakarta.persistence.EntityNotFoundException;

public class EmptyProductListException extends EntityNotFoundException {
    public EmptyProductListException(){
        super("No product were found");
    }
}
