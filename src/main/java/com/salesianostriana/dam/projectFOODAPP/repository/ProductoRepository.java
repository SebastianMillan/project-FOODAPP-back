package com.salesianostriana.dam.projectFOODAPP.repository;

import com.salesianostriana.dam.projectFOODAPP.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}