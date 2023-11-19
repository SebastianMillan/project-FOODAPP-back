package com.salesianostriana.dam.projectFOODAPP.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@IdClass(LineaPedidoPK.class)
public class LineaPedido {

    @Id
    @GeneratedValue
    private Long codLinea;

    @Id
    @ManyToOne
    private Pedido pedido;

    private double precioUnitario;
    private int cantidad;

    @ManyToOne
    private Producto producto;

    public LineaPedidoPK getId(){
        return new LineaPedidoPK(pedido, codLinea);
    }

    public void setId(LineaPedidoPK pk){
        this.pedido = pk.getPedido();
        this.codLinea = pk.getCodLinea();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineaPedido that = (LineaPedido) o;
        return Objects.equals(codLinea, that.codLinea) && Objects.equals(pedido, that.pedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codLinea, pedido);
    }
}
