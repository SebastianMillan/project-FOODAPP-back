package com.salesianostriana.dam.projectFOODAPP.usuario.service;

import com.salesianostriana.dam.projectFOODAPP.usuario.Exception.TrabajadoresListEmpty;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Trabajador;


import com.salesianostriana.dam.projectFOODAPP.usuario.repository.TrabajadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrabajadorService {

    private final TrabajadorRepository trabajadorRepository;
    public Page<Trabajador> findAllTrabajadores(Pageable pageable) {
        Page<Trabajador> trabajadorList = trabajadorRepository.trabajadorPage(pageable);
        if(trabajadorList.isEmpty()){
            throw new TrabajadoresListEmpty();
        }
        return trabajadorList;
    }


}
