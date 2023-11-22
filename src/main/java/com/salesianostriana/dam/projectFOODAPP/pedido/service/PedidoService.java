package com.salesianostriana.dam.projectFOODAPP.pedido.service;

import com.salesianostriana.dam.projectFOODAPP.pedido.exception.EmptyHistorialException;
import com.salesianostriana.dam.projectFOODAPP.pedido.model.LineaPedido;
import com.salesianostriana.dam.projectFOODAPP.pedido.model.Pedido;
import com.salesianostriana.dam.projectFOODAPP.pedido.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public List<Pedido> getHistorialCliente (String clienteId){

        List<Pedido> pedidos = pedidoRepository.getHistorialByClienteID(clienteId);

        if (pedidos.isEmpty())
            throw new EmptyHistorialException();

        return pedidos;
    }

    public double calcularImporteTotal (Pedido ped){

        List<LineaPedido> lineas = ped.getLineasPedido();
        double importeTotal = 0.0;
        for (LineaPedido lp : lineas)
            importeTotal += lp.getCantidad() * lp.getPrecioUnitario();

        return importeTotal;
    }


}
