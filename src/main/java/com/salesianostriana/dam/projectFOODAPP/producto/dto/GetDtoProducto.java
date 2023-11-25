package com.salesianostriana.dam.projectFOODAPP.producto.dto;

import com.salesianostriana.dam.projectFOODAPP.categoria.dto.GetCategoriaDto;
import com.salesianostriana.dam.projectFOODAPP.categoria.dto.GetDtoCategoria;
import com.salesianostriana.dam.projectFOODAPP.categoria.model.Categoria;
import com.salesianostriana.dam.projectFOODAPP.producto.model.Producto;

import java.util.UUID;

public record GetDtoProducto(
        UUID id,
        String nombre,
        String imagen,
        String descripcion,
        double precio,
        String[] tags,
        GetCategoriaDto categoria

) {

    public static GetDtoProducto of(Producto p){
        return new GetDtoProducto(
                p.getId(),
                p.getNombre(),
                p.getImagen(),
                p.getDescripcion(),
                p.getPrecioOferta()!=0?p.getPrecioOferta():p.getPrecio(),
                p.getTags(),
                GetCategoriaDto.of(p.getCategoria())
        );
    }
}
