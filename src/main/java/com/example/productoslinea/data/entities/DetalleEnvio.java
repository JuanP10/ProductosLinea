package com.example.productoslinea.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "DetallesEnvios")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetalleEnvio {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private String transportadora;

    @Column(name = "numero_guia", nullable = false)
    private Integer numeroGuia;

    @OneToOne @JoinColumn(name = "pedido")
    private Pedido pedido;

}
