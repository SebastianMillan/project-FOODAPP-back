package com.salesianostriana.dam.projectFOODAPP.categoria.exception;

import com.salesianostriana.dam.projectFOODAPP.categoria.model.Categoria;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;

import java.net.URI;
import java.sql.Timestamp;
import java.time.Instant;

public class EmptyCategoriesException extends ErrorResponseException {

    public EmptyCategoriesException (){
        super(HttpStatus.NOT_FOUND, of("No hay categorías existentes."), null);
    }

    public static ProblemDetail of (String mensaje){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, mensaje);
        problemDetail.setTitle("No hay categorías.");
        problemDetail.setType(URI.create("https://api.midominio.com/errors/not-found"));
        problemDetail.setProperty("entityType", "Categoría");
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }
}