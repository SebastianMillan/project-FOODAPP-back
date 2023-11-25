package com.salesianostriana.dam.projectFOODAPP.categoria.error;

import jakarta.persistence.EntityNotFoundException;

public class CategoryException extends EntityNotFoundException {

    public CategoryException(){
        super ("Category not found");
    }
}
