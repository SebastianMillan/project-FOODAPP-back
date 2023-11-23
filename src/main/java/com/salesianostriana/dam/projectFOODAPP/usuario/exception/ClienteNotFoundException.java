package com.salesianostriana.dam.projectFOODAPP.usuario.exception;

import jakarta.persistence.EntityNotFoundException;
import org.hibernate.annotations.NotFound;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.UUID;

public class ClienteNotFoundException extends EntityNotFoundException {

    public ClienteNotFoundException(){
        super("The product could not be found");
    }
    public ClienteNotFoundException(String id){
        super(String.format("The product with the id %s could not be found", id));
    }
}
