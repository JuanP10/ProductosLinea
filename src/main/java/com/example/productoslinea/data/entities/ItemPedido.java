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
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer cantidad;
    private Double precioUnitario;

    @ManyToOne  @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne @JoinColumn(name = "producto_id")
    private Producto producto;
}
