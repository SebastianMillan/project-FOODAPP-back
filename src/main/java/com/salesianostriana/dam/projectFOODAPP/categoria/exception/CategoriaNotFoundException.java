package com.salesianostriana.dam.projectFOODAPP.categoria.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;

import java.net.URI;
import java.time.Instant;

public class CategoriaNotFoundException extends EntityNotFoundException {

    public CategoriaNotFoundException(String nombreCategoria){
        super("No se ha encontrado la categoría con el nombre: "+nombreCategoria);
    }
}