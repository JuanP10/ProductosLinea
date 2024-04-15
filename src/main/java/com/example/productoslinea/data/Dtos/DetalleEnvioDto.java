package com.example.productoslinea.data.Dtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleEnvioDto {
    private Long id;
    private String direccion;
    private String transportadora;
    private Integer numeroGuia;
    private ClienteDto cliente;
}
