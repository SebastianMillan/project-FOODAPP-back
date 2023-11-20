package com.salesianostriana.dam.projectFOODAPP.pedido.repository;

import com.salesianostriana.dam.projectFOODAPP.pedido.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PedidoRepository extends JpaRepository<Pedido, UUID> {
}