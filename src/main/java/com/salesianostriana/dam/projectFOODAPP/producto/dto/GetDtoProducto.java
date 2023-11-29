package com.salesianostriana.dam.projectFOODAPP.producto.dto;
import com.fasterxml.jackson.annotation.JsonView;
import com.salesianostriana.dam.projectFOODAPP.View.MenuProductosView;
import com.salesianostriana.dam.projectFOODAPP.View.ProductView;
import com.salesianostriana.dam.projectFOODAPP.categoria.dto.GetCategoriaDto;
import com.salesianostriana.dam.projectFOODAPP.categoria.dto.GetCategoriaProductsDto;
import com.salesianostriana.dam.projectFOODAPP.producto.model.Producto;

import java.util.UUID;

public record GetDtoProducto(
        String id,
        @JsonView({ProductView.editProduct.class, MenuProductosView.menu.class})
        String nombre,
        @JsonView({ProductView.editProduct.class, MenuProductosView.menu.class})
        String imagen,
        @JsonView({ProductView.editProduct.class, MenuProductosView.menu.class})
        String descripcion,
        @JsonView({ProductView.editProduct.class, MenuProductosView.menu.class})
        double precio,
        @JsonView({ProductView.editProduct.class, MenuProductosView.menu.class})
        String[] tags,
        @JsonView({ProductView.editProduct.class})
        GetCategoriaDto categoria

) {

    public static GetDtoProducto of(Producto p){
        return new GetDtoProducto(
                p.getId().toString(),
                p.getNombre(),
                p.getImagen(),
                p.getDescripcion(),
                p.getPrecioOferta()!=0?p.getPrecioOferta():p.getPrecio(),
                p.getTags(),
                GetCategoriaDto.of(p.getCategoria())

        );
    }
}
