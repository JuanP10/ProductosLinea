package com.example.productoslinea.data.entities;

import com.example.productoslinea.data.entities.Enums.MetodoPago;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "Pagos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pago {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double totalPago;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fechaPago;
    private MetodoPago metodoPago;

    @OneToOne @JoinColumn(name = "pedido_id")
    private Pedido pedido;


}
