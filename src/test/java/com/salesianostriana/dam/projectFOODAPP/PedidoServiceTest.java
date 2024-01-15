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
import com.salesianostriana.dam.projectFOODAPP.usuario.repository.TrabajadorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        Cliente cliente = new Cliente(1,"direccion","44440","Sevilla","Sevilla",1);
        Pedido expectedResult= new Pedido(UUID.fromString("adce1211-fcd4-47cd-a327-68203a45749f"), LocalDateTime.of(2022,7,12, 15, 30), EstadoPedido.ABIERTO, "1ce9c1c7-7a02-4c7f-bf69-6d0306cbed68", UUID.randomUUID().toString(), UUID.randomUUID().toString(), List.of());
        Producto productToAdd =new Producto(UUID.randomUUID(), "Camisa","url","descripcion",20.2, 20.2,new String[2], new Categoria(UUID.randomUUID(), "Ropa"));
        expectedResult.addLineaPedido(LineaPedido.builder()
                        .codLinea(UUID.randomUUID())
                        .producto(productToAdd)
                        .pedido(expectedResult)
                        .cantidad(1)
                        .precioUnitario(productToAdd.getPrecioOferta())
                .build());
        Pedido result= pedidoService.addProductoToPedidoOpen(productToAdd.getId().toString(), cliente);
        assertEquals(expectedResult, result);
    }


}

