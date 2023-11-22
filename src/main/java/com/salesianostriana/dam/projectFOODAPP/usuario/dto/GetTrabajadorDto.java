package com.salesianostriana.dam.projectFOODAPP.usuario.dto;

import com.salesianostriana.dam.projectFOODAPP.usuario.model.TipoTrabajador;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Trabajador;

public record GetTrabajadorDto(

        String nombre,

        TipoTrabajador puesto

) {

    public static GetTrabajadorDto of (Trabajador trabajador){
        return  new GetTrabajadorDto(
                trabajador.getNombre(),
                trabajador.getTipoTrabajador()
        );
    }
}
