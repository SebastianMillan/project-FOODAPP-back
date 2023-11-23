package com.salesianostriana.dam.projectFOODAPP.categoria.service;

import com.salesianostriana.dam.projectFOODAPP.categoria.error.EmptyCategoryWithProductsException;
import com.salesianostriana.dam.projectFOODAPP.categoria.repository.CategoriaRepository;
import com.salesianostriana.dam.projectFOODAPP.producto.model.Producto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public List<Producto> getProductsCategory(String nombreCategoria){

        List<Producto> productos = categoriaRepository.productosCategoria(nombreCategoria);

        if(productos.isEmpty())
            throw new EmptyCategoryWithProductsException();
        else
            return productos;
    }

}
