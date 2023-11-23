package com.salesianostriana.dam.projectFOODAPP.categoria.error;

import jakarta.persistence.EntityNotFoundException;

public class EmptyCategoryWithProductsException extends EntityNotFoundException {

    public EmptyCategoryWithProductsException(){
        super("This category does not contain any products");
    }
}
