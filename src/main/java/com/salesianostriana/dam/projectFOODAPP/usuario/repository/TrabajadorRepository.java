package com.salesianostriana.dam.projectFOODAPP.usuario.repository;

import com.salesianostriana.dam.projectFOODAPP.usuario.model.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TrabajadorRepository extends JpaRepository<Trabajador, UUID> {
}