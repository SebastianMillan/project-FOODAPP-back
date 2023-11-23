package com.salesianostriana.dam.projectFOODAPP.usuario.service;

import com.salesianostriana.dam.projectFOODAPP.pedido.model.Pedido;
import com.salesianostriana.dam.projectFOODAPP.usuario.dto.GetClienteDtoDetail;
import com.salesianostriana.dam.projectFOODAPP.usuario.exception.ClienteNotFoundException;
import com.salesianostriana.dam.projectFOODAPP.usuario.exception.EmptyClientOrdersException;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Cliente;
import com.salesianostriana.dam.projectFOODAPP.usuario.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public Cliente buscarClienteDetail(String id){
        Optional<Cliente> result = clienteRepository.buscarClienteDetail(UUID.fromString(id));
        if(result.isEmpty()){
            throw new ClienteNotFoundException(id);
        }
        return result.get();
    }

    public List<Pedido> buscarPedidosByClienteId(String id){
        List<Pedido> lista = clienteRepository.buscarPedidosByClienteId(id);
        if(lista.isEmpty()){
            throw new EmptyClientOrdersException();
        }
        return lista;
    }
}
