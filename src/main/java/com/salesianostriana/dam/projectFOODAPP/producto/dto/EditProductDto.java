package com.salesianostriana.dam.projectFOODAPP.producto.dto;

public record EditProductDto(

        String nombre,
        String imagen,
        String descripcion,
        double precio,
        double descuento,
        String[] tags

) {


}
