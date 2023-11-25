package com.salesianostriana.dam.projectFOODAPP.producto.repository;

import com.salesianostriana.dam.projectFOODAPP.producto.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductoRepository extends JpaRepository<Producto, UUID> {

    @Query("select p from Producto p order by function('RAND') limit 1")
    Optional<Producto> getProductMonth();

    @Query("select p from Producto p order by function('RAND') limit 6")
    List<Producto> getProductNews();

    @Query("select p from Producto p where p.id = ?1")
    Optional<Producto> findId(UUID id);


}