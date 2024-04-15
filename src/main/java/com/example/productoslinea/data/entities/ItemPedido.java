package com.example.productoslinea.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ItemsPedidos")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class ItemPedido {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(name = "precio_unitario", nullable = false)
    private Double precioUnitario;

    @ManyToOne  @JoinColumn(name = "pedido")
    private Pedido pedido;

    @ManyToOne @JoinColumn(name = "producto")
    private Producto producto;
}
