package com.example.productoslinea.data.Dtos;
import com.example.productoslinea.data.entities.Enums.Estado;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class PedidoDto {
    private Long id;
    private Estado estado;
    @JsonFormat (pattern = "dd/MM/yyyy")
    private LocalDate fechaPedido;
    private ClienteDto cliente;

}
