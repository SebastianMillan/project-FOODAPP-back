package com.salesianostriana.dam.projectFOODAPP.pedido.controller;

import com.salesianostriana.dam.projectFOODAPP.pedido.dto.GetHistorialDTO;
import com.salesianostriana.dam.projectFOODAPP.pedido.dto.GetPedidoDetallesDTO;
import com.salesianostriana.dam.projectFOODAPP.pedido.exception.PedidoNotFoundException;
import com.salesianostriana.dam.projectFOODAPP.pedido.model.Pedido;
import com.salesianostriana.dam.projectFOODAPP.pedido.service.PedidoService;
import com.salesianostriana.dam.projectFOODAPP.usuario.exception.ClienteNotFoundException;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Cliente;
import com.salesianostriana.dam.projectFOODAPP.usuario.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedido")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;
    private final ClienteService clienteService;

    @GetMapping("/")
    public List<Pedido> getAllPedidos() {
        return pedidoService.getAllPedidos();
    }



    @GetMapping("/detalle/{idPedido}")
    public GetPedidoDetallesDTO getPedidoById (@PathVariable String idPedido, ){

        if (pedidoOpt.isEmpty())
            throw new PedidoNotFoundException(idPedido);

        Pedido pedido = pedidoOpt.get();
        String clienteId = pedido.getCliente();

        Optional<Pedido> pedidoOpt = pedidoService.getPedidoDeClienteById()

        if (clienteId == null)
            throw new ClienteNotFoundException(clienteId);

        return GetPedidoDetallesDTO.of(pedido, clienteService.buscarClienteDetail(clienteId));
    }
}
