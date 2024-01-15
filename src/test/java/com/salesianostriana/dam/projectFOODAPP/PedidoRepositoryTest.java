package com.salesianostriana.dam.projectFOODAPP;

import com.salesianostriana.dam.projectFOODAPP.pedido.model.EstadoPedido;
import com.salesianostriana.dam.projectFOODAPP.pedido.model.Pedido;
import com.salesianostriana.dam.projectFOODAPP.pedido.repository.PedidoRepository;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Cliente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class PedidoRepositoryTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    PedidoRepository pedidoRepository;

    @Test
    void buscarPedidoAbiertoByClienteId(){

        Cliente cliente1 = Cliente.builder()
                .id(UUID.randomUUID())
                .build();
        Cliente cliente2 = Cliente.builder()
                .id(UUID.randomUUID())
                .build();
        Pedido p1 = Pedido.builder()
                .id(UUID.randomUUID())
                .estadoPedido(EstadoPedido.ABIERTO)
                .cliente(cliente1.getId().toString())
                .build();
        Pedido p2 = Pedido.builder()
                .id(UUID.randomUUID())
                .estadoPedido(EstadoPedido.ABIERTO)
                .cliente(cliente2.getId().toString())
                .build();
        Pedido p3 = Pedido.builder()
                .id(UUID.randomUUID())
                .estadoPedido(EstadoPedido.CONFIRMADO)
                .cliente(cliente1.getId().toString())
                .build();

        testEntityManager.merge(cliente1);
        testEntityManager.merge(cliente2);
        testEntityManager.merge(p1);
        testEntityManager.merge(p2);
        testEntityManager.merge(p3);


        Optional<Pedido> result = pedidoRepository.buscarPedidoAbiertoByClienteId(cliente1.getId().toString());

        assertEquals(result.get(), cliente1);


    }
}
