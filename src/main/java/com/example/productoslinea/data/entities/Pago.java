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
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "total_pago", nullable = false)
    private Double totalPago;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "fecha_pago", nullable = false)
    private LocalDate fechaPago;

    @Column(name = "metodo_pago", nullable = false)
    @Enumerated(EnumType.STRING)
    private MetodoPago metodoPago;

    @OneToOne @JoinColumn(name = "pedido")
    private Pedido pedido;


}
