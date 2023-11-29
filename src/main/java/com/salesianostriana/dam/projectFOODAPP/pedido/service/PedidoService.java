package com.salesianostriana.dam.projectFOODAPP.pedido.service;
import com.salesianostriana.dam.projectFOODAPP.pedido.dto.*;
import com.salesianostriana.dam.projectFOODAPP.pedido.exception.LineaPedidoNotFoundException;
import com.salesianostriana.dam.projectFOODAPP.pedido.exception.PedidoNotFoundException;
import com.salesianostriana.dam.projectFOODAPP.pedido.model.EstadoPedido;
import com.salesianostriana.dam.projectFOODAPP.pedido.model.LineaPedido;
import com.salesianostriana.dam.projectFOODAPP.pedido.model.Pedido;
import com.salesianostriana.dam.projectFOODAPP.pedido.repository.PedidoRepository;
import com.salesianostriana.dam.projectFOODAPP.producto.dto.GetProductShortDto;
import com.salesianostriana.dam.projectFOODAPP.producto.exception.ProductoNotFoundException;
import com.salesianostriana.dam.projectFOODAPP.producto.model.Producto;
import com.salesianostriana.dam.projectFOODAPP.producto.repository.ProductoRepository;
import com.salesianostriana.dam.projectFOODAPP.usuario.exception.TrabajadorNotFoundException;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Cliente;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Trabajador;
import com.salesianostriana.dam.projectFOODAPP.usuario.repository.ClienteRepository;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Cliente;
import com.salesianostriana.dam.projectFOODAPP.usuario.repository.TrabajadorRepository;
import com.salesianostriana.dam.projectFOODAPP.usuario.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ProductoRepository productoRepository;
    private final ClienteRepository clienteRepository;
    private final ClienteService clienteService;
    private final TrabajadorRepository trabajadorRepository;


    public List<Pedido> getAllPedidos() {

        return pedidoRepository.getAllPedidosConLineas();
    }

    public Optional<Pedido> getPedidoDeClienteById(String idCliente){

        Optional<Pedido> pedido = pedidoRepository.getPedidoDeClienteById(idCliente);

        if (pedido.isEmpty())
            throw new PedidoNotFoundException();

        return pedido;
    }
    public Page<GetPedidoEnCocinero> getAllPedidosDelCocinero(Pageable pageable, String id) {
        return pedidoRepository.getAllPedidosDelCocinero(pageable, id);
    }

    public Pedido changeEstadoPedidoCocinero(String id, EditEstadoPedidoDto editEstadoPedidoDto) {
        Optional<Pedido> result = pedidoRepository.buscarPedidoPorId(UUID.fromString(id));
        if (result.isEmpty()) {
            throw new PedidoNotFoundException();
        }
        result.get().setEstadoPedido(EstadoPedido.valueOf(editEstadoPedidoDto.estadoPedido()));
        return pedidoRepository.save(result.get());
    }

    public Pedido getPedidoDetails(UUID idPedido) {

        return pedidoRepository.buscarPedidoPorId(idPedido)
                .orElseThrow(PedidoNotFoundException::new);

    }

    public GetDetallePedidoDto getPedidoDetailsDto(UUID idPedido) {
        Pedido pedido = getPedidoDetails(idPedido);
        Cliente cliente = clienteService.buscarClientePorId(pedido.getCliente());
        return new GetDetallePedidoDto(
                pedido.getId().toString(),
                cliente.getDireccion(),
                cliente.getTelefono(),
                pedido.getEstadoPedido().toString(),
                pedido.getFecha().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")),
                pedido.getLineasPedido().stream().map(GetLineaPedidoEnDetalle::of).toList(),
                pedido.getLineasPedido().stream().mapToDouble(x -> x.getPrecioUnitario() *
                        x.getCantidad()).sum());

    }




    public Pedido addProductoToPedidoOpen (String idProducto, Cliente c){
        Optional<Pedido> pedidoOpen = pedidoRepository.buscarPedidoAbiertoByClienteId(c.getId().toString());
        Optional<Producto> productoToAdd = productoRepository.encontrarProductoPorId(idProducto);

        if(productoToAdd.isEmpty()){
            throw new ProductoNotFoundException();
        }

        if(pedidoOpen.isEmpty()){
            Optional<Trabajador> repartidorAsignado = trabajadorRepository.randomSelectRepartidor();
            Optional<Trabajador> cocineroAsignado = trabajadorRepository.randomSelectCocinero();


            if(repartidorAsignado.isEmpty() || cocineroAsignado.isEmpty()){
                throw new TrabajadorNotFoundException();
            }

            LineaPedido nuevaLineaPedido = LineaPedido.builder()
                    .precioUnitario(productoToAdd.get().getPrecio())
                    .cantidad(1)
                    .producto(productoToAdd.get())
                    .build();

            Pedido newPedidoOpen = Pedido.builder()
                    .fecha(LocalDateTime.now())
                    .estadoPedido(EstadoPedido.ABIERTO)
                    .cliente(c.getId().toString())
                    .repartidor(trabajadorRepository.randomSelectRepartidor().get().getId().toString())
                    .cocinero(trabajadorRepository.randomSelectCocinero().get().getId().toString())
                    .build();

            newPedidoOpen.addLineaPedido(nuevaLineaPedido);
            return pedidoRepository.save(newPedidoOpen);
        }

        Optional<LineaPedido> lnEncontrada= pedidoRepository.buscarLineaPedidoPorProductoyPedido(productoToAdd.get().getId(), pedidoOpen.get().getId());

        if(lnEncontrada.isEmpty()){
            LineaPedido nuevaLineaPedido = LineaPedido.builder()
                    .precioUnitario(productoToAdd.get().getPrecio())
                    .cantidad(1)
                    .producto(productoToAdd.get())
                    .build();
            pedidoOpen.get().addLineaPedido(nuevaLineaPedido);
            return pedidoRepository.save(pedidoOpen.get());
        }
        lnEncontrada.get().setCantidad(lnEncontrada.get().getCantidad()+1);
        pedidoOpen.get().removeLineaPedido(lnEncontrada.get());
        pedidoOpen.get().addLineaPedido(lnEncontrada.get());
        return pedidoRepository.save(pedidoOpen.get());

    }

    public Pedido getOpenPedido(Cliente c){
        Optional<Pedido> pedidoOpen = pedidoRepository.buscarPedidoAbiertoByClienteId(c.getId().toString());
        if(pedidoOpen.isEmpty()){
            throw new PedidoNotFoundException();
        }
        return pedidoOpen.get();
    }

}
