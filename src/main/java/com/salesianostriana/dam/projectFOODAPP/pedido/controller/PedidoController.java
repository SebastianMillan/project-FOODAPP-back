package com.salesianostriana.dam.projectFOODAPP.pedido.controller;

import com.salesianostriana.dam.projectFOODAPP.pedido.dto.GetHistorialDTO;
import com.salesianostriana.dam.projectFOODAPP.pedido.model.Pedido;
import com.salesianostriana.dam.projectFOODAPP.pedido.service.PedidoService;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pedido")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;
/*
    @GetMapping("/historial/{cliente}")
    public List<GetHistorialDTO> getHistorialPedidos(@AuthenticationPrincipal Cliente cliente) {

        List<Pedido> pedidos = pedidoService.getHistorialCliente(cliente.getId());

        List<GetHistorialDTO> historial = new ArrayList<>();
        for (Pedido pedido : pedidos)
            historial.add(GetHistorialDTO.of(cliente, pedido, pedidoService.calcularImporteTotal(pedido)));

        return historial;
    }
*/
}
