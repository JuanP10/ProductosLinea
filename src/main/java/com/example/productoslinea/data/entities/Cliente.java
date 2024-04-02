package com.example.productoslinea.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Clientes")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cliente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String direccion;

    @OneToMany(mappedBy = "cliente")
    List<Pedido> pedidos;

}
