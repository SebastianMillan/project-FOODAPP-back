package com.salesianostriana.dam.projectFOODAPP.pedido.service;

import com.salesianostriana.dam.projectFOODAPP.pedido.dto.GetHistorialDTO;
import com.salesianostriana.dam.projectFOODAPP.pedido.exception.EmptyHistorialException;
import com.salesianostriana.dam.projectFOODAPP.pedido.exception.PedidoNotFoundException;
import com.salesianostriana.dam.projectFOODAPP.pedido.model.LineaPedido;
import com.salesianostriana.dam.projectFOODAPP.pedido.model.Pedido;
import com.salesianostriana.dam.projectFOODAPP.pedido.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;


    public List<Pedido> getAllPedidos(){

        return pedidoRepository.getAllPedidosConLineas();
    }

    public Optional<Pedido> getPedidoDeClienteById(String idCliente){

        Optional<Pedido> pedido = pedidoRepository.getPedidoDeClienteById(idCliente);

        if (pedido.isEmpty())
            throw new PedidoNotFoundException(idCliente);

        return pedido;
    }
}
