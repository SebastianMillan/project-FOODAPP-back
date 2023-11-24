package com.salesianostriana.dam.projectFOODAPP.usuario.dto;

import com.salesianostriana.dam.projectFOODAPP.pedido.dto.GetPedidoEnClienteDto;
import com.salesianostriana.dam.projectFOODAPP.pedido.model.Pedido;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Cliente;

import java.util.List;

public record GetClienteDtoDetail(String id, String nombre, String email, String avatar, String direccion, String codPostal, String poblacion, int puntos, List<GetPedidoEnClienteDto> pedidos) {

    public static GetClienteDtoDetail of(Cliente c, List<Pedido> lista) {
        return new GetClienteDtoDetail(
                c.getId().toString(),
                c.getNombre(),
                c.getEmail(),
                c.getAvatar(),
                c.getDireccion(),
                c.getCodPostal(),
                c.getPoblacion(),
                c.getPuntos(),
                lista.stream()
                        .map(GetPedidoEnClienteDto::of)
                        .toList()
        );
    }
}
