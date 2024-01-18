package com.salesianostriana.dam.projectFOODAPP.pedido.service;

import com.salesianostriana.dam.projectFOODAPP.pedido.dto.GetDetallePedidoDto;
import com.salesianostriana.dam.projectFOODAPP.pedido.model.EstadoPedido;
import com.salesianostriana.dam.projectFOODAPP.pedido.model.Pedido;
import com.salesianostriana.dam.projectFOODAPP.pedido.repository.PedidoRepository;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Cliente;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PedidoServiceTest {

    @Mock
    PedidoRepository pedidoRepository;

    @InjectMocks
    PedidoService pedidoService;

    @Test
    void ComprobarCorrectoFuncionamientoDetallesPedido() {

        Cliente c1 = Cliente.builder()
                .id(UUID.randomUUID())
                .build();

        Pedido p1 = Pedido.builder()
                .id(UUID.randomUUID())
                .fecha(LocalDateTime.now())
                .estadoPedido(EstadoPedido.ABIERTO)
                .cliente(c1.getId().toString())
                .repartidor(UUID.randomUUID().toString())
                .cocinero(UUID.randomUUID().toString())
                .lineasPedido(new ArrayList<>())
                .build();


        Mockito.when(pedidoService.getPedidoDetailsDto(p1.getId())).thenReturn(new GetDetallePedidoDto(
                p1.getId().toString(),
                p1.getFecha().toString(),
                p1.getEstadoPedido().toString(),
                p1.getCliente(),
                p1.getRepartidor(),
                new ArrayList<>(),
                40
        ));

        GetDetallePedidoDto resultado = pedidoService.getPedidoDetailsDto(p1.getId());

        assertEquals(p1.getId().toString(), resultado.id());

    }
}