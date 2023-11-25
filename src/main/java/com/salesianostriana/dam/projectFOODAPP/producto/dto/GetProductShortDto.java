package com.salesianostriana.dam.projectFOODAPP.producto.dto;

import com.salesianostriana.dam.projectFOODAPP.producto.model.Producto;
import jakarta.validation.constraints.NotEmpty;

import java.util.UUID;

public record GetProductShortDto(UUID id, String nombre, String imagen, @NotEmpty(message = "{productDto.description.notEmpty}") String descripcion, double precio) {

    public static GetProductShortDto of(Producto p){
        return new GetProductShortDto(
                p.getId(),
                p.getNombre(),
                p.getImagen(),
                p.getDescripcion(),
                p.getPrecioOferta()!=0?p.getPrecioOferta():p.getPrecio()
        );
    }
}
