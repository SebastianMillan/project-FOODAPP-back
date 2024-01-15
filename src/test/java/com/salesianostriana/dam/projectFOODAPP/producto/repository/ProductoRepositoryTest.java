package com.salesianostriana.dam.projectFOODAPP.producto.repository;

import com.salesianostriana.dam.projectFOODAPP.categoria.model.Categoria;
import com.salesianostriana.dam.projectFOODAPP.producto.model.Producto;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductoRepositoryTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    ProductoRepository productoRepository;

    @Test
    void findByCategoria(){

        Categoria c = Categoria.builder()
                .id(new UUID(1L, 9L))
                .nombre("Bebida")
                .build();

        Categoria c2 = Categoria.builder()
                .id(new UUID(1L, 9L))
                .nombre("Comida")
                .build();

        Producto p = Producto.builder()
                .id(new UUID(1L, 9L))
                .nombre("coca-cola")
                .build();

        Producto p2 = Producto.builder()
                .id(new UUID(1L, 9L))
                .nombre("Pimientos")
                .build();

        p.setCategoria(c);
        p2.setCategoria(c2);

        testEntityManager.merge(c);
        testEntityManager.merge(c2);
        testEntityManager.merge(p);
        testEntityManager.merge(p2);

        List<Producto> resultado = productoRepository.findByCategoria(c);

        assertEquals(1, resultado.size());


    }

}