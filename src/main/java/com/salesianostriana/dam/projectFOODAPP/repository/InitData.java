package com.salesianostriana.dam.projectFOODAPP.repository;

import com.salesianostriana.dam.projectFOODAPP.model.*;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class InitData {

    private final CategoriaRepository categoriaRepository;
    private final ClienteRepository clienteRepository;
    private final ProductoRepository productoRepository;
    private final TrabajadorRepository trabajadorRepository;

    @PostConstruct
    public void initData(){

        List<LineaPedido> lineasDePedido = new ArrayList<>();
        List<Pedido> pedidos = new ArrayList<>();

        Categoria c1 = Categoria.builder()
                .nombre("Tapas")
                .build();

        Categoria c2 = Categoria.builder()
                .nombre("Postres")
                .build();

        categoriaRepository.saveAll(List.of(c1, c2));

        Cliente cl1 = Cliente.builder()
                .pin(1234)
                .direccion("c/Condes de Bustillo, 17")
                .codPostal("41011")
                .poblacion("Sevilla")
                .provincia("Sevilla")
                .puntos(50)
                .build();

        Cliente cl2 = Cliente.builder()
                .pin(1234)
                .direccion("c/Evangelista, 3")
                .codPostal("41011")
                .poblacion("Sevilla")
                .provincia("Sevilla")
                .puntos(100)
                .build();

        clienteRepository.saveAll(List.of(cl1, cl2));

        Producto p1 = Producto.builder()
                .nombre("Patatas Bravas")
                .imagen("https://upload.wikimedia.org/wikipedia/commons/thumb/1/16/Patatas_bravas_madrid.jpg/640px-Patatas_bravas_madrid.jpg")
                .descripcion("Patatas fritas acompañadas con una salsa picante de tomate Goya.")
                .precio(2.30)
                .precioOferta(1.50)
                .tags(new String[]{"patatas", "bravas"})
                .categoria(c1)
                .build();

        Producto p2 = Producto.builder()
                .nombre("Plato de Jamón Ibérico")
                .imagen("https://phantom-expansion.unidadeditorial.es/4a18f7865539ab348461b2ff7fc87fe4/crop/0x455/1197x1253/f/jpg/assets/multimedia/imagenes/2022/02/24/16457011092381.jpg")
                .descripcion("Plato de Jamón 100% Ibérico y curado")
                .precio(6.30)
                .precioOferta(4.50)
                .tags(new String[]{"Jamón", "Ibérico", "De Bellota"})
                .categoria(c1)
                .build();

        Producto p3 = Producto.builder()
                .nombre("Tarta de queso")
                .imagen("https://i.blogs.es/75907e/tarta_queso_philadelphia-min/1366_2000.jpeg")
                .descripcion("Tarta de queso philadelphia super cremosa.")
                .precio(4.30)
                .precioOferta(3.00)
                .tags(new String[]{"Tarta", "Queso", "Cremosa"})
                .categoria(c2)
                .build();

        productoRepository.saveAll(List.of(p1, p2));

        Trabajador t1 = Trabajador.builder()
                .fechaNacimiento(LocalDate.parse("26-07-2000", DateTimeFormatter.ofPattern("dd-MM-yyyy")))
                .tipoTrabajador(TipoTrabajador.REPARTIDOR)
                .pedidos(pedidos)
                .build();

        Trabajador t2 = Trabajador.builder()
                .fechaNacimiento(LocalDate.parse("13-11-2002", DateTimeFormatter.ofPattern("dd-MM-yyyy")))
                .tipoTrabajador(TipoTrabajador.COCINERO)
                .pedidos(pedidos)
                .build();

        trabajadorRepository.saveAll(List.of(t1,t2));

        Pedido ped1 = Pedido.builder()
                .fecha(LocalDateTime.now())
                .estadoPedido(EstadoPedido.EN_PREPARACION)
                .cliente(cl1)
                .repartidor(t1)
                .cocinero(t2)
                .lineasPedido(lineasDePedido)
                .build();

    }
}
 