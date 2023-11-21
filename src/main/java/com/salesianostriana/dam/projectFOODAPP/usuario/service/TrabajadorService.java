package com.salesianostriana.dam.projectFOODAPP.usuario.service;

import com.salesianostriana.dam.projectFOODAPP.usuario.model.Trabajador;
import com.salesianostriana.dam.projectFOODAPP.usuario.repository.TrabajadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrabajadorService {

    private final TrabajadorRepository trabajadorRepository;

    public List<Trabajador> findAllTrabajadores(){
        return trabajadorRepository.findAll();
    }
}
