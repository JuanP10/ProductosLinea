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
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String direccion;
    private String transportadora;
    private int numeroGuia;

    @OneToOne @JoinColumn(name = "pedido_id")
    private Pedido pedido;

}
