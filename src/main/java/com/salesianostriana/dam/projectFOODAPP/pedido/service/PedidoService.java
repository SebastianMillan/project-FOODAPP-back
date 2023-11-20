package com.salesianostriana.dam.projectFOODAPP.pedido.service;

import com.salesianostriana.dam.projectFOODAPP.pedido.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
}
