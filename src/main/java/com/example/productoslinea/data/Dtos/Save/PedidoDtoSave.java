package com.example.productoslinea.data.Dtos.Save;
import com.example.productoslinea.data.entities.Enums.Estado;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PedidoDtoSave {
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fechaPedido;
    private Estado estado;

}
