package com.salesianostriana.dam.projectFOODAPP.usuario.repository;

import com.salesianostriana.dam.projectFOODAPP.usuario.dto.GetClienteDtoDetail;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface ClienteRepository extends JpaRepository<Cliente, UUID> {

    @Query("""
            select new com.salesianostriana.dam.projectFOODAPP.usuario.repository.ClienteRepository(
                c.id, c.nombre, c.email, c.avatar, c.direccion, c.codPostal, c.poblacion, c.puntos, p
            )
            from Cliente c JOIN FETCH Pedido p
            where c.id = ?1
            """)
    Optional<GetClienteDtoDetail> buscarClienteDetailConPedidos(UUID id);
}