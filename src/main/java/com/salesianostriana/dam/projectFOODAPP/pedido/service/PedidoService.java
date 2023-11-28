package com.salesianostriana.dam.projectFOODAPP.pedido.service;

import com.salesianostriana.dam.projectFOODAPP.pedido.dto.EditEstadoPedidoDto;
import com.salesianostriana.dam.projectFOODAPP.pedido.dto.GetDetallePedidoDto;
import com.salesianostriana.dam.projectFOODAPP.pedido.dto.GetLineaPedidoEnDetalle;
import com.salesianostriana.dam.projectFOODAPP.pedido.dto.GetPedidoEnCocinero;
import com.salesianostriana.dam.projectFOODAPP.pedido.exception.PedidoNotFoundException;
import com.salesianostriana.dam.projectFOODAPP.pedido.model.EstadoPedido;
import com.salesianostriana.dam.projectFOODAPP.pedido.model.Pedido;
import com.salesianostriana.dam.projectFOODAPP.pedido.repository.PedidoRepository;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Cliente;
import com.salesianostriana.dam.projectFOODAPP.usuario.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteService clienteService;


    public List<Pedido> getAllPedidos() {

        return pedidoRepository.getAllPedidosConLineas();
    }

    public Page<GetPedidoEnCocinero> getAllPedidosDelCocinero(Pageable pageable, String id) {
        return pedidoRepository.getAllPedidosDelCocinero(pageable, id);
    }

    public Pedido changeEstadoPedidoCocinero(String id, EditEstadoPedidoDto editEstadoPedidoDto) {
        Optional<Pedido> result = pedidoRepository.buscarPedidoPorId(UUID.fromString(id));
        if (result.isEmpty()) {
            throw new PedidoNotFoundException(id);
        }
        result.get().setEstadoPedido(EstadoPedido.valueOf(editEstadoPedidoDto.estadoPedido()));
        return pedidoRepository.save(result.get());
    }

    public Pedido getPedidoDetails(UUID idPedido) {

        return pedidoRepository.buscarPedidoPorId(idPedido)
                .orElseThrow(() -> new PedidoNotFoundException(idPedido.toString()));

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
}
