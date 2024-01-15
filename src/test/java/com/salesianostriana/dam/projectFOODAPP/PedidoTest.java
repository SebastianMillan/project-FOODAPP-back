package com.salesianostriana.dam.projectFOODAPP;

import com.salesianostriana.dam.projectFOODAPP.categoria.model.Categoria;
import com.salesianostriana.dam.projectFOODAPP.pedido.model.EstadoPedido;
import com.salesianostriana.dam.projectFOODAPP.pedido.model.LineaPedido;
import com.salesianostriana.dam.projectFOODAPP.pedido.model.Pedido;
import com.salesianostriana.dam.projectFOODAPP.pedido.repository.PedidoRepository;
import com.salesianostriana.dam.projectFOODAPP.pedido.service.PedidoService;
import com.salesianostriana.dam.projectFOODAPP.producto.model.Producto;
import com.salesianostriana.dam.projectFOODAPP.producto.repository.ProductoRepository;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Cliente;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.TipoTrabajador;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Trabajador;
import com.salesianostriana.dam.projectFOODAPP.usuario.repository.TrabajadorRepository;
import org.hibernate.annotations.Any;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class PedidoTest {


    UUID uuid = java.util.UUID.randomUUID();

    Trabajador cocinero = Trabajador.builder()
            .id(new UUID(1L, 9L))
            .nombre("Paco")
            .tipoTrabajador(TipoTrabajador.COCINERO)
            .build();
    Trabajador repartidor = Trabajador.builder()
            .id(new UUID(1L, 9L))
            .nombre("Luis")
            .tipoTrabajador(TipoTrabajador.REPARTIDOR)
            .build();

    Categoria categoria = Categoria.builder()
            .id(uuid)
            .nombre("Bebida")
            .build();

    Producto producto = Producto.builder()
            .id(new UUID(1L, 9L))
            .nombre("Coca-Cola")
            .precio(2.0)
            .categoria(categoria)
            .build();


    Cliente cliente = Cliente.builder()
            .id(uuid)
            .nombre("Jose")
            .build();

    Pedido pedido = Pedido.builder()
            .estadoPedido(EstadoPedido.ABIERTO)
            .id(new UUID(1L, 9L))
            .build();


    @Mock
    PedidoRepository pedidoRepository;

    @Mock
    ProductoRepository productoRepository;

    @Mock
    TrabajadorRepository trabajadorRepository;

    @InjectMocks
    PedidoService pedidoService;





    @Test
    void addProductoToPedidoOpen (){

        Optional<Pedido> pedidoEncontrado = Mockito.doReturn(Optional.of(pedido)).when(pedidoRepository).buscarPedidoAbiertoByClienteId(uuid.toString());
        Optional <Producto> productoAgregado = Mockito.doReturn(Optional.of(producto)).when(productoRepository).encontrarProductoPorId(uuid.toString());

        Optional<Trabajador> repartidorAsginado = Mockito.doReturn(Optional.of(repartidor)).when(trabajadorRepository).randomSelectRepartidor();
        Optional<Trabajador> cocineroAsignado = Mockito.doReturn(Optional.of(cocinero)).when(trabajadorRepository).randomSelectCocinero();

        LineaPedido nuevaLineaPedido = LineaPedido.builder()
                .precioUnitario(productoAgregado.get().getPrecio())
                .cantidad(1)
                .producto(productoAgregado.get())
                .build();

      pedidoEncontrado.get().addLineaPedido(nuevaLineaPedido);

      Assertions.assertEquals(1, pedidoEncontrado.get().getLineasPedido().size());
    }

}
