package com.salesianostriana.dam.projectFOODAPP.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Pedido {

    @GeneratedValue @Id
    private Long id;

    private LocalDateTime fecha;
    private EstadoPedido estadoPedido;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Trabajador repartidor;

    @ManyToOne
    private Trabajador cocinero;

    @ToString.Exclude
    @Builder.Default
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LineaPedido> lineasPedido = new ArrayList<>();

    public void addLineaPedido(LineaPedido lineaPedido) {
        lineasPedido.add(lineaPedido);
        lineaPedido.setPedido(this);
    }

    public void removeLineaPedido(LineaPedido lineaPedido) {
        lineasPedido.remove(lineaPedido);
        lineaPedido.setPedido(null);
    }
}
