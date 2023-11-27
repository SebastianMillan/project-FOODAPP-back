package com.salesianostriana.dam.projectFOODAPP.producto.service;

import com.salesianostriana.dam.projectFOODAPP.categoria.error.CategoryException;
import com.salesianostriana.dam.projectFOODAPP.categoria.model.Categoria;
import com.salesianostriana.dam.projectFOODAPP.categoria.repository.CategoriaRepository;
import com.salesianostriana.dam.projectFOODAPP.pedido.model.LineaPedido;
import com.salesianostriana.dam.projectFOODAPP.producto.dto.EditProductDto;
import com.salesianostriana.dam.projectFOODAPP.producto.exception.EmptyProductListException;
import com.salesianostriana.dam.projectFOODAPP.producto.exception.ProductNotDeleteException;
import com.salesianostriana.dam.projectFOODAPP.producto.exception.ProductoNotFoundException;
import com.salesianostriana.dam.projectFOODAPP.producto.model.Producto;
import com.salesianostriana.dam.projectFOODAPP.producto.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;

    public Producto getMonthProduct() {
        Optional<Producto> result = productoRepository.getProductMonth();
        if (result.isEmpty()) {
            throw new ProductoNotFoundException();
        }
        return result.get();
    }

    public List<Producto> getProductsOnOffer() {
        List<Producto> result = productoRepository.findAll()
                .stream()
                .filter(p -> p.getPrecioOferta() != 0)
                .toList();
        if (result.isEmpty()) {
            throw new EmptyProductListException();
        }
        return result;
    }

    public List<Producto> getProductNews() {
        List<Producto> result = productoRepository.getProductNews();
        if (result.isEmpty()) {
            throw new EmptyProductListException();
        }
        return result;
    }

    public Producto save(EditProductDto nuevo) {

        Producto p = new Producto();

        p.setNombre(nuevo.nombre());
        p.setImagen(nuevo.imagen());
        p.setDescripcion(nuevo.descripcion());
        p.setPrecio(nuevo.precio());
        p.setTags(nuevo.tags());

        Categoria categoria = categoriaRepository.findByNombreIgnoreCase(nuevo.categoria());

        if (categoria == null)
            throw new CategoryException();
        else
            p.setCategoria(categoria);


        return productoRepository.save(p);
    }

    public void delete(String id) {

        int num = productoRepository.comprobarProductoEnLineaPedido(UUID.fromString(id));
        if (num == 0)
            productoRepository.deleteById(UUID.fromString(id));
        else
            throw new ProductNotDeleteException();
    }

    public Producto edit(EditProductDto editProduct, String id) {
        Optional<Producto> p = productoRepository.findById(UUID.fromString(id));

        if (p.isPresent()) {
            Producto edit = p.get();

            edit.setNombre(editProduct.nombre());
            edit.setImagen(editProduct.imagen());
            edit.setDescripcion(editProduct.descripcion());
            edit.setPrecio(editProduct.precio());
            edit.setTags(editProduct.tags());

            Categoria categoria = categoriaRepository.findByNombreIgnoreCase(editProduct.categoria());

            if (categoria == null)
                throw new CategoryException();
            else
                edit.setCategoria(categoria);

            return productoRepository.save(edit);
        }

        throw new ProductoNotFoundException();

    }

    public Producto details (String id){

        Optional<Producto> p = productoRepository.findById(UUID.fromString(id));

        if (p.isPresent())
            return p.get();

        throw new ProductoNotFoundException();

        }

    public List<Producto> getProductGruopByCategory() {
        return productoRepository.findAllGroupByCategoria();
    }
}
