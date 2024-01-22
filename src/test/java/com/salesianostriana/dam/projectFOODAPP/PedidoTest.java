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

<<<<<<< HEAD

    UUID uuid = new UUID (1L, 9L);

    Trabajador cocinero = Trabajador.builder()
            .id(uuid)
            .nombre("Paco")
            .tipoTrabajador(TipoTrabajador.COCINERO)
            .build();
    Trabajador repartidor = Trabajador.builder()
            .id(uuid)
            .nombre("Luis")
=======
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
>>>>>>> 7371880e17c3018c02c07322a6cf3f314eb30a26
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
<<<<<<< HEAD
            .id(uuid)
            .nombre("Coca-Cola")
            .precio(2.0)
=======
            .id(UUID.randomUUID())
            .nombre("Coca-cola")
            .precio(1.20)
            .precioOferta(0.90)
>>>>>>> 7371880e17c3018c02c07322a6cf3f314eb30a26
            .categoria(categoria)
            .build();


<<<<<<< HEAD
    Cliente cliente = Cliente.builder()
            .id(uuid)
            .nombre("Jose")
            .build();

    Pedido pedido = Pedido.builder()
            .estadoPedido(EstadoPedido.ABIERTO)
            .id(uuid)
            .cocinero(cocinero.getId().toString())
            .repartidor(repartidor.getId().toString())
            .cliente(cliente.getId().toString())
            .build();


    @Mock
    PedidoRepository pedidoRepository;

    @Mock
    ProductoRepository productoRepository;

    @Mock
    TrabajadorRepository trabajadorRepository;
=======
>>>>>>> 7371880e17c3018c02c07322a6cf3f314eb30a26

    @InjectMocks
    private PedidoService pedidoService;

    @Mock
    private ProductoRepository productoRepository;
    @Mock
    private PedidoRepository pedidoRepository;
    @Mock
    private TrabajadorRepository trabajadorRepository;

    @Test
    void comprobarExisteProductoToAdd(){

<<<<<<< HEAD
        Mockito.doReturn(Optional.of(pedido)).when(pedidoRepository).buscarPedidoAbiertoByClienteId(uuid.toString());
        Mockito.doReturn(Optional.of(producto)).when(productoRepository).encontrarProductoPorId(uuid.toString());

        Pedido pedidoEncontrado = pedidoRepository.buscarPedidoAbiertoByClienteId(uuid.toString()).get();
        Producto productoAgregado = productoRepository.encontrarProductoPorId(uuid.toString()).get();

        LineaPedido nuevaLineaPedido = LineaPedido.builder()
                .precioUnitario(productoAgregado.getPrecio())
                .cantidad(1)
                .producto(productoAgregado)
                .build();

      pedidoEncontrado.addLineaPedido(nuevaLineaPedido);
      Mockito.when(pedidoRepository.save(pedidoEncontrado)).thenReturn(pedidoEncontrado);

      pedidoRepository.save(pedidoEncontrado);

      Assertions.assertEquals(1, pedidoEncontrado.getLineasPedido().size());
      Assertions.assertEquals(cliente.getId().toString(), pedidoEncontrado.getCliente().toString());
=======


        when(pedidoRepository.buscarPedidoAbiertoByClienteId(cliente.getId().toString())).thenReturn(Optional.of(pedido));
        when(productoRepository.encontrarProductoPorId(producto.getId().toString())).thenReturn(Optional.of(producto));

        when(pedidoRepository.save(Mockito.any(Pedido.class))).thenAnswer(i -> i.getArguments()[0]);
        when(pedidoRepository.buscarLineaPedidoPorProductoyPedido(producto.getId(), pedido.getId())).thenReturn(Optional.of(lineaPedido));


        Pedido resultado = pedidoService.addProductoToPedidoOpen(producto.getId().toString(), cliente);
        assertEquals(pedido.getId(), resultado.getId());
        assertEquals(1, resultado.getLineasPedido().size());
        assertEquals(pedido.getEstadoPedido(), resultado.getEstadoPedido());
        assertEquals(pedido.getCliente(), resultado.getCliente());

>>>>>>> 7371880e17c3018c02c07322a6cf3f314eb30a26
    }

}
