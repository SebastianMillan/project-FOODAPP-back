package com.salesianostriana.dam.projectFOODAPP.usuario.controller;

import com.salesianostriana.dam.projectFOODAPP.pedido.dto.GetHistorialDTO;
import com.salesianostriana.dam.projectFOODAPP.pedido.model.Pedido;
import com.salesianostriana.dam.projectFOODAPP.pedido.service.PedidoService;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Cliente;
import com.salesianostriana.dam.projectFOODAPP.usuario.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;
    private final PedidoService pedidoService;

    @GetMapping("/")
    public List<Cliente> getAllClientes(){

        return clienteService.getAllClientes();
    }

    @GetMapping("/historial/{uuid}")
    public List<GetHistorialDTO> getHistorialPedidosDeUnCliente (String uuid){

        List<Pedido> pedidos = clienteService.buscarPedidosByClienteId(uuid);

        List<GetHistorialDTO> pedidosClienteDTO = new ArrayList<>();
        for(Pedido pedido: pedidos){
            pedidosClienteDTO.add(GetHistorialDTO.of(pedido,
                    pedidoService.calcularImporteTotal(pedido)));
        }

        return pedidosClienteDTO;
    }
}
