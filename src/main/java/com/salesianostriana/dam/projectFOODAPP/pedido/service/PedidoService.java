package com.salesianostriana.dam.projectFOODAPP.pedido.service;

import com.salesianostriana.dam.projectFOODAPP.pedido.dto.EditEstadoPedidoDto;
import com.salesianostriana.dam.projectFOODAPP.pedido.dto.GetHistorialDTO;
import com.salesianostriana.dam.projectFOODAPP.pedido.dto.GetPedidoEnCocinero;
import com.salesianostriana.dam.projectFOODAPP.pedido.dto.NewLineaPedidoDto;
import com.salesianostriana.dam.projectFOODAPP.pedido.exception.EmptyHistorialException;
import com.salesianostriana.dam.projectFOODAPP.pedido.exception.PedidoNotFoundException;
import com.salesianostriana.dam.projectFOODAPP.pedido.model.EstadoPedido;
import com.salesianostriana.dam.projectFOODAPP.pedido.model.LineaPedido;
import com.salesianostriana.dam.projectFOODAPP.pedido.model.Pedido;
import com.salesianostriana.dam.projectFOODAPP.pedido.repository.PedidoRepository;
import com.salesianostriana.dam.projectFOODAPP.producto.dto.GetProductShortDto;
import com.salesianostriana.dam.projectFOODAPP.producto.model.Producto;
import com.salesianostriana.dam.projectFOODAPP.producto.repository.ProductoRepository;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Cliente;
import com.salesianostriana.dam.projectFOODAPP.usuario.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ProductoRepository productoRepository;
    private final ClienteRepository clienteRepository;


    public List<Pedido> getAllPedidos(){

        return pedidoRepository.getAllPedidosConLineas();
    }

    public Page<GetPedidoEnCocinero> getAllPedidosDelCocinero(Pageable pageable, String id){
        return pedidoRepository.getAllPedidosDelCocinero(pageable, id);
    }

    public Pedido changeEstadoPedidoCocinero(String id, EditEstadoPedidoDto editEstadoPedidoDto){
        Optional<Pedido> result = pedidoRepository.buscarPedidoPorId(UUID.fromString(id));
        if(result.isEmpty()){
            throw new PedidoNotFoundException(id);
        }
        result.get().setEstadoPedido(EstadoPedido.valueOf(editEstadoPedidoDto.estadoPedido()));
        return pedidoRepository.save(result.get());
    }

    /*
    public List<GetHistorialDTO> getHistorialCliente (String clienteId){

        List<GetHistorialDTO> pedidos = pedidoRepository.getHistorialByClienteID(clienteId);

        if (pedidos.isEmpty())
            throw new EmptyHistorialException();

        return pedidos;
    }

     */
    /*
    public double calcularImporteTotal (Pedido ped){

        List<LineaPedido> lineas = ped.getLineasPedido();
        double importeTotal = 0.0;
        for (LineaPedido lp : lineas)
            importeTotal += lp.getCantidad() * lp.getPrecioUnitario();

        return importeTotal;
    }
    */



    public Pedido nuevoPedido (NewLineaPedidoDto lineaPedido){
       Producto p =  productoRepository.findById(UUID.fromString(lineaPedido.idProducto())).get();
       Cliente c = clienteRepository.findById(UUID.fromString(lineaPedido.idCliente())).get();
       LineaPedido l = new LineaPedido();
       l.setProducto(p);
       l.setPrecioUnitario(p.getPrecio());
       l.setCantidad(lineaPedido.cantidad());

       Pedido pe = new Pedido();
       pe.setEstadoPedido(EstadoPedido.ABIERTO);
       pe.setFecha(LocalDateTime.now());
       pe.setCliente(c.getId().toString());
       pe.addLineaPedido(l);
       return pedidoRepository.save(pe);

    }

}
