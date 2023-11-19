package com.salesianostriana.dam.projectFOODAPP.model;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class LineaPedidoPK implements Serializable {
    private Pedido pedido;
    private Long codLinea;

    private LineaPedidoPK() { }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineaPedidoPK that = (LineaPedidoPK) o;
        return Objects.equals(pedido, that.pedido) && Objects.equals(codLinea, that.codLinea);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pedido, codLinea);
    }
}
