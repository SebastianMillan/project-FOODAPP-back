package com.salesianostriana.dam.projectFOODAPP.repository;

import com.salesianostriana.dam.projectFOODAPP.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}