package com.example.productoslinea.data.Dtos.Send;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagoDtoSend {
    private Long id;
    private double monto;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fechaPago;
    private String metodo;
    private PedidoDtoSend pedido;
}
