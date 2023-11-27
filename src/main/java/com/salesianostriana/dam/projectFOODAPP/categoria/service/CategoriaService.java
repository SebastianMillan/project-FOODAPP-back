package com.salesianostriana.dam.projectFOODAPP.categoria.service;


import com.salesianostriana.dam.projectFOODAPP.categoria.dto.GetCategoriaDto;
import com.salesianostriana.dam.projectFOODAPP.categoria.dto.GetCategoriaProductsDto;
import com.salesianostriana.dam.projectFOODAPP.categoria.error.EmptyCategoryWithProductsException;
import com.salesianostriana.dam.projectFOODAPP.categoria.exception.CategoriaConProductosException;
import com.salesianostriana.dam.projectFOODAPP.categoria.exception.CategoriaNotFoundException;
import com.salesianostriana.dam.projectFOODAPP.categoria.exception.EmptyCategoriesException;
import com.salesianostriana.dam.projectFOODAPP.categoria.model.Categoria;
import com.salesianostriana.dam.projectFOODAPP.categoria.repository.CategoriaRepository;
import com.salesianostriana.dam.projectFOODAPP.producto.dto.GetDtoProducto;
import com.salesianostriana.dam.projectFOODAPP.producto.model.Producto;
import com.salesianostriana.dam.projectFOODAPP.producto.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final ProductoRepository productoRepository;

    public List<Producto> getProductsCategory(String nombreCategoria){

        List<Producto> productos = categoriaRepository.productosCategoriaIgnoreCase(nombreCategoria.toLowerCase());

        if(productos.isEmpty())
            throw new EmptyCategoryWithProductsException();
        else
            return productos;
    }

    public List<Categoria> getAllCategorias(){

        List<Categoria> categorias =  categoriaRepository.findAll();

        if (categorias.isEmpty())
            throw new EmptyCategoriesException();

        return categorias;
    }

    public int contarCantidadProductosDeUnaCategoria(UUID categoriaId){

        return categoriaRepository.contarCantidadProductosDeUnaCategoria(categoriaId);

    }

    public Categoria createCategoria (GetCategoriaDto nuevaCategoria){

        Categoria cat = new Categoria();

        cat.setNombre(nuevaCategoria.nombre());

        return categoriaRepository.save(cat);
    }

    public Categoria editCategoria (GetCategoriaDto editCategoria, String nombreCategoria){

        Categoria cat = categoriaRepository.buscarCategoriaPorNombre(nombreCategoria)
                .orElseThrow(() -> new CategoriaNotFoundException(nombreCategoria));

        cat.setNombre(editCategoria.nombre());

        return categoriaRepository.save(cat);

    }

    public void deleteCategoria (String nombreCategoria) {

        Categoria cat = categoriaRepository.findByNombreIgnoreCase(nombreCategoria);
        int cantProductos = categoriaRepository.contarCantidadProductosDeUnaCategoriaByNombre(nombreCategoria);

        if (cat == null)
            throw new CategoriaNotFoundException(nombreCategoria);

        if (cantProductos == 0)
            categoriaRepository.delete(cat);
        else
            throw new CategoriaConProductosException(nombreCategoria);
    }

//    public Map<Categoria, List<Producto>> getProductosByCategoria() {
//        List<Categoria> categorias = getAllCategorias();
//        Map<Categoria, List<Producto>> productosByCategoria = new HashMap<>();
//
//        for (Categoria categoria : categorias) {
//            List<Producto> productos = productoRepository.findByCategoria(categoria);
//            productosByCategoria.put(categoria, productos);
//        }
//
//        return productosByCategoria;
//    }








}
