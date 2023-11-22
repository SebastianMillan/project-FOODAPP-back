package com.salesianostriana.dam.projectFOODAPP.pedido.repository;

import com.salesianostriana.dam.projectFOODAPP.pedido.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PedidoRepository extends JpaRepository<Pedido, UUID> {
/*
    @Query("""
            SELECT p
            FROM Pedido p
            JOIN FETCH p.cliente as cl
            WHERE cl.id = ?1
            """)
    List<Pedido> getHistorialByClienteID(UUID id);

 */
}