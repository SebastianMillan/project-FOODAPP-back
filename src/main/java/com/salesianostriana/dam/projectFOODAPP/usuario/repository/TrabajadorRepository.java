package com.salesianostriana.dam.projectFOODAPP.usuario.repository;

import com.salesianostriana.dam.projectFOODAPP.usuario.model.Trabajador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface TrabajadorRepository extends JpaRepository<Trabajador, UUID> {

    @Query("SELECT t FROM Trabajador t")
    Page<Trabajador> trabajadorPage(Pageable pageable);

    @Query("SELECT t from Trabajador t where t.id = ?1")
    Optional<Trabajador> buscarTrabajadorID(UUID id);

    @Query("""
            select t
            from Trabajador t
            where t.tipoTrabajador = 1
            order by function('RAND') limit 1
            """)
    Optional<Trabajador> randomSelectCocinero();

    @Query("""
            select t
            from Trabajador t
            where t.tipoTrabajador = 2
            order by function('RAND') limit 1
            """)
    Optional<Trabajador> randomSelectRepartidor();
}