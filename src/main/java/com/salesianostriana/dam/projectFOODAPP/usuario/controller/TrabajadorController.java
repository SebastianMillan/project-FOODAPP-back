package com.salesianostriana.dam.projectFOODAPP.usuario.controller;

import com.salesianostriana.dam.projectFOODAPP.categoria.service.CategoriaService;
import com.salesianostriana.dam.projectFOODAPP.producto.dto.GetProductShortDto;
import com.salesianostriana.dam.projectFOODAPP.producto.model.Producto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/trabajador")
public class TrabajadorController {

    private final CategoriaService categoriaService;

    @GetMapping("/producto/{nombreCategoria}")
    public List<GetProductShortDto> getProductoCategory (@PathVariable String nombreCategoria){

        List<Producto> productos = categoriaService.getProductsCategory(nombreCategoria);

        return productos.stream()
                .map(GetProductShortDto::of)
                .toList();
    }
}
