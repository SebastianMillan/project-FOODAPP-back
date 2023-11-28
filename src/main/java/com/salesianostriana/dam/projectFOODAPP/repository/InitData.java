package com.salesianostriana.dam.projectFOODAPP.repository;

import com.salesianostriana.dam.projectFOODAPP.categoria.model.Categoria;
import com.salesianostriana.dam.projectFOODAPP.categoria.repository.CategoriaRepository;
import com.salesianostriana.dam.projectFOODAPP.pedido.model.EstadoPedido;
import com.salesianostriana.dam.projectFOODAPP.pedido.model.LineaPedido;
import com.salesianostriana.dam.projectFOODAPP.pedido.model.Pedido;
import com.salesianostriana.dam.projectFOODAPP.pedido.repository.PedidoRepository;
import com.salesianostriana.dam.projectFOODAPP.producto.model.Producto;
import com.salesianostriana.dam.projectFOODAPP.producto.repository.ProductoRepository;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Cliente;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.RolUsuario;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.TipoTrabajador;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Trabajador;
import com.salesianostriana.dam.projectFOODAPP.usuario.repository.ClienteRepository;
import com.salesianostriana.dam.projectFOODAPP.usuario.repository.TrabajadorRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Component
public class InitData {

    private final CategoriaRepository categoriaRepository;
    private final ClienteRepository clienteRepository;
    private final ProductoRepository productoRepository;
    private final TrabajadorRepository trabajadorRepository;
    private final PedidoRepository pedidoRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void initData(){

        Categoria c1 = Categoria.builder()
                .nombre("Tapas")
                .build();

        Categoria c2 = Categoria.builder()
                .nombre("Postres")
                .build();

        categoriaRepository.saveAll(List.of(c1, c2));

        Cliente cl1 = Cliente.builder()
                .username("sebastian")
                .password(passwordEncoder.encode("1234"))
                .nombre("Sebastián Millán")
                .roles(Set.of(RolUsuario.CLIENTE))
                .email("sebas@gmail.com")
                .telefono("987654111")
                .pin(1234)
                .direccion("c/Condes de Bustillo, 17")
                .codPostal("41011")
                .poblacion("Sevilla")
                .provincia("Sevilla")
                .puntos(50)
                .build();

        Cliente cl2 = Cliente.builder()
                .username("fran")
                .password(passwordEncoder.encode("1234"))
                .nombre("Francisco Claro")
                .email("fran@gmail.com")
                .roles(Set.of(RolUsuario.CLIENTE))
                .telefono("334665121")
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
                .precioOferta(0)
                .tags(new String[]{"patatas", "bravas"})
                .categoria(c1)
                .build();

        Producto p2 = Producto.builder()
                .nombre("Plato de Jamón Ibérico")
                .imagen("https://phantom-expansion.unidadeditorial.es/4a18f7865539ab348461b2ff7fc87fe4/crop/0x455/1197x1253/f/jpg/assets/multimedia/imagenes/2022/02/24/16457011092381.jpg")
                .descripcion("Plato de Jamón 100% Ibérico y curado")
                .precio(6.30)
                .precioOferta(0)
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

        Producto p4 = Producto.builder()
                .nombre("Hamburguesa Queso")
                .imagen("https://i.blogs.es/75907e/tarta_queso_philadelphia-min/1366_2000.jpeg")
                .descripcion("Hamburguesa de Buey con queso de cabra")
                .precio(3.55)
                .precioOferta(2.4)
                .tags(new String[]{"Queso", "Hamburguesa", "Buey"})
                .categoria(c1)
                .build();

        productoRepository.saveAll(List.of(p1, p2, p3, p4));

        Trabajador t1 = Trabajador.builder()
                .username("pedro")
                .password(passwordEncoder.encode("1234"))
                .roles(Set.of(RolUsuario.TRABAJADOR))
                .nombre("Pedro Franch")
                .email("pedro@gmail.com")
                .telefono("545656767")
                .fechaNacimiento(LocalDate.parse("26-07-2000", DateTimeFormatter.ofPattern("dd-MM-yyyy")))
                .tipoTrabajador(TipoTrabajador.REPARTIDOR)
                .build();

        Trabajador t2 = Trabajador.builder()

                .username("fer")
                .password(passwordEncoder.encode("1234"))
                .nombre("Fernando Claro")
                .roles(Set.of(RolUsuario.TRABAJADOR, RolUsuario.ADMIN))
                .email("fer@gmail.com")
                .telefono("121232888")
                .fechaNacimiento(LocalDate.parse("13-11-2002", DateTimeFormatter.ofPattern("dd-MM-yyyy")))
                .tipoTrabajador(TipoTrabajador.COCINERO)
                .build();

        trabajadorRepository.saveAll(List.of(t1,t2));

        LineaPedido ln1 = LineaPedido.builder()
                .cantidad(1)
                .precioUnitario(p1.getPrecio())
                .producto(p1)
                .build();

        LineaPedido ln2 = LineaPedido.builder()
                .cantidad(1)
                .precioUnitario(p2.getPrecio())
                .producto(p2)
                .build();

        LineaPedido ln3 = LineaPedido.builder()
                .cantidad(2)
                .precioUnitario(p2.getPrecio())
                .producto(p2)
                .build();

        LineaPedido ln4 = LineaPedido.builder()
                .cantidad(2)
                .precioUnitario(p1.getPrecio())
                .producto(p1)
                .build();

        Pedido ped1 = Pedido.builder()
                .fecha(LocalDateTime.now())
                .estadoPedido(EstadoPedido.EN_PREPARACION)
                .cliente(cl1.getId().toString())
                .repartidor(t1.getId().toString())
                .cocinero(t2.getId().toString())
                .build();

        Pedido ped2 = Pedido.builder()
                .fecha(LocalDateTime.now())
                .estadoPedido(EstadoPedido.CONFIRMADO)
                .cliente(cl2.getId().toString())
                .repartidor(t1.getId().toString())
                .cocinero(t2.getId().toString())
                .build();

        Pedido ped3 = Pedido.builder()
                .fecha(LocalDateTime.now())
                .estadoPedido(EstadoPedido.CONFIRMADO)
                .cliente(cl2.getId().toString())
                .repartidor(t1.getId().toString())
                .cocinero(t2.getId().toString())
                .build();

        ped1.addLineaPedido(ln1);
        ped2.addLineaPedido(ln2);
        ped3.addLineaPedido(ln3);
        ped2.addLineaPedido(ln4);

        pedidoRepository.saveAll(List.of(ped1,ped2, ped3));

    }
}
 