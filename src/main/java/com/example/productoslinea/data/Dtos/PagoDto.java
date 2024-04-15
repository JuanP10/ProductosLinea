package com.example.productoslinea.data.Dtos;
import com.example.productoslinea.data.entities.Enums.MetodoPago;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PagoDto {
    private Long id;
    private Double totalPago;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fechaPago;
    private MetodoPago metodoPago;
    private PedidoDto pedido;
}
