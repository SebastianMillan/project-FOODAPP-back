package com.salesianostriana.dam.projectFOODAPP.categoria.dto;

import com.salesianostriana.dam.projectFOODAPP.producto.dto.GetDtoProducto;

import java.util.List;

public record GetCategoriaProductsDto(   String nombre,
        List<GetDtoProducto> productos){



}




