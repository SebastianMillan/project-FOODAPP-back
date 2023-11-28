package com.salesianostriana.dam.projectFOODAPP.producto.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.salesianostriana.dam.projectFOODAPP.View.ProductView;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

public record EditProductDto(

        @NotEmpty(message = "{productDto.name.notEmpty}")
        String nombre,
        @URL(message = "{productDto.url}")
        String imagen,
        String descripcion,
        @Min(value = 0, message = "{productDto.price.min}")
        double precio,
        String[] tags,
        @NotEmpty(message = "{productDto.description.notEmpty}")
        String categoria

) {


}
