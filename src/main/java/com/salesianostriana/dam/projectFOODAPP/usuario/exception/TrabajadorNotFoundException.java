package com.salesianostriana.dam.projectFOODAPP.usuario.exception;

import jakarta.persistence.EntityNotFoundException;

public class TrabajadorNotFoundException extends EntityNotFoundException {

    public  TrabajadorNotFoundException(){
        super("El trabajador no ha sido encontrado");
    }

    public TrabajadorNotFoundException(String id){
        super(String.format("El trabajador con id %s no ha sido encontrado", id));
    }
}
