package com.salesianostriana.dam.projectFOODAPP.producto.service;

import com.salesianostriana.dam.projectFOODAPP.producto.dto.EditProductDto;
import com.salesianostriana.dam.projectFOODAPP.producto.exception.EmptyProductListException;
import com.salesianostriana.dam.projectFOODAPP.producto.exception.ProductoNotFoundException;
import com.salesianostriana.dam.projectFOODAPP.producto.model.Producto;
import com.salesianostriana.dam.projectFOODAPP.producto.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;

    public Producto getMonthProduct(){
        Optional<Producto> result = productoRepository.getProductMonth();
        if(result.isEmpty()){
            throw new ProductoNotFoundException();
        }
        return result.get();
    }

    public List<Producto> getProductsOnOffer(){
        List<Producto> result = productoRepository.findAll()
                .stream()
                .filter(p -> p.getPrecioOferta()!=0)
                .toList();
        if(result.isEmpty()){
            throw new EmptyProductListException();
        }
        return result;
    }

    public List<Producto> getProductNews(){
        List<Producto> result = productoRepository.getProductNews();
        if(result.isEmpty()){
            throw new EmptyProductListException();
        }
        return result;
    }

    public Producto save (EditProductDto nuevo){

        Producto p = new Producto();

        p.setNombre(nuevo.nombre());
    }

}
