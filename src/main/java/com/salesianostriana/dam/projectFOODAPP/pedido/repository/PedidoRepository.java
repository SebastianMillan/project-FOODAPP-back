package com.salesianostriana.dam.projectFOODAPP.pedido.repository;

import com.salesianostriana.dam.projectFOODAPP.pedido.dto.GetHistorialDTO;
import com.salesianostriana.dam.projectFOODAPP.pedido.dto.GetPedidoEnCocinero;
import com.salesianostriana.dam.projectFOODAPP.pedido.model.LineaPedido;
import com.salesianostriana.dam.projectFOODAPP.pedido.model.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PedidoRepository extends JpaRepository<Pedido, UUID> {

    /*
    @Query("""
            SELECT new com.salesianostriana.dam.projectFOODAPP.pedido.dto.GetHistorialDTO(
            (select c.nombre from Cliente c where c.id = p.cliente), p.fecha,
                (lp.precioUnitario * lp.cantidad), p.estadoPedido)
                from Pedido p
                join p.lineasPedido as lp
                where p.cliente.id = ?1
            """)
    List<GetHistorialDTO> getHistorialByClienteID(String clienteId);

*/

// Consulta 2 del historial.

    /*
    @Query("""
    select new com.salesianostriana.dam.projectFOODAPP.pedido.dto.GetHistorialDTO(
    (select c.nombre from Cliente c where c.id = p.cliente), p.fecha,
    (lp.precioUnitario * lp.cantidad), p.estadoPedido)
    from Pedido p
    join p.lineasPedido as lp
    where p.cliente = :clienteId
    """)
    List<GetHistorialDTO> getHistorialByClienteID(@Param("clienteId") UUID clienteId);
     */

    @Query("""
            SELECT p
            FROM Pedido p
            JOIN FETCH p.lineasPedido
            """)
    List<Pedido> getAllPedidosConLineas();

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

}
