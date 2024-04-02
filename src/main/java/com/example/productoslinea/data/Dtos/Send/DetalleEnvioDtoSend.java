package com.example.productoslinea.data.Dtos.Send;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleEnvioDtoSend {
    private Long id;
    private String direccion;
    private String transportadora;
    private int numeroGuia;
    private ClienteDtoSend cliente;
}
