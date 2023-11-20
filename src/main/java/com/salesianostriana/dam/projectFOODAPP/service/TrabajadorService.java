package com.salesianostriana.dam.projectFOODAPP.service;

import com.salesianostriana.dam.projectFOODAPP.repository.TrabajadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrabajadorService {

    private final TrabajadorRepository trabajadorRepository;
}
