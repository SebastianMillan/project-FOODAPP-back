package com.salesianostriana.dam.projectFOODAPP.categoria.service;

import com.salesianostriana.dam.projectFOODAPP.categoria.exception.EmptyCategoriesException;
import com.salesianostriana.dam.projectFOODAPP.categoria.model.Categoria;
import com.salesianostriana.dam.projectFOODAPP.categoria.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public List<Categoria> getAllCategorias(){

        List<Categoria> categorias =  categoriaRepository.findAll();

        if (categorias.isEmpty())
            throw new EmptyCategoriesException();

        return categorias;
    }

    public int contarCantidadProductosDeUnaCategoria(UUID categoriaId){

        return categoriaRepository.contarCantidadProductosDeUnaCategoria(categoriaId);

    }
}
