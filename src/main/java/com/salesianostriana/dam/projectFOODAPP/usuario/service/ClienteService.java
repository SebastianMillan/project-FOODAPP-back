package com.salesianostriana.dam.projectFOODAPP.usuario.service;

import com.salesianostriana.dam.projectFOODAPP.usuario.dto.GetClienteDtoDetail;
import com.salesianostriana.dam.projectFOODAPP.usuario.exception.ClienteNotFoundException;
import com.salesianostriana.dam.projectFOODAPP.usuario.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public GetClienteDtoDetail buscarClienteDetailConPedidos(String id){
        Optional<GetClienteDtoDetail> result = clienteRepository.buscarClienteDetailConPedidos(UUID.fromString(id));
        if(result.isEmpty()){
            throw new ClienteNotFoundException(id);
        }
        return result.get();

    }
}
