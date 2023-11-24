package com.salesianostriana.dam.projectFOODAPP.categoria.exception;

public class EmptyCategoriesException extends RuntimeException{

    public EmptyCategoriesException (){
        super("La lista de categorías está vacía.");
    }
}
