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
import com.salesianostriana.dam.projectFOODAPP.producto.dto.GetProductShortDto;
import com.salesianostriana.dam.projectFOODAPP.producto.model.Producto;
import com.salesianostriana.dam.projectFOODAPP.producto.repository.ProductoRepository;
import com.salesianostriana.dam.projectFOODAPP.usuario.exception.ClienteNotFoundException;
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

    public Categoria editCategoria (GetCategoriaDto editCategoria, UUID idCategoria) {

        Categoria cat = categoriaRepository.findById(idCategoria)
                .orElseThrow(() -> new CategoriaNotFoundException(idCategoria.toString()));

        cat.setNombre(editCategoria.nombre());

        return categoriaRepository.save(cat);

    }

    public void deleteCategoria (UUID idCategoria) {

        Categoria cat = categoriaRepository.findById(idCategoria).
                orElseThrow(() -> new ClienteNotFoundException(idCategoria.toString()));

        int cantProductos = categoriaRepository.contarCantidadProductosDeUnaCategoria(idCategoria);

        if (cantProductos == 0)
            categoriaRepository.delete(cat);
        else
            throw new CategoriaConProductosException(idCategoria.toString());
    }

    public List<GetCategoriaProductsDto> categoryWithProductsV2() {
        List<GetCategoriaProductsDto> getProductDtos = new ArrayList<>();

        List<Categoria> categorias = categoriaRepository.findAll();
        for (Categoria categoria : categorias) {
            List<Producto> productos = productoRepository.findByCategoriaId(categoria.getId());
            List<GetDtoProducto> dtoProductos = new ArrayList<>();

            for (Producto producto : productos) {
                GetDtoProducto dtoProducto = GetDtoProducto.of(producto);
                dtoProductos.add(dtoProducto);
            }

            GetCategoriaProductsDto dto = new GetCategoriaProductsDto(categoria.getNombre(), dtoProductos);
            getProductDtos.add(dto);
        }

        return getProductDtos;
    }



}
