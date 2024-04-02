package com.example.productoslinea.data.Dtos.Save;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagoDtoSave {
    private double monto;
    private String metodo;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fechaPago;
}
