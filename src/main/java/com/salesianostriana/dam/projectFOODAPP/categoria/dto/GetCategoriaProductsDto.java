package com.salesianostriana.dam.projectFOODAPP.categoria.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.salesianostriana.dam.projectFOODAPP.View.MenuProductosView;
import com.salesianostriana.dam.projectFOODAPP.View.ProductView;
import com.salesianostriana.dam.projectFOODAPP.producto.dto.GetDtoProducto;

import java.util.List;

public record GetCategoriaProductsDto(
        @JsonView({MenuProductosView.menu.class})
        String nombre,
        @JsonView({MenuProductosView.menu.class})
        List<GetDtoProducto> productos){



}




