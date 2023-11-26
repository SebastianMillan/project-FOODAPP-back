package com.salesianostriana.dam.projectFOODAPP.categoria.exception;

public class CategoriaConProductosException extends RuntimeException{

    public CategoriaConProductosException(String nombreCategoria){
        super("La categoria con el nombre: "+nombreCategoria+" no se puede borrar por que" +
                " tiene productos asociados.");
    }
}
