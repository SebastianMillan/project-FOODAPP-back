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
public class PedidoServiceTest {

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
        Trabajador repartidor= Trabajador.builder().id(UUID.randomUUID()).roles(Set.of(RolUsuario.TRABAJADOR)).tipoTrabajador(TipoTrabajador.REPARTIDOR).build();
        Trabajador cocinero= Trabajador.builder().id(UUID.randomUUID()).roles(Set.of(RolUsuario.TRABAJADOR)).tipoTrabajador(TipoTrabajador.COCINERO).build();
        LineaPedido ln = LineaPedido.builder().codLinea(UUID.randomUUID()).build();
        Cliente cliente = Cliente.builder().id(UUID.randomUUID()).build();
        Pedido pedido= new Pedido(UUID.randomUUID(), LocalDateTime.of(2022,7,12, 15, 30), EstadoPedido.ABIERTO, cliente.getId().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString(), new ArrayList<>());
        Producto productToAdd =new Producto(UUID.randomUUID(), "Camisa","url","descripcion",20.2, 20.2,new String[2], new Categoria(UUID.randomUUID(), "Ropa"));

        //Precondiciones
        lenient().when(pedidoRepository.buscarPedidoAbiertoByClienteId(cliente.getId().toString())).thenReturn(Optional.of(pedido));
        lenient().when(productoRepository.encontrarProductoPorId(productToAdd.getId().toString())).thenReturn(Optional.of(productToAdd));
        lenient().when(trabajadorRepository.randomSelectRepartidor()).thenReturn(Optional.of(repartidor));
        lenient().when(trabajadorRepository.randomSelectCocinero()).thenReturn(Optional.of(cocinero));
        lenient().when(pedidoRepository.save(Mockito.any(Pedido.class))).thenAnswer(i -> i.getArguments()[0]);
        lenient().when(pedidoRepository.buscarLineaPedidoPorProductoyPedido(productToAdd.getId(), pedido.getId())).thenReturn(Optional.of(ln));

        //Test
        Pedido expectedResult = pedidoService.addProductoToPedidoOpen(productToAdd.getId().toString(), cliente);
        assertEquals(pedido.getId(), expectedResult.getId());
        assertEquals(pedido.getEstadoPedido(), expectedResult.getEstadoPedido());
        assertEquals(1, expectedResult.getLineasPedido().size());

    }


}

