package com.salesianostriana.dam.projectFOODAPP.repository;

import com.salesianostriana.dam.projectFOODAPP.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}