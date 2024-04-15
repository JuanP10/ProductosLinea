package com.example.productoslinea.data.entities;

import com.example.productoslinea.data.Mappers.ClienteMapper;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String direccion;

    @OneToMany(mappedBy = "cliente")
    List<Pedido> pedidos;

}
