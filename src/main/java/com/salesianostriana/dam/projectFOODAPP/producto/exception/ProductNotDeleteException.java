package com.salesianostriana.dam.projectFOODAPP.producto.exception;

import jakarta.persistence.EntityNotFoundException;

public class ProductNotDeleteException extends EntityNotFoundException {

    public ProductNotDeleteException(){
        super ("This product can´t be deleted");
    }
}
