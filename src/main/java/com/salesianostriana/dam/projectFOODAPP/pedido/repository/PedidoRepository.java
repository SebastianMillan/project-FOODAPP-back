package com.salesianostriana.dam.projectFOODAPP.pedido.repository;

import com.salesianostriana.dam.projectFOODAPP.pedido.dto.GetPedidoEnCocinero;
import com.salesianostriana.dam.projectFOODAPP.pedido.model.LineaPedido;
import com.salesianostriana.dam.projectFOODAPP.pedido.model.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PedidoRepository extends JpaRepository<Pedido, UUID> {

    @Query("""
            SELECT p
            FROM Pedido p
            JOIN FETCH p.lineasPedido
            """)
    List<Pedido> getAllPedidosConLineas();

    @Query("""
            SELECT p
            FROM Pedido p
            JOIN FETCH p.lineasPedido
            WHERE p.cliente = ?1
            """)
    Optional<Pedido> getPedidoDeClienteById(String idCliente);

    @Query("""
            SELECT p
            FROM Pedido p
            JOIN FETCH p.lineasPedido
            WHERE p.id = ?1
            """)
    Optional<Pedido> getPedidoById(String idPedido);

    @Query("""
            select p
            from Pedido p
            join fetch p.lineasPedido
            where p.cocinero = :id
            """)
    Page<GetPedidoEnCocinero> getAllPedidosDelCocinero(Pageable pageable, String id);

    @Query("""
            select p
            from Pedido p
            JOIN FETCH p.lineasPedido
            where p.id=:id
            """)
    Optional<Pedido> buscarPedidoPorId(UUID id);

    @Query("""
            select p
            from Pedido p
            join fetch p.lineasPedido
            where p.cliente = ?1
            and p.estadoPedido = 'ABIERTO'
            """)
    Optional<Pedido> buscarPedidoAbiertoByClienteId(String id);


    @Query("""
            select l
             from LineaPedido l
             where l.producto.id = ?1
             and l.pedido.id = ?2
             order by l.producto.id asc
             limit 1
            """)
    Optional<LineaPedido> buscarLineaPedidoPorProductoyPedido(UUID idProducto, UUID idPedido);

}
