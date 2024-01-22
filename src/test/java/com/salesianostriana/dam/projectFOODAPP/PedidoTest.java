package com.salesianostriana.dam.projectFOODAPP;

import com.salesianostriana.dam.projectFOODAPP.categoria.model.Categoria;
import com.salesianostriana.dam.projectFOODAPP.pedido.model.EstadoPedido;
import com.salesianostriana.dam.projectFOODAPP.pedido.model.LineaPedido;
import com.salesianostriana.dam.projectFOODAPP.pedido.model.Pedido;
import com.salesianostriana.dam.projectFOODAPP.pedido.repository.PedidoRepository;
import com.salesianostriana.dam.projectFOODAPP.pedido.service.PedidoService;
import com.salesianostriana.dam.projectFOODAPP.producto.model.Producto;
import com.salesianostriana.dam.projectFOODAPP.producto.repository.ProductoRepository;
import com.salesianostriana.dam.projectFOODAPP.producto.service.ProductoService;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Cliente;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.RolUsuario;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.TipoTrabajador;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Trabajador;
import com.salesianostriana.dam.projectFOODAPP.usuario.repository.TrabajadorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PedidoTest {


    Categoria categoria = Categoria.builder()
            .id(UUID.randomUUID())
            .nombre("Bebida")
            .build();
    Cliente cliente = Cliente.builder()
            .id(UUID.randomUUID())
            .nombre("Luis Lopez")
            .build();
    Trabajador repartidor= Trabajador.builder()
            .id(UUID.randomUUID())
            .nombre("Paco Pepe")
            .roles(Set.of(RolUsuario.TRABAJADOR))
            .tipoTrabajador(TipoTrabajador.REPARTIDOR)
            .build();
    Trabajador cocinero= Trabajador.builder()
            .id(UUID.randomUUID())
            .nombre("Fernando Torres")
            .roles(Set.of(RolUsuario.TRABAJADOR))
            .tipoTrabajador(TipoTrabajador.COCINERO)
            .build();
    Pedido pedido = Pedido.builder()
            .id(UUID.randomUUID())
            .estadoPedido(EstadoPedido.ABIERTO)
            .cliente(cliente.getId().toString())
            .cocinero(cocinero.getId().toString())
            .repartidor(repartidor.getId().toString())
            .build();
    LineaPedido lineaPedido = LineaPedido.builder()
            .codLinea(UUID.randomUUID())
            .build();

    Producto producto = Producto.builder()
            .id(UUID.randomUUID())
            .nombre("Coca-cola")
            .precio(1.20)
            .precioOferta(0.90)
            .categoria(categoria)
            .build();



    @Mock
    PedidoRepository pedidoRepository;

    @Mock
    ProductoRepository productoRepository;

    @Mock
    TrabajadorRepository trabajadorRepository;


    @InjectMocks
    private PedidoService pedidoService;



    @Test
    void comprobarExisteProductoToAdd(){


        when(pedidoRepository.buscarPedidoAbiertoByClienteId(cliente.getId().toString())).thenReturn(Optional.of(pedido));
        when(productoRepository.encontrarProductoPorId(producto.getId().toString())).thenReturn(Optional.of(producto));

        when(pedidoRepository.save(Mockito.any(Pedido.class))).thenAnswer(i -> i.getArguments()[0]);
        when(pedidoRepository.buscarLineaPedidoPorProductoyPedido(producto.getId(), pedido.getId())).thenReturn(Optional.of(lineaPedido));


        Pedido resultado = pedidoService.addProductoToPedidoOpen(producto.getId().toString(), cliente);
        assertEquals(pedido.getId(), resultado.getId());
        assertEquals(1, resultado.getLineasPedido().size());
        assertEquals(pedido.getEstadoPedido(), resultado.getEstadoPedido());
        assertEquals(pedido.getCliente(), resultado.getCliente());

    }

}
