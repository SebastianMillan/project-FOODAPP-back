package com.salesianostriana.dam.projectFOODAPP.usuario.service;

import com.salesianostriana.dam.projectFOODAPP.usuario.dto.AltaTrabajadorDto;
import com.salesianostriana.dam.projectFOODAPP.usuario.dto.PutTrabajadorDto;
import com.salesianostriana.dam.projectFOODAPP.usuario.exception.TrabajadorNotFoundException;
import com.salesianostriana.dam.projectFOODAPP.usuario.exception.TrabajadoresListEmptyException;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.TipoTrabajador;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Trabajador;


import com.salesianostriana.dam.projectFOODAPP.usuario.repository.TrabajadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TrabajadorService {

    private final TrabajadorRepository trabajadorRepository;

    public Page<Trabajador> findAllTrabajadores(Pageable pageable) {
        Page<Trabajador> trabajadorList = trabajadorRepository.trabajadorPage(pageable);
        if (trabajadorList.isEmpty()) {
            throw new TrabajadoresListEmptyException();
        }
        return trabajadorList;
    }


    public void eliminarTrabajador(String id) {
        trabajadorRepository.delete(trabajadorRepository.buscarTrabajadorID(UUID.fromString(id)).get());
    }


    public Trabajador save(AltaTrabajadorDto nuevoTrabajador) {
        Trabajador t = new Trabajador();
        t.setNombre(nuevoTrabajador.nombre());
        t.setEmail(nuevoTrabajador.email());
        t.setTelefono(nuevoTrabajador.telefono());
        t.setUsername(nuevoTrabajador.username());
        t.setPassword(nuevoTrabajador.password());
        t.setTipoTrabajador(TipoTrabajador.valueOf(nuevoTrabajador.puesto()));
        t.setFechaNacimiento(nuevoTrabajador.fechaNacimiento());
        return trabajadorRepository.save(t);
    }

    public Trabajador edit(String id, PutTrabajadorDto trabajadorEditado) {
        Optional<Trabajador> t = trabajadorRepository.buscarTrabajadorID(UUID.fromString(id));
        if (t.isEmpty()) {
            throw new TrabajadorNotFoundException(id);
        }else{
            Trabajador trabajador = t.get();
            trabajador.setNombre(trabajadorEditado.nombre());
            trabajador.setTipoTrabajador(TipoTrabajador.valueOf(trabajadorEditado.puesto()));
            trabajador.setEmail(trabajadorEditado.email());
            trabajador.setTelefono(trabajadorEditado.telefono());
            trabajador.setFechaNacimiento(trabajadorEditado.fechaNacimiento());
            return trabajadorRepository.save(trabajador);
        }
    }

    public Trabajador bucarUIID(String id){
        Optional <Trabajador>t = trabajadorRepository.buscarTrabajadorID(UUID.fromString(id));

        if(t.isEmpty()){
            throw new TrabajadorNotFoundException(id);
        }
        return  t.get();
    }
}
