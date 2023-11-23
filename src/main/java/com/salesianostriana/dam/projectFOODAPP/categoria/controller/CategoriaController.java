package com.salesianostriana.dam.projectFOODAPP.categoria.controller;

import com.salesianostriana.dam.projectFOODAPP.categoria.dto.GetDtoCategoria;
import com.salesianostriana.dam.projectFOODAPP.categoria.model.Categoria;
import com.salesianostriana.dam.projectFOODAPP.categoria.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categoria")
@RequiredArgsConstructor

public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping("/")

    public List<GetDtoCategoria> getAll(){

        List<Categoria> categorias = categoriaService.getAllCategorias();

        return categorias.stream().map(GetDtoCategoria::of).toList();
    }
}
