package com.salesianostriana.dam.projectFOODAPP.usuario.repository;

import com.salesianostriana.dam.projectFOODAPP.pedido.model.Pedido;
import com.salesianostriana.dam.projectFOODAPP.usuario.dto.GetClienteDtoDetail;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClienteRepository extends JpaRepository<Cliente, UUID> {

    /*
    @Query("""
            select new com.salesianostriana.dam.projectFOODAPP.usuario.dto.GetClienteDtoDetail(
                cast(c.id as string), c.nombre, c.email, c.avatar, c.direccion, c.codPostal, c.poblacion, c.puntos, p
            )
            from Cliente c left join Pedido p on p.cliente = cast(c.id as string)
            where c.id = ?1
            """)
    Optional<GetClienteDtoDetail> buscarClienteDetailConPedidos(UUID id);
     */

    @Query("""
            select c 
            from Cliente c
            where c.id = ?1
            """)
    Optional<Cliente> buscarClienteDetail(UUID id);

    @Query("""
            select p
            from Pedido p join fetch p.lineasPedido
            where p.cliente = ?1
            """)
    List<Pedido> buscarPedidosByClienteId(String id);


}