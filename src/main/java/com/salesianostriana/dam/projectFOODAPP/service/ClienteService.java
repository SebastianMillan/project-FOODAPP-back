package com.salesianostriana.dam.projectFOODAPP.service;

import com.salesianostriana.dam.projectFOODAPP.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
}
