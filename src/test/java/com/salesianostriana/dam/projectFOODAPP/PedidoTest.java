package com.salesianostriana.dam.projectFOODAPP;

import com.salesianostriana.dam.projectFOODAPP.pedido.model.EstadoPedido;
import com.salesianostriana.dam.projectFOODAPP.pedido.model.Pedido;
import com.salesianostriana.dam.projectFOODAPP.pedido.repository.PedidoRepository;
import com.salesianostriana.dam.projectFOODAPP.pedido.service.PedidoService;
import com.salesianostriana.dam.projectFOODAPP.producto.model.Producto;
import com.salesianostriana.dam.projectFOODAPP.producto.repository.ProductoRepository;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Cliente;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.TipoTrabajador;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Trabajador;
import com.salesianostriana.dam.projectFOODAPP.usuario.repository.TrabajadorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class PedidoTest {


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

    Producto producto = Producto.builder()
            .id(new UUID(1L, 9L))
            .nombre("Coca-Cola")
            .precio(2.0)
            .build();

    Cliente cliente = Cliente.builder()
            .id(new UUID(1L, 9L))
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

    }

}
