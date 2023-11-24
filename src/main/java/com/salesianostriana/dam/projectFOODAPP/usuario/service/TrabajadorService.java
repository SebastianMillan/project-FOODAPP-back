package com.salesianostriana.dam.projectFOODAPP.usuario.service;

import com.salesianostriana.dam.projectFOODAPP.usuario.exception.TrabajadoresListEmptyException;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Trabajador;


import com.salesianostriana.dam.projectFOODAPP.usuario.repository.TrabajadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrabajadorService {

    private final TrabajadorRepository trabajadorRepository;
    public Page<Trabajador> findAllTrabajadores(Pageable pageable) {
        Page<Trabajador> trabajadorList = trabajadorRepository.trabajadorPage(pageable);
        if(trabajadorList.isEmpty()){
            throw new TrabajadoresListEmptyException();
        }
        return trabajadorList;
    }

    /*public Trabajador save (PostDtoTrabajador nuevoTrabajador){
        Trabajador t = new Trabajador();
        t.setTipoTrabajador(nuevoTrabajador);
    }*/

}
