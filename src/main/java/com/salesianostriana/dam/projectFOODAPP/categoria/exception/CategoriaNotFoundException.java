package com.salesianostriana.dam.projectFOODAPP.categoria.exception;

import jakarta.persistence.EntityNotFoundException;

public class CategoriaNotFoundException extends EntityNotFoundException {

    public CategoriaNotFoundException(String id){
        super("No se ha encontrado la categoría con el id: "+id);
    }
}
