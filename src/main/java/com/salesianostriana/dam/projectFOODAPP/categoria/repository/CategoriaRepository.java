package com.salesianostriana.dam.projectFOODAPP.categoria.repository;

import com.salesianostriana.dam.projectFOODAPP.categoria.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoriaRepository extends JpaRepository<Categoria, UUID> {
}