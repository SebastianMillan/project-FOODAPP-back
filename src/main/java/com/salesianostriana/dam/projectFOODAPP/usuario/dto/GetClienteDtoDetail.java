package com.salesianostriana.dam.projectFOODAPP.usuario.dto;

import com.salesianostriana.dam.projectFOODAPP.pedido.model.Pedido;

import java.util.List;

public record GetClienteDtoDetail(String id, String nombre, String email, String avatar, String direccion, String codPostar, String poblacion, int puntos, List<Pedido> pedidos) {
}
