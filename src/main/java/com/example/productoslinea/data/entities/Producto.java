package com.example.productoslinea.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Productos")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Producto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Double price;
    private int stock;
    @OneToMany (mappedBy = "producto")
    private List<ItemPedido> itemPedido;


}
