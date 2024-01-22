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


    UUID uuid = new UUID (1L, 9L);

    Trabajador cocinero = Trabajador.builder()
            .id(uuid)
            .nombre("Paco")
            .tipoTrabajador(TipoTrabajador.COCINERO)
            .build();
    Trabajador repartidor = Trabajador.builder()
            .id(uuid)
            .nombre("Luis")
            .tipoTrabajador(TipoTrabajador.REPARTIDOR)
            .build();

    Categoria categoria = Categoria.builder()
            .id(uuid)
            .nombre("Bebida")
            .build();

    Producto producto = Producto.builder()
            .id(uuid)
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

    @InjectMocks
    PedidoService pedidoService;





    @Test
    void addProductoToPedidoOpen (){

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
    }

}
