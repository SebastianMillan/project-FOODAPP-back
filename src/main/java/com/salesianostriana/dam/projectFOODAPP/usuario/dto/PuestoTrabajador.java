package com.salesianostriana.dam.projectFOODAPP.usuario.dto;

import com.salesianostriana.dam.projectFOODAPP.usuario.model.Trabajador;

public record PuestoTrabajador(
        String id,
        String puesto
) {

    public static PuestoTrabajador of (Trabajador trabajador){
        return  new PuestoTrabajador(
                trabajador.getId().toString(),
                trabajador.getTipoTrabajador().toString()
        );
    }
}
